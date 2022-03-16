package com.saydept.api.spf.excel.dayAggregation;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saydept.api.spf.excel.dayAggregation.model.DayAggregationModel;
import com.saydept.api.spf.excel.dayAggregation.model.DayAggregationParamModel;
import com.saydept.utils.SayUtils;

	@Service
	public class DayAggregationService {

	@Autowired
	private DayAggregationMapper dayAggregationMapper;
	@Autowired
	private SayUtils sayUtils;
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public DayAggregationModel selectDayAggregation(DayAggregationModel request)throws Exception {

	DayAggregationModel result = dayAggregationMapper.selectDayAggregation(request);
	return result;

	}
	public List<DayAggregationModel> selectListDayAggregation(DayAggregationParamModel request)throws Exception {
		request.setLastyearstartDt(sayUtils.getCusomYear(request.getStartDt(), -1 ));
		request.setLastyearmmDt(sayUtils.getCusomYear(request.getMmDt(), -1 ));
		request.setLastyearmmEndDt(sayUtils.getCusomYear(request.getMmEndDt(), -1 ));
		request.setLastyearyyDt(sayUtils.getCusomYear(request.getYyDt(), -1 ));
		System.out.println(request);
		List<DayAggregationModel> result = dayAggregationMapper.selectDayAggregationList(request);
		return result;

	}
	
	public List<DayAggregationModel> selectListDayAggregation2(DayAggregationParamModel request)throws Exception {
		request.setLastyearstartDt(sayUtils.getCusomYear(request.getStartDt(), -1 ));
		request.setLastyearmmDt(sayUtils.getCusomYear(request.getMmDt(), -1 ));
		request.setLastyearmmEndDt(sayUtils.getCusomYear(request.getMmEndDt(), -1 ));
		request.setLastyearyyDt(sayUtils.getCusomYear(request.getYyDt(), -1 ));
		System.out.println(request);
		List<DayAggregationModel> result = dayAggregationMapper.selectDayAggregationList2(request);
		return result;

	}
			
	public List<DayAggregationModel> selectListDayAggregation3(DayAggregationParamModel request)throws Exception {
		request.setLastyearstartDt(sayUtils.getCusomYear(request.getStartDt(), -1 ));
		request.setLastyearmmDt(sayUtils.getCusomYear(request.getMmDt(), -1 ));
		request.setLastyearmmEndDt(sayUtils.getCusomYear(request.getMmEndDt(), -1 ));
		request.setLastyearyyDt(sayUtils.getCusomYear(request.getYyDt(), -1 ));
		System.out.println(request);
		List<DayAggregationModel> result = dayAggregationMapper.selectDayAggregationList3(request);
		return result;

	}


}