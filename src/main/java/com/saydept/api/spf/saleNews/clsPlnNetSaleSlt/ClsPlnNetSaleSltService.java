package com.saydept.api.spf.saleNews.clsPlnNetSaleSlt;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.clsPlnNetSaleSlt.model.ClsPlnNetSaleSltModel;
import com.saydept.api.spf.saleNews.clsPlnNetSaleSlt.model.ClsPlnNetSaleSltParamModel;
import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

@Service
public class ClsPlnNetSaleSltService {

	@Autowired
	private ClsPlnNetSaleSltMapper clsPlnNetSaleSltMapper;
	
	@Autowired
	private SayUtils sayUtils;

	public List<ClsPlnNetSaleSltModel> clsPlnNetSaleSltList(ClsPlnNetSaleSltParamModel request) throws ParseException {
		// TODO Auto-generated method stub

		// 작년일자
		request.setFrDateLy(sayUtils.getCusomYear(request.getFrDate(), -1 ));
	    request.setToDateLy(sayUtils.getCusomYear(request.getToDate(), -1 ));
//	    System.out.println("LastDay"); 					//로그 찍기
//	    System.out.println(request); 					//로그 찍기
	    
		List<ClsPlnNetSaleSltModel> resultList = new ArrayList<ClsPlnNetSaleSltModel>();
    
//		String beforeDay = sayUtils.getCusomDay(request.getSearchDay(), -1 );
//		String beforeYear = sayUtils.getCusomYear(request.getSearchDay(), -1 );
//		System.out.println("before jum");
//		if( request.getSerchLevel().equals(null)		//등급이 null일때
//				) {	
			System.out.println("SerchLevel: all"); 					// 조회레벨 출력
			
			if(request.getBu() == null) {
				request.setBu("");
			}
			if(request.getTim() == null) {
				request.setTim("");
			}

			List<ClsPlnNetSaleSltModel> clsPlnNetSaleSltList = clsPlnNetSaleSltMapper.getClsPlnNetSaleSltlist(request);
			for( ClsPlnNetSaleSltModel data :  clsPlnNetSaleSltList) {
				ClsPlnNetSaleSltModel model = new ClsPlnNetSaleSltModel();
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
				
				model.setThisYySplan( data.getThisYySplan() );
				model.setThisYyNetsale( data.getThisYyNetsale() );
				model.setThisYyAchivmentrate( data.getThisYyAchivmentrate() );
				model.setLastYySplan( data.getLastYySplan() );
				model.setLastYyNetsale( data.getLastYyNetsale() );
				model.setLastYyAchivmentrate( data.getLastYyAchivmentrate() );
				
				
				resultList.add( model );
			}
//			System.out.println("all list end");
			
//		} /* -- null end */

		return resultList;
	}
}
