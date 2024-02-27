package com.org.Trackerproject.service;

import com.org.Trackerproject.dto.SprintsDto;
import com.org.Trackerproject.payload.SprintApiResponse;

public interface SprintsService {

	SprintApiResponse addData(SprintsDto sprintsdto);

	SprintApiResponse getAllDataSprints();

	SprintApiResponse updateSprints(SprintsDto sprintsdto, int id);

	SprintApiResponse deleteData(int id);

	SprintApiResponse getById(int id);

}
