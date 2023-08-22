package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import com.example.demo.entity.Category;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository repository;

    @Test
    public void find(){
        Category category = Category.builder()
                                    .id(1)
                                    .topCategoryId(1)
                                    .name("한식")
                                    .build();
        Category category2 = repository.findById(1);

        assertEquals(category, category2, "동일함");

    }
}
