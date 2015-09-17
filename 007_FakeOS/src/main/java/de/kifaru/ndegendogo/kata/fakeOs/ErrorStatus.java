package de.kifaru.ndegendogo.kata.fakeOs;

public class ErrorStatus {
    public enum ErrorValue {
        NO_ERROR,
        IO_EXCEPTION,
        OTHER_ERROR,
    };
    
    private ErrorValue error = ErrorValue.NO_ERROR;
    
    public void setError(ErrorValue error) {this.error = error;}
    public boolean hasError() {return !isOk();}
    public boolean isOk() {return error == ErrorValue.NO_ERROR;}
}
