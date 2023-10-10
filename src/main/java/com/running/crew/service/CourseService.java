package com.running.crew.service;

import com.running.crew.domain.course.Course;
import com.running.crew.dto.CourseDto;
import com.running.crew.dto.CourseResponseDto;
import com.running.crew.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    /**
     * 러닝 코스 추천받기
     *
     * @param location
     * @return
     */
    public CourseResponseDto recommendCourse(String location) {
        List<Course> courseList = courseRepository.findByLnmAddrOrSignguNmContaining(location);
        List<CourseDto> courseDtoList = courseList.stream()
                .map(it -> new CourseDto(it.getId(), it.getEsntlId(), it.getWlkCoursFlagNm(), it.getWlkCoursNm(),
                        it.getCoursDc(), it.getSignguNm(), it.getCoursLevelNm(), it.getCoursLtCn(),
                        it.getCoursDetailLtCn(), it.getAditDc(), it.getCoursTimeCn(), it.getOptnDc(),
                        it.getToiletDc(), it.getCvntlNm(), it.getLnmAddr(), it.getCoursSpotLa(), it.getCoursSpotLo()))
                .collect(Collectors.toList());
        return new CourseResponseDto(courseDtoList);
    }

}
