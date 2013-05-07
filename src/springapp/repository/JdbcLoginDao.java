package springapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import springapp.domain.User;

public class JdbcLoginDao extends SimpleJdbcDaoSupport implements LoginDao {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());


    public List<User> getUserList() {
        logger.info("Getting users!");
        List<User> users = getSimpleJdbcTemplate().query(
                "select username, password, imeiNumber, emailAddress from users", 
                new LoginMapper());
        return users;
    }

    public void saveUser(User user){
        logger.info("Saving user: " + user.getUsername());
        try{
        	int count = getSimpleJdbcTemplate().update(
                    "insert into users(username, password,emailAddress, imeiNumber) values " +
                    "(:username,:password,:emailAddress,:imeiNumber )",
                    new MapSqlParameterSource().addValue("username", user.getUsername())
                        .addValue("password", user.getPassword())
                        .addValue("emailAddress", user.getEmailAddress()).
                        addValue("imeiNumber", user.getImeiNumber()));
                logger.info("Rows affected: " + count);
        }
        catch(Exception e){
        	System.out.println("Exception while inserting new user details : " + e);
        }
    }
    
    /** Check whether the new username being registered already exists or not
     * 
     * @param user
     */
    public boolean checkUserExistence(User user){
    	System.out.println("JdbcLoginDao::checkUserExistence()");
    	for (User localUser:getUserList())
    	{
    		if(localUser.getUsername().equalsIgnoreCase(user.getUsername()))
    			return true;
    	}
    	return false;
    }
    
    
    private static class LoginMapper implements ParameterizedRowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmailAddress(rs.getString("emailAddress"));
            user.setImeiNumber(rs.getString("imeiNumber"));
            return user;
        }

    }


    @Override
    public User getUserDetails(String username) {
        // TODO Auto-generated method stub
        return null;
    }

}