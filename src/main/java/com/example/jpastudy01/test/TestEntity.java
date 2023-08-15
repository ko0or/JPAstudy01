package com.example.jpastudy01.test;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test")
public class TestEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column private String title;
    @Column private String content;

    public TestDTO toDTO() {
        return TestDTO.builder()
                      .id(this.id)
                      .title(this.title)
                      .content(this.content)
                      .build();
    }
}
