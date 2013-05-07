package springapp.service;

import java.io.Serializable;

import springapp.domain.User;

public interface RegisterManager extends Serializable{

    public void register(User user);
    
    public boolean checkUserExistence(User user);
    
}
