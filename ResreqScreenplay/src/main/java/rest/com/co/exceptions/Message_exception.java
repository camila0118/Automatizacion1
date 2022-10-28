package rest.com.co.exceptions;

public class Message_exception extends Error{

    public Message_exception(String message, Throwable throwable){
        super(message,throwable);
    }
}
