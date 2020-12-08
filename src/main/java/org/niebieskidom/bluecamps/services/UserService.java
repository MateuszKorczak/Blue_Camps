package org.niebieskidom.bluecamps.services;

import org.niebieskidom.bluecamps.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);

    List<User> showUsers();

    Optional<User> getUser(Long id);

    void deleteUser(Long id);

    void updateUser(User user);

}
