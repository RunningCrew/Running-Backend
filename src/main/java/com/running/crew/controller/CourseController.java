package com.running.crew.controller;


import com.running.crew.dto.CourseResponseDto;
import com.running.crew.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    /**
     * 러닝 코스 추천
     *
     * @param location
     * @return
     */
    @GetMapping("/recommend")
    public CourseResponseDto recommendCourse(@RequestParam("location") String location) {
        return courseService.recommendCourse(location);
    }
}
