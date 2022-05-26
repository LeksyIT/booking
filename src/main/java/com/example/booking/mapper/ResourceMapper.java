package com.example.booking.mapper;

import com.example.booking.dto.ResourceDTO;
import com.example.booking.entity.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResourceMapper {
    @Mapping(target = "resourceTitle", source = "resource.title")
    ResourceDTO toResourceDTO(Resource resource);

    @Mapping(target = "title", source = "resourceDTO.resourceTitle")
    Resource toResource(ResourceDTO resourceDTO);

    List<ResourceDTO> toResourceDTO(List<Resource> resourceList);

    List<Resource> toResource(List<ResourceDTO> resourceDTOList);
}
