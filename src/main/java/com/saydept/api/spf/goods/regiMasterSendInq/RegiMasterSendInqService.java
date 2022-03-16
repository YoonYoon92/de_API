package com.saydept.api.spf.goods.regiMasterSendInq;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.goods.clsSendHistory.model.ClsSendHistoryModel;
import com.saydept.api.spf.goods.regiMasterSendInq.model.RegiMasterSendInqModel;
import com.saydept.api.spf.goods.regiMasterSendInq.model.RegiMasterSendInqParamModel;
import com.saydept.api.spf.goods.regiMasterSendInq.model.RegiMasterSendInqSearchModel;
import com.saydept.utils.SayUtils;

@Service
public class RegiMasterSendInqService {

	@Autowired
	private RegiMasterSendInqMapper regiMasterSendInqMapper;
	
//	@Autowired
//	private SayUtils sayUtils;
	
//	public List<RegiMasterSendInqModel> regiMasterSendInqList(RegiMasterSendInqParamModel request)throws Exception {
//		if(request.getRegiNo() == null) {
//			request.setRegiNo("");
//		}
//		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
//		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
//		List<RegiMasterSendInqModel> result = regiMasterSendInqMapper.getRegiMasterSendInqlist(request);
//		System.out.println("all list end");
//		return result;
//	}

	public List<RegiMasterSendInqModel> regiMasterSendInqList(RegiMasterSendInqParamModel request) throws ParseException {
		List<RegiMasterSendInqModel> resultList = new ArrayList<RegiMasterSendInqModel>();
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
			List<RegiMasterSendInqModel> regiMasterSendInqList = regiMasterSendInqMapper.getRegiMasterSendInqlist(request);
			for( RegiMasterSendInqModel data :  regiMasterSendInqList) {
				RegiMasterSendInqModel model = new RegiMasterSendInqModel();
				model.setRegiNo(data.getRegiNo());
				model.setRegiNm(data.getRegiNm());
				model.setCode0(data.getCode0());
				model.setDate0(data.getDate0());
				model.setCode1(data.getCode1());
				model.setDate1(data.getDate1());
				model.setCode2(data.getCode2());
				model.setDate2(data.getDate2());
				model.setCode3(data.getCode3());
				model.setDate3(data.getDate3());
				model.setCode4(data.getCode4());
				model.setDate4(data.getDate4());
				model.setCode5(data.getCode5());
				model.setDate5(data.getDate5());
				model.setCode6(data.getCode6());
				model.setDate6(data.getDate6());
				model.setCode7(data.getCode7());
				model.setDate7(data.getDate7());
				model.setCode8(data.getCode8());
				model.setDate8(data.getDate8());
				model.setCode9(data.getCode9());
				model.setDate9(data.getDate9());
				resultList.add( model );
			}
			System.out.println("all list end");
		return resultList;
	}
	
	
	//------------
	
	public List<RegiMasterSendInqSearchModel> regiMasterSendInqSearchList(RegiMasterSendInqSearchModel request) throws ParseException {
		// TODO Auto-generated method stub
		List<RegiMasterSendInqSearchModel> resultList = new ArrayList<RegiMasterSendInqSearchModel>();
		if(request.getJum() == null) {
			request.setJum("01");
		}
		if(request.getBu() == null) {
			request.setBu("00");
		}
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
			List<RegiMasterSendInqSearchModel> regiMasterSendInqList = regiMasterSendInqMapper.getRegiMasterSendInqSearchList(request);
			for( RegiMasterSendInqSearchModel data :  regiMasterSendInqList) {
				RegiMasterSendInqSearchModel model = new RegiMasterSendInqSearchModel();
				
//				model.setMaeDate ( data.getMaeDate() );
				model.setRegiNo ( data.getRegiNo() );
				model.setRegiNm ( data.getRegiNm() );
				model.setRcptNo ( data.getRcptNo() );
				
				resultList.add( model );
			}
			System.out.println("regi list end");
			
//		} /* -- null end */

		return resultList;
	}
}
