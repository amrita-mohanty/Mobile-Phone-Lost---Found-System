package springapp.web;

import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import springapp.domain.User;
import springapp.service.RegisterManager;

public class RegisterController extends SimpleFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private RegisterManager registerManager;

    public ModelAndView onSubmit(Object command) throws ServletException 
    {
        User user = ((User) command);
        System.out.println("Got user " + user.toString());
        
        boolean userExists = registerManager.checkUserExistence(user);
    	if(!userExists)
    	{
    		registerManager.register(user);
    	}
    	else
    	{
    		System.out.println("Username Already Exists !!!");
    	}
        
        return new ModelAndView(new RedirectView(getSuccessView()));
    }

    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
        User user = new User();
        return user;
    }

    public void setRegisterManager(RegisterManager registerManager) {
        this.registerManager = registerManager;
    }

    public RegisterManager getRegisterManager() {
        return registerManager;
    }

}