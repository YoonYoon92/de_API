package com.saydept.api.spf.saleNews.cornerRtnSts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.cornerRtnSts.model.CornerRtnStsModel;
import com.saydept.api.spf.saleNews.cornerRtnSts.model.CornerRtnStsParamModel;

	@Service
	public class CornerRtnStsService {

	@Autowired
	private CornerRtnStsMapper cornerRtnStsMapper;


	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<CornerRtnStsModel> selectCornerRtnStsList(CornerRtnStsParamModel request)throws Exception {

		List<CornerRtnStsModel> result = cornerRtnStsMapper.selectCornerRtnStsList(request);
		return result;

	}

}