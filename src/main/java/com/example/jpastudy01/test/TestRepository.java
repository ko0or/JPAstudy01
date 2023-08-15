package com.example.jpastudy01.test;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<TestEntity, Integer> {

    List<TestEntity> findByTitleLike(String keyword);
}