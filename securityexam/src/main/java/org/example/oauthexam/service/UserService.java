package org.example.oauthexam.service;

import lombok.RequiredArgsConstructor;
import org.example.oauthexam.domain.Role;
import org.example.oauthexam.repository.RoleRepository;
import org.example.oauthexam.domain.User;
import org.example.oauthexam.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    //회원가입
    @Transactional
    public User registUser(User user){
        //role 추가
        Role userRole = roleRepository.findByName("USER");
        user.setRoles(Collections.singleton(userRole));
        //password 암호화해서 넣어줘야한다.
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return  userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

//    public Optional<User> findByProviderAndSocialId(String provider, String socialId){
//        return userRepository.find
//    }
}
