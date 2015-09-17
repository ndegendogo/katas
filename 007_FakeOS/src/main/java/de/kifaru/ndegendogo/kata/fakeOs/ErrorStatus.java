package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.IOException;

public class ErrorStatus {
    public enum ErrorCode {
        NO_ERROR,
        IO_EXCEPTION,
        OTHER_ERROR,
    };
    
    private ErrorCode error = ErrorCode.NO_ERROR;
    
    private void setError(ErrorCode error) {this.error = error;}
    
    public void mapException(Exception e) {
        if (e instanceof IOException) {
            setError(ErrorCode.IO_EXCEPTION);
        } else {
            setError(ErrorCode.OTHER_ERROR);
        }
    }
    public boolean hasError() {return !isOk();}
    public boolean isOk() {return error == ErrorCode.NO_ERROR;}
}
