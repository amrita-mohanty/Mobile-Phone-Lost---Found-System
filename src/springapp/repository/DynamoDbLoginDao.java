package springapp.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import springapp.domain.User;

public class DynamoDbLoginDao implements LoginDao {

    public DynamoDbLoginDao()
    {
        System.out.println("DynamoDbLoginDao constructor()");
        
        String accessKey = "AKIAJZ5EU4EXKKBFX5JQ";
        String secretKey = "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";
        AWSCredentials awsCredential = new BasicAWSCredentials(accessKey, secretKey);
        
        amazonDynamoDBClient = new AmazonDynamoDBClient(awsCredential);
    }
    
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    public static AmazonDynamoDBClient amazonDynamoDBClient = null;

    public List<User> getUserList() {
        System.out.println("DynamoDbLoginDao getUserList()");
        List<User> users = new ArrayList<User>();
        
        ScanRequest scanRequest = new ScanRequest("userdetails");
        ScanResult scanResult = amazonDynamoDBClient.scan(scanRequest);
        List<Map<String, AttributeValue>> tableData = scanResult.getItems();
        for(Map<String, AttributeValue> rowData : tableData)
        {
            String userName = rowData.get("username").getS();
            String password = rowData.get("password").getS();
            String imeiNumber = rowData.get("imeinumber").getS();
            String email = rowData.get("email").getS();
            
            User newUser = new User();
            
            newUser.setUsername(userName);
            newUser.setPassword(password);
            newUser.setImeiNumber(imeiNumber);
            newUser.setEmailAddress(email);
            
            users.add(newUser);
            System.out.println("[username, password, imeiNumber, email]=>["+userName
               +", "+password+", "+", " + imeiNumber +", "+email+"]");
        }
        
        return users;
    }

    private Map<String, AttributeValue> newUserDetailsItem(String username, String password, String imeiNumber, String email) {
        Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
        item.put("username", new AttributeValue(username));
        item.put("password", new AttributeValue(password));
        item.put("imeinumber", new AttributeValue(imeiNumber));
        item.put("email", new AttributeValue(email));

        return item;
    }
    
    public void saveUser(User user){
        System.out.println("Saving user: " + user.getUsername());
        try{
            String tableName = "userdetails";
            
            // Add an item
            Map<String, AttributeValue> item = newUserDetailsItem(user.getUsername(),user.getPassword(),
                    user.getImeiNumber(), user.getEmailAddress());
            PutItemRequest putItemRequest = new PutItemRequest(tableName, item);
            PutItemResult putItemResult = amazonDynamoDBClient.putItem(putItemRequest);
            System.out.println("Result: " + putItemResult);
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

    @Override
    public User getUserDetails(String username) 
    {
        for (User localUser:getUserList())
        {
            if(localUser.getUsername().equalsIgnoreCase(username))
                return localUser;
        }    
        return null;
    }
}