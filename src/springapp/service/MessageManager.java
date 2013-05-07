package springapp.service;

import java.io.Serializable;
import java.util.List;

import springapp.domain.Message;

public interface MessageManager extends Serializable{

    public List<Message> getMessages(String mobileNumber);
    
}
