package com.saydept.api.spf.saleNews.directoryOfPartnersInq;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.directoryOfPartnersInq.model.DirectoryOfPartnersInqModel;
import com.saydept.api.spf.saleNews.directoryOfPartnersInq.model.DirectoryOfPartnersInqParamModel;
import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

@Service
public class DirectoryOfPartnersInqService {

	@Autowired
	private DirectoryOfPartnersInqMapper directoryOfPartnersInqMapper;
	
	@Autowired
	private SayUtils sayUtils;

	public List<DirectoryOfPartnersInqModel> directoryOfPartnersInqList(DirectoryOfPartnersInqParamModel request) throws ParseException {
		// TODO Auto-generated method stub

		// 작년일자
//		request.setFrDateLy(sayUtils.getCusomYear(request.getFrDate(), -1 ));
//	    request.setToDateLy(sayUtils.getCusomYear(request.getToDate(), -1 ));
//	    System.out.println("LastDay"); 					//로그 찍기
//	    System.out.println(request); 					//로그 찍기
	    
		List<DirectoryOfPartnersInqModel> resultList = new ArrayList<DirectoryOfPartnersInqModel>();
    
//		String beforeDay = sayUtils.getCusomDay(request.getSearchDay(), -1 );
//		String beforeYear = sayUtils.getCusomYear(request.getSearchDay(), -1 );
//		System.out.println("before jum");
//		if( request.getSerchLevel().equals(null)		//등급이 null일때
//				) {	
//			System.out.println("SerchLevel: all"); 					// 조회레벨 출력
			
			if(request.getSerchName() == null) {
				request.setSerchName("");
			}
			if(request.getOnlineChk() == null) {
				request.setOnlineChk("");
			}
			if(request.getCorpNo() == null) {
				request.setCorpNo("");
			}

			List<DirectoryOfPartnersInqModel> directoryOfPartnersInqList = directoryOfPartnersInqMapper.getDirectoryOfPartnersInqlist(request);
			for( DirectoryOfPartnersInqModel data :  directoryOfPartnersInqList) {
				DirectoryOfPartnersInqModel model = new DirectoryOfPartnersInqModel();
				
				model.setJum ( data.getJum() );
				model.setRepName ( data.getRepName() );
				model.setTradeName( data.getTradeName() );
				model.setCorpRegNum( data.getCorpRegNum() );
				model.setJumin  ( data.getJumin() );
				
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
