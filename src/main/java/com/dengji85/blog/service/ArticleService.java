package com.dengji85.blog.service;

import java.util.List;

import com.dengji85.blog.common.AjaxPagerResult;
import com.dengji85.blog.model.Article;
import com.dengji85.blog.model.Visit;
import com.dengji85.blog.param.ArticleParam;
import com.dengji85.blog.resultmap.ArticleResultMap;

public interface ArticleService {
	public void addArtice(Article article);
	public ArticleResultMap searchByParam(ArticleParam param);
	public AjaxPagerResult<ArticleResultMap> page(ArticleParam param);
	public void deleteArticleById(Long id);
	public void updateArtice(Article article);
	public List<ArticleResultMap> getHot(int limit);
	
}
