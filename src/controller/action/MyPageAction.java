package controller.action;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dto.MemberVO;

public class MyPageAction implements Action {
  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	  
    String url = "member/mypage.jsp"; 
    HttpSession session = request.getSession();
    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

    if (loginUser == null) {
      url = "HyundaiServlet?command=login_form";
    } 
    else {
//      OrderDAO orderDAO = OrderDAO.getInstance();
//      ArrayList<Integer> oseqList = //현재 주문중인것 갯수 가져오기
//    		  orderDAO.selectSeqOrderIng(loginUser.getId());
//      ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
//
//      for (int oseq : oseqList) { //반복분 횟수지정    	  
//    	  ArrayList<OrderVO> orderListIng = 
//        		orderDAO.listOrderById( loginUser.getId(), "1", oseq );
//    	  OrderVO orderVO = orderListIng.get(0);
//    	  orderVO.setPname(
//    		orderVO.getPname() + " 외 " + ( orderListIng.size() -1) + "건");        
//    	  int totalPrice = 0;
//    	  for (OrderVO ovo : orderListIng) {
//    		  totalPrice += ovo.getPrice2() * ovo.getQuantity();
//    	  }
//        
//    	  orderVO.setPrice2(totalPrice);
//    	  orderList.add(orderVO);
      
//      }
      request.setAttribute("title", "진행 중인 주문 내역");
//      request.setAttribute("orderList", orderList);
    }
    request.getRequestDispatcher(url).forward(request, response);
  }
}//end class
