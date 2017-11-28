package com.dengji85.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dengji85.blog.common.AjaxPagerResult;
import com.dengji85.blog.common.BlogConstants;
import com.dengji85.blog.mapper.DictMapper;
import com.dengji85.blog.model.Article;
import com.dengji85.blog.param.ArticleParam;
import com.dengji85.blog.param.DictParam;
import com.dengji85.blog.resultmap.ArticleResultMap;
import com.dengji85.blog.service.ArticleService;
import com.dengji85.blog.service.DictService;

@Controller
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private DictService dictService;

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
		DictParam dictParam = new DictParam();
		dictParam.setClassCode(BlogConstants.CLASS_CODE_ARTICLE_TYPE);
		map.put("articleTypes", this.dictService.getByClassCode(dictParam));

		map.put("type", param.getType());
		map.put("keyWords", param.getKeyWords());
		return "article";

	}
	
	@RequestMapping("/{id}")
	public String viewArticleById(ModelMap map, @PathVariable Long id) {
		ArticleParam param = new ArticleParam();
		param.setId(id);
		map.put("article", this.articleService.searchByParam(param));
		
		DictParam dictParam = new DictParam();
		dictParam.setClassCode(BlogConstants.CLASS_CODE_ARTICLE_TYPE);
		map.put("articleTypes", this.dictService.getByClassCode(dictParam));
		
		return "detail";
	}

}
