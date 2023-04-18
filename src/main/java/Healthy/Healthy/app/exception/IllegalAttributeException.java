package Healthy.Healthy.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author : Ayman_Alsapagh
 * @since :  2/28/2023
 **/
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IllegalAttributeException extends HttpMessageNotReadableException {

    private String message;

    public IllegalAttributeException(String message)
    {
        super(message);
        this.message =  message;
    }

    public String getMessage()
    {
        return message;
    }
}
