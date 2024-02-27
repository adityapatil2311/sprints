package com.org.Trackerproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.org.Trackerproject.dto.SprintsDto;
import com.org.Trackerproject.entity.Sprints;
import com.org.Trackerproject.exception.ResourcesNotFound;
import com.org.Trackerproject.mapper.SprintsMapper;
import com.org.Trackerproject.payload.SprintApiResponse;
import com.org.Trackerproject.repository.SpritsRepository;

@Service
@Component
public class SprintsServiceImpl implements SprintsService {

	@Autowired
	private SpritsRepository spritsrepository;

	@Autowired
	private SprintsMapper mapper;

	@Override
	public SprintApiResponse addData(SprintsDto sprintsdto) {
		try {
			Sprints sprints = mapper.mapSprintsDtoToSprints(sprintsdto);
			Sprints savesprints = spritsrepository.save(sprints);
			SprintsDto savesprintsdto = mapper.mapSprintsToSprintsDto(savesprints);
			return new SprintApiResponse(savesprintsdto, null, null, HttpStatus.CREATED, "data add successfully", false);
		} catch (Exception e) {
			return new SprintApiResponse(null, null, null, HttpStatus.NOT_FOUND, "Internal Server Error", true);
		}

	}

	@Override
	public SprintApiResponse getAllDataSprints() {
		try {
			List<Sprints> sprintsList = spritsrepository.findAll();
			List<SprintsDto> Dto = mapper.mapSprintsListToSprintsDtoList(sprintsList);
			return new SprintApiResponse(null, Dto, null, HttpStatus.OK, "Get All Data successfully", false);
		} catch (Exception e) {
			return new SprintApiResponse(null, null, null, HttpStatus.NOT_FOUND, "Internal Server Error", true);
		}
	}

	@Override
	public SprintApiResponse updateSprints(SprintsDto sprintsdto, int id) {
		try {
			Sprints existingSprints = spritsrepository.findById(id)
					.orElseThrow(() -> new ResourcesNotFound("Sprints", "Id", id));

			existingSprints.setSprint_name(sprintsdto.getSprint_name());
			existingSprints.setSprint_desc(sprintsdto.getSprint_desc());
			existingSprints.setCreated_by(sprintsdto.getCreated_by());
			existingSprints.setCreated_date(sprintsdto.getCreated_date());
			existingSprints.set_deleted(sprintsdto.is_deleted());
			existingSprints.setModified_by(sprintsdto.getModified_by());
			existingSprints.setModified_date(sprintsdto.getModified_date());
			SprintsDto dto = mapper.mapSprintsToSprintsDto(spritsrepository.save(existingSprints));
			return new SprintApiResponse(dto, null, null, HttpStatus.OK, "data updated successfully", false);
		} catch (Exception e) {
			return new SprintApiResponse(null, null, null, HttpStatus.NOT_FOUND, "Internal Server Error", true);
		}

	}

	@Override
	public SprintApiResponse deleteData(int id) {
		try {
			spritsrepository.deleteById(id);
			return new SprintApiResponse(null, null, null, HttpStatus.OK, "data delete successfully", false);
		} catch (Exception e) {
			return new SprintApiResponse(null, null, null, HttpStatus.NOT_FOUND, "Internal Server Error", true);
		}

	}

	@Override
	public SprintApiResponse getById(int id) {
		try {
			Sprints sprints = spritsrepository.findById(id)
					.orElseThrow(() -> new ResourcesNotFound("Sprints", "Id", id));
			SprintsDto dto = mapper.mapSprintsToSprintsDto(sprints);
			return new SprintApiResponse(dto, null, null, HttpStatus.OK, "data get By ID successfully", false);
		} catch (Exception e) {
			return new SprintApiResponse(null, null, null, HttpStatus.NOT_FOUND, "Internal Server Error", true);
		}

	}

}
