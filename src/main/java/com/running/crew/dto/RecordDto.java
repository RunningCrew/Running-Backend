package com.running.crew.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalTime;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class RecordDto {

    private final long id;

    private final String nickname;

    private final String address;

    private final float averagePace;

    private final float totalDistance;

    private final LocalTime totalTime;

    private final long totalCalory;

    private final LocalTime startTime;

    private final LocalTime endTime;

}
