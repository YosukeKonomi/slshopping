package com.example.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	/**
	 * カテゴリー新規登録画面表示
	 * 
	 * @param model
	 * @return カテゴリー新規登録画面
	 */
	@GetMapping("/new")
	public String newCategory(Model model) {
		// 新規登録用に、空のカテゴリー情報作成
		Category category = new Category();
		model.addAttribute("category", category);
		return "categories/category_form";
	}
	
	/**
	 * カテゴリー登録・更新処理
	 * 
	 * @param category カテゴリー情報
	 * @param ra
	 * @return カテゴリー一覧画面
	 */
	@PostMapping("/save")
	public String saveCategory(Category category, RedirectAttributes ra) {
		// カテゴリー情報の登録
		categoryService.save(category);
		// 登録成功のメッセージを格納
		ra.addFlashAttribute("success_message", "登録に成功しました");
		return "redirect:/categories";
	}
	
	/**
	 * カテゴリー詳細画面表示
	 * 
	 * @param id カテゴリーID
	 * @param model
	 * @return カテゴリー詳細画面
	 */
	@GetMapping("/detail/{id}")
	public String detailCategory(@PathVariable(name = "id")Long id, Model model) {
		Category category = categoryService.get(id);
		model.addAttribute("category", category);
		return "categories/category_detail";
	}
	/**
	 * カテゴリー編集仮面表示
	 * 
	 * @param id カテゴリーID 
	 * @param model
	 * @return カテゴリー編集画面
	 */
	@GetMapping("/edit/{id}")
	public String editCategory(@PathVariable(name = "id") Long id, Model model) {
		// ブランドIDに紐づくブランド情報取得
		Category category = categoryService.get(id);
		model.addAttribute("category", category);
		return "categories/catefory_edit";
	}
}
