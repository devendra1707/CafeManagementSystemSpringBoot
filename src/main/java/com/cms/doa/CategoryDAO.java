package com.cms.doa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.model.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

	List<Category> getAllCategory();

}
