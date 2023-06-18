package com.mealkit.productmicro.web.controller;

import com.mealkit.productmicro.domain.dto.TagDto;
import com.mealkit.productmicro.domain.service.tag.TagService;
import com.mealkit.productmicro.mapper.TagMapper;
import com.mealkit.productmicro.web.request.TagApiInput;
import com.mealkit.productmicro.web.response.TagApiOutput;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tag")
@Tag(name= "Tag Service")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;

    @GetMapping("/getAll")
    public ResponseEntity<List<TagApiOutput>> getTags() {
        List<TagDto> tagDtoList = tagService.getTags();
        return new ResponseEntity<>(tagMapper.tagDtoListToApiOutputList(tagDtoList), HttpStatus.OK);
    }

    @GetMapping("/getById/{tagId}")
    public ResponseEntity<TagApiOutput> getTagById(@PathVariable Long tagId) throws Exception {

        TagDto tagDto = tagService.getTagById(tagId);
        if (tagDto == null) {
            throw new Exception("Tag with id " + tagId + " not found");
        }
        return new ResponseEntity<>(tagMapper.tagDtoToApiOutput(tagDto), HttpStatus.OK);
    }

    @PostMapping("/getTagsByIds")
    public ResponseEntity<List<TagApiOutput>> getTagsByIds(@RequestBody List<Long> tagIdList) {

        List<TagDto> tagDtoList = tagService.getTagsByIds(tagIdList);
        return new ResponseEntity<>(tagMapper.tagDtoListToApiOutputList(tagDtoList), HttpStatus.OK);
    }

    @PostMapping("/createTag")
    public ResponseEntity<Void> createTag(@RequestBody TagApiInput tagApiInput) {
        tagService.createTag(tagMapper.tagApiInputToDto(tagApiInput));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
