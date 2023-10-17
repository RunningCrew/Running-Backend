package com.running.crew.domain.letter;


import com.running.crew.domain.user.User;
import javax.persistence.*;
import lombok.*;

/**
 * User 사이의 쪽지를 나타내는 테이블입니다.
 *
 * <p>User -> Letter <- User 로 N:M 관계를 맺습니다
 */
@Entity
@Table(name = "letter")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 유저 */
    @ManyToOne
    @JoinColumn(name = "sender_user_id", nullable = false)
    private User sender;

    /** 유저 */
    @ManyToOne
    @JoinColumn(name = "receiver_user_id", nullable = false)
    private User receiver;

    private String content;
}
