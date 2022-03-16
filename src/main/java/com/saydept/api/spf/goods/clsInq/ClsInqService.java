package com.saydept.api.spf.goods.clsInq;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.giftEvent.giftEventInq.model.GiftEventInqModel;
import com.saydept.api.spf.goods.clsInq.model.ClsInqModel;
import com.saydept.api.spf.selng.conerDcntListInq.model.ConerDcntListInqModel;

	@Service
	public class ClsInqService {

	@Autowired
	private ClsInqMapper classInqMapper;

	

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<ClsInqModel> selectClassInqList(ClsInqModel request)throws Exception {
		
		if(request.getConer()==null)
		{
			request.setConer("");
		}
		if(request.getPartner()==null)
		{
			request.setPartner("");
		}
		System.out.println(request);
		List<ClsInqModel> result = classInqMapper.selectClassInqList(request);
		
		return result;

	}
	//클래스목록
	public List<ClsInqModel> selectConerList(ClsInqModel request)throws Exception {

			List<ClsInqModel> result = classInqMapper.selectConerList(request);
			System.out.println(request);
			System.out.println(result);
			return result;

		}
	
	//클래스상세조회
	public ClsInqModel selectDetailClsList(ClsInqModel request)throws Exception {

		ClsInqModel result = classInqMapper.selectDetailClsList(request);
		return result;

		}
	//클래스마진조회
	public List<ClsInqModel> selectDetailClsMargin(ClsInqModel request)throws Exception {
		
		List<ClsInqModel> result = classInqMapper.selectDetailClsMargin(request);
		
		return result;

	}

}