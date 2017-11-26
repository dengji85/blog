package com.dengji85.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dengji85.blog.common.AjaxPagerResult;
import com.dengji85.blog.model.Article;
import com.dengji85.blog.param.ArticleParam;
import com.dengji85.blog.resultmap.ArticleResultMap;
import com.dengji85.blog.service.ArticleService;

@Controller
public class IndexController {
	@Autowired
	private ArticleService articleService;

	@RequestMapping("/")
	public void index() {
		this.index();
	}

	@RequestMapping("/index")
	public String index(ModelMap map, ArticleParam param) {
		if (null == param) {
			param = new ArticleParam();

		}

		param.setLimit(7);
		AjaxPagerResult<ArticleResultMap> data = this.articleService
				.page(param);
		data.setPage(param.getPage());
		map.put("articles", data);
		return "home";
	}

	@RequestMapping("/article/{id}")
	public String viewArticleById(ModelMap map, @PathVariable Long id) {
		ArticleParam param = new ArticleParam();
		param.setId(id);
		map.put("article", this.articleService.searchByParam(param));
		return "detail";
	}

	
}
