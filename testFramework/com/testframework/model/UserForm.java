package testFramework.com.testframework.model;

import framework.utilitaire.ValidationResult;

public class UserForm {

    private String username;

    private String email;

    private String password;

    private ValidationResult lastValidationResult;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValid() {
        ValidationResult vr = new ValidationResult();

        if (username == null || username.trim().isEmpty()) {
            vr.addError("username", "Username is required");
        }

        if (email == null || email.trim().isEmpty()) {
            vr.addError("email", "Email is required");
        } else if (!email.contains("@") || !email.contains(".")) {
            vr.addError("email", "Email format is invalid");
        }

        if (password == null || password.trim().isEmpty()) {
            vr.addError("password", "Password is required");
        } else if (password.length() < 6) {
            vr.addError("password", "Password must be at least 6 characters");
        }

        this.lastValidationResult = vr;
        return vr.isValid();
    }

    public ValidationResult getLastValidationResult() {
        return lastValidationResult;
    }
}
