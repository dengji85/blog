package com.dengji85.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dengji85.blog.common.BlogConstants;
import com.dengji85.blog.exception.MessageException;
import com.dengji85.blog.mapper.DictMapper;
import com.dengji85.blog.model.Dict;
import com.dengji85.blog.model.DictExample;
import com.dengji85.blog.model.DictExample.Criteria;
import com.dengji85.blog.param.DictParam;
import com.dengji85.blog.service.DictService;

@Service
public class DictServiceImpl implements DictService {
	@Autowired
	private DictMapper dictMapper;

	@Override
	public List<Dict> getByClassCode(DictParam param) {
		DictExample example = new DictExample();
		Criteria criteria = example.createCriteria();
		if (null == param.getClassCode()) {
			throw new MessageException(101);
		}
		criteria.andClassCodeEqualTo(param.getClassCode());
		criteria.andDelFlagEqualTo(BlogConstants.DELETE_FLAG_0);
		return dictMapper.selectByExample(example);
	}

	@Override
	public Dict getByDictCode(DictParam param) {

		DictExample example = new DictExample();
		Criteria criteria = example.createCriteria();
		criteria.andDictCodeEqualTo(param.getDictCode());
		criteria.andDelFlagEqualTo(BlogConstants.DELETE_FLAG_0);
		criteria.andClassCodeEqualTo(param.getClassCode());
		return this.dictMapper.selectByExample(example).get(0);
	}
}
