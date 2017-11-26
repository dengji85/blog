package com.dengji85.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dengji85.blog.common.AjaxPagerResult;
import com.dengji85.blog.mapper.ArticleMapper;
import com.dengji85.blog.model.Article;
import com.dengji85.blog.param.ArticleParam;
import com.dengji85.blog.resultmap.ArticleResultMap;
import com.dengji85.blog.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public void addArtice(Article article) {
		this.articleMapper.insertSelective(article);
	}

	@Override
	public AjaxPagerResult<ArticleResultMap> page(ArticleParam param) {
		AjaxPagerResult<ArticleResultMap> result = new AjaxPagerResult<>();

		result.setData(this.articleMapper.searchPageList(param));
		Integer count = this.articleMapper.searchPageCount(param);
		result.setCount(count==null?0:count);

		return result;
	}

	@Override
	public ArticleResultMap searchByParam(ArticleParam article) {
		return this.articleMapper.searchByParam(article);
	}

	

}
