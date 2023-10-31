package com.running.crew.controller;


import com.running.crew.controller.request.FriendResponse;
import com.running.crew.service.FriendService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/friends")
@RequiredArgsConstructor
public class FriendController {
    private final FriendService friendService;

    // 내 친구 리스트
    @GetMapping
    public List<FriendResponse> getFriends(@RequestParam Long userId) {
        return friendService.getFriendByUserId(userId).stream()
                .map(FriendResponse::from)
                .collect(Collectors.toList());
    }

    // 유저 친구 추가
    @PostMapping("/add")
    public FriendResponse addFriend(@RequestParam Long userId, @RequestParam String email) {
        return FriendResponse.from(friendService.addFriendByEmail(userId, email));
    }

    // 친구 삭제
    @DeleteMapping
    public FriendResponse deleteFriend(@RequestParam Long userId, @RequestParam Long friendId) {
        return FriendResponse.from(friendService.deleteFriend(userId, friendId));
    }
}
