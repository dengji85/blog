package com.dengji85.blog.service;

import java.util.List;

import com.dengji85.blog.model.Dict;
import com.dengji85.blog.param.DictParam;

public interface DictService {
	
	public List<Dict> getByClassCode(DictParam param);

}
