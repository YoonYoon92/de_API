package com.saydept.api.spf.selng.salesByTypeInq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.selng.salesByTypeInq.model.SalesByTypeInqDetailModel;
import com.saydept.api.spf.selng.salesByTypeInq.model.SalesByTypeInqModel;
import com.saydept.api.spf.selng.salesByTypeInq.model.SalesByTypeInqParamModel;

	@Service
	public class SalesByTypeInqService {

	@Autowired
	private SalesByTypeInqMapper SalesByTypeInqMapper;
	

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<SalesByTypeInqModel> selectSalesByTypeInqList(SalesByTypeInqParamModel request)throws Exception {

		List<SalesByTypeInqModel> result = SalesByTypeInqMapper.selectSalesByTypeInqList(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public SalesByTypeInqDetailModel selectSalesByTypeInqDetail(SalesByTypeInqParamModel request)throws Exception {

		SalesByTypeInqDetailModel result = SalesByTypeInqMapper.selectSalesByTypeInqDetail(request);
		return result;

	}



}