package com.example.jpastudy01.test;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @PostMapping("create")
    public String create(@RequestBody TestDTO dto) {
        testService.create(dto);
        log.info("@@@ save ### => " + dto);
        return "save test";
    }

    @GetMapping("/list")
    public List<TestDTO> list() {
        return testService.list();
    }

    @GetMapping("/read")
    public TestDTO read(TestDTO dto) {
        log.info("@@@ read ### => " + dto);
        return testService.read(dto);
    }

    @PatchMapping("/update")
    public TestDTO update(@RequestBody TestDTO dto) {
        log.info("@@@ update ### => " + dto);
        return testService.update(dto);
    }

    @DeleteMapping("/delete")
    public String delete(TestDTO dto) {
        log.info("@@@ delete ### => " + dto);
        testService.delete(dto);
        return "delete test";
    }

    @GetMapping("/test")
    public List<TestDTO> test(String keyword) {
        return testService.test(keyword);
    }
}


