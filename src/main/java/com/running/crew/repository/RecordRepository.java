package com.running.crew.repository;


import com.running.crew.domain.running.Record;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findAllByUserId(Long userId);
}
