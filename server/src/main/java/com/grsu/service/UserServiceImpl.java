package com.grsu.service;


import com.grsu.dto.UserDTO;
import com.grsu.entity.Role;
import com.grsu.entity.User;
import com.grsu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService  {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
        user.ifPresent(detailsChecker::check);
        return user.orElseThrow(() -> new UsernameNotFoundException("user not found."));
    }

    @Override
    public User update(User user, UserDTO params) {
        params.getEmail().ifPresent(user::setUsername);
        params.getEncodedPassword().ifPresent(user::setPassword);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUser(Long id) {
        return Optional.of(userRepository.findOne(id));

    }

    @Override
    public User createUser(UserDTO userDTO) {
        User user = toUserRole(userDTO);
        return userRepository.save(user);
    }

    private User toUserRole(UserDTO userDTO) {
        User user = userDTO.toUser();
        Role role = new Role();
        role.setName("ROLE_USER");
        user.setRole(role);
        return user;
    }
}
