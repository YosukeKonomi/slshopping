package com.example.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Category;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	private final CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	/**
	 * カテゴリー一覧画面表示
	 * 
	 * @param model
	 * @return カテゴリー一覧画面
	 */
	@GetMapping
	public String listCategories(@RequestParam(required = false) String keyword, Model model) {
		// 全カテゴリー情報の取得
		List<Category> listCategories = categoryService.listAll(keyword);
		model.addAttribute("listCategories", listCategories);
		model.addAttribute("keyword", keyword);
		// カテゴリー一覧画面を渡す
		return "categories/categories";
	}
}
