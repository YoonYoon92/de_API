package com.saydept.api.spf.selng.partnerSaleInq;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.selng.partnerSaleInq.model.PartnerSaleInqModel;

	@Service
	public class PartnerSaleInqService {

	@Autowired
	private PartnerSaleInqMapper partnerSaleInqMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */


	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PartnerSaleInqModel> selectPartnerSaleInqList(PartnerSaleInqModel request)throws Exception {
		
		System.out.println(request);
		List<PartnerSaleInqModel> result = partnerSaleInqMapper.selectPartnerSaleInqList(request);
		System.out.println(result);
		return result;

	}
	
	
	//협력업체리스트
	public List<PartnerSaleInqModel> selectPartnerList(PartnerSaleInqModel request)throws Exception {

		List<PartnerSaleInqModel> result = partnerSaleInqMapper.selectPartnerList(request);
		return result;

	}
	//품목코드리스트
		public List<PartnerSaleInqModel> selectGlsList(PartnerSaleInqModel request)throws Exception {

			List<PartnerSaleInqModel> result = partnerSaleInqMapper.selectGlsList(request);
			return result;

		}
	//클래스리스트
		public List<PartnerSaleInqModel> selectClsList(PartnerSaleInqModel request)throws Exception {

			List<PartnerSaleInqModel> result = partnerSaleInqMapper.selectClsList(request);
			return result;

		}



}