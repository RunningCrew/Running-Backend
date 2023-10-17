package com.running.crew.controller;


import com.running.crew.controller.request.LetterResponse;
import com.running.crew.controller.request.SendLetterRequest;
import com.running.crew.domain.letter.Letter;
import com.running.crew.domain.user.User;
import com.running.crew.domain.user.UserService;
import com.running.crew.service.LetterService;
import java.util.*;
import java.util.stream.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/letters")
@RequiredArgsConstructor
public class LetterController {
    private final LetterService letterService;
    private final UserService userService;

    // 받은 쪽지 리스트
    @GetMapping("/{receiverUserId}/received")
    public List<LetterResponse> getLetterByReceiver(@PathVariable Long receiverUserId) {
        User receiver = userService.findById(receiverUserId);
        List<Letter> letter = letterService.getLettersByReceiver(receiver);
        return letter.stream().map(LetterResponse::from).collect(Collectors.toList());
    }

    // 특정 유저와 주고받은 쪽지 리스트
    @GetMapping("/{senderUserId}/{receivedUserId}")
    public List<LetterResponse> getLettersBySenderAndReceiver(
            @PathVariable Long senderUserId, @PathVariable Long receivedUserId) {
        User sender = userService.findById(senderUserId);
        User receiver = userService.findById(receivedUserId);
        List<Letter> letter = letterService.getLettersBySenderAndReceiver(sender, receiver);
        return letter.stream().map(LetterResponse::from).collect(Collectors.toList());
    }

    @PostMapping("/{senderUserId}/{receiverUserId}")
    public LetterResponse sendLetter(
            @PathVariable Long senderUserId,
            @PathVariable Long receiverUserId,
            @RequestBody SendLetterRequest request) {
        User sender = userService.findById(senderUserId);
        User receiver = userService.findById(receiverUserId);
        Letter letter = letterService.sendLetter(sender, receiver, request.getContent());
        return LetterResponse.from(letter);
    }
}
