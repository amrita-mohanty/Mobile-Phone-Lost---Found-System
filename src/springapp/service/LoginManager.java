package springapp.service;

import java.io.Serializable;

import springapp.domain.User;

public interface LoginManager extends Serializable{

    public boolean validLogin(String username, String password);
    
    public User getUserDetails(String username);
    
}
