package com.saydept.api.sda.sleManageCt.acntSleManageCt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.sda.sleManageCt.acntSleManageCt.model.AcntSleManageCtModel;
import com.saydept.api.sda.sleManageCt.acntSleManageCt.model.AcntSleManageCtParamModel;
import com.saydept.api.spf.saleNews.buPlanSaleInq.model.BuPlanSaleInqModel;
import com.saydept.api.spf.saleNews.buPlanSaleInq.model.BuPlanSaleInqParamModel;
//import com.saydept.api.spf.saleNews.buPlanSaleInq.model.BuPlanSaleInqModel;
import com.saydept.utils.SayUtils;

@Service
public class AcntSleManageCtService {

	@Autowired
	private AcntSleManageCtMapper acntSleManageCtMapper;
	
	@Autowired
	private SayUtils sayUtils;

	/**/
	public  List<AcntSleManageCtModel> acntSleManageCtList(AcntSleManageCtParamModel request)throws ParseException {
		
		List<AcntSleManageCtModel> result = acntSleManageCtMapper.selectAcntSleManageCtlist(request);
		return result;

	}
	/**/
//	public List<AcntSleManageCtModel> acntSleManageCtListA(AcntSleManageCtParamModel request) throws ParseException {
//		// TODO Auto-generated method stub
//
//		if(request.getJum() == null) {
//			request.setJum("01");
//		}
//		if(request.getOnlineChk() == null) {
//			request.setOnlineChk("");
//		}
//	
//		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
//		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
//		
//		List<AcntSleManageCtModel> result = new ArrayList<AcntSleManageCtModel>();
//		
//					//로그 찍기
//			/**
//			 * 1. 해당 부 리스트 조회
//			 */
////			List<AcntSleManageCtModel> AcntSleManageCtList = acntSleManageCtMapper.getAcntSleManageCtlistA(request);
////			for( AcntSleManageCtModel data :  AcntSleManageCtList) {
////				AcntSleManageCtModel model = new AcntSleManageCtModel();
////				model.setBu( data.getBu() );
////				model.setBuNm( data.getBuNm() );
////				model.setCls( data.getCls() );
////				model.setClsNm( data.getClsNm() );
////				model.setDdTotsale( data.getDdTotsale() );
////				model.setDdDsicount( data.getDdDsicount() );
////				model.setDdNetsale( data.getDdNetsale() );
////				model.setMmTotsale( data.getMmTotsale() );
////				model.setMmDsicount( data.getMmDsicount() );
////				model.setMmNetsale( data.getMmNetsale() );
////				model.setYyTotsale( data.getYyTotsale() );
////				model.setYyDsicount( data.getYyDsicount() );
////				model.setYyNetsale( data.getYyNetsale() );
////				
////				resultList.add( model );
////			}
//		
//		return result;
//	}
	/**/
}
