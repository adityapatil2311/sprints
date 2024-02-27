package com.org.Trackerproject.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class SprintsDto {

	private int sprint_id;
	private String sprint_name;
	private String sprint_desc;
	private boolean is_deleted;
	private int created_by;
	private LocalDateTime created_date;
	private int modified_by;
	private LocalDateTime modified_date;
	//aaaaaa
}
