package com.example.jpastudy01.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public void create(TestDTO dto) {
        testRepository.save(dto.toEntity());
    }

    public TestDTO read(TestDTO dto) {
        return testRepository.findById(dto.getId()).orElseThrow().toDTO();
    }

    public TestDTO update(TestDTO dto) {
        TestEntity update = TestEntity.builder()
                                      .id(dto.getId())
                                      .title(dto.getTitle())
                                      .content(dto.getContent())
                                      .build();
        return testRepository.save(update).toDTO();
    }

    public void delete(TestDTO dto) {
        testRepository.deleteById(dto.getId());
    }


    public List<TestDTO> list() {
/*         List<TestEntity> entitys = testRepository.findAll();
        List<TestDTO> dtos = new ArrayList<>();
        entitys.forEach( entity -> dtos.add( entity.toDTO() ));
        return dtos;
        return entitys.stream().map(e -> e.toDTO()).collect(Collectors.toList());*/
        return testRepository.findAll()
                             .stream()
                                .map(TestEntity::toDTO)
                                .collect(Collectors.toList());
    }


    public List<TestDTO> test(String keyword) {
        return testRepository.findByTitleLike(keyword)
                             .stream()
                                .map(entity -> entity.toDTO())
                                .collect(Collectors.toList());
    }
}
