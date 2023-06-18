package com.mealkit.productmicro.mapper;

import com.mealkit.productmicro.dao.entity.TagEntity;
import com.mealkit.productmicro.domain.dto.TagDto;
import com.mealkit.productmicro.web.request.TagApiInput;
import com.mealkit.productmicro.web.response.TagApiOutput;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {

    TagApiOutput tagDtoToApiOutput(TagDto tagDto);
    List<TagApiOutput> tagDtoListToApiOutputList(List<TagDto> tagDtoList);
    TagDto tagEntityToDto(TagEntity tagEntity);
    TagEntity tagDtoToEntity(TagDto tagDto);
    List<TagDto> tagEntityListToDtoList(List<TagEntity> tagEntityList);

    TagDto tagApiInputToDto(TagApiInput tagApiInput);
    List<TagEntity> tagDtoListToEntityList(List<TagDto> tagDtoList);
}
