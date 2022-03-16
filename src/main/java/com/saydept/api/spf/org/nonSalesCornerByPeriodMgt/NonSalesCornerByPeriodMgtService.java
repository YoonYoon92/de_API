package com.saydept.api.spf.org.nonSalesCornerByPeriodMgt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.as400.access.Converter;
import com.saydept.api.spf.org.nonSalesCornerByPeriodMgt.model.NonSalesCornerByPeriodMgtClassClosedModel;
import com.saydept.api.spf.org.nonSalesCornerByPeriodMgt.model.NonSalesCornerByPeriodMgtCornerClosedModel;
import com.saydept.api.spf.org.nonSalesCornerByPeriodMgt.model.NonSalesCornerByPeriodMgtModel;
import com.saydept.api.spf.org.nonSalesCornerByPeriodMgt.model.NonSalesCornerByPeriodMgtParamModel;

@Service
public class NonSalesCornerByPeriodMgtService {
	
	@Autowired
	private NonSalesCornerByPeriodMgtMapper nonSalesCornerByPeriodMgtMapper;
	
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<NonSalesCornerByPeriodMgtModel> selectNonSalesCornerByPeriodList(NonSalesCornerByPeriodMgtParamModel request)throws Exception {

		List<NonSalesCornerByPeriodMgtModel> result = nonSalesCornerByPeriodMgtMapper.selectNonSalesCornerByPeriodList(request);
		return result;

	}
	
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public void updateNonSalesCornerClosed(List<NonSalesCornerByPeriodMgtCornerClosedModel> request) {
		// TODO Auto-generated method stub
		
		System.out.println("request: " + request);
		for( NonSalesCornerByPeriodMgtCornerClosedModel model :  request) {
		
			// SPFM05PF-코너마스터 : 미사용 코너 폐기
			nonSalesCornerByPeriodMgtMapper.updateNonSalesCornerClosed(model);
			
			// 미사용 코너의 살아있는 클래스 내역
			System.out.println("model: " + model);
			List<NonSalesCornerByPeriodMgtClassClosedModel> classClosedList = nonSalesCornerByPeriodMgtMapper.selectClassList(model);
			System.out.println("classClosedList: " +  classClosedList);
			
			for(NonSalesCornerByPeriodMgtClassClosedModel classModel: classClosedList ) {
				
				//미사용 클래스 폐기 
				int classClosedCnt = nonSalesCornerByPeriodMgtMapper.updateNonSalesClassClosed(classModel);
				System.out.println("클래스 폐기 update count: "+ classClosedCnt);
				
				//미사용 단품 폐기
				int danpumClosedCnt = nonSalesCornerByPeriodMgtMapper.updateNonSalesDanpumClosed(classModel);
				System.out.println("단품 폐기 update count: "+ danpumClosedCnt);
				
				//폐기 클래스 내역 전송
				try {
					int classSendInsertCnt = nonSalesCornerByPeriodMgtMapper.insertNonSalesClassSendClosed(classModel);
					System.out.println("폐기 클래스 전송내역 insert count: "+ classSendInsertCnt);
				} catch(Exception e) {
					int classSendUpdateCnt = nonSalesCornerByPeriodMgtMapper.updateNonSalesClassSendClosed(classModel);
					System.out.println("폐기 클래스 전송내역 update count: "+ classSendUpdateCnt);
				}	
				
			}
	
		}
	}
	
	
}
