package com.saydept.api.app.appSayPlusMemInfo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.app.appSayPlusMemInfo.model.AppSayPlusMemInfoModel;
import com.saydept.api.app.appSayPlusMemInfo.model.AppSayPlusMemInfoParamModel;

import com.saydept.utils.SayUtils;

@Service
public class AppSayPlusMemInfoService {

	@Autowired
	private AppSayPlusMemInfoMapper appSayPlusMemInfoMapper;
	
	@Autowired
	private SayUtils sayUtils;

	public List<AppSayPlusMemInfoModel> appSayPlusMemInfoList(AppSayPlusMemInfoParamModel request) throws ParseException {
		// TODO Auto-generated method stub

		// 작년일자
//		request.setFrDateLy(sayUtils.getCusomYear(request.getFrDate(), -1 ));
//	    request.setToDateLy(sayUtils.getCusomYear(request.getToDate(), -1 ));
//	    System.out.println("LastDay"); 					//로그 찍기
//	    System.out.println(request); 					//로그 찍기
	    
		List<AppSayPlusMemInfoModel> resultList = new ArrayList<AppSayPlusMemInfoModel>();
    
//		String beforeDay = sayUtils.getCusomDay(request.getSearchDay(), -1 );
//		String beforeYear = sayUtils.getCusomYear(request.getSearchDay(), -1 );
//		System.out.println("before jum");
//		if( request.getSerchLevel().equals(null)		//등급이 null일때
//				) {	
//			System.out.println("SerchLevel: all"); 					// 조회레벨 출력
			
//			if(request.getJum() == null) {
//				request.setJum("01");
		
		//1바이트문자 2바이트변환 
		//대문자 "Ａ","Ｂ","Ｃ","Ｄ","Ｅ","Ｆ","Ｇ","Ｈ","Ｉ","Ｊ","Ｋ","Ｌ","Ｍ","Ｎ","Ｏ","Ｐ","Ｑ","Ｒ","Ｓ","Ｔ","Ｕ","Ｖ","Ｗ","Ｘ","Ｙ","Ｚ"
			String[] alpha2={"ａ","ｂ","ｃ","ｄ","ｅ","ｆ","ｇ","ｈ","ｉ","ｊ","ｋ","ｌ","ｍ","ｎ","ｏ","ｐ","ｑ","ｒ","ｓ","ｔ","ｕ","ｖ","ｗ","ｘ","ｙ","ｚ"
							,"ａ","ｂ","ｃ","ｄ","ｅ","ｆ","ｇ","ｈ","ｉ","ｊ","ｋ","ｌ","ｍ","ｎ","ｏ","ｐ","ｑ","ｒ","ｓ","ｔ","ｕ","ｖ","ｗ","ｘ","ｙ","ｚ"};
			
			String[] alpha1={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
							,"a","b","c","d","e","f","g","h","i","j","k","l","N","n","o","p","q","r","s","t","u","v","w","x","y","z"};
			
			String alphaConvBef=request.getMemName();
			StringBuilder alphaConvAf=new StringBuilder();
			int chkdigit=request.getMemName().length();
		
			for (int i=0; i< chkdigit;i++)
			{
				for (int j=0; j<alpha1.length;j++) {
				if(alphaConvBef.substring(i,i+1).equals(alpha1[j])) {
				
					alphaConvAf.insert(i,alpha2[j]);
				}
													}
				if(alphaConvAf.length()<=i)
				{
					
					alphaConvAf.insert(i,alphaConvBef.substring(i,i+1));
				}
			}
			request.setMemName(alphaConvAf.toString());
			System.out.println(request);
			if(request.getCitizenNo1() == null) {
				request.setCitizenNo1("");
			}
			if(request.getMemName() == null) {
				request.setMemName("조회불가");
			}
			if(request.getMemName() == "") {
				request.setMemName("조회불가");
			}
			if(request.getHpNo() == null) {
				request.setHpNo("");
			}

			//현재날짜
			java.util.Date d = new java.util.Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			String date = df.format(d);
			//한달후 날짜
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, +1);
			Date currentTime=cal.getTime();
			SimpleDateFormat formatter=new SimpleDateFormat("yyyyMMdd");
			String release_Dt_start=formatter.format(currentTime);
			System.out.println(release_Dt_start);
			
			request.setDelDate(release_Dt_start);
			
			
//			if(request.getInputDate() == null) {
//				request.setInputDate("");
//			}

			List<AppSayPlusMemInfoModel> appSayPlusMemInfoList = appSayPlusMemInfoMapper.getAppSayPlusMemInfolist(request);
			for( AppSayPlusMemInfoModel data :  appSayPlusMemInfoList) {
				AppSayPlusMemInfoModel model = new AppSayPlusMemInfoModel();
				AppSayPlusMemInfoModel informodel = new AppSayPlusMemInfoModel();
//				model.setJum( data.getJum() );
				model.setCitizenNo1( data.getCitizenNo1() );
				model.setCitizenNo2( data.getCitizenNo2() );
				model.setWheno( data.getWheno() );
				model.setName( data.getName() );
				model.setHptel( data.getHptel() );
				model.setJoinDate( data.getJoinDate() );
				model.setTerminateDate( data.getTerminateDate() );
				model.setCardst( data.getCardst() );
				model.setTpoint( data.getTpoint() );
				model.setNow( data.getNow() );
				model.setLostPoint(data.getLostPoint());
//				informodel=appSayPlusMemInfoMapper.getAppSayPlusMemlostPoint(data);
//				if(informodel!=null) {
//				model.setLostPoint(informodel.getLostPoint());
//				}
//			
				
				resultList.add( model );
			}
//			System.out.println("all list end");
			
//		} /* -- null end */

		return resultList;
	}

	
}
