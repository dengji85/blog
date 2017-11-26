package com.dengji85.blog.service;

import com.dengji85.blog.common.AjaxPagerResult;
import com.dengji85.blog.model.Article;
import com.dengji85.blog.param.ArticleParam;
import com.dengji85.blog.resultmap.ArticleResultMap;

public interface ArticleService {
	public void addArtice(Article article);
	public ArticleResultMap searchByParam(ArticleParam param);
	public AjaxPagerResult<ArticleResultMap> page(ArticleParam param);

}
