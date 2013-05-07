package springapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import springapp.domain.Message;

public class JdbcMessageDao extends SimpleJdbcDaoSupport implements MessageDao {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());


    public List<Message> getMessageList(String username) {
        logger.info("Getting users!");
        Map<String,String> parameterMap = new HashMap<String, String>();
        parameterMap.put("username", username);
        List<Message> messages = getSimpleJdbcTemplate().query(
                "select date_received, message, latitude, longitude from messages where username = :username " +
                "order by date_received desc", new MessageMapper(),
                parameterMap
                );
        return messages;
    }

    private static class MessageMapper implements ParameterizedRowMapper<Message> {

        public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
            Message message = new Message();
            message.setMessage(rs.getString("message"));
            message.setDateReceived(rs.getString("date_received"));
            message.setLatitude(rs.getString("latitude"));
            message.setLongitude(rs.getString("longitude"));
            return message;
        }

    }

}