package com.example.booking.service.impl;

import com.example.booking.dto.RoleDTO;
import com.example.booking.dto.UserRegistrationDTO;
import com.example.booking.entity.Role;
import com.example.booking.entity.User;
import com.example.booking.mapper.UserRegistrationMapper;
import com.example.booking.repository.UserRepository;
import com.example.booking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    private final UserRegistrationMapper userRegistrationMapper;

    @Override
    public User save(UserRegistrationDTO userRegistrationDTO) {
        try {
            User user = new User(userRegistrationDTO.getLogin(),
                    passwordEncoder.encode(userRegistrationDTO.getPassword()),
                    List.of(new Role("ROLE_ADMIN")));
            return userRepository.save(user);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public String getUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails userDetails) {
            username = (userDetails).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserRegistrationDTO user = userRegistrationMapper.toUserRegistrationDTO(userRepository.findByLogin(username));
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(), user.getPassword(), mapRolesToAuthorities(user.getUserRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<RoleDTO> roleDTOS) {
        return roleDTOS.stream().map(roleDTO -> new SimpleGrantedAuthority(roleDTO.getName())).toList();
    }
}
