package com.example.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Category;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	/**
	 * カテゴリー情報全件取得
	 * 
	 * @return カテゴリー情報のリスト
	 */
	
	public List<Category> listAll(String keyword){
		// 検索キーワードがあった場合
		if(keyword != null && !keyword.isEmpty()) {
			return categoryRepository.search(keyword);
		}
		// それ以外の場合
		else {
			return categoryRepository.findAll();
		}
	}
}
