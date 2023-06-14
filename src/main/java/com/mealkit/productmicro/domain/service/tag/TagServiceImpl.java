package com.mealkit.productmicro.domain.service.tag;

import com.mealkit.productmicro.dao.entity.TagEntity;
import com.mealkit.productmicro.dao.repository.TagRepository;
import com.mealkit.productmicro.domain.dto.TagDto;
import com.mealkit.productmicro.mapper.TagMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService{

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;



    public TagServiceImpl(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }
    @Override
    public List<TagDto> getTags() {

        List<TagEntity> tagEntityList = tagRepository.findAll();

        return tagMapper.tagEntityListToDtoList(tagEntityList);
    }



    @Override
    public TagDto getTagById(Long tagId) throws Exception {

        Optional<TagEntity> tagEntity = tagRepository.findById(tagId);

        if(tagEntity.isPresent()){
            return tagMapper.tagEntityToDto(tagEntity.get());
        }else {
            throw new Exception("Tag Not Found");
        }

    }

    @Override
    public List<TagDto> getTagsByIds(List<Long> tagIdList) {

        List<TagEntity> tagEntityList = tagRepository.findAllById(tagIdList);
        return tagMapper.tagEntityListToDtoList(tagEntityList);
    }

    @Override
    public void addTag(TagDto tagDto) {

        TagEntity tagEntity = tagMapper.tagDtoToEntity(tagDto);
        tagRepository.save(tagEntity);
    }
}
