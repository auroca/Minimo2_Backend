package edu.upc.dsa.services.dto;

public class RegisterResponse {
    private boolean ok;
    private String message;

    public RegisterResponse() {}

    public RegisterResponse(boolean ok, String message) {
        this.ok = ok;
        this.message = message;
    }

    public boolean isOk() { return ok; }
    public void setOk(boolean ok) { this.ok = ok; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
