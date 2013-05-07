package springapp.service;

import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import org.apache.log4j.Logger;

import springapp.domain.User;

public class RegisterValidator implements Validator {

    /** Logger for this class and subclasses */
    protected final Logger logger = Logger.getLogger(getClass());

    public boolean supports(Class clazz) {
        return User.class.equals(clazz);
    }
    
    

    /*public void validate(Object obj, Errors errors) {
        Login pi = (Login) obj;
        if (pi.getUsername() == null || pi.getUsername() == "") {
            errors.rejectValue("login", "error.username-not-specified", null, "Username required.");
        }
        if (pi.getPassword() == null || pi.getPassword() == "") {
            errors.rejectValue("login", "error.password-not-specified", null, "Password required.");
        }
    }*/
    
    public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(
			errors, "username", "required.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "password", "required.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "imeiNumber", "required.imeiNumber");
		ValidationUtils.rejectIfEmptyOrWhitespace(
					errors, "emailAddress", "required.emailAddress");
	}
}