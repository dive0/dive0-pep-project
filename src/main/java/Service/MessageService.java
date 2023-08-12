package Service;

import java.util.List;

import DAO.MessageDAO;
import Model.Message;

public class MessageService {
    private MessageDAO messageDAO;

    public MessageService() {
        messageDAO = new MessageDAO();
    }

    public MessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    public Message addMessage(Message message) {
        if (message.getMessage_text() == "" || message.getMessage_text().length() > 254) {
            return null;
        }
        return messageDAO.insertMessage(message);
    }

    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }

    public Message getMessageById(int message_id) {
        return messageDAO.getMessageById(message_id);
    }

    public Message deleteMessageById(int message_id) {
        Message deletedMessage = messageDAO.getMessageById(message_id);
        if (deletedMessage != null) {
            messageDAO.deleteMessage(message_id);
        }
        return deletedMessage;
    }

    public Message updateMessage(Message message, int message_id) {
        if (message.getMessage_text() == "" || message.getMessage_text().length() > 254) {
            return null;
        }
        return messageDAO.updateMessage(message, message_id);
    }

    public List<Message> getAllUserMessages(int account_id) {
        return messageDAO.getAllMessages(account_id);
    }
}
