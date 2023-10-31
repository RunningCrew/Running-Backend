package com.running.crew.service;


import com.running.crew.domain.Friend;
import com.running.crew.domain.user.User;
import com.running.crew.domain.user.UserService;
import com.running.crew.exception.NotFoundException;
import com.running.crew.repository.FriendRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final UserService userService;
    private final FriendRepository friendRepository;

    public List<Friend> getFriendByUserId(Long userId) {
        return friendRepository.findAllByUserId(userId);
    }

    public Friend addFriendByEmail(Long userId, String email) {
        final User user = userService.findById(userId);
        final User oppositeUser = userService.findByEmail(email);
        final Friend friend = Friend.builder().user(user).friend(oppositeUser).build();
        return friendRepository.save(friend);
    }

    public Friend deleteFriend(Long userId, Long oppositeUserId) {
        final Friend friend =
                friendRepository
                        .findByUserIdAndFriendId(userId, oppositeUserId)
                        .orElseThrow(() -> new NotFoundException("친구가 아닙니다."));
        friendRepository.delete(friend);
        return friend;
    }
}
