package id.project.skripsi.manzone.dto;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

public class EmailDTO {

    @NotNull
    @Email
    private String email;

    @NotNull
    private String feedback;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
