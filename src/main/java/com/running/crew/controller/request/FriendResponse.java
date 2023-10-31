package com.running.crew.controller.request;


import com.running.crew.domain.Friend;
import com.running.crew.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FriendResponse {
    private User friend;

    public static FriendResponse from(Friend friend) {
        return FriendResponse.builder().friend(friend.getFriend()).build();
    }
}
