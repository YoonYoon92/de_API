package com.saydept.api.spf.selng.conerBestSaleInq;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.selng.conerBestSaleInq.model.ConerBestSaleInqModel;
import com.saydept.api.spf.selng.conerBestSaleInq.model.ConerBestSaleInqParamModel;

	@Service
	public class ConerBestSaleInqService {

	@Autowired
	private ConerBestSaleInqMapper conerBestSaleInqMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public ConerBestSaleInqModel selectConerBestSaleInq(ConerBestSaleInqParamModel request)throws Exception {

	ConerBestSaleInqModel result = conerBestSaleInqMapper.selectConerBestSaleInq(request);
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<ConerBestSaleInqModel> selectConerBestSaleInqList(ConerBestSaleInqParamModel request)throws Exception {

		
		
		System.out.println("req 파라메터");
		request.setSelectDay(request.getStartDt());
		request.setToDay(request.getEndDt());
		System.out.println(request);
		
		System.out.println("0. 임시 테이블 만들기");
			conerBestSaleInqMapper.createConerBestSaleInqTempTable1();	
			conerBestSaleInqMapper.createConerBestSaleInqTempTable2();
			conerBestSaleInqMapper.createConerBestSaleInqTempTable3();
			
		System.out.println("1. 선택 조짘코드 코너 리스트 작성");
			System.out.println("1-1. insertConerBestSaleInqTempTable11");
			conerBestSaleInqMapper.insertConerBestSaleInqTempTable11(request);
			System.out.println("1-2. insertConerBestSaleInqTempTable12");
			conerBestSaleInqMapper.insertConerBestSaleInqTempTable12(request);
			System.out.println("1-3. insertConerBestSaleInqTempTable13");
			conerBestSaleInqMapper.insertConerBestSaleInqTempTable13(request);
			System.out.println("1-4. insertConerBestSaleInqTempTable14");
			conerBestSaleInqMapper.insertConerBestSaleInqTempTable14(request);
			System.out.println("1-5. insertConerBestSaleInqTempTable15");
			conerBestSaleInqMapper.insertConerBestSaleInqTempTable15(request);
		
		System.out.println("2. 코너별,월별 I01기준으로 월매출 계산");
			System.out.println("2-1. insertConerBestSaleInqTempTable21");
			conerBestSaleInqMapper.insertConerBestSaleInqTempTable21(request);
		
		System.out.println("3. 재사용코너의 경우 입점일에 해당하는월의 매출데이터는 삭제 - 해당루틴 일단 보류");
			//conerBestSaleInqMapper.insertConerBestSaleInqTempTable22(request);
		
		System.out.println("4. 종속코너의 코너번호를 주코너번호로 업데이트 (SPFM051PF)");
			System.out.println("4-1. insertConerBestSaleInqTempTable23");
			conerBestSaleInqMapper.insertConerBestSaleInqTempTable23(request);
			System.out.println("4-2. insertConerBestSaleInqTempTable24");
			conerBestSaleInqMapper.insertConerBestSaleInqTempTable24(request);
			System.out.println("4-3. insertConerBestSaleInqTempTable25");
			conerBestSaleInqMapper.insertConerBestSaleInqTempTable25(request);
		
		System.out.println("5. 기간내 코너별 best 매출월 가져오기  ");		
			System.out.println("5-1. insertConerBestSaleInqTempTable31");
			conerBestSaleInqMapper.insertConerBestSaleInqTempTable31(request);
		
		/********************************************* 최종 데이터 리스트 출력 *************************************************/			
		System.out.println("req 파라메터");	
		System.out.println(request);
		System.out.println("99. 최종데이터 출력");
		List<ConerBestSaleInqModel> result = conerBestSaleInqMapper.selectConerBestSaleInqList(request);
		
		
		
		
		
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateConerBestSaleInq(ConerBestSaleInqParamModel request)throws Exception {

		int result = conerBestSaleInqMapper.updateConerBestSaleInq(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int insertConerBestSaleInq(ConerBestSaleInqParamModel request) {

		int result = conerBestSaleInqMapper.insertConerBestSaleInq(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int saveConerBestSaleInq(ConerBestSaleInqParamModel request) {

		int result = conerBestSaleInqMapper.saveConerBestSaleInq(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteConerBestSaleInq(ConerBestSaleInqParamModel request) {

		int result = conerBestSaleInqMapper.deleteConerBestSaleInq(request);
		return result;

	}

}