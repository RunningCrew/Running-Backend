package com.running.crew.domain.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 1 - 고유ID
     * ESNTL_ID
     */
    private String esntlId;

    /**
     * 2 - 산책경로구분명
     * WLK_COURS_FLAG_NM
     */
    private String wlkCoursFlagNm;

    /**
     * 3 - 산책경로명
     * WLK_COURS_NM
     */
    private String wlkCoursNm;

    /**
     * 4 - 경로설명
     * COURS_DC
     */
    private String coursDc;

    /**
     * 5 - 시군구명
     * SIGNGU_NM
     */
    private String signguNm;

    /**
     * 6 - 경로레벨명
     * COURS_LEVEL_NM
     */
    private String coursLevelNm;

    /**
     * 7 - 경로길이내용
     * COURS_LT_CN
     */
    private String coursLtCn;

    /**
     * 8 - 경로상세길이내용
     * COURS_DETAIL_LT_CN
     */
    private String coursDetailLtCn;

    /**
     * 9 - 추가설명
     * ADIT_DC
     */
    private String aditDc;

    /**
     * 10 - 경로시간내용
     * COURS_TIME_CN
     */
    private String coursTimeCn;

    /**
     * 11 - 옵션설명
     * OPTN_DC
     */
    private String optnDc;

    /**
     * 12 - 화장실설명
     * TOILET_DC
     */
    private String toiletDc;

    /**
     * 13 - 편의시설명
     * CVNTL_NM
     */
    private String cvntlNm;

    /**
     * 14 - 지번주소
     * LNM_ADDR
     */
    private String lnmAddr;

    /**
     * 15 - 경로지점위도
     * COURS_SPOT_LA
     */
    private String coursSpotLa;

    /**
     * 16 - 경로지점경도
     * COURS_SPOT_LO
     */
    private String coursSpotLo;
}
