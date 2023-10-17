package com.running.crew.repository;


import com.running.crew.domain.letter.Letter;
import com.running.crew.domain.user.User;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterRepository extends JpaRepository<Letter, Long> {
    List<Letter> findAllBySender(User sender);

    List<Letter> findAllBySenderAndReceiver(User sender, User receiver);
}
