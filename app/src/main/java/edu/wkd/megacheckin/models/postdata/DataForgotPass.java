package edu.wkd.megacheckin.models.postdata;

public class DataForgotPass {
    private String email;

    public DataForgotPass(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
