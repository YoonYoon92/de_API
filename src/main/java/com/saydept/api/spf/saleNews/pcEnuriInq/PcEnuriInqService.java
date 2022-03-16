package com.saydept.api.spf.saleNews.pcEnuriInq;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.saydept.api.spf.goods.regiMasterSendInq.model.RegiMasterSendInqSearchModel;
import com.saydept.api.spf.saleNews.pcEnuriInq.model.PcEnuriInqModel;
import com.saydept.api.spf.saleNews.pcEnuriInq.model.PcEnuriInqParamModel;
import com.saydept.api.spf.saleNews.pcEnuriInq.model.PcEnuriInqSearchModel;

//import com.saydept.api.spf.saleNews.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

@Service
public class PcEnuriInqService {

	@Autowired
	private PcEnuriInqMapper pcEnuriInqMapper;
	
	@Autowired
	private SayUtils sayUtils;

	public List<PcEnuriInqModel> pcEnuriInqList(PcEnuriInqParamModel request) throws ParseException {
		// TODO Auto-generated method stub

		// 작년일자
		request.setFrDateLy(sayUtils.getCusomYear(request.getFrDate(), -1 ));
	    request.setToDateLy(sayUtils.getCusomYear(request.getToDate(), -1 ));
//	    System.out.println("LastDay"); 					//로그 찍기
//	    System.out.println(request); 					//로그 찍기
	    
		List<PcEnuriInqModel> resultList = new ArrayList<PcEnuriInqModel>();
    
//		String beforeDay = sayUtils.getCusomDay(request.getSearchDay(), -1 );
//		String beforeYear = sayUtils.getCusomYear(request.getSearchDay(), -1 );
//		System.out.println("before jum");
//		if( request.getSerchLevel().equals(null)		//등급이 null일때
//				) {	
			System.out.println("     SerchLevel :"+(char)27+"[0;36m "+request.getSerchLevel()+(char)27+"[0;00m"); 					// 조회레벨 출력
			
			if(request.getBu() == null) {
				request.setBu("");
			}
			if(request.getTim() == null) {
				request.setTim("");
			}
			if(request.getRegiNo() == null) {
				request.setRegiNo("");
			}
			if(request.getEnuriCd() == null) {
				request.setEnuriCd("");
			}

			List<PcEnuriInqModel> pcEnuriInqList = pcEnuriInqMapper.getPcEnuriInqlist(request);
			for( PcEnuriInqModel data :  pcEnuriInqList) {
				PcEnuriInqModel model = new PcEnuriInqModel();
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
				model.setCpNm( data.getCpNm() );
				
				model.setClsNo( data.getClsNo() );
				model.setMaeDate( data.getMaeDate() );
				model.setRegiNo( data.getRegiNo() );
				model.setRcptNo( data.getRcptNo() );
				model.setAppNo( data.getAppNo() );
				model.setTcdNo( data.getTcdNo() );
				model.setPointNo( data.getPointNo() );
				model.setEnuriCd( data.getEnuriCd() );
				
				model.setSaleAmt( data.getSaleAmt() );
				model.setEnuriAmt( data.getEnuriAmt() );
				model.setEnuriRate( data.getEnuriRate() );
				
				resultList.add( model );
			}
//			System.out.println("all list end");
			
//		} /* -- null end */

		return resultList;
	}
	
	//------------
	//포스
	public List<PcEnuriInqSearchModel> pcEnuriInqSearchList(PcEnuriInqSearchModel request) throws ParseException {
		// TODO Auto-generated method stub
		List<PcEnuriInqSearchModel> resultList = new ArrayList<PcEnuriInqSearchModel>();
		if(request.getJum() == null) {
			request.setJum("01");
		}
		if(request.getBu() == null) {
			request.setBu("00");
		}
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
			List<PcEnuriInqSearchModel> pcEnuriInqList = pcEnuriInqMapper.getPcEnuriInqSearchList(request);
			for( PcEnuriInqSearchModel data :  pcEnuriInqList) {
				PcEnuriInqSearchModel model = new PcEnuriInqSearchModel();
				
				model.setRegiNo ( data.getRegiNo() );
				model.setRegiNm ( data.getRegiNm() );
				model.setRcptNo ( data.getRcptNo() );
				
				resultList.add( model );
			}
			System.out.println("regi list end");
			
//		} /* -- null end */

		return resultList;
	}
	
	//사유
	public List<PcEnuriInqSearchModel> pcEnuriInqSearchList2(PcEnuriInqSearchModel request) throws ParseException {
		// TODO Auto-generated method stub
		List<PcEnuriInqSearchModel> resultList = new ArrayList<PcEnuriInqSearchModel>();
		if(request.getJum() == null) {
			request.setJum("01");
		}
		if(request.getBu() == null) {
			request.setBu("00");
		}
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
			List<PcEnuriInqSearchModel> pcEnuriInqList2 = pcEnuriInqMapper.getPcEnuriInqSearchList2(request);
			for( PcEnuriInqSearchModel data :  pcEnuriInqList2) {
				PcEnuriInqSearchModel model = new PcEnuriInqSearchModel();
				
				model.setEnuriCd ( data.getEnuriCd() );
				model.setEnuriNm ( data.getEnuriNm() );
				model.setRcptNo ( data.getRcptNo() );
				
				resultList.add( model );
			}
			System.out.println("cd list end");
			
//		} /* -- null end */

		return resultList;
	}
}
