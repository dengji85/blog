package com.dengji85.blog.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dengji85.blog.common.AjaxPagerResult;
import com.dengji85.blog.common.BlogConstants;
import com.dengji85.blog.common.MessageResponse;
import com.dengji85.blog.exception.MessageException;
import com.dengji85.blog.model.Article;
import com.dengji85.blog.param.ArticleParam;
import com.dengji85.blog.param.DictParam;
import com.dengji85.blog.resultmap.ArticleResultMap;
import com.dengji85.blog.service.ArticleService;
import com.dengji85.blog.service.DictService;

@Controller
@RequestMapping("back/article")
public class ArticleBackController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private DictService dictService;

	@RequestMapping("/toIndex")
	public String toIndex() {

		return "manager/datalist";
	}

	@RequestMapping("/toAdd")
	public String toAdd(ModelMap map) {
		map.put("article", new ArticleResultMap());
		map.put("types", this.dictService.getByClassCode(new DictParam(BlogConstants.CLASS_CODE_ARTICLE_TYPE) ));
		return "manager/articleInfo";
	}

	@RequestMapping("/toEdit")
	public String toEdit(ModelMap map, ArticleParam param) {

		map.put("article", this.articleService.searchByParam(param));
		map.put("types", this.dictService.getByClassCode(new DictParam(BlogConstants.CLASS_CODE_ARTICLE_TYPE) ));

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
		} catch (MessageException e) {
			e.printStackTrace();
			ret.setCode(e.getCode());
			ret.setMsg(e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			ret.setCode(999);
			ret.setMsg("系统异常");
		}
		return ret;

	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public MessageResponse<String> delete(@PathVariable Long id) {
		MessageResponse<String> ret = new MessageResponse<>();
		try {
			this.articleService.deleteArticleById(id);
		} catch (MessageException e) {
			e.printStackTrace();
			ret.setCode(e.getCode());
			ret.setMsg(e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			ret.setCode(999);
			ret.setMsg("系统异常");
		}
		return ret;

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public MessageResponse<String> update(@PathVariable Long id,Article param) {
		MessageResponse<String> ret = new MessageResponse<>();
		try {
			this.articleService.updateArtice(param);
		} catch (MessageException e) {
			e.printStackTrace();
			ret.setCode(e.getCode());
			ret.setMsg(e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			ret.setCode(999);
			ret.setMsg("系统异常");
		}
		return ret;

	}
}
