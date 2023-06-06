package com.running.crew.domain.running;


import com.running.crew.domain.User;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User의 러닝 기록을 나타내는 테이블입니다.
 *
 * <p>하나의 러닝 기록에 대한 전체적인 정보를 가지고 있습니다.
 */
@Entity
@Table(name = "record")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 유저 */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /** 러닝 기록의 시작 주소를 나타냅니다 */
    @Column(name = "address", nullable = false)
    private String address;

    /** 평균 페이스 */
    @Column(name = "average_pace")
    private Float averagePace;

    /** 운동 총 거리 */
    @Column(name = "total_distance")
    private Float totalDistance;

    /** 운동 총 시간 */
    @Column(name = "total_time")
    private LocalTime totalTime;

    /** 소모한 총 칼로리 */
    @Column(name = "total_calory")
    private Long totalCalory;

    /** 러닝 기록 시작 시간 */
    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    /** 러닝 기록 종료 시간 */
    @Column(name = "end_time")
    private LocalTime endTime;

    /** 러닝 세부 기록들 */
    @OneToMany(
            mappedBy = "record",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<RecordDetail> recordDetails;
}
