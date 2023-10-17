package com.running.crew.controller.request;


import com.running.crew.domain.letter.Letter;
import com.running.crew.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LetterResponse {
    private User senderUser;
    private User receiverUser;
    private String content;

    public static LetterResponse from(Letter letter) {
        return LetterResponse.builder()
                .senderUser(letter.getSender())
                .receiverUser(letter.getReceiver())
                .content(letter.getContent())
                .build();
    }
}
