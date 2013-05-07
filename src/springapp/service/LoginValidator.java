package springapp.service;

import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import org.apache.log4j.Logger;

public class LoginValidator implements Validator {

    /** Logger for this class and subclasses */
    protected final Logger logger = Logger.getLogger(getClass());

    public boolean supports(Class clazz) {
        return Login.class.equals(clazz);
    }
    
    

    /*public void validate(Object obj, Errors errors) {
        Login pi = (Login) obj;
        if (pi.getUsername() == null || pi.getUsername() == "") {
            errors.rejectValue("login", "error.username-not-specified", null, "Username required.");
        }
        if (pi.getPassword() == null || pi.getPassword() == "") {
            errors.rejectValue("login", "error.password-not-specified", null, "Passowrd required.");
        }
    }*/
    
    public void validate(Object target, Errors errors) 
    {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password");
	}
}