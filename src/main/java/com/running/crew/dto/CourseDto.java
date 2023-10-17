package com.running.crew.dto;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class CourseDto {

    private final Long id;

    /** 1 - 고유ID ESNTL_ID */
    private final String esntlId;

    /** 2 - 산책경로구분명 WLK_COURS_FLAG_NM */
    private final String wlkCoursFlagNm;

    /** 3 - 산책경로명 WLK_COURS_NM */
    private final String wlkCoursNm;

    /** 4 - 경로설명 COURS_DC */
    private final String coursDc;

    /** 5 - 시군구명 SIGNGU_NM */
    private final String signguNm;

    /** 6 - 경로레벨명 COURS_LEVEL_NM */
    private final String coursLevelNm;

    /** 7 - 경로길이내용 COURS_LT_CN */
    private final String coursLtCn;

    /** 8 - 경로상세길이내용 COURS_DETAIL_LT_CN */
    private final String coursDetailLtCn;

    /** 9 - 추가설명 ADIT_DC */
    private final String aditDc;

    /** 10 - 경로시간내용 COURS_TIME_CN */
    private final String coursTimeCn;

    /** 11 - 옵션설명 OPTN_DC */
    private final String optnDc;

    /** 12 - 화장실설명 TOILET_DC */
    private final String toiletDc;

    /** 13 - 편의시설명 CVNTL_NM */
    private final String cvntlNm;

    /** 14 - 지번주소 LNM_ADDR */
    private final String lnmAddr;

    /** 15 - 경로지점위도 COURS_SPOT_LA */
    private final String coursSpotLa;

    /** 16 - 경로지점경도 COURS_SPOT_LO */
    private final String coursSpotLo;
}
