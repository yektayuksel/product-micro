package com.mealkit.productmicro.domain.service.tag;

import com.mealkit.productmicro.domain.dto.TagDto;

import java.util.List;

public interface TagService {

    List<TagDto> getTags();

    TagDto getTagById(Long tagId) throws Exception;

    List<TagDto> getTagsByIds(List<Long> tagIdList);

    void addTag(TagDto tagDto);
}
