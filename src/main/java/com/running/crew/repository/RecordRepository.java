package com.running.crew.repository;

import com.running.crew.domain.running.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecordRepository extends JpaRepository<Record, Long> {

    List<Record> findAllByUserId(Long userId);
    Optional<Record> findByIdAndUserId(Long id, Long userId);
}
