package com.running.crew.domain;

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
 * User 의 친구 관계를 나타내는 테이블입니다.
 *
 * User -> Friend 로
 * 단방향 관계를 맺은 것을 의미합니다.
 */
@Entity
@Table(name = "friend")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Friend {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 유저
	 */
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	/**
	 * 유저가 맺은 친구
	 */
	@ManyToOne
	@JoinColumn(name = "friend_id", nullable = false)
	private User friend;
}
