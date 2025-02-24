package model.exceptions;

import java.io.Serial;

public class BusinessException extends Exception {

    public BusinessException(String msg) {
        super(msg);
    }
}
