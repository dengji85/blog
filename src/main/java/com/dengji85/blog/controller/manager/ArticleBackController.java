package com.dengji85.blog.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dengji85.blog.common.AjaxPagerResult;
import com.dengji85.blog.common.MessageResponse;
import com.dengji85.blog.model.Article;
import com.dengji85.blog.param.ArticleParam;
import com.dengji85.blog.resultmap.ArticleResultMap;
import com.dengji85.blog.service.ArticleService;

@Controller
@RequestMapping("back/article")
public class ArticleBackController {
	@Autowired
	private ArticleService articleService;

	@RequestMapping("/toIndex")
	public String toIndex() {

		return "manager/datalist";
	}

	@RequestMapping("/toAdd")
	public String toAdd() {

		return "manager/articleInfo";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public AjaxPagerResult<ArticleResultMap> page(ArticleParam param) {
		AjaxPagerResult<ArticleResultMap> page = new AjaxPagerResult<ArticleResultMap>();
		try {
			page = this.articleService.page(param);
			page.setPage(param.getPage());
			page.setLimit(param.getLimit());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public MessageResponse<String> add(Article param) {
		MessageResponse<String> ret = new MessageResponse<>();
		try {
			this.articleService.addArtice(param);
		} catch (Exception e) {
			e.printStackTrace();
			ret.setCode(999);
			ret.setMsg(e.getMessage());
		}
		return ret;

	}
}
