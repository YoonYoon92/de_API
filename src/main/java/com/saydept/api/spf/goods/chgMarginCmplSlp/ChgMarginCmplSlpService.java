package com.saydept.api.spf.goods.chgMarginCmplSlp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.goods.chgMarginCmplSlp.model.ChgMarginCmplSlpModel;
import com.saydept.api.spf.goods.chgMarginCmplSlp.model.ChgMarginCmplSlpParamModel;
import com.saydept.api.spf.saleNews.cornerRtnSts.model.CornerRtnStsModel;
import com.saydept.api.spf.saleNews.cornerRtnSts.model.CornerRtnStsParamModel;
//import com.saydept.api.spf.goods.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

@Service
public class ChgMarginCmplSlpService {

	@Autowired
	private ChgMarginCmplSlpMapper chgMarginCmplSlpMapper;
	
	@Autowired
	private SayUtils sayUtils;

	
	public List<ChgMarginCmplSlpModel> chgMarginCmplSlpList(ChgMarginCmplSlpParamModel request) throws Exception {
		if(request.getBu() == null) {
		request.setBu("");
		}
		if(request.getTim() == null) {
			request.setTim("");
		}
		if(request.getOnlineChk() == null) {
			request.setOnlineChk("");
		}
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
//		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<ChgMarginCmplSlpModel> result = chgMarginCmplSlpMapper.getChgMarginCmplSlplist(request);
		return result;

	}
	
	
//	public List<ChgMarginCmplSlpModel> chgMarginCmplSlpList(ChgMarginCmplSlpParamModel request) throws ParseException {
//		// TODO Auto-generated method stub
//
//		// 작년일자
////		request.setFrDateLy(sayUtils.getCusomYear(request.getFrDate(), -1 ));
////	    request.setToDateLy(sayUtils.getCusomYear(request.getToDate(), -1 ));
//	    
//		List<ChgMarginCmplSlpModel> resultList = new ArrayList<ChgMarginCmplSlpModel>();
//    
////		String beforeDay = sayUtils.getCusomDay(request.getSearchDay(), -1 );
////		String beforeYear = sayUtils.getCusomYear(request.getSearchDay(), -1 );
//			System.out.println("SerchLevel: all"); 					// 조회레벨 출력
//			

//			
//			List<ChgMarginCmplSlpModel> chgMarginCmplSlpList = chgMarginCmplSlpMapper.getChgMarginCmplSlplist(request);
//			for( ChgMarginCmplSlpModel data :  chgMarginCmplSlpList) {
//				ChgMarginCmplSlpModel model = new ChgMarginCmplSlpModel();
////				model.setJum( data.getJum() );
////				model.setJumNm( data.getJumNm() );
////				model.setBu( data.getBu() );
////				model.setBuNm( data.getBuNm() );
////				model.setTim( data.getTim() );
////				model.setTimNm( data.getTimNm() );
////				model.setPc( data.getPc() );
////				model.setPcNm( data.getPcNm() );
//				model.setClsNo( data.getClsNo() );
//				model.setClsNm( data.getClsNm() );
//				
//				model.setFrMargin( data.getFrMargin() );
//				model.setToMargin( data.getToMargin() );
//				
//				resultList.add( model );
//			}
//			System.out.println("all list end");
//			
////		} /* -- null end */
//
//		return resultList;
//	}
	
}
