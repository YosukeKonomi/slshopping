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
	
	/**
	 * カテゴリー情報登録処理
	 * 
	 * @param category 保存したいカテゴリー情報
	 * @return 保存したカテゴリー情報
	 */
	public Category save(Category category) {
		return categoryRepository.save(category);
	}
	
	/**
	 * IDに紐づくカテゴリー情報取得処理
	 * 
	 * @param id カテゴリーID
	 * @return カテゴリー情報
	 */
	public Category get(Long id) {
		return categoryRepository.findById(id).get();
	}
	
	/**
	 * IDに紐づくカテゴリー情報削除処理
	 * 
	 * @param id カテゴリーID
	 */
	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}
}
