package com.relation.jpa.dto.response.tag;

import com.relation.jpa.entity.FoodTag;
import com.relation.jpa.entity.Tag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class TagResponseDto {

    private Long id;

    private String name;

    public TagResponseDto(Tag tag) {
        this.id = tag.getId();
        this.name = tag.getName();
    }

    public static TagResponseDto from(Tag tag) {
        return new TagResponseDto(tag);
    }

    public static List<TagResponseDto> from(List<Tag> tags) {
        return tags.stream().map(TagResponseDto::from).collect(Collectors.toList());
    }
}
