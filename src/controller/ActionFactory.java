package controller;

import controller.action.mainAction;

import controller.action.Action;

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
	    System.out.println("ActionFactory  :" + command);
	    
	    if (command.equals("main")) {
	        action = new mainAction();
	    } else if(command.equals("product_detail")) {	    	  
	    } else  if (command.equals("catagory")) {
	    }

	    return action;
	  }
	
}
