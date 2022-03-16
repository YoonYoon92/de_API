package com.saydept.api.spf.saleNews.clsDanPumCdInq;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.clsDanPumCdInq.model.ClsDanPumCdInqModel;
import com.saydept.api.spf.saleNews.clsDanPumCdInq.model.ClsDanPumCdInqParamModel;
import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

@Service
public class ClsDanPumCdInqService {

	@Autowired
	private ClsDanPumCdInqMapper clsDanPumCdInqMapper;
	
	@Autowired
	private SayUtils sayUtils;

	public List<ClsDanPumCdInqModel> clsDanPumCdInqList(ClsDanPumCdInqParamModel request) throws ParseException {
		// TODO Auto-generated method stub

		// 작년일자
//		request.setFrDateLy(sayUtils.getCusomYear(request.getFrDate(), -1 ));
//	    request.setToDateLy(sayUtils.getCusomYear(request.getToDate(), -1 ));
//	    System.out.println("LastDay"); 					//로그 찍기
//	    System.out.println(request); 					//로그 찍기
	    
		List<ClsDanPumCdInqModel> resultList = new ArrayList<ClsDanPumCdInqModel>();
    
//		String beforeDay = sayUtils.getCusomDay(request.getSearchDay(), -1 );
//		String beforeYear = sayUtils.getCusomYear(request.getSearchDay(), -1 );
//		System.out.println("before jum");
//		if( request.getSerchLevel().equals(null)		//등급이 null일때
//				) {	
//			System.out.println("SerchLevel: all"); 					// 조회레벨 출력
			
			if(request.getClsNo1() == null) {
				request.setClsNo1("");
			}
			if(request.getClsNo2() == null) {
				request.setClsNo2("");
			}
			if(request.getDanPumNo() == null) {
				request.setDanPumNo("");
			}

			List<ClsDanPumCdInqModel> clsDanPumCdInqList = clsDanPumCdInqMapper.getClsDanPumCdInqlist(request);
			for( ClsDanPumCdInqModel data :  clsDanPumCdInqList) {
				ClsDanPumCdInqModel model = new ClsDanPumCdInqModel();
				
				model.setDanpumNo ( data.getDanpumNo() );
				model.setDanpumNm ( data.getDanpumNm() );
				model.setDanpumCd( data.getDanpumCd() );
				model.setWonGa( data.getWonGa() );
				model.setMaeGa( data.getMaeGa() );
				model.setClsNo1  ( data.getClsNo1() );
				model.setClsNo2  ( data.getClsNo2() );
				model.setBuNm  ( data.getBuNm() );
				model.setTmNm ( data.getTmNm() );
				model.setPcNm  ( data.getPcNm() );
				model.setClsNm  ( data.getClsNm() );
				model.setMarginYul( data.getMarginYul() );
				model.setEachUnit( data.getEachUnit() );
				
//				model.setThisYySplan( data.getThisYySplan() );
//				model.setThisYyNetsale( data.getThisYyNetsale() );
//				model.setAchivmentrate( data.getAchivmentrate() );
//				model.setLastYySplan( data.getLastYySplan() );
//				model.setLastYyNetsale( data.getLastYyNetsale() );
//				model.setIncrsrate( data.getIncrsrate() );
				
				resultList.add( model );
			}
			System.out.println("all list end");
			
//		} /* -- null end */

		return resultList;
	}
}
