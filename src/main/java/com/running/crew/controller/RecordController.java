package com.running.crew.controller;


import com.running.crew.controller.request.RecordResponse;
import com.running.crew.domain.running.Record;
import com.running.crew.service.RecordService;
import java.util.*;
import java.util.stream.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/record")
@RequiredArgsConstructor
public class RecordController {
    private final RecordService recordService;

    @GetMapping("/{userId}")
    public List<RecordResponse> getRecords(@PathVariable Long userId) {
        List<Record> records = recordService.findAllByUser(userId);
        return records.stream().map(RecordResponse::from).collect(Collectors.toList());
    }
}
