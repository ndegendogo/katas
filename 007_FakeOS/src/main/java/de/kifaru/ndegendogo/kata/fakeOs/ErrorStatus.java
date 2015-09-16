package de.kifaru.ndegendogo.kata.fakeOs;

public class ErrorStatus {
    private boolean hasError = false;
    
    public void setError() {hasError = true;}
    public boolean hasError() {return hasError;}
}
