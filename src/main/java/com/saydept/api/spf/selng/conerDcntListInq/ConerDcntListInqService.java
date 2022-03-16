package com.saydept.api.spf.selng.conerDcntListInq;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.selng.conerDcntListInq.model.ConerDcntListInqModel;

	@Service
	public class ConerDcntListInqService {

	@Autowired
	private ConerDcntListInqMapper conerDcntListInqMapper;


	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<ConerDcntListInqModel> selectConerDcntListInqList(ConerDcntListInqModel request)throws Exception {

		List<ConerDcntListInqModel> result = conerDcntListInqMapper.selectConerDcntListInqList(request);
		System.out.println(request);
		System.out.println(result);
		return result;

	}
	//클래스목록
	public List<ConerDcntListInqModel> selectConerList(ConerDcntListInqModel request)throws Exception {

		List<ConerDcntListInqModel> result = conerDcntListInqMapper.selectConerList(request);
		System.out.println(request);
		System.out.println(result);
		return result;

	}


}