package com.sunday.sundaycustom.service;

import com.sunday.sundaycustom.exception.UserAlreadyExistsException;
import com.sunday.sundaycustom.model.User;
import com.sunday.sundaycustom.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String userid, String username, String email, String password, String phoneNumber) {
        if (userRepository.existsByUserId(userid)) {
            throw new UserAlreadyExistsException("이미 사용 중인 사용자 ID입니다!");
        }

        if (userRepository.existsByEmail(email)) {
            throw new UserAlreadyExistsException("이미 사용 중인 이메일 주소입니다!");
        }

        String encodedPassword = passwordEncoder.encode(password);
        User user = User.createUser(userid, username, email, encodedPassword, phoneNumber);
        return userRepository.save(user);
    }
}
