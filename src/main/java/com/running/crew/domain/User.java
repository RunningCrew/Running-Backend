package com.running.crew.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.running.crew.domain.running.Record;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 유저 이메일
	 */
	@Column(name = "email", nullable = false)
	private String email;

	/**
	 * 카카오 유저 고유번호
	 */
	@Column(name = "oauth_id", nullable = false)
	private String oauthId;

	/**
	 * 카카오 프로필 이미지
	 */
	@Column(name = "profile_image", nullable = true)
	private String profileImage;

	/**
	 * 닉네임
	 */
	@Column(name = "nickname", nullable = false)
	private String nickname;

	/**
	 * 유저가 관계맺은 친구 리스트
	 */
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Friend> friends;

	/**
	 * 유저의 러닝 기록(들)
	 */
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Record> records;
}