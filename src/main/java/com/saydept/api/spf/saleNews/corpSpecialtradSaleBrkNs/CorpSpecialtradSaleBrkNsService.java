package com.saydept.api.spf.saleNews.corpSpecialtradSaleBrkNs;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.corpSpecialtradSaleBrkNs.model.CorpSpecialtradSaleBrkNsModel;
import com.saydept.api.spf.saleNews.corpSpecialtradSaleBrkNs.model.CorpSpecialtradSaleBrkNsParamModel;
import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

@Service
public class CorpSpecialtradSaleBrkNsService {

	@Autowired
	private CorpSpecialtradSaleBrkNsMapper corpSpecialtradSaleBrkNsMapper;
	
	@Autowired
	private SayUtils sayUtils;

	public List<CorpSpecialtradSaleBrkNsModel> corpSpecialtradSaleBrkNsList(CorpSpecialtradSaleBrkNsParamModel request) throws ParseException {
		// TODO Auto-generated method stub

		// 작년일자
//		request.setFrDateLy(sayUtils.getCusomYear(request.getFrDate(), -1 ));
//	    request.setToDateLy(sayUtils.getCusomYear(request.getToDate(), -1 ));
//	    System.out.println("LastDay"); 					//로그 찍기
//	    System.out.println(request); 					//로그 찍기
	    
		List<CorpSpecialtradSaleBrkNsModel> resultList = new ArrayList<CorpSpecialtradSaleBrkNsModel>();
    
//		String beforeDay = sayUtils.getCusomDay(request.getSearchDay(), -1 );
//		String beforeYear = sayUtils.getCusomYear(request.getSearchDay(), -1 );
//		System.out.println("before jum");
//		if( request.getSerchLevel().equals(null)		//등급이 null일때
//				) {	
			System.out.println("SerchLevel: all"); 					// 조회레벨 출력
			
//			if(request.getBu() == null) {
//				request.setBu("");
//			}
//			if(request.getTim() == null) {
//				request.setTim("");
//			}

			List<CorpSpecialtradSaleBrkNsModel> corpSpecialtradSaleBrkNsList = corpSpecialtradSaleBrkNsMapper.getCorpSpecialtradSaleBrkNslist(request);
			for( CorpSpecialtradSaleBrkNsModel data :  corpSpecialtradSaleBrkNsList) {
				CorpSpecialtradSaleBrkNsModel model = new CorpSpecialtradSaleBrkNsModel();
				model.setJum( data.getJum() );
				model.setJumNm( data.getJumNm() );
				model.setBu( data.getBu() );
				model.setBuNm( data.getBuNm() );
				model.setTim( data.getTim() );
				model.setTimNm( data.getTimNm() );
				model.setPc( data.getPc() );
				model.setPcNm( data.getPcNm() );
				model.setCls( data.getCls() );
				model.setClsNm( data.getClsNm() );
				
				model.setMdate( data.getMdate() );
				model.setSpcsale( data.getSpcsale() );
				
				resultList.add( model );
			}
			System.out.println("all list end");
			
//		} /* -- null end */

		return resultList;
	}
}
