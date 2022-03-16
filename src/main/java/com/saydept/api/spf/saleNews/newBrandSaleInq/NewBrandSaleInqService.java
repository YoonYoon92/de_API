package com.saydept.api.spf.saleNews.newBrandSaleInq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.newBrandSaleInq.model.NewBrandSaleInqModel;
import com.saydept.api.spf.saleNews.newBrandSaleInq.model.NewBrandSaleInqParamModel;

	@Service
	public class NewBrandSaleInqService {

	@Autowired
	private NewBrandSaleInqMapper NewBrandSaleInqMapper;
	

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<NewBrandSaleInqModel> selectNewBrandSaleInqList(NewBrandSaleInqParamModel request)throws Exception {

		List<NewBrandSaleInqModel> result = NewBrandSaleInqMapper.selectNewBrandSaleInqList(request);
		return result;

	}



}