package com.saydept.api.scd.custmer.pointSalesInq;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.scd.custmer.pointSalesInq.model.PointSalesInqModel;
import com.saydept.api.spf.selng.receiptInfoInq.model.ReceiptInfoInqModel;

	@Service
	public class PointSalesInqService {

	@Autowired
	private PointSalesInqMapper pointSalesInqMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public PointSalesInqModel selectPointSalesInq(PointSalesInqModel request)throws Exception {

	PointSalesInqModel result = pointSalesInqMapper.selectPointSalesInq(request);
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PointSalesInqModel> selectPointSalesInqList(PointSalesInqModel request)throws Exception {
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMdd");
		SimpleDateFormat format2 = new SimpleDateFormat ( "HHmmss");
		Date time = new Date();
		String time1 = format1.format(time);
		String time2 = format2.format(time);
		
		int year  = Integer.parseInt(time1.substring(0,4));
		int month = Integer.parseInt(time1.substring(4,6));
		month=month+1;
		if(month==13) 
		{
			month=1;
			year=year+1;
		}
		System.out.println(year);
		System.out.println(month);
		
		request.setYearP1(String.valueOf(year));
		request.setMonthP1(String.valueOf(month));
		request.setSearchPoint1(request.getSearchPoint().substring(0,2));
		request.setSearchPoint2(request.getSearchPoint().substring(3,9));
		request.setSearchPoint3(request.getSearchPoint().substring(10,11));
		System.out.println(request);
		List<PointSalesInqModel> resultList = new ArrayList<PointSalesInqModel>();
		List<PointSalesInqModel> result = pointSalesInqMapper.selectPointSalesInqList(request);
		PointSalesInqModel pointInform = new PointSalesInqModel();

		PointSalesInqModel pointWrite=pointSalesInqMapper.pointInform(request);
			if(pointWrite==null) {
				pointInform.setStsDiv("A");
				pointInform.setPointNm("회원없음");
			}
			else {
				pointInform.setStsDiv(pointWrite.getStsDiv());
				pointInform.setPointNm(pointWrite.getPointNm());
				pointInform.setPointScore(pointWrite.getPointScore());
				pointInform.setLostPoint(pointWrite.getLostPoint());
			}
		
		
		resultList.add(pointInform);
		if(result!=null){
		for(PointSalesInqModel model : result) {
			model.setStsDiv("B");
			resultList.add(model);
			System.out.println(model);
		}
		}
		
		return resultList;

	}



}