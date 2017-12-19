package com.dengji85.blog.service;

import java.util.List;

import com.dengji85.blog.common.AjaxPagerResult;
import com.dengji85.blog.model.Actress;
import com.dengji85.blog.param.ActressParam;
import com.dengji85.blog.param.ArticleParam;

public interface ActressService {
	public void addActress(Actress actress);
	public Actress searchByParam(ActressParam param);
	public AjaxPagerResult<Actress> page(ActressParam param);
	public void deleteActressById(Long id);
	public void updateActress(Actress actress);
	public List<Actress> getHot(int limit);
	public Actress searchById(ActressParam param);
}
