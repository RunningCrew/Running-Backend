package com.running.crew.service;


import com.running.crew.domain.running.Record;
import com.running.crew.repository.RecordRepository;
import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RecordService {
    private final RecordRepository recordRepository;

    public List<Record> findAllByUser(Long userId) {
        return recordRepository.findAllByUserId(userId);
    }
}
