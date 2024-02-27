package com.org.Trackerproject.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.org.Trackerproject.dto.SprintsDto;
import com.org.Trackerproject.entity.Sprints;

@Mapper(componentModel = "spring")
public interface SprintsMapper {

	Sprints mapSprintsDtoToSprints(SprintsDto dto);
	SprintsDto mapSprintsToSprintsDto(Sprints sprints);
	List<SprintsDto> mapSprintsListToSprintsDtoList(List<Sprints> sprints);
	
	
}
