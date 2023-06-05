package com.running.crew.domain.base;

import java.time.LocalDateTime;

import javax.persistence.Column;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TimeBase {

	@Column(name = "created_at", columnDefinition = "TIMESTAMP(6)", nullable = false, updatable = false)
	protected LocalDateTime createdAt;

	@Column(name = "updated_at", columnDefinition = "TIMESTAMP(6)", nullable = false)
	protected LocalDateTime updatedAt;
}
