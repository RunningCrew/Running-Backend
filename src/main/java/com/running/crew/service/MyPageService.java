package com.running.crew.service;

import com.running.crew.domain.running.Record;
import com.running.crew.dto.RecordDto;
import com.running.crew.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyPageService {

    private final RecordRepository recordRepository;

    public List<RecordDto> findRecords(Long userId) {
        List<Record> records = recordRepository.findAllByUserId(userId);
        return records.stream()
                .map(it -> new RecordDto(it.getId(), it.getUser().getNickname(), it.getAddress(), it.getAveragePace(),
                        it.getTotalDistance(), it.getTotalTime(), it.getTotalCalory(), it.getStartTime(), it.getEndTime()))
                .collect(Collectors.toList());
    }

    public RecordDto findRecord(Long userId, Long recordId) {
        Record record = recordRepository.findByIdAndUserId(recordId, userId).get();
        return new RecordDto(record.getId(), record.getUser().getNickname(), record.getAddress(), record.getAveragePace(),
                record.getTotalDistance(), record.getTotalTime(), recordId, record.getStartTime(), record.getEndTime());
    }
}
