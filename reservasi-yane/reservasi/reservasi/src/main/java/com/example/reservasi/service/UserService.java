package com.example.reservasi.service;

import com.example.reservasi.model.User;
import com.example.reservasi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            // Validasi password simpel (bisa dikembangkan pakai enkripsi nanti)
            return user.getPassword().equals(password);
        }
        return false;
    }
}