package springapp.repository;

import java.util.List;

import springapp.domain.Message;

public interface MessageDao {

    public List<Message> getMessageList(String username);

}