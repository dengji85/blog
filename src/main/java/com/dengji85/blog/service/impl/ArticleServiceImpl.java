package com.dengji85.blog.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dengji85.blog.common.AjaxPagerResult;
import com.dengji85.blog.common.BlogConstants;
import com.dengji85.blog.exception.MessageException;
import com.dengji85.blog.mapper.ArticleMapper;
import com.dengji85.blog.mapper.VisitMapper;
import com.dengji85.blog.model.Article;
import com.dengji85.blog.model.ArticleExample;
import com.dengji85.blog.model.ArticleExample.Criteria;
import com.dengji85.blog.model.Visit;
import com.dengji85.blog.param.ArticleParam;
import com.dengji85.blog.resultmap.ArticleResultMap;
import com.dengji85.blog.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public void addArtice(Article article) {
		article.setAddTime(new Date());
		this.articleMapper.insertSelective(article);
	}

	@Override
	public AjaxPagerResult<ArticleResultMap> page(ArticleParam param) {
		AjaxPagerResult<ArticleResultMap> result = new AjaxPagerResult<>();

		result.setData(this.articleMapper.searchPageList(param));
		Integer count = this.articleMapper.searchPageCount(param);
		result.setCount(count == null ? 0 : count);

		return result;
	}

	@Override
	public ArticleResultMap searchByParam(ArticleParam article) {
		return this.articleMapper.searchByParam(article);
	}

	@Override
	public void deleteArticleById(Long id) {
		Article record = new Article();
		record.setId(id);
		record.setDelFlag(BlogConstants.DELETE_FLAG_1);
		this.articleMapper.updateByPrimaryKeySelective(record);

	}

	@Override
	public void updateArtice(Article article) {
		if (null == article.getId()) {
			throw new MessageException(102);
		}
		this.articleMapper.updateByPrimaryKeySelective(article);

	}

	@Override
	public List<ArticleResultMap> getHot(int limit) {
		if(limit == 0){
			limit = 7;
		}
		List<ArticleResultMap> result = new ArrayList<>();
		ArticleExample example = new ArticleExample();
		Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo(BlogConstants.DELETE_FLAG_0);
		example.setOrderByClause("view_Num DESC");
		RowBounds rowBounds = new RowBounds(0, limit);
		List<Article> list = this.articleMapper.selectByExampleWithBLOBsWithRowbounds(example, rowBounds);
		if(null!=list){
			ArticleResultMap t = null;
			for (Article article : list) {
				t = new ArticleResultMap();
				t.setId(article.getId());
				t.setTitle(article.getTitle());
				result.add(t);
			}
		}
		return result;
	}

	

}
