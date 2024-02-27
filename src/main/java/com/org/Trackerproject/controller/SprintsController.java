package com.org.Trackerproject.controller;

import org.springframework.web.bind.annotation.PathVariable;

import com.org.Trackerproject.dto.SprintsDto;
import com.org.Trackerproject.payload.SprintApiResponse;


public interface SprintsController {

	public SprintApiResponse addData( SprintsDto sprintsdto);
	public SprintApiResponse getAll();
	public SprintApiResponse updateSprints( SprintsDto sprintsdto, int id);
	public SprintApiResponse deleteData(@PathVariable("id") int id);
	public SprintApiResponse getById(int id);
}