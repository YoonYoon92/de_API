package com.saydept.api.app.appSayMsgCoupon;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.app.appSayMsgCoupon.model.AppSayMsgCouponModel;
import com.saydept.api.app.appSayMsgCoupon.model.AppSayMsgCouponParamModel;
//import com.saydept.api.app.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

@Service
public class AppSayMsgCouponService {

	@Autowired
	private AppSayMsgCouponMapper appSayMsgCouponMapper;
	
	@Autowired
	private SayUtils sayUtils;

	public List<AppSayMsgCouponModel> appSayMsgCouponList(AppSayMsgCouponParamModel request) throws ParseException {
		// TODO Auto-generated method stub

		// 작년일자
//		request.setFrDateLy(sayUtils.getCusomYear(request.getFrDate(), -1 ));
//	    request.setToDateLy(sayUtils.getCusomYear(request.getToDate(), -1 ));
//	    System.out.println("LastDay"); 					//로그 찍기
//	    System.out.println(request); 					//로그 찍기
	    
		List<AppSayMsgCouponModel> resultList = new ArrayList<AppSayMsgCouponModel>();
    
//		String beforeDay = sayUtils.getCusomDay(request.getSearchDay(), -1 );
//		String beforeYear = sayUtils.getCusomYear(request.getSearchDay(), -1 );
//		System.out.println("before jum");
//		if( request.getSerchLevel().equals(null)		//등급이 null일때
//				) {	
			System.out.println("SerchLevel: all"); 					// 조회레벨 출력
			
			if(request.getJum() == null || request.getJum() == "") {
			request.setJum("01");
			}
//			if(request.getBu() == null) {
//				request.setBu("");
//			}
//			if(request.getTim() == null) {
//				request.setTim("");
//			}

			List<AppSayMsgCouponModel> appSayMsgCouponList = appSayMsgCouponMapper.getAppSayMsgCouponlist(request);
			for( AppSayMsgCouponModel data :  appSayMsgCouponList) {
				AppSayMsgCouponModel model = new AppSayMsgCouponModel();
				model.setJum( data.getJum() );
				model.setCdNo( data.getCdNo() );
				model.setCpNo( data.getCpNo() );
				model.setCpFdate( data.getCpFdate() );
				model.setCpTdate( data.getCpTdate() );
				model.setCpGubun( data.getCpGubun() );
				model.setCpName( data.getCpName() );
				model.setCpType( data.getCpType() );
				model.setCpDcPer( data.getCpDcPer() );
				model.setCpDcWon( data.getCpDcWon() );
				model.setCpTno( data.getCpTno() );
				model.setCpUno( data.getCpUno() );
				model.setCpJno( data.getCpJno() );
											
				resultList.add( model );
			}
//			System.out.println("all list end");
			
//		} /* -- null end */

		return resultList;
	}
}
