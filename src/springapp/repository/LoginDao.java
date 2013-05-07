package springapp.repository;

import java.util.List;

import springapp.domain.User;

public interface LoginDao {

    public List<User> getUserList();
    
    public boolean checkUserExistence(User user);
    
    public void saveUser(User user);

    public User getUserDetails(String username);

}