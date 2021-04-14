package ru.gov.rkn.model.database;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gov.rkn.model.database.Log;
import ru.gov.rkn.model.enums.UserRole;
import ru.gov.rkn.model.enums.UserState;
import ru.gov.rkn.model.form.UserForm;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Builder
@Entity(name = "cc_user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String login;
    private String hashPassword;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Enumerated(EnumType.STRING)
    private UserState state;

    @OneToMany(mappedBy = "cc_user")
    private List<Log> logs;

    public static User fromForm(UserForm userForm) {
        return User.builder()
                .login(userForm.getLogin())
                .hashPassword(userForm.getPassword())
                .role(UserRole.valueOf(userForm.getRole()))
                .state(UserState.ACTIVE)
                .build();
    }
}
