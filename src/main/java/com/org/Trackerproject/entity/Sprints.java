package com.org.Trackerproject.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "sprints")
@Data
public class Sprints {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "sprint_id",nullable = false)
	private int sprint_id;
	@Column(name = "sprint_name",nullable = false)
	private String sprint_name;
	private String sprint_desc;
	private boolean is_deleted;
	@Column(name = "created_by",nullable = false)
	private int created_by;
	@Column(name = "created_date",nullable = false)
    private LocalDateTime created_date;
	private int modified_by;
	private LocalDateTime modified_date;



}
