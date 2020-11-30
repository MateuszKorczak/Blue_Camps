package org.niebieskidom.bluecamps.services;

import org.niebieskidom.bluecamps.entity.User;
import org.niebieskidom.bluecamps.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> showUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

}
