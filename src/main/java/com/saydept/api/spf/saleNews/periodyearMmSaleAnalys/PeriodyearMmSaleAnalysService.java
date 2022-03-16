package com.saydept.api.spf.saleNews.periodyearMmSaleAnalys;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.periodyearMmSaleAnalys.model.PeriodyearMmSaleAnalysModel;
import com.saydept.api.spf.saleNews.periodyearMmSaleAnalys.model.PeriodyearMmSaleAnalysParamModel;
import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

@Service
public class PeriodyearMmSaleAnalysService {

	@Autowired
	private PeriodyearMmSaleAnalysMapper periodyearMmSaleAnalysMapper;
	
	@Autowired
	private SayUtils sayUtils;

	public List<PeriodyearMmSaleAnalysModel> periodyearMmSaleAnalysList(PeriodyearMmSaleAnalysParamModel request) throws ParseException {
		// TODO Auto-generated method stub

		// 작년일자
		request.setFrDateLy(sayUtils.getCusomYear(request.getFrDate(), -1 ));
	    request.setToDateLy(sayUtils.getCusomYear(request.getToDate(), -1 ));
	    System.out.println("LastDay"); 					//로그 찍기
	    System.out.println(request); 					//로그 찍기
	    
		List<PeriodyearMmSaleAnalysModel> resultList = new ArrayList<PeriodyearMmSaleAnalysModel>();
    
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

			List<PeriodyearMmSaleAnalysModel> periodyearMmSaleAnalysList = periodyearMmSaleAnalysMapper.getPeriodyearMmSaleAnalyslist(request);
			for( PeriodyearMmSaleAnalysModel data :  periodyearMmSaleAnalysList) {
				PeriodyearMmSaleAnalysModel model = new PeriodyearMmSaleAnalysModel();
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
				
				model.setSmm( data.getSmm() );
				model.setThisYySplan( data.getThisYySplan() );
				model.setThisYyNetsale( data.getThisYyNetsale() );
				model.setAchivmentrate( data.getAchivmentrate() );
				model.setLastYySplan( data.getLastYySplan() );
				model.setLastYyNetsale( data.getLastYyNetsale() );
				model.setIncrsrate( data.getIncrsrate() );
				
				resultList.add( model );
			}
			System.out.println("all list end");
			
//		} /* -- null end */

		return resultList;
	}
}
