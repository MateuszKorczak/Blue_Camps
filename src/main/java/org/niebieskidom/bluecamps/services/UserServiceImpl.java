package org.niebieskidom.bluecamps.services;

import org.niebieskidom.bluecamps.entity.Role;
import org.niebieskidom.bluecamps.entity.User;
import org.niebieskidom.bluecamps.repositories.RoleRepository;
import org.niebieskidom.bluecamps.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }


    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }


    public List<User> showUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        Optional<User> entity = userRepository.findById(user.getId());
        if (entity.isPresent()) {
            User updatedUser = entity.get();
            if (!user.getPassword().equals(updatedUser.getPassword())) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            userRepository.save(user);
        }
    }


}
