package org.niebieskidom.bluecamps.entity;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Login is mandatory")
    @NotEmpty(message = "Login is mandatory")
    private String login;

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull(message = "Email is mandatory")
    @NotEmpty(message = "Email is mandatory")
    @Email
    @Column(unique = true, nullable = false)
    @Pattern(regexp = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}", flags = Pattern.Flag.UNICODE_CASE)
    private String email;

    @NotNull(message = "Password is mandatory")
    @NotEmpty(message = "Password is mandatory")
    @Pattern(regexp = "((?=.*[a-z])(?=.*\\\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,20})", flags = Pattern.Flag.UNICODE_CASE)
    private String password = BCrypt.hashpw("", BCrypt.gensalt());

    @OneToMany
    @JoinColumn(name = "id_child")
    private List<Child> children = new ArrayList<>();   // czy lepiej byłoby korzystać z set?



}
