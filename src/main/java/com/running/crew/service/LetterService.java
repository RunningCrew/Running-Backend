package com.running.crew.service;


import com.running.crew.domain.letter.Letter;
import com.running.crew.domain.user.User;
import com.running.crew.repository.LetterRepository;
import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LetterService {
    private final LetterRepository letterRepository;

    public List<Letter> getLettersByReceiver(User receiver) {
        return letterRepository.findAllBySender(receiver);
    }

    public List<Letter> getLettersBySenderAndReceiver(User sender, User receiver) {
        return letterRepository.findAllBySenderAndReceiver(sender, receiver);
    }

    public Letter sendLetter(User sender, User receiver, String content) {
        Letter letter = Letter.builder().sender(sender).receiver(receiver).content(content).build();
        return letterRepository.save(letter);
    }
}
