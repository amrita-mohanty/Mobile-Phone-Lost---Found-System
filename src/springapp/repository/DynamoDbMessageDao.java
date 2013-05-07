package springapp.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import springapp.domain.Message;

public class DynamoDbMessageDao implements MessageDao {

    public DynamoDbMessageDao()
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

    public List<Message> getMessageList(String mobileNumber) {
        System.out.println("Getting users!");
        
        // scanning messages based on imei-number
        HashMap<String, Condition> scanFilter = new HashMap<String, Condition>();
        Condition condition = new Condition()
            .withComparisonOperator(ComparisonOperator.EQ.toString())
            .withAttributeValueList(new AttributeValue().withS(mobileNumber));
        scanFilter.put("imeinumber", condition);
        ScanRequest scanRequest = new ScanRequest("messages").withScanFilter(scanFilter);
        ScanResult scanResult = amazonDynamoDBClient.scan(scanRequest);
        List<Map<String, AttributeValue>> tableData = scanResult.getItems();
        
         DescComparator descComparator = new DescComparator();
        TreeMap<Long, String> treeMap = new TreeMap<Long, String>(descComparator);
        for(Map<String, AttributeValue> rowData : tableData)
        {
            AttributeValue attributeValueTimestamp = rowData.get("timestamp");
            AttributeValue attributeValueDate = rowData.get("date");
            AttributeValue attributeValueMobile = rowData.get("imeinumber");
            AttributeValue attributeValueMessage = rowData.get("message");
            AttributeValue attributeValueLatitude = rowData.get("latitude");
            AttributeValue attributeValueLongitude = rowData.get("longitude");
            
            String value = attributeValueDate.getS()+","+attributeValueMobile.getS()+
                    ","+attributeValueMessage.getS()+","+attributeValueLatitude.getS()
                    +","+attributeValueLongitude.getS();
            
            // add values so that it is sorted
            treeMap.put(Long.parseLong(attributeValueTimestamp.getN()), value);
        }
        
        List<Message> messages = new ArrayList<Message>();
        for (Entry<Long, String> entry : treeMap.entrySet())
        {
        	
        	// Key Value pair , timestamp => date, imeinumber, message, latitude, longitude
            System.out.println("[timestamp, date, imeinumber, message, latitude, longitude]=>["+entry.getKey()
                    +", "+entry.getValue()+"]");
            
            String[] values = entry.getValue().split(",");
            
            Message message = new Message();
            message.setDateReceived(values[0]);
            message.setMessage(values[2]);
            message.setLatitude(values[3]);
            message.setLongitude(values[4]);
            
            messages.add(message);
        }
        return messages;
    }
    
    public static class DescComparator implements Comparator<Long> {
        @Override
        public int compare(Long l1, Long l2) {
            int compare = (int) Math.signum(l1.compareTo(l2));
            return compare * (-1);
        }
    }
}