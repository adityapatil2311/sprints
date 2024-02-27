package com.org.Trackerproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.Trackerproject.dto.SprintsDto;
import com.org.Trackerproject.payload.SprintApiResponse;
import com.org.Trackerproject.service.SprintsServiceImpl;

@RestController
@RequestMapping("/spi")
public class ControllerImpl implements SprintsController {

	@Autowired
	private SprintsServiceImpl sprintsserviceimpl;

	@PostMapping("/post")
	@Override
	public SprintApiResponse addData(@RequestBody SprintsDto sprintsdto) {
		return sprintsserviceimpl.addData(sprintsdto);
	}

	
	@GetMapping("/getall")
	@Override
	public SprintApiResponse getAll() {
		return sprintsserviceimpl.getAllDataSprints();
	}

	@PutMapping("/update/{id}")
	@Override
	public SprintApiResponse updateSprints(@RequestBody SprintsDto sprintsdto, @PathVariable("id") int id) {
		return sprintsserviceimpl.updateSprints(sprintsdto, id);

	}

	@DeleteMapping("/DELETE/{id}")
	@Override
	public SprintApiResponse deleteData(@PathVariable("id") int id) {
		return sprintsserviceimpl.deleteData(id);

	}

	@GetMapping("/getById/{id}")
	@Override
	public SprintApiResponse getById(@PathVariable("id") int id) {
		return sprintsserviceimpl.getById(id);

	}

}
