package com.saydept.api.spf.salePrice.salePriceChgReqFormInq;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.salePrice.salePriceChgReqFormInq.model.SalePriceChgReqFormInqModel;

	@Service
	public class SalePriceChgReqFormInqService {

	@Autowired
	private SalePriceChgReqFormInqMapper salePriceChgReqFormInqMapper;

	

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<SalePriceChgReqFormInqModel> selectSalePriceChgReqFormInqList(SalePriceChgReqFormInqModel request)throws Exception {

		List<SalePriceChgReqFormInqModel> result = salePriceChgReqFormInqMapper.selectSalePriceChgReqFormInqList(request);
		return result;

	}

	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<SalePriceChgReqFormInqModel> selectDetailList(SalePriceChgReqFormInqModel request)throws Exception {

		List<SalePriceChgReqFormInqModel> result = salePriceChgReqFormInqMapper.selectDetailList(request);
		return result;

	}
}