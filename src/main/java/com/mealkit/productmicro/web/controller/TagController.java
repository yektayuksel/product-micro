package com.mealkit.productmicro.web.controller;

import com.mealkit.productmicro.domain.dto.TagDto;
import com.mealkit.productmicro.domain.service.tag.TagService;
import com.mealkit.productmicro.mapper.TagMapper;
import com.mealkit.productmicro.web.response.TagApiOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tag")
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;
    public TagController(TagService tagService, TagMapper tagMapper) {
        this.tagService = tagService;
        this.tagMapper = tagMapper;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TagApiOutput>> getTags() {
        List<TagDto> tagDtoList = tagService.getTags();
        return new ResponseEntity<>(tagMapper.tagDtoListToApiOutputList(tagDtoList), HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<TagApiOutput> getTagById(Long tagId) throws Exception {

        TagDto tagDto = tagService.getTagById(tagId);
        return new ResponseEntity<>(tagMapper.tagDtoToApiOutput(tagDto), HttpStatus.OK);
    }

    @PostMapping("/getTagsByIds")
    public ResponseEntity<List<TagDto>> getTagsByIds(List<Long> tagIdList) {

        List<TagDto> tagDtoList = tagService.getTagsByIds(tagIdList);
        return new ResponseEntity<>(tagDtoList, HttpStatus.OK);
    }

    @PostMapping("/addTag")
    public ResponseEntity<Void> addTag(TagDto tagDto) {

        tagService.addTag(tagDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
