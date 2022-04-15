package controller.action;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberVO;
import utill.AES128;
import utill.Secret;

// 작성자 : 고정민
// 기능 : 회원 가입
public class JoinAction implements Action {
  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	  
    String url = "member/login.jsp";     
    HttpSession session = request.getSession();    
    MemberVO memberVO = new MemberVO();    
    
    String pwd = null;
    
    // 입력 받은 password 값을 AES128 알고리즘을 적용하여 암호화한 후 pwd 변수에 저장
    try {
		pwd = new AES128(Secret.USER_INFO_PASSWORD_KEY).encrypt(request.getParameter("pw"));
	} catch (InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | BadPaddingException
			| IllegalBlockSizeException | InvalidAlgorithmParameterException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    // 입력 받은 값과 암호화된 비밀번호를 설정
    memberVO.setEmail(request.getParameter("email"));
    memberVO.setName(request.getParameter("name"));
    memberVO.setPw(pwd);
    memberVO.setPhone_number(request.getParameter("phone_number"));
    memberVO.setBirth(request.getParameter("birth"));
    memberVO.setGender(request.getParameter("gender"));
    memberVO.setAddress(request.getParameter("address"));
      
    session.setAttribute("email", request.getParameter("email"));    
    
    // 회원가입 로직을 처리할 DAO 객체를 생성
    MemberDAO memberDAO = MemberDAO.getInstance();
    
    // DAO에 값을 전부 넘김
    memberDAO.insertMember(memberVO);    
    
    // url로 값을 전달
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }
}
