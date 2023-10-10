package com.running.crew.repository;

import com.running.crew.domain.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    /**
     * lnm_addr -> lnmAddr
     * signgu_nm -> signguNm
     */
    @Query("SELECT c FROM Course c WHERE c.lnmAddr LIKE %:keyword% OR c.signguNm LIKE %:keyword%")
    List<Course> findByLnmAddrOrSignguNmContaining(@Param("keyword") String keyword);
}
