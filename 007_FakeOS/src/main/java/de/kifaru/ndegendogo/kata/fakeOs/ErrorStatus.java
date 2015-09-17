package de.kifaru.ndegendogo.kata.fakeOs;

public class ErrorStatus {
    public enum ErrorCode {
        NO_ERROR,
        IO_EXCEPTION,
        OTHER_ERROR,
    };
    
    private ErrorCode error = ErrorCode.NO_ERROR;
    
    public void setError(ErrorCode error) {this.error = error;}
    public boolean hasError() {return !isOk();}
    public boolean isOk() {return error == ErrorCode.NO_ERROR;}
}
