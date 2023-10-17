package com.running.crew.controller.request;


import com.running.crew.domain.running.Record;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecordResponse {
    private String address;

    private Float averagePace;

    private Float totalDistance;

    private LocalTime totalTime;

    private Long totalCalory;

    private LocalTime startTime;

    private LocalTime endTime;

    public static RecordResponse from(Record record) {
        return RecordResponse.builder()
                .address(record.getAddress())
                .averagePace(record.getAveragePace())
                .totalDistance(record.getTotalDistance())
                .totalTime(record.getTotalTime())
                .totalCalory(record.getTotalCalory())
                .startTime(record.getStartTime())
                .endTime(record.getEndTime())
                .build();
    }
}
