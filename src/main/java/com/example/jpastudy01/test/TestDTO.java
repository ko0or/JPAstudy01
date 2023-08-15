package com.example.jpastudy01.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestDTO {

    private int id;
    private String title;
    private String content;

    public TestEntity toEntity() {
        return TestEntity.builder()
                         .title( this.title )
                         .content( this.content)
                         .build();
    }

    public TestDTO(TestEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
