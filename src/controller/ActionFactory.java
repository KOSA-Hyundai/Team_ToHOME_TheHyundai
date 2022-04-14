package controller;

import controller.action.*;

public class ActionFactory {
  
    private static ActionFactory instance = new ActionFactory();

    private ActionFactory() {
        super();
    }

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
