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

    public User() {
    }

    public User(@NotNull(message = "Login is mandatory") @NotEmpty(message = "Login is mandatory") String login, @NotNull @NotEmpty String firstName, @NotNull @NotEmpty String lastName, @NotNull(message = "Email is mandatory") @NotEmpty(message = "Email is mandatory") @Email @Pattern(regexp = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}", flags = Pattern.Flag.UNICODE_CASE) String email, @NotNull(message = "Password is mandatory") @NotEmpty(message = "Password is mandatory") @Pattern(regexp = "((?=.*[a-z])(?=.*\\\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,20})", flags = Pattern.Flag.UNICODE_CASE) String password, List<Child> children) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
