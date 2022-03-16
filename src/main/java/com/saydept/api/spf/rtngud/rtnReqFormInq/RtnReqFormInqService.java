package com.saydept.api.spf.rtngud.rtnReqFormInq;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.rtngud.rtnReqFormInq.model.RtnReqFormInqModel;

	@Service
	public class RtnReqFormInqService {

	@Autowired
	private RtnReqFormInqMapper rtnReqFormInqMapper;

	

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<RtnReqFormInqModel> selectRtnReqFormInqList(RtnReqFormInqModel request)throws Exception {

		List<RtnReqFormInqModel> result = rtnReqFormInqMapper.selectRtnReqFormInqList(request);
		return result;

	}
	
	/**
	 * 
	 * @상세조회
	 */
	public List<RtnReqFormInqModel> selectDetailList(RtnReqFormInqModel request)throws Exception {

		List<RtnReqFormInqModel> result = rtnReqFormInqMapper.selectDetailList(request);
		return result;

	}

	

}