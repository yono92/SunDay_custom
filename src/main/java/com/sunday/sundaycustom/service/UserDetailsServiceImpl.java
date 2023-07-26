package com.sunday.sundaycustom.service;

import com.sunday.sundaycustom.model.User;
import com.sunday.sundaycustom.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList; // 이 부분을 추가해주세요

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        User user = userRepository.findByUserId ( userid );
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + userid);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUserId (), user.getPassword(), new ArrayList<>()
        );
    }

    // getAuthorities() 메서드 등 다른 메서드들...
}
