package com.saydept.api.spf.saleNews.creditCardApprInq;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.creditCardApprInq.model.CreditCardApprInqModel;
import com.saydept.api.spf.saleNews.creditCardApprInq.model.CreditCardApprInqParamModel;
import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

@Service
public class CreditCardApprInqService {

	@Autowired
	private CreditCardApprInqMapper creditCardApprInqMapper;
	
	@Autowired
	private SayUtils sayUtils;

	public List<CreditCardApprInqModel> creditCardApprInqList(CreditCardApprInqParamModel request) throws ParseException {
		// TODO Auto-generated method stub

		// 작년일자
//		request.setFrDateLy(sayUtils.getCusomYear(request.getFrDate(), -1 ));
//	    request.setToDateLy(sayUtils.getCusomYear(request.getToDate(), -1 ));
//	    System.out.println("LastDay"); 					//로그 찍기
//	    System.out.println(request); 					//로그 찍기
	    
		List<CreditCardApprInqModel> resultList = new ArrayList<CreditCardApprInqModel>();
    
//		String beforeDay = sayUtils.getCusomDay(request.getSearchDay(), -1 );
//		String beforeYear = sayUtils.getCusomYear(request.getSearchDay(), -1 );
//		System.out.println("before jum");
//		if( request.getSerchLevel().equals(null)		//등급이 null일때
//				) {	
//			System.out.println("SerchLevel: all"); 					// 조회레벨 출력
			
//			if(request.getBu() == null) {
//				request.setBu("");
//			}
//			if(request.getTim() == null) {
//				request.setTim("");
//			}

			List<CreditCardApprInqModel> creditCardApprInqList = creditCardApprInqMapper.getCreditCardApprInqlist(request);
			for( CreditCardApprInqModel data :  creditCardApprInqList) {
				CreditCardApprInqModel model = new CreditCardApprInqModel();
				
				model.setRegiNo ( data.getRegiNo() );
				model.setRegiNm ( data.getRegiNm() );
				model.setAppTime( data.getAppTime() );
				model.setAppJp( data.getAppJp() );
				model.setAppRcpt( data.getAppRcpt() );
				model.setAppNo  ( data.getAppNo() );
				model.setHalBu  ( data.getHalBu() );
				model.setRcvNo  ( data.getRcvNo() );
				model.setAppAmt ( data.getAppAmt() );
				model.setVanCo  ( data.getVanCo() );
				model.setGuBun  ( data.getGuBun() );
				model.setS40Memo( data.getS40Memo() );
				model.setVanMemo( data.getVanMemo() );
				
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
