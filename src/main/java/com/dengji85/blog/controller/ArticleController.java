package com.dengji85.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dengji85.blog.common.AjaxPagerResult;
import com.dengji85.blog.common.BlogConstants;
import com.dengji85.blog.config.VisitAspect;
import com.dengji85.blog.mapper.DictMapper;
import com.dengji85.blog.model.Article;
import com.dengji85.blog.model.Dict;
import com.dengji85.blog.model.Visit;
import com.dengji85.blog.param.ArticleParam;
import com.dengji85.blog.param.DictParam;
import com.dengji85.blog.resultmap.ArticleResultMap;
import com.dengji85.blog.service.ArticleService;
import com.dengji85.blog.service.CommonService;
import com.dengji85.blog.service.DictService;

@Controller
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private DictService dictService;
	@Autowired
	private CommonService commonService;
	private Logger log = Logger.getLogger(getClass());

	@RequestMapping(value="/page",method=RequestMethod.GET)
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
		map.put("msg", param.getKeyWords());
		// 根据类型选择为空时提示信息
		if (null != param.getType() && param.getKeyWords() == null) {
			dictParam.setDictCode(String.valueOf(param.getType()));
			Dict dict = this.dictService.getByDictCode(dictParam);
			map.put("msg", dict.getDictValue());
		}

		map.put("type", param.getType());
		map.put("keyWords", param.getKeyWords());
		return "article";

	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String viewArticleById(ModelMap map, @PathVariable Long id,HttpServletRequest request) {
		
		
		
		ArticleParam param = new ArticleParam();
		param.setId(id);
		ArticleResultMap article = this.articleService.searchByParam(param);
		map.put("article", article);

		DictParam dictParam = new DictParam();
		dictParam.setClassCode(BlogConstants.CLASS_CODE_ARTICLE_TYPE);
		map.put("articleTypes", this.dictService.getByClassCode(dictParam));

		return "detail";
	}

}
