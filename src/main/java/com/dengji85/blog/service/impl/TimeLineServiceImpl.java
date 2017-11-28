package com.dengji85.blog.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dengji85.blog.common.DateUtil;
import com.dengji85.blog.mapper.TimeLineMapper;
import com.dengji85.blog.model.TimeLine;
import com.dengji85.blog.model.TimeLineExample;
import com.dengji85.blog.resultmap.TimeLineResultMap;
import com.dengji85.blog.service.TimeLineService;

@Service
public class TimeLineServiceImpl implements TimeLineService {
	@Autowired
	private TimeLineMapper timeLineMapper;

	@Override
	public List<TimeLineResultMap> getAll() {
		List<TimeLineResultMap> result = new ArrayList<>();
		TimeLineExample example = new TimeLineExample();
		example.setOrderByClause("ADD_TIME DESC");
		List<TimeLine> lists = this.timeLineMapper.selectByExample(example);
		LinkedHashSet<String> yearSet = new LinkedHashSet<String>();

		for (TimeLine t : lists) {

			yearSet.add(DateUtil.getDateYearStr(t.getAddTime()));
		}

		for (String year : yearSet) {

			LinkedHashSet<String> mouthSet = new LinkedHashSet<String>();

			for (TimeLine t : lists) {
				if (year.equals(DateUtil.getDateYearStr(t.getAddTime()))) {
					mouthSet.add(DateUtil.getDateMouthStr(t.getAddTime()));
				}
			}

			TimeLineResultMap yearLine = new TimeLineResultMap();
			yearLine.setTime(year);
			List<TimeLineResultMap> mouthList = new ArrayList<>();
			for (String mouth : mouthSet) {
				TimeLineResultMap mouthLine = new TimeLineResultMap();
				mouthLine.setTime(mouth);
				List<TimeLineResultMap> dateList = new ArrayList<>();
				for (TimeLine timeLine : lists) {
					String str = year + "-" + mouth;
					String str2 = DateUtil.getDateYearMouthStr(timeLine
							.getAddTime());
					if (str.equals(str2)) {
						TimeLineResultMap dateLine = new TimeLineResultMap();
						dateLine.setTime(DateUtil.getDateMouthDateStr(timeLine
								.getAddTime()));
						dateLine.setContent(timeLine.getContent());
						dateList.add(dateLine);
					}
				}
				mouthLine.setData(dateList);
				mouthList.add(mouthLine);

			}
			yearLine.setData(mouthList);
			result.add(yearLine);
		}
		return result;
	}

}
