package com.running.crew.repository;


import com.running.crew.domain.Friend;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Long> {
    List<Friend> findAllByUserId(Long userId);

    Optional<Friend> findByUserIdAndFriendId(Long userId, Long friendId);
}
