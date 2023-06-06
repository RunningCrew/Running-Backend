package com.running.crew.domain.running;


import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 유저의 러닝 기록에 대한 세부적인 정보를 나타내는 테이블입니다.
 *
 * <p>유저가 러닝을 하는 동안의 위경도 좌표값과 시간들이 기록됩니다.
 */
@Entity
@Table(name = "record_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecordDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 해당 러닝 기록 */
    @ManyToOne
    @JoinColumn(name = "record_id", nullable = false)
    private Record record;

    /** 현재 시각 */
    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    /** 위도 */
    @Column(name = "latitude", nullable = false)
    private Float latitude;

    /** 경도 */
    @Column(name = "longitude", nullable = false)
    private Float longitude;
}
