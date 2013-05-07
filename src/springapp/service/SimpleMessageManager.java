package springapp.service;

import java.util.List;

import springapp.domain.Message;

import springapp.repository.MessageDao;

public class SimpleMessageManager implements MessageManager {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private MessageDao messageDao;

    public List<Message> getMessages(String username) {
        return messageDao.getMessageList(username);
    }

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }
}
