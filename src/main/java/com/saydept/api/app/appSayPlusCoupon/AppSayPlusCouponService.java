package com.saydept.api.app.appSayPlusCoupon;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.app.appSayPlusCoupon.model.AppSayPlusCouponModel;
import com.saydept.api.app.appSayPlusCoupon.model.AppSayPlusCouponParamModel;
import com.saydept.api.app.appSayResign.model.AppSayResignModel;
//import com.saydept.api.app.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

@Service
public class AppSayPlusCouponService {

	@Autowired
	private AppSayPlusCouponMapper appSayPlusCouponMapper;
	
	@Autowired
	private SayUtils sayUtils;

	public List<AppSayPlusCouponModel> appSayPlusCouponList(AppSayPlusCouponParamModel request) throws ParseException {
		// TODO Auto-generated method stub

		// 작년일자
//		request.setFrDateLy(sayUtils.getCusomYear(request.getFrDate(), -1 ));
//	    request.setToDateLy(sayUtils.getCusomYear(request.getToDate(), -1 ));
//	    System.out.println("LastDay"); 					//로그 찍기
//	    System.out.println(request); 					//로그 찍기
	    
		List<AppSayPlusCouponModel> resultList = new ArrayList<AppSayPlusCouponModel>();
    
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

			List<AppSayPlusCouponModel> appSayPlusCouponList = appSayPlusCouponMapper.getAppSayPlusCouponlist(request);
			for( AppSayPlusCouponModel data :  appSayPlusCouponList) {
				AppSayPlusCouponModel model = new AppSayPlusCouponModel();
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
	
	public List<AppSayPlusCouponModel> appSayPlusCouponListA(AppSayPlusCouponParamModel request) throws ParseException {
		// TODO Auto-generated method stub


		List<AppSayPlusCouponModel> resultList = new ArrayList<AppSayPlusCouponModel>();

			System.out.println("SerchLevel: all"); 					// 조회레벨 출력
			
			if(request.getJum() == null || request.getJum() == "") {
			request.setJum("01");
			}


			List<AppSayPlusCouponModel> appSayPlusCouponList = appSayPlusCouponMapper.getAppSayPlusCouponlistA(request);
			for( AppSayPlusCouponModel data :  appSayPlusCouponList) {
				AppSayPlusCouponModel model = new AppSayPlusCouponModel();
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


		return resultList;
	}
	//쿠폰사용
	public AppSayPlusCouponModel getUseCoupon(AppSayPlusCouponModel request)throws Exception {
		System.out.println(request);
		AppSayPlusCouponModel result=new AppSayPlusCouponModel();
		int result1 =0;
		int cpCheck=0;
		AppSayPlusCouponModel cpCk=appSayPlusCouponMapper.getcpJnoCheck(request);
		cpCheck=Integer.parseInt(cpCk.getCpJno());
		System.out.println(cpCheck);
		if(cpCheck>0) {
		result1 = appSayPlusCouponMapper.getUseCoupon(request);
		}
		else
		{
		result1=0;
		}
		result.setCpResult(String.valueOf(result1));
		System.out.println(result);
		return result;

	}
}
