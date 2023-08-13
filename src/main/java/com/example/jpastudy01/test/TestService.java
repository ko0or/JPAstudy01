package com.example.jpastudy01.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

}
