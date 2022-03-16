package com.saydept.api.app.appSayPlusPointExt;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.app.appSayPlusPointExt.model.AppSayPlusPointExtModel;
import com.saydept.api.app.appSayPlusPointExt.model.AppSayPlusPointExtParamModel;
//import com.saydept.api.app.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

@Service
public class AppSayPlusPointExtService {

	@Autowired
	private AppSayPlusPointExtMapper appSayPlusPointExtMapper;
	
	@Autowired
	private SayUtils sayUtils;

	public List<AppSayPlusPointExtModel> appSayPlusPointExtList(AppSayPlusPointExtParamModel request) throws ParseException {
		// TODO Auto-generated method stub

		// 작년일자
//		request.setFrDateLy(sayUtils.getCusomYear(request.getFrDate(), -1 ));
//	    request.setToDateLy(sayUtils.getCusomYear(request.getToDate(), -1 ));
//	    System.out.println("LastDay"); 					//로그 찍기
//	    System.out.println(request); 					//로그 찍기
	    
		List<AppSayPlusPointExtModel> resultList = new ArrayList<AppSayPlusPointExtModel>();
    
//		String beforeDay = sayUtils.getCusomDay(request.getSearchDay(), -1 );
//		String beforeYear = sayUtils.getCusomYear(request.getSearchDay(), -1 );
//		System.out.println("before jum");
//		if( request.getSerchLevel().equals(null)		//등급이 null일때
//				) {	
			System.out.println("SerchLevel: all"); 					// 조회레벨 출력
			
			if(request.getJum() == null || request.getJum() == "") {
			request.setJum("01");
		}
			//if(request.getBu() == null) {
//			request.setBu("");
//		}
//			if(request.getTim() == null) {
//				request.setTim("");
//			}

			List<AppSayPlusPointExtModel> appSayPlusPointExtList = appSayPlusPointExtMapper.getAppSayPlusPointExtlist(request);
			for( AppSayPlusPointExtModel data :  appSayPlusPointExtList) {
				AppSayPlusPointExtModel model = new AppSayPlusPointExtModel();
				model.setJum( data.getJum() );
				model.setCdNo( data.getCdNo() );
				model.setMaedate( data.getMaedate() );
				model.setExtdate( data.getExtdate() );
				model.setExtpoint( data.getExtpoint() );
				model.setUsedpoint( data.getUsedpoint() );
				model.setExtrealpoint( data.getExtrealpoint() );
				
				resultList.add( model );
			}
//			System.out.println("all list end");
			
//		} /* -- null end */

		return resultList;
	}
}
