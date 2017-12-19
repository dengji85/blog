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
import com.dengji85.blog.model.Actress;
import com.dengji85.blog.model.Article;
import com.dengji85.blog.param.ActressParam;
import com.dengji85.blog.param.ArticleParam;
import com.dengji85.blog.param.DictParam;
import com.dengji85.blog.resultmap.ArticleResultMap;
import com.dengji85.blog.service.ActressService;
import com.dengji85.blog.service.ArticleService;
import com.dengji85.blog.service.DictService;

@Controller
@RequestMapping("back/actress")
public class ActressBackController {
	@Autowired
	private ActressService actressService;
	@Autowired
	private DictService dictService;

	@RequestMapping("/toIndex")
	public String toIndex() {

		return "manager/actress/actressList";
	}

	@RequestMapping("/toAdd")
	public String toAdd(ModelMap map) {
		map.put("actress", new Actress());
		map.put("types", this.dictService.getByClassCode(new DictParam(BlogConstants.CLASS_CODE_ACTRESS_TYPE) ));
		return "manager/actress/actressInfo";
	}

	@RequestMapping("/toEdit")
	public String toEdit(ModelMap map, ActressParam param) {
		map.put("actress",this.actressService.searchById(param));
		map.put("types", this.dictService.getByClassCode(new DictParam(BlogConstants.CLASS_CODE_ACTRESS_TYPE) ));
		return "manager/actress/actressInfo";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public AjaxPagerResult<Actress> page(ActressParam param) {
		AjaxPagerResult<Actress> page = new AjaxPagerResult<Actress>();
		try {
			page = this.actressService.page(param);
			page.setPage(param.getPage());
			page.setLimit(param.getLimit());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public MessageResponse<String> add(Actress param) {
		MessageResponse<String> ret = new MessageResponse<>();
		try {
			this.actressService.addActress(param);
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
			this.actressService.deleteActressById(id);
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
	public MessageResponse<String> update(@PathVariable Long id,Actress param) {
		MessageResponse<String> ret = new MessageResponse<>();
		try {
			this.actressService.updateActress(param);
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
