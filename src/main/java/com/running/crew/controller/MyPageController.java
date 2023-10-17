package com.running.crew.controller;

import com.running.crew.dto.RecordDto;
import com.running.crew.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MyPageController {

    private final MyPageService myPageService;

    @GetMapping("/mypage/{userId}")
    public List<RecordDto> getAllRecords(@PathVariable Long userId) {
        return myPageService.findRecords(userId);
    }

    @GetMapping("/mypage/{userId}/{recordID}")
    public RecordDto getRecord(@PathVariable Long userId, @PathVariable Long recordId) {
        return myPageService.findRecord(userId, recordId);
    }
}
