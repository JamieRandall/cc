package ru.gov.rkn.model.form;


import lombok.Data;

@Data
public class UserForm {
    private String login;
    private String password;
    private String role;
}
