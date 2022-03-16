package com.saydept.api.spf.selng.cardApprLogInq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.selng.cardApprLogInq.model.CardApprLogInqModel;
import com.saydept.api.spf.selng.cardApprLogInq.model.CardApprLogInqParamModel;

	@Service
	public class CardApprLogInqService {

	@Autowired
	private CardApprLogInqMapper CardApprLogInqMapper;
	

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<CardApprLogInqModel> selectCardApprLogInqList(CardApprLogInqParamModel request)throws Exception {

		List<CardApprLogInqModel> result = CardApprLogInqMapper.selectCardApprLogInqList(request);
		return result;

	}

	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public CardApprLogInqParamModel selectCardPrefixInqList(CardApprLogInqParamModel request)throws Exception {

		CardApprLogInqParamModel result = CardApprLogInqMapper.selectCardPrefixInqList(request);
		return result;

	}

}