package com.org.Trackerproject.payload;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import com.org.Trackerproject.dto.SprintsDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SprintApiResponse {

	private SprintsDto sprintDto;
	private List<SprintsDto> sprintsDtoList;
	private Page<SprintsDto> sprintDtoPage;
	private HttpStatus status;
	private String message;
	private boolean error;

}
