package com.saydept.api.spf.selng.cornerMarginChgSalesInq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.selng.cornerMarginChgSalesInq.model.CornerMarginChgSalesInqModel;
import com.saydept.api.spf.selng.cornerMarginChgSalesInq.model.CornerMarginChgSalesInqParamModel;

	@Service
	public class CornerMarginChgSalesInqService {

	@Autowired
	private CornerMarginChgSalesInqMapper cornerMarginChgSalesInqMapper;
	

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<CornerMarginChgSalesInqModel> selectCornerMarginChgSalesInqList(CornerMarginChgSalesInqParamModel request)throws Exception {

		List<CornerMarginChgSalesInqModel> result = cornerMarginChgSalesInqMapper.selectCornerMarginChgSalesInqList(request);
		return result;

	}


}