package springapp.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import springapp.domain.Message;
import springapp.domain.User;
import springapp.service.LoginManager;
import springapp.service.Login;
import springapp.service.MessageManager;

public class LoginController extends SimpleFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private LoginManager loginManager;
    private MessageManager messageManager;

    public ModelAndView onSubmit(Object command) throws ServletException {

        String username = ((Login) command).getUsername();
        String password = ((Login) command).getPassword();

        System.out.println("Got password " + password);
        System.out.println("Got username " + username);
        
        boolean isvalid = false;
        
        if(username != null && !username.equalsIgnoreCase("") && password != null && !password.equalsIgnoreCase(""))
        	isvalid = loginManager.validLogin(username, password);

        if(isvalid)
        {
        	System.out.println("Is valid");
        	User user = loginManager.getUserDetails(username);
        	
            List<Message> messages = messageManager.getMessages(user.getImeiNumber());
            
            Map<String, Object> myModel = new HashMap<String, Object>();
            myModel.put("messages", messages);
            
            ModelAndView modelAndView = new ModelAndView("messages","model",myModel);
            
            return modelAndView;
        }
        else
        {
        	
        	System.out.println("Is invalid");
        	Map<String, Object> myModel = new HashMap<String, Object>();
            myModel.put("invalid", "Invalid Username or Passowrd");
            
            ModelAndView modelAndView = new ModelAndView("login","model",myModel);
            
            return modelAndView;
        }
    }

    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
        Login login = new Login();
        return login;
    }

    public void setLoginManager(LoginManager loginManager) {
        this.loginManager = loginManager;
    }

    public LoginManager getLoginManager() {
        return loginManager;
    }
    
    public void setMessageManager(MessageManager messageManager) {
        this.messageManager = messageManager;
    }

    public MessageManager getMessageManager() {
        return messageManager;
    }

}