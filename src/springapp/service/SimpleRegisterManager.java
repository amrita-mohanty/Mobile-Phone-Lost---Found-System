package springapp.service;

import springapp.domain.User;

import springapp.repository.LoginDao;

public class SimpleRegisterManager implements RegisterManager 
{

	private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    @Override
    public void register(User user) {
    	loginDao.saveUser(user);
    }
   
    public boolean checkUserExistence(User user)
    {
    	return loginDao.checkUserExistence(user);
    }
    
    public LoginDao getLoginDao() {
        return loginDao;
    }
    
    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

}
