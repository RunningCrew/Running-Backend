package com.running.crew.domain.user;


import com.running.crew.domain.user.model.SignupRequest;
import com.running.crew.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User signup(SignupRequest request) {
        User user =
                User.builder().email(request.getEmail()).nickname(request.getNickname()).build();
        return userRepository.save(user);
    }

    public User findById(Long userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(() -> new NotFoundException("유저 정보가 없습니다."));
    }

    public User findByEmail(String email) {
        return userRepository
                .findByEmail(email)
                .orElseThrow(() -> new NotFoundException("유저 정보가 없습니다."));
    }
}
