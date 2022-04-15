package controller;

import controller.action.*;

//작성자 : 유지훈 
//기능 : servlet으로 넘어온 Command값에 따라 맵핑해주어 객체를 생성해주는 역할을 한다.  
public class ActionFactory {
  
	// 싱글톤 패턴을 적용시키기 위해 instance를 하나만 생성하여 관리하였다.
    private static ActionFactory instance = new ActionFactory();

    private ActionFactory() {
        super();
    }

    // getInstance으로 생성된 하나의 객체를 가져와 사용할 수 있다.
    public static ActionFactory getInstance() {
        return instance;
    }

    public Action getAction(String command) {
        Action action = null;
        System.out.println("ActionFactory  : " + command);
        
        // 메인화면 
        if (command.equals("main")) {
            action = new MainAction();
        } 
        
        // 회원가입 
        else if (command.equals("join")) {
            action = new JoinAction();
        } else if (command.equals("joinStep1")) {
            action = new JoinStep1Action();
        } else if (command.equals("joinStep2")) {
            action = new JoinStep2Action();
        } 
        
        // 로그인 
        else if (command.equals("login_form")) {
            action = new LoginFormAction();
        } else if (command.equals("login")) {
            action = new LoginAction();
        } else if (command.equals("logout")) {
            action = new LogoutAction();
        } else if (command.equals("id_check_form")) {
            action = new IdCheckFormAction();
        }
        
        // 마이페이지
        else if (command.equals("mypage")) {
            action = new MyPageAction();
        } else if (command.equals("update")) {
            action = new UpdateAction();
        } else if (command.equals("updateMember")) {
            action = new UpdateMemberAction();
    	} 
        
        // 상품관련
        else if (command.equals("productList")) {
            action = new ProductListAction();
        } else if (command.equals("product_search")) {
            action = new ProductSearchAction();
        } else if (command.equals("product_sale")) {
            action = new ProductSaleAction();
        } else if (command.equals("product_detail")) {
	        action = new ProductDetailAction();
	    } else if (command.equals("cart_list")) {
            action = new CartListAction();
        }
        
        // 리뷰관련
	    else if (command.equals("review_list")) {
	    	action = new ReviewAction();
	    } 		
  		return action;
	}
}
