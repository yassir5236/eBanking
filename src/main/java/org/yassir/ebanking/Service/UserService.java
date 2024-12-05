package org.yassir.ebanking.Service;


import org.yassir.ebanking.Exception.UsernameAlreadyExistsException;
import org.yassir.ebanking.Model.Entity.User;
import org.yassir.ebanking.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistsException("Le nom d'utilisateur existe déjà !");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User updateUserRole(String username, String role) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable !"));
        System.out.println("im here");

        user.setRole(role);
        return userRepository.save(user);
    }

    public void updatePassword(String username, String oldPassword, String newPassword) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable !"));

        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new RuntimeException("L'ancien mot de passe est incorrect !");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable !"));
        userRepository.delete(user);
    }
}

