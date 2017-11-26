package com.dengji85.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dengji85.blog.common.AjaxPagerResult;
import com.dengji85.blog.param.ArticleParam;
import com.dengji85.blog.resultmap.ArticleResultMap;
import com.dengji85.blog.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;

	@RequestMapping("/page")
	public String toIndex(ArticleParam param, ModelMap map) {

		if (null == param) {
			param = new ArticleParam();

		}
		param.setOrderNo(1);
		param.setLimit(7);
		AjaxPagerResult<ArticleResultMap> data = this.articleService
				.page(param);
		data.setPage(param.getPage());
		map.put("articles", data);
		return "article";

	}

}
