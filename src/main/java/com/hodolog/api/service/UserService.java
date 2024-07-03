package com.hodolog.api.service;

import com.hodolog.api.domain.User;
import com.hodolog.api.exception.UserNotFound;
import com.hodolog.api.repository.UserRepository;
import com.hodolog.api.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse getUserProfile(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFound::new);

        return new UserResponse(user);
    }
}
