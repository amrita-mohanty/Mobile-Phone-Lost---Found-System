package springapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Login {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private String username;
    
    private String password;

    public void setUsername(String i) {
        username = i;
        logger.info("Username set to " + i);
    }

    public String getUsername() {
        return username;
    }
    
    public void setPassword(String i) {
        password = i;
        logger.info("Password set to " + i);
    }

    public String getPassword() {
        return password;
    }


}