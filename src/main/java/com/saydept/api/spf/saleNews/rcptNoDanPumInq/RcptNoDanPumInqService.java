package com.saydept.api.spf.saleNews.rcptNoDanPumInq;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.rcptNoDanPumInq.model.RcptNoDanPumInqModel;
import com.saydept.api.spf.saleNews.rcptNoDanPumInq.model.RcptNoDanPumInqParamModel;
import com.saydept.api.spf.saleNews.rcptNoDanPumInq.model.RcptNoDanPumInqSearchModel;
//import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

@Service
public class RcptNoDanPumInqService {

	@Autowired
	private RcptNoDanPumInqMapper rcptNoDanPumInqMapper;
	
//	@Autowired
//	private SayUtils sayUtils;

	public List<RcptNoDanPumInqModel> rcptNoDanPumInqList(RcptNoDanPumInqParamModel request) throws ParseException {
		// TODO Auto-generated method stub

		// 작년일자
//		request.setFrDateLy(sayUtils.getCusomYear(request.getFrDate(), -1 ));
//	    request.setToDateLy(sayUtils.getCusomYear(request.getToDate(), -1 ));
//	    System.out.println("LastDay"); 					//로그 찍기
//	    System.out.println(request); 					//로그 찍기
	    
		List<RcptNoDanPumInqModel> resultList = new ArrayList<RcptNoDanPumInqModel>();
    
//		String beforeDay = sayUtils.getCusomDay(request.getSearchDay(), -1 );
//		String beforeYear = sayUtils.getCusomYear(request.getSearchDay(), -1 );
//		System.out.println("before jum");
//		if( request.getSerchLevel().equals(null)		//등급이 null일때
//				) {	
//			System.out.println("SerchLevel: all"); 					// 조회레벨 출력
			
		if(request.getRcptNo1() == null) {
			request.setRcptNo1("0001");
		}
		if(request.getRcptNo2() == null) {
			request.setRcptNo2("9999");
		}
		if(request.getRegiNo() == null) {
			request.setRegiNo("");
		}
		System.out.println(request); 					//로그 찍기
			List<RcptNoDanPumInqModel> rcptNoDanPumInqList = rcptNoDanPumInqMapper.getRcptNoDanPumInqlist(request);
			for( RcptNoDanPumInqModel data :  rcptNoDanPumInqList) {
				RcptNoDanPumInqModel model = new RcptNoDanPumInqModel();
				
				model.setMaeDate ( data.getMaeDate() );
				model.setRcptNo ( data.getRcptNo() );
				model.setHsGuNm( data.getHsGuNm() );
				model.setRegiNo( data.getRegiNo() );
				model.setRegiNm( data.getRegiNm() );
				model.setHsG1Nm  ( data.getHsG1Nm() );
				model.setClsNo  ( data.getClsNo() );
				model.setDanPum  ( data.getDanPum() );
				model.setDanName  ( data.getDanName() );
				model.setCntPum ( data.getCntPum() );
				model.setHalGum  ( data.getHalGum() );
				model.setDanCode  ( data.getDanCode() );
				
				resultList.add( model );
			}
			System.out.println("all list end");
			
//		} /* -- null end */

		return resultList;
	}
	
	
	//------------
	
	public List<RcptNoDanPumInqSearchModel> rcptNoDanPumInqSearchList(RcptNoDanPumInqSearchModel request) throws ParseException {
		// TODO Auto-generated method stub
		List<RcptNoDanPumInqSearchModel> resultList = new ArrayList<RcptNoDanPumInqSearchModel>();
		if(request.getJum() == null) {
			request.setJum("01");
		}
		System.out.println("regi list str");
		System.out.println(request); 					//로그 찍기
			List<RcptNoDanPumInqSearchModel> rcptNoDanPumInqList = rcptNoDanPumInqMapper.getRcptNoDanPumInqSearchList(request);
			for( RcptNoDanPumInqSearchModel data :  rcptNoDanPumInqList) {
				RcptNoDanPumInqSearchModel model = new RcptNoDanPumInqSearchModel();
				
//				model.setMaeDate ( data.getMaeDate() );
				model.setRegiNo ( data.getRegiNo() );
				model.setRegiNm ( data.getRegiNm() );
				model.setRcptNo ( data.getRcptNo() );
				
				resultList.add( model );
			}
			System.out.println("regi list end");
			
//		} /* -- null end */

		return resultList;
	}
}
