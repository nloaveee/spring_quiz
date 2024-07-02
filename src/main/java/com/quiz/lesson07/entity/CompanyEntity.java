package com.quiz.lesson07.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "company")
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompanyEntity {

	@Id // pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String business;

	private String scale;

	private int headcount;

	@Column(name = "createdAt")
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updatedAt")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
