package com.saydept.api.spf.org.conerHistoryInq;

import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.org.conerHistoryInq.model.ConerHistoryInqModel;
import com.saydept.api.spf.org.conerHistoryInq.model.ConerHistoryInqParamModel;

	@Service
	public class ConerHistoryInqService {

	@Autowired
	private ConerHistoryInqMapper conerHistoryInqMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public ConerHistoryInqModel selectConerHistoryInq(ConerHistoryInqModel request)throws Exception {		
		
		ConerHistoryInqModel result = conerHistoryInqMapper.selectConerHistoryInq(request);
		return result;

	}

	/** 재사용코너의 과거 코너 사용이력 가져오기,  SPFM33PF를 사용한다
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<ConerHistoryInqModel> selectConerHistoryInqList(ConerHistoryInqParamModel request)throws ParseException  {

		System.out.println("테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테");
		System.out.println("테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테");
		System.out.println("테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테");
		System.out.println("테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테");
		
		System.out.println(request);	
		
		List<ConerHistoryInqModel> result = conerHistoryInqMapper.selectConerHistoryInqList(request);
		
		
		System.out.println("테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테");
		System.out.println("테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테");
		System.out.println("테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테");
		System.out.println("테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테테");
		
		System.out.println(result);	
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateConerHistoryInq(ConerHistoryInqModel request)throws Exception {

		int result = conerHistoryInqMapper.updateConerHistoryInq(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int insertConerHistoryInq(ConerHistoryInqModel request) {

		int result = conerHistoryInqMapper.insertConerHistoryInq(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int saveConerHistoryInq(ConerHistoryInqModel request) {

		int result = conerHistoryInqMapper.saveConerHistoryInq(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteConerHistoryInq(ConerHistoryInqModel request) {

		int result = conerHistoryInqMapper.deleteConerHistoryInq(request);
		return result;

	}

}