package de.kifaru.ndegendogo.kata.fakeOs;

class ErrorState {
    private boolean hasError = false;

    boolean hasError() {
        return (hasError);
    }

    void setError() {
        hasError = true;
    }

    void handleError() {
        if (hasError()) {
            System.exit(1);
        }
    }
}