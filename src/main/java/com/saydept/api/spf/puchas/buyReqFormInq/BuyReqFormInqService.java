package com.saydept.api.spf.puchas.buyReqFormInq;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.puchas.buyReqFormInq.model.BuyReqFormInqModel;

	@Service
	public class BuyReqFormInqService {

	@Autowired
	private BuyReqFormInqMapper buyReqFormInqMapper;

	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<BuyReqFormInqModel> selectBuyReqFormInqList(BuyReqFormInqModel request)throws Exception {

		List<BuyReqFormInqModel> result = buyReqFormInqMapper.selectBuyReqFormInqList(request);
		return result;

	}
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<BuyReqFormInqModel> selectDetailList(BuyReqFormInqModel request)throws Exception {

		List<BuyReqFormInqModel> result = buyReqFormInqMapper.selectDetailList(request);
		return result;

	}
	
}