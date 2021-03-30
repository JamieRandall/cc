package ru.gov.rkn.model.database;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gov.rkn.model.database.Log;
import ru.gov.rkn.model.enums.UserRole;

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

    private String username;

    private String password;

    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    private boolean isActive;

    @OneToMany(mappedBy = "cc_user")
    private List<Log> logs;
}
