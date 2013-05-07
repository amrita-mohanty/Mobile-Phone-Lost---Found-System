package springapp.service;

import java.util.List;

import springapp.domain.User;

import springapp.repository.LoginDao;

public class SimpleLoginManager implements LoginManager {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public boolean validLogin(String username, String password) {
        List<User> users = loginDao.getUserList();
        if (users != null) {
            for (User user:users) {
                if (user.getUsername().equalsIgnoreCase(username) 
                        && user.getPassword().equalsIgnoreCase(password))
                    return true;
            }
        }
        
        return false;
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public User getUserDetails(String username) 
    {
        return loginDao.getUserDetails(username);
    }
}
