package coelhostore.storageapi.domain.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class ModelIntegrityViolationException extends DataIntegrityViolationException {
    public ModelIntegrityViolationException(String message,Throwable cause){
        super(message,cause);
    }
}
