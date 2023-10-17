package com.example.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	/**
	 * カテゴリー一覧画面表示
	 * 
	 * @param model
	 * @return カテゴリー一覧画面
	 */
	@GetMapping
	public String listCategories(@RequestParam(required = false) String keyword, Model model) {
		// 全カテゴリー情報の取得
		
		// カテゴリー一覧画面を渡す
		return "categories/categories";
	}
}
