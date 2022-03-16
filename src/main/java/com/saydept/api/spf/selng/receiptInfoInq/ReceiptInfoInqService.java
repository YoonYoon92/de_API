package com.saydept.api.spf.selng.receiptInfoInq;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.selng.generalCreditSalesInq.model.GeneralCreditSalesInqModel;
import com.saydept.api.spf.selng.receiptInfoInq.model.ReceiptInfoInqModel;
import com.saydept.api.spf.selng.receiptInfoInq.model.ReceiptInfoInqTrModel;

	@Service
	public class ReceiptInfoInqService {

	@Autowired
	private ReceiptInfoInqMapper receiptInfoInqMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public ReceiptInfoInqModel selectReceiptInfoInq(ReceiptInfoInqModel request)throws Exception {
		String a ="";
		a=String.format("%04d", Integer.parseInt(request.getReceiptNum()));
		
		request.setReceiptNum(a);
		
	ReceiptInfoInqModel resultchk = receiptInfoInqMapper.selectReceiptInfoInq(request);
	
	ReceiptInfoInqModel result= new ReceiptInfoInqModel();
	System.out.println(request);
	System.out.println(resultchk);
	if(resultchk!=null) {
		result.setStsDiv("Y");
	}else
	{
		result.setStsDiv("N");
	}
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
//	public List<ReceiptInfoInqModel> selectReceiptInfoInqList(ReceiptInfoInqModel request)throws Exception {
//		
//		return resultList;
//
//	}
	public List<ReceiptInfoInqModel> selectReceiptInfoInqList2(ReceiptInfoInqModel request)throws Exception {

//		
//		int count=0;
//		ReceiptInfoInqModel payResult = receiptInfoInqMapper.selectReceiptInfoInqList(request);
//		List<ReceiptInfoInqModel> result = receiptInfoInqMapper.selectReceiptInfoInqList4(request);
//		List<ReceiptInfoInqModel> eventList = receiptInfoInqMapper.findEvent(request);
//		List<ReceiptInfoInqModel> resultList = new ArrayList<ReceiptInfoInqModel>();
//		ReceiptInfoInqModel classChk= new ReceiptInfoInqModel();
//		ReceiptInfoInqModel cls= new ReceiptInfoInqModel();
//		ReceiptInfoInqModel itemChk= new ReceiptInfoInqModel();
//		ReceiptInfoInqModel item= new ReceiptInfoInqModel();
//		
//		ReceiptInfoInqModel point= new ReceiptInfoInqModel();
//		ReceiptInfoInqModel point1= new ReceiptInfoInqModel();
//		
//		ReceiptInfoInqModel cardNo= new ReceiptInfoInqModel();
//		ReceiptInfoInqModel coupon= new ReceiptInfoInqModel();
//		ReceiptInfoInqModel cash= new ReceiptInfoInqModel();
//		ReceiptInfoInqModel cashAfter= new ReceiptInfoInqModel();
//		
//		ReceiptInfoInqModel gift1= new ReceiptInfoInqModel();
//		ReceiptInfoInqModel gift2= new ReceiptInfoInqModel();
//		ReceiptInfoInqModel gift3= new ReceiptInfoInqModel();
//		ReceiptInfoInqModel gift4= new ReceiptInfoInqModel();
//		ReceiptInfoInqModel gift5= new ReceiptInfoInqModel();
//		ReceiptInfoInqModel gift6= new ReceiptInfoInqModel();
//		ReceiptInfoInqModel gift7= new ReceiptInfoInqModel();
//		ReceiptInfoInqModel gift8= new ReceiptInfoInqModel();
//		ReceiptInfoInqModel gift9= new ReceiptInfoInqModel();
//		
//		ReceiptInfoInqModel data = new ReceiptInfoInqModel();
//		ReceiptInfoInqModel data2 = new ReceiptInfoInqModel();
//		ReceiptInfoInqModel data3 = new ReceiptInfoInqModel();
//		ReceiptInfoInqModel data4 = new ReceiptInfoInqModel();
//		ReceiptInfoInqModel data5 = new ReceiptInfoInqModel();
//
//		ReceiptInfoInqModel van = new ReceiptInfoInqModel();
//
//		
//		
//		data.setStsDiv("A");
//		data.setStartDt(request.getStartDt());
//		data.setJum(request.getJum());
//		data.setChit(payResult.getChit1());
//		data.setPayDiv(payResult.getPayDiv1());
//		data.setPayPrice(payResult.getPayPrice1());
//		data.setCardNo(payResult.getCardNo1());
//		data.setAppNo(payResult.getAppNo1());
//		System.out.println(data);
//		if(!data.getCardNo().equals("")&&data.getPayDiv().equals("카드")) {
//		van = receiptInfoInqMapper.searchVan(data);
//		data.setVan(van==null? "" : van.getVan());	
//		}
//		
//		
//		resultList.add(data);
//		
//		if(!payResult.getPayDiv2().equals("")){
//		data2.setStsDiv("A");
//		data2.setStartDt(request.getStartDt());
//		data2.setJum(request.getJum());
//		data2.setChit(payResult.getChit2());
//		data2.setPayDiv(payResult.getPayDiv2());
//		data2.setPayPrice(payResult.getPayPrice2());
//		data2.setCardNo(payResult.getCardNo2());
//		data2.setAppNo(payResult.getAppNo2());
//		if(!data2.getCardNo().equals("")&&data2.getPayDiv().equals("카드")) {
//		van = receiptInfoInqMapper.searchVan(data2);
//		data2.setVan(van==null? "" : van.getVan());	
//		}
//		
//		resultList.add(data2);
//		}
//		if(!payResult.getPayDiv3().equals("")) {
//		data3.setStsDiv("A");
//		data3.setStartDt(request.getStartDt());
//		data3.setJum(request.getJum());
//		data3.setChit(payResult.getChit3());
//		data3.setPayDiv(payResult.getPayDiv3());
//		data3.setPayPrice(payResult.getPayPrice3());
//		data3.setCardNo(payResult.getCardNo3());
//		data3.setAppNo(payResult.getAppNo3());
//		if(!data3.getCardNo().equals("")&&data3.getPayDiv().equals("카드")) {
//		van = receiptInfoInqMapper.searchVan(data3);
//		data3.setVan(van==null? "" : van.getVan());	
//
//		}
//		resultList.add(data3);
//		}
//		if(!payResult.getPayDiv4().equals("")) {
//		data4.setStsDiv("A");
//		data4.setStartDt(request.getStartDt());
//		data4.setJum(request.getJum());
//		data4.setChit(payResult.getChit4());
//		data4.setPayDiv(payResult.getPayDiv4());
//		data4.setPayPrice(payResult.getPayPrice4());
//		data4.setCardNo(payResult.getCardNo4());
//		data4.setAppNo(payResult.getAppNo4());
//		if(!data4.getCardNo().equals("")&&data4.getPayDiv().equals("카드")) {
//		van = receiptInfoInqMapper.searchVan(data4);
//		data4.setVan(van==null? "" : van.getVan());	
//		}
//		resultList.add(data4);
//		}
//		if(!payResult.getPayDiv5().equals("")) {
//		data5.setStsDiv("A");
//		data5.setStartDt(request.getStartDt());
//		data5.setJum(request.getJum());
//		data5.setChit(payResult.getChit5());
//		data5.setPayDiv(payResult.getPayDiv5());
//		data5.setPayPrice(payResult.getPayPrice5());
//		data5.setCardNo(payResult.getCardNo5());
//		data5.setAppNo(payResult.getAppNo5());
//		if(!data5.getCardNo().equals("")&&data5.getPayDiv().equals("카드")) {
//		van = receiptInfoInqMapper.searchVan(data5);
//		data5.setVan(van==null? "" : van.getVan());	
//		}
//		
//		resultList.add(data5);
//		}
//		System.out.println(result);
//		
//		
//		for(ReceiptInfoInqModel eventModel :eventList) {
//			if(eventList!=null) {
//				eventModel.setStsDiv("E");
//				resultList.add(eventModel);
//				System.out.println(resultList);
//			}
//		}
//		
//		for(ReceiptInfoInqModel model :result ) {
//			
//		
//			if
//				(model.getData1().substring(0,1).equals("3")){cardNo.setCardNo(model.getData1().substring(6,22));cardNo.setChit(model.getData1().substring(1, 5));}
//				else if	
//				(model.getData2().substring(0,1).equals("3")){cardNo.setCardNo(model.getData2().substring(6,22));cardNo.setChit(model.getData2().substring(1, 5));}
//				else if	
//				(model.getData3().substring(0,1).equals("3")){cardNo.setCardNo(model.getData3().substring(6,22));cardNo.setChit(model.getData3().substring(1, 5));}
//				else if	
//				(model.getData4().substring(0,1).equals("3")){cardNo.setCardNo(model.getData4().substring(6,22));cardNo.setChit(model.getData4().substring(1, 5));}
//				else if	
//				(model.getData5().substring(0,1).equals("3")){cardNo.setCardNo(model.getData5().substring(6,22));cardNo.setChit(model.getData5().substring(1, 5));}
//				else if	
//				(model.getData6().substring(0,1).equals("3")){cardNo.setCardNo(model.getData6().substring(6,22));cardNo.setChit(model.getData6().substring(1, 5));}
//				else if	
//				(model.getData7().substring(0,1).equals("3")){cardNo.setCardNo(model.getData7().substring(6,22));cardNo.setChit(model.getData7().substring(1, 5));}
//				else if	
//				(model.getData8().substring(0,1).equals("3")){cardNo.setCardNo(model.getData8().substring(6,22));cardNo.setChit(model.getData8().substring(1, 5));}
//				else if	
//				(model.getData9().substring(0,1).equals("3")){cardNo.setCardNo(model.getData9().substring(6,22));cardNo.setChit(model.getData9().substring(1, 5));}
//			//전표가없으면 0으로 
//			if(cardNo.getChit()==null){cardNo.setChit("0");}
//			request.setChit(cardNo.getChit());
//			System.out.println(cardNo.getCardNo()+"전표"+cardNo.getChit());
//			//------------------포 인 트 카 드----------------------------			
//			if(model.getData1().substring(0,1).equals("6")){
//				System.out.println("P1");
//				point=receiptInfoInqMapper.findPoint(request);
//				if(point!=null) {
//					point.setStsDiv("6");
//				resultList.add(point);
//				}
//			}
//			if(model.getData2().substring(0,1).equals("6")){
//				System.out.println("P2");
//				point=receiptInfoInqMapper.findPoint(request);
//				if(point!=null) {
//					point.setStsDiv("6");
//				resultList.add(point);
//				}
//			}
//			if(model.getData3().substring(0,1).equals("6")){
//				System.out.println("P3");
//				point=receiptInfoInqMapper.findPoint(request);
//				if(point!=null) {
//					point.setStsDiv("6");
//				resultList.add(point);
//				}
//			}
//			if(model.getData4().substring(0,1).equals("6")){
//				System.out.println("P4");
//				point=receiptInfoInqMapper.findPoint(request);
//				if(point!=null) {
//					point.setStsDiv("6");
//				resultList.add(point);
//				}
//			}
//			if(model.getData5().substring(0,1).equals("6")){
//				System.out.println("P5");
//				point=receiptInfoInqMapper.findPoint(request);
//				if(point!=null) {
//					point.setStsDiv("6");
//				resultList.add(point);
//				}
//			}
//			if(model.getData6().substring(0,1).equals("6")){
//				System.out.println("P6");
//				point=receiptInfoInqMapper.findPoint(request);
//				if(point!=null) {
//					point.setStsDiv("6");
//				resultList.add(point);
//				}
//			}
//			if(model.getData7().substring(0,1).equals("6")){
//				System.out.println("P7");
//				point=receiptInfoInqMapper.findPoint(request);
//				if(point!=null) {
//					point.setStsDiv("6");
//				resultList.add(point);
//				}
//			}
//			if(model.getData8().substring(0,1).equals("6")){
//				System.out.println("P8");
//				point=receiptInfoInqMapper.findPoint(request);
//				if(point!=null) {
//					point.setStsDiv("6");
//				resultList.add(point);
//				}
//			}
//			if(model.getData9().substring(0,1).equals("6")){
//				System.out.println("P9");
//				point=receiptInfoInqMapper.findPoint(request);
//				if(point!=null) {
//					point.setStsDiv("6");
//				resultList.add(point);
//				}
//			}
//			
//			if(point.getPointNum()==null) {
//				point1=receiptInfoInqMapper.findPointafter(request);
//				if(point1!=null) {
//				point.setStsDiv("6");
//				point.setPointNum(point1.getPointNum()==null? "" : point1.getPointNum());
//				point.setTotPoint(point1.getTotPoint()==null? "" : point1.getTotPoint());
//				resultList.add(point);
//				}
//			
//			}
////			//------------------전 자 쿠 폰---------------------------- 
//			
//			if(model.getData1().substring(0,1).equals("K")){
//				coupon=receiptInfoInqMapper.findCoupon(request);
//				if(coupon!=null) {
//					coupon.setStsDiv("K");
//				resultList.add(coupon);
//				}
//			}
//			if(model.getData2().substring(0,1).equals("K")){
//				coupon=receiptInfoInqMapper.findCoupon(request);
//				if(coupon!=null) {
//					coupon.setStsDiv("K");
//				resultList.add(coupon);
//				
//				}
//			}
//			if(model.getData3().substring(0,1).equals("K")){
//				coupon=receiptInfoInqMapper.findCoupon(request);
//				System.out.println("coupon:"+coupon);
//				if(coupon!=null) {
//					coupon.setStsDiv("K");
//				resultList.add(coupon);
//				}
//			}
//			if(model.getData4().substring(0,1).equals("K")){
//				coupon=receiptInfoInqMapper.findCoupon(request);
//				if(coupon!=null) {
//					coupon.setStsDiv("K");
//				resultList.add(coupon);
//				}
//			}
//			if(model.getData5().substring(0,1).equals("K")){
//				coupon=receiptInfoInqMapper.findCoupon(request);
//				if(coupon!=null) {
//					coupon.setStsDiv("K");
//				resultList.add(point);
//				}
//			}
//			if(model.getData6().substring(0,1).equals("K")){
//				coupon=receiptInfoInqMapper.findCoupon(request);
//				if(coupon!=null) {
//					coupon.setStsDiv("K");
//				resultList.add(coupon);
//				}
//			}
//			if(model.getData7().substring(0,1).equals("K")){
//				coupon=receiptInfoInqMapper.findCoupon(request);
//				if(coupon!=null) {
//					coupon.setStsDiv("K");
//				resultList.add(coupon);
//				}
//			}
//			if(model.getData8().substring(0,1).equals("K")){
//				coupon=receiptInfoInqMapper.findCoupon(request);
//				if(coupon!=null) {
//					coupon.setStsDiv("K");
//				resultList.add(coupon);
//				}
//			}
//			if(model.getData9().substring(0,1).equals("K")){
//				coupon=receiptInfoInqMapper.findCoupon(request);
//				if(coupon!=null) {
//					coupon.setStsDiv("K");
//				resultList.add(coupon);
//				}
//			}
//			//------------------메 세 지 쿠 폰---------------------------- 
//			
//			if(model.getData1().substring(0,1).equals("M")){
//				request.setCouponCd(model.getData1().substring(1,21));
//				coupon=receiptInfoInqMapper.findMessageCoupon(request);
//				if(coupon!=null) {
//					coupon.setStsDiv("K");
//				resultList.add(coupon);
//				}
//			}
//			if(model.getData2().substring(0,1).equals("M")){
//				request.setCouponCd(model.getData2().substring(1,21));
//				coupon=receiptInfoInqMapper.findMessageCoupon(request);
//				if(coupon!=null) {
//					coupon.setStsDiv("K");
//				resultList.add(coupon);
//				}
//			}
//			if(model.getData3().substring(0,1).equals("M")){
//				request.setCouponCd(model.getData3().substring(1,21));
//				coupon=receiptInfoInqMapper.findMessageCoupon(request);
//				if(coupon!=null) {
//					coupon.setStsDiv("K");
//				resultList.add(coupon);
//				}
//			}
//			if(model.getData4().substring(0,1).equals("M")){
//				request.setCouponCd(model.getData4().substring(1,21));
//				coupon=receiptInfoInqMapper.findMessageCoupon(request);
//				if(coupon!=null) {
//					coupon.setStsDiv("K");
//				resultList.add(coupon);
//				}
//			}
//			if(model.getData5().substring(0,1).equals("M")){
//				request.setCouponCd(model.getData5().substring(1,21));
//				coupon=receiptInfoInqMapper.findMessageCoupon(request);
//				if(coupon!=null) {
//					coupon.setStsDiv("K");
//				resultList.add(coupon);
//				}
//			}
//			if(model.getData6().substring(0,1).equals("M")){
//				request.setCouponCd(model.getData6().substring(1,21));
//				coupon=receiptInfoInqMapper.findMessageCoupon(request);
//				if(coupon!=null) {
//					coupon.setStsDiv("K");
//				resultList.add(coupon);
//				}
//			}
//			if(model.getData7().substring(0,1).equals("M")){
//				request.setCouponCd(model.getData7().substring(1,21));
//				coupon=receiptInfoInqMapper.findMessageCoupon(request);
//				if(coupon!=null) {
//					coupon.setStsDiv("K");
//				resultList.add(coupon);
//				}
//			}
//			if(model.getData8().substring(0,1).equals("M")){
//				request.setCouponCd(model.getData8().substring(1,21));
//				coupon=receiptInfoInqMapper.findMessageCoupon(request);
//				if(coupon!=null) {
//					coupon.setStsDiv("K");
//				resultList.add(coupon);
//				}
//			}
//			if(model.getData9().substring(0,1).equals("M")){
//				request.setCouponCd(model.getData9().substring(1,21));
//				coupon=receiptInfoInqMapper.findMessageCoupon(request);
//				if(coupon!=null) {
//					coupon.setStsDiv("K");
//				resultList.add(coupon);
//				}
//			}
//		
////------------------현 금 영 수 증 ---------------------------- 
//			
//			if(model.getData1().substring(0,1).equals("B")){
//				cash.setCashNum(model.getData1().substring(6,24));
//				cash.setStsDiv("B");
//				resultList.add(cash);
//			
//			}
//			if(model.getData2().substring(0,1).equals("B")){
//				cash.setCashNum(model.getData2().substring(6,24));
//				cash.setStsDiv("B");
//				resultList.add(cash);
//			}
//			if(model.getData3().substring(0,1).equals("B")){
//				cash.setCashNum(model.getData3().substring(6,24));
//				cash.setStsDiv("B");
//				resultList.add(cash);
//			}
//			if(model.getData4().substring(0,1).equals("B")){
//				cash.setCashNum(model.getData4().substring(6,24));
//				cash.setStsDiv("B");
//				resultList.add(cash);
//			}
//			if(model.getData5().substring(0,1).equals("B")){
//				cash.setCashNum(model.getData5().substring(6,24));
//				cash.setStsDiv("B");
//				resultList.add(cash);
//			}
//			if(model.getData6().substring(0,1).equals("B")){
//				cash.setCashNum(model.getData6().substring(6,24));
//				cash.setStsDiv("B");
//				resultList.add(cash);
//			}
//			if(model.getData7().substring(0,1).equals("B")){
//				cash.setCashNum(model.getData7().substring(6,24));
//				cash.setStsDiv("B");
//				resultList.add(cash);
//			}
//			if(model.getData8().substring(0,1).equals("B")){
//				cash.setCashNum(model.getData8().substring(6,24));
//				cash.setStsDiv("B");
//				resultList.add(cash);
//			}
//			if(model.getData9().substring(0,1).equals("B")){
//				cash.setCashNum(model.getData9().substring(6,24));
//				cash.setStsDiv("B");
//				resultList.add(cash);
//			}
//			
//			cashAfter=receiptInfoInqMapper.findCash(request);
//			if(cashAfter!=null) {
//				if(cash.getCashNum()==null) {
//					cash.setCashNum(cashAfter.getCashNum());
//				}
//				cash.setCashApp(cashAfter.getCashApp());
//				cash.setStsDiv("B");
//				resultList.add(cash);
//			}
////------------------상 품 권 ---------------------------- 
//			
//			if(model.getData1().substring(0,1).equals("2")){
//				gift1.setGiftNum(model.getData1().substring(6,19));
//				gift1.setGiftNm("자사상품권");
//				gift1.setStsDiv("2");
//				resultList.add(gift1);
//			
//			}
//			else if(model.getData1().substring(0,1).equals("4")||model.getData1().substring(0,1).equals("8")||model.getData1().substring(0,1).equals("9")||model.getData1().substring(0,1).equals("a")){
//				gift1.setGiftNum(model.getData1().substring(6,19));
//				gift1.setGiftNm("제휴상품권");
//				gift1.setStsDiv("2");
//				resultList.add(gift1);
//			}
//			if(model.getData2().substring(0,1).equals("2")){
//				gift2.setGiftNum(model.getData2().substring(6,19));
//				gift2.setGiftNm("자사상품권");
//				gift2.setStsDiv("2");
//				resultList.add(gift2);
//			}
//			else if(model.getData2().substring(0,1).equals("4")||model.getData2().substring(0,1).equals("8")||model.getData2().substring(0,1).equals("9")||model.getData2().substring(0,1).equals("A")){
//				gift2.setGiftNum(model.getData2().substring(6,19));
//				gift2.setGiftNm("제휴상품권");
//				gift2.setStsDiv("2");
//				resultList.add(gift2);
//			}
//			if(model.getData3().substring(0,1).equals("2")){
//				gift3.setGiftNum(model.getData3().substring(6,19));
//				gift3.setGiftNm("자사상품권");
//				gift3.setStsDiv("2");
//				resultList.add(gift3);
//			}
//			else if(model.getData3().substring(0,1).equals("4")||model.getData3().substring(0,1).equals("8")||model.getData3().substring(0,1).equals("9")||model.getData3().substring(0,1).equals("A")){
//				gift3.setGiftNum(model.getData3().substring(6,19));
//				gift3.setGiftNm("제휴상품권");
//				gift3.setStsDiv("2");
//				resultList.add(gift3);
//			}
//			if(model.getData4().substring(0,1).equals("2")){
//				gift4.setGiftNum(model.getData4().substring(6,19));
//				gift4.setGiftNm("자사상품권");
//				gift4.setStsDiv("2");
//				resultList.add(gift4);
//			}
//			else if(model.getData4().substring(0,1).equals("4")||model.getData4().substring(0,1).equals("8")||model.getData4().substring(0,1).equals("9")||model.getData4().substring(0,1).equals("A")){
//				gift4.setGiftNum(model.getData4().substring(6,19));
//				gift4.setGiftNm("제휴상품권");
//				gift4.setStsDiv("2");
//				resultList.add(gift4);
//			}
//			if(model.getData5().substring(0,1).equals("2")){
//				gift5.setGiftNum(model.getData5().substring(6,19));
//				gift5.setGiftNm("자사상품권");
//				gift5.setStsDiv("2");
//				resultList.add(gift5);
//			}
//			else if(model.getData5().substring(0,1).equals("4")||model.getData5().substring(0,1).equals("8")||model.getData5().substring(0,1).equals("9")||model.getData5().substring(0,1).equals("A")){
//				gift5.setGiftNum(model.getData5().substring(6,19));
//				gift5.setGiftNm("제휴상품권");
//				gift5.setStsDiv("2");
//				resultList.add(gift5);
//			}
//			if(model.getData6().substring(0,1).equals("2")){
//				gift6.setGiftNum(model.getData6().substring(6,19));
//				gift6.setGiftNm("자사상품권");
//				gift6.setStsDiv("2");
//				resultList.add(gift6);
//			}
//			else if(model.getData6().substring(0,1).equals("4")||model.getData6().substring(0,1).equals("8")||model.getData6().substring(0,1).equals("9")||model.getData6().substring(0,1).equals("A")){
//				gift6.setGiftNum(model.getData6().substring(6,19));
//				gift6.setGiftNm("제휴상품권");
//				gift6.setStsDiv("2");
//				resultList.add(gift6);
//			}
//			if(model.getData7().substring(0,1).equals("2")){
//				gift7.setGiftNum(model.getData7().substring(6,19));
//				gift7.setGiftNm("자사상품권");
//				gift7.setStsDiv("2");
//				resultList.add(gift7);
//			}
//			else if(model.getData7().substring(0,1).equals("4")||model.getData7().substring(0,1).equals("8")||model.getData7().substring(0,1).equals("9")||model.getData7().substring(0,1).equals("A")){
//				gift7.setGiftNum(model.getData7().substring(6,19));
//				gift7.setGiftNm("제휴상품권");
//				gift7.setStsDiv("2");
//				resultList.add(gift7);
//			}
//			if(model.getData8().substring(0,1).equals("2")){
//				gift8.setGiftNum(model.getData8().substring(6,19));
//				gift8.setGiftNm("자사상품권");
//				gift8.setStsDiv("2");
//				resultList.add(gift8);
//			}
//			else if(model.getData8().substring(0,1).equals("4")||model.getData8().substring(0,1).equals("8")||model.getData8().substring(0,1).equals("9")||model.getData8().substring(0,1).equals("A")){
//				gift8.setGiftNum(model.getData8().substring(6,19));
//				gift8.setGiftNm("제휴상품권");
//				gift8.setStsDiv("2");
//				resultList.add(gift8);
//			}
//			if(model.getData9().substring(0,1).equals("2")){
//				gift9.setGiftNum(model.getData9().substring(6,19));
//				gift9.setGiftNm("자사상품권");
//				gift9.setStsDiv("2");
//				resultList.add(gift9);
//			}
//			else if(model.getData9().substring(0,1).equals("4")||model.getData9().substring(0,1).equals("8")||model.getData9().substring(0,1).equals("9")||model.getData9().substring(0,1).equals("A")){
//				gift9.setGiftNum(model.getData9().substring(6,19));
//				gift9.setGiftNm("제휴상품권");
//				gift9.setStsDiv("2");
//				resultList.add(gift9);
//			}
//			//------------------아 이 템 ----------------------------
//			if(model.getData1().substring(0,1).equals("1")){
//				if(model.getData1().substring(1,2).equals(" ")||model.getData1().substring(1,2).equals("C")||model.getData1().substring(1,2).equals("D"))
//				{	classChk.setJum(request.getJum());
//					classChk.setCls(model.getData1().substring(16,23));
//					
//					cls = receiptInfoInqMapper.findCls(classChk);
//					cls.setCls(model.getData1().substring(16,23));
//					cls.setNum(Integer.parseInt(model.getData1().substring(31,34)));
//					cls.setPrice(Integer.parseInt(model.getData1().substring(23,31)));
//					cls.setItemDiscount(Integer.parseInt(model.getData1().substring(37,44)));
//					cls.setTotPrice(cls.getNum()*cls.getPrice());
//					cls.setNetsales(cls.getTotPrice()-cls.getItemDiscount());
//					cls.setStsDiv("1");
//					resultList.add(cls);
//				}
//				else {
//					itemChk.setJum(request.getJum());
//					itemChk.setPosNum(request.getPosNum());
//					itemChk.setCls(model.getData1().substring(3,16));
//					item = receiptInfoInqMapper.findItem(itemChk);
//					item.setNum(Integer.parseInt(model.getData1().substring(31,34)));
//					item.setPrice(Integer.parseInt(model.getData1().substring(23,31)));
//					item.setItemDiscount(Integer.parseInt(model.getData1().substring(37,44)));
//					item.setTotPrice(cls.getNum()*cls.getPrice());
//					item.setNetsales(item.getTotPrice()-item.getItemDiscount());
//					item.setStsDiv("1");
//					
//					resultList.add(item);
//				}
//			}
//			if(model.getData2().substring(0,1).equals("1")){
//				if(model.getData2().substring(1,2).equals(" ")||model.getData2().substring(1,2).equals("C")||model.getData2().substring(1,2).equals("D"))
//				{	classChk.setJum(request.getJum());
//					classChk.setCls(model.getData2().substring(16,23));
//					
//					cls = receiptInfoInqMapper.findCls(classChk);
//					cls.setCls(model.getData2().substring(16,23));
//					cls.setNum(Integer.parseInt(model.getData2().substring(31,34)));
//					cls.setPrice(Integer.parseInt(model.getData2().substring(23,31)));
//					cls.setItemDiscount(Integer.parseInt(model.getData2().substring(37,44)));
//					cls.setTotPrice(cls.getNum()*cls.getPrice());
//					cls.setNetsales(cls.getTotPrice()-cls.getItemDiscount());
//					cls.setStsDiv("1");
//					resultList.add(cls);
//				}
//				else {
//					itemChk.setJum(request.getJum());
//					itemChk.setPosNum(request.getPosNum());
//					itemChk.setCls(model.getData2().substring(3,16));
//					item = receiptInfoInqMapper.findItem(itemChk);
//					item.setNum(Integer.parseInt(model.getData2().substring(31,34)));
//					item.setPrice(Integer.parseInt(model.getData2().substring(23,31)));
//					item.setItemDiscount(Integer.parseInt(model.getData2().substring(37,44)));
//					item.setTotPrice(cls.getNum()*cls.getPrice());
//					item.setNetsales(item.getTotPrice()-item.getItemDiscount());
//					item.setStsDiv("1");
//					resultList.add(item);
//				}
//			}
//			if(model.getData3().substring(0,1).equals("1")){
//				if(model.getData3().substring(1,2).equals(" ")||model.getData3().substring(1,2).equals("C")||model.getData3().substring(1,2).equals("D"))
//				{	classChk.setJum(request.getJum());
//					classChk.setCls(model.getData3().substring(16,23));
//					
//					cls = receiptInfoInqMapper.findCls(classChk);
//					cls.setCls(model.getData3().substring(16,23));
//					cls.setNum(Integer.parseInt(model.getData3().substring(31,34)));
//					cls.setPrice(Integer.parseInt(model.getData3().substring(23,31)));
//					cls.setItemDiscount(Integer.parseInt(model.getData3().substring(37,44)));
//					cls.setTotPrice(cls.getNum()*cls.getPrice());
//					cls.setNetsales(cls.getTotPrice()-cls.getItemDiscount());
//					cls.setStsDiv("1");
//					resultList.add(cls);
//				}
//				else {
//					itemChk.setJum(request.getJum());
//					itemChk.setPosNum(request.getPosNum());
//					itemChk.setCls(model.getData3().substring(3,16));
//					item = receiptInfoInqMapper.findItem(itemChk);
//					item.setNum(Integer.parseInt(model.getData3().substring(31,34)));
//					item.setPrice(Integer.parseInt(model.getData3().substring(23,31)));
//					item.setItemDiscount(Integer.parseInt(model.getData3().substring(37,44)));
//					item.setTotPrice(cls.getNum()*cls.getPrice());
//					item.setNetsales(item.getTotPrice()-item.getItemDiscount());
//					item.setStsDiv("1");
//					resultList.add(item);
//				}
//			}
//			if(model.getData4().substring(0,1).equals("1")){
//				if(model.getData4().substring(1,2).equals(" ")||model.getData4().substring(1,2).equals("C")||model.getData4().substring(1,2).equals("D"))
//				{	classChk.setJum(request.getJum());
//					classChk.setCls(model.getData4().substring(16,23));
//					
//					cls = receiptInfoInqMapper.findCls(classChk);
//					cls.setCls(model.getData4().substring(16,23));
//					cls.setNum(Integer.parseInt(model.getData4().substring(31,34)));
//					cls.setPrice(Integer.parseInt(model.getData4().substring(23,31)));
//					cls.setItemDiscount(Integer.parseInt(model.getData4().substring(37,44)));
//					cls.setTotPrice(cls.getNum()*cls.getPrice());
//					cls.setNetsales(cls.getTotPrice()-cls.getItemDiscount());
//					cls.setStsDiv("1");
//					resultList.add(cls);
//				}
//				else {
//					itemChk.setJum(request.getJum());
//					itemChk.setPosNum(request.getPosNum());
//					itemChk.setCls(model.getData4().substring(3,16));
//					item = receiptInfoInqMapper.findItem(itemChk);
//					item.setNum(Integer.parseInt(model.getData4().substring(31,34)));
//					item.setPrice(Integer.parseInt(model.getData4().substring(23,31)));
//					item.setItemDiscount(Integer.parseInt(model.getData4().substring(37,44)));
//					item.setTotPrice(cls.getNum()*cls.getPrice());
//					item.setNetsales(item.getTotPrice()-item.getItemDiscount());
//					item.setStsDiv("1");
//					resultList.add(item);
//				}
//			}
//			if(model.getData5().substring(0,1).equals("1")){
//			
//				if(model.getData5().substring(1,2).equals(" ")||model.getData5().substring(1,2).equals("C")||model.getData5().substring(1,2).equals("D"))
//				{	classChk.setJum(request.getJum());
//					classChk.setCls(model.getData5().substring(16,23));
//					
//					cls = receiptInfoInqMapper.findCls(classChk);
//					cls.setCls(model.getData5().substring(16,23));
//					cls.setNum(Integer.parseInt(model.getData5().substring(31,34)));
//					cls.setPrice(Integer.parseInt(model.getData5().substring(23,31)));
//					cls.setItemDiscount(Integer.parseInt(model.getData5().substring(37,44)));
//					cls.setTotPrice(cls.getNum()*cls.getPrice());
//					cls.setNetsales(cls.getTotPrice()-cls.getItemDiscount());
//					cls.setStsDiv("1");
//					
//					resultList.add(cls);
//				}
//				else {
//					itemChk.setJum(request.getJum());
//					itemChk.setPosNum(request.getPosNum());
//					itemChk.setCls(model.getData5().substring(3,16));
//					item = receiptInfoInqMapper.findItem(itemChk);
//					item.setNum(Integer.parseInt(model.getData5().substring(31,34)));
//					item.setPrice(Integer.parseInt(model.getData5().substring(23,31)));
//					item.setItemDiscount(Integer.parseInt(model.getData5().substring(37,44)));
//					item.setTotPrice(cls.getNum()*cls.getPrice());
//					item.setNetsales(item.getTotPrice()-item.getItemDiscount());
//					item.setStsDiv("1");
//					resultList.add(item);
//				}
//			}
//			if(model.getData6().substring(0,1).equals("1")){
//				if(model.getData6().substring(1,2).equals(" ")||model.getData6().substring(1,2).equals("C")||model.getData6().substring(1,2).equals("D"))
//				{	classChk.setJum(request.getJum());
//					classChk.setCls(model.getData6().substring(16,23));
//					
//					cls = receiptInfoInqMapper.findCls(classChk);
//					cls.setCls(model.getData6().substring(16,23));
//					cls.setNum(Integer.parseInt(model.getData6().substring(31,34)));
//					cls.setPrice(Integer.parseInt(model.getData6().substring(23,31)));
//					cls.setItemDiscount(Integer.parseInt(model.getData6().substring(37,44)));
//					cls.setTotPrice(cls.getNum()*cls.getPrice());
//					cls.setNetsales(cls.getTotPrice()-cls.getItemDiscount());
//					cls.setStsDiv("1");
//		
//					resultList.add(cls);
//				}
//				else {
//					itemChk.setJum(request.getJum());
//					itemChk.setPosNum(request.getPosNum());
//					itemChk.setCls(model.getData6().substring(3,16));
//					item = receiptInfoInqMapper.findItem(itemChk);
//					item.setNum(Integer.parseInt(model.getData6().substring(31,34)));
//					item.setPrice(Integer.parseInt(model.getData6().substring(23,31)));
//					item.setItemDiscount(Integer.parseInt(model.getData6().substring(37,44)));
//					item.setTotPrice(cls.getNum()*cls.getPrice());
//					item.setNetsales(item.getTotPrice()-item.getItemDiscount());
//					item.setStsDiv("1");
//					resultList.add(item);
//				}
//			}
//			if(model.getData7().substring(0,1).equals("1")){
//				if(model.getData7().substring(1,2).equals(" ")||model.getData7().substring(1,2).equals("C")||model.getData7().substring(1,2).equals("D"))
//				{	classChk.setJum(request.getJum());
//					classChk.setCls(model.getData7().substring(16,23));
//					
//					cls = receiptInfoInqMapper.findCls(classChk);
//					cls.setCls(model.getData7().substring(16,23));
//					cls.setNum(Integer.parseInt(model.getData7().substring(31,34)));
//					cls.setPrice(Integer.parseInt(model.getData7().substring(23,31)));
//					cls.setItemDiscount(Integer.parseInt(model.getData7().substring(37,44)));
//					cls.setTotPrice(cls.getNum()*cls.getPrice());
//					cls.setNetsales(cls.getTotPrice()-cls.getItemDiscount());
//					cls.setStsDiv("1");
//					resultList.add(cls);
//				}
//				else {
//					itemChk.setJum(request.getJum());
//					itemChk.setPosNum(request.getPosNum());
//					itemChk.setCls(model.getData7().substring(3,16));
//					item = receiptInfoInqMapper.findItem(itemChk);
//					item.setNum(Integer.parseInt(model.getData7().substring(31,34)));
//					item.setPrice(Integer.parseInt(model.getData7().substring(23,31)));
//					item.setItemDiscount(Integer.parseInt(model.getData7().substring(37,44)));
//					item.setTotPrice(cls.getNum()*cls.getPrice());
//					item.setNetsales(item.getTotPrice()-item.getItemDiscount());
//					resultList.add(item);
//				}
//			}
//			if(model.getData8().substring(0,1).equals("1")){
//				if(model.getData8().substring(1,2).equals(" ")||model.getData8().substring(1,2).equals("C")||model.getData8().substring(1,2).equals("D"))
//				{	classChk.setJum(request.getJum());
//					classChk.setCls(model.getData8().substring(16,23));
//					cls = receiptInfoInqMapper.findCls(classChk);
//					cls.setCls(model.getData8().substring(16,23));
//					cls.setNum(Integer.parseInt(model.getData8().substring(31,34)));
//					cls.setPrice(Integer.parseInt(model.getData8().substring(23,31)));
//					cls.setItemDiscount(Integer.parseInt(model.getData8().substring(37,44)));
//					cls.setTotPrice(cls.getNum()*cls.getPrice());
//					cls.setNetsales(cls.getTotPrice()-cls.getItemDiscount());
//					cls.setStsDiv("1");
//					
//					resultList.add(cls);
//				}
//				else {
//					itemChk.setJum(request.getJum());
//					itemChk.setPosNum(request.getPosNum());
//					itemChk.setCls(model.getData8().substring(3,16));
//					item = receiptInfoInqMapper.findItem(itemChk);
//					item.setNum(Integer.parseInt(model.getData8().substring(31,34)));
//					item.setPrice(Integer.parseInt(model.getData8().substring(23,31)));
//					item.setItemDiscount(Integer.parseInt(model.getData8().substring(37,44)));
//					item.setTotPrice(cls.getNum()*cls.getPrice());
//					item.setNetsales(item.getTotPrice()-item.getItemDiscount());
//					item.setStsDiv("1");
//					resultList.add(item);
//				}
//			}
//			if(model.getData9().substring(0,1).equals("1")){
//				if(model.getData9().substring(1,2).equals(" ")||model.getData9().substring(1,2).equals("C")||model.getData9().substring(1,2).equals("D"))
//				{	classChk.setJum(request.getJum());
//					classChk.setCls(model.getData9().substring(16,23));
//					cls = receiptInfoInqMapper.findCls(classChk);
//					cls.setCls(model.getData9().substring(16,23));
//					cls.setNum(Integer.parseInt(model.getData9().substring(31,34)));
//					cls.setPrice(Integer.parseInt(model.getData9().substring(23,31)));
//					cls.setItemDiscount(Integer.parseInt(model.getData9().substring(37,44)));
//					cls.setTotPrice(cls.getNum()*cls.getPrice());
//					cls.setNetsales(cls.getTotPrice()-cls.getItemDiscount());
//					cls.setStsDiv("1");
//					resultList.add(cls);
//				}
//				else {
//					itemChk.setJum(request.getJum());
//					itemChk.setPosNum(request.getPosNum());
//					itemChk.setCls(model.getData9().substring(3,16));
//					item = receiptInfoInqMapper.findItem(itemChk);
//					item.setNum(Integer.parseInt(model.getData9().substring(31,34)));
//					item.setPrice(Integer.parseInt(model.getData9().substring(23,31)));
//					item.setItemDiscount(Integer.parseInt(model.getData9().substring(37,44)));
//					item.setTotPrice(cls.getNum()*cls.getPrice());
//					item.setNetsales(item.getTotPrice()-item.getItemDiscount());
//					item.setStsDiv("1");
//					resultList.add(item);
//				}
//			}
//					
//		}
////	
//	
//		
//		return resultList;
		List<ReceiptInfoInqModel> result = new ArrayList<ReceiptInfoInqModel>();
		return result;

	}
	
	public List<ReceiptInfoInqModel> selectReceiptInfoInqList3(ReceiptInfoInqModel request)throws Exception {

//		
		int count=0;
		final String PDATA = "P01DATA";
		String a ="";
		a=String.format("%04d", Integer.parseInt(request.getReceiptNum()));
		
		request.setReceiptNum(a);
		ReceiptInfoInqModel payResult = receiptInfoInqMapper.selectReceiptInfoInqList(request);
		
		List<ReceiptInfoInqModel> eventList = receiptInfoInqMapper.findEvent(request);
		List<ReceiptInfoInqModel> resultList = new ArrayList<ReceiptInfoInqModel>();
		ReceiptInfoInqModel classChk= new ReceiptInfoInqModel();
		ReceiptInfoInqModel cls= new ReceiptInfoInqModel();
		ReceiptInfoInqModel itemChk= new ReceiptInfoInqModel();
		ReceiptInfoInqModel item= new ReceiptInfoInqModel();
		
		ReceiptInfoInqModel point= new ReceiptInfoInqModel();
		ReceiptInfoInqModel point1= new ReceiptInfoInqModel();
		
		ReceiptInfoInqModel cardNo= new ReceiptInfoInqModel();
		ReceiptInfoInqModel coupon= new ReceiptInfoInqModel();
		ReceiptInfoInqModel cash= new ReceiptInfoInqModel();
		ReceiptInfoInqModel cashAfter= new ReceiptInfoInqModel();
		
		ReceiptInfoInqModel gift1= new ReceiptInfoInqModel();
		ReceiptInfoInqModel gift2= new ReceiptInfoInqModel();
		ReceiptInfoInqModel gift3= new ReceiptInfoInqModel();
		ReceiptInfoInqModel gift4= new ReceiptInfoInqModel();
		ReceiptInfoInqModel gift5= new ReceiptInfoInqModel();
		ReceiptInfoInqModel gift6= new ReceiptInfoInqModel();
		ReceiptInfoInqModel gift7= new ReceiptInfoInqModel();
		ReceiptInfoInqModel gift8= new ReceiptInfoInqModel();
		ReceiptInfoInqModel gift9= new ReceiptInfoInqModel();
		
		ReceiptInfoInqModel data = new ReceiptInfoInqModel();
		ReceiptInfoInqModel data2 = new ReceiptInfoInqModel();
		ReceiptInfoInqModel data3 = new ReceiptInfoInqModel();
		ReceiptInfoInqModel data4 = new ReceiptInfoInqModel();
		ReceiptInfoInqModel data5 = new ReceiptInfoInqModel();

		ReceiptInfoInqModel van = new ReceiptInfoInqModel();

		
		
		data.setStsDiv("A");
		data.setStartDt(request.getStartDt());
		data.setJum(request.getJum());
		data.setChit(payResult.getChit1());
		data.setPayDiv(payResult.getPayDiv1());
		data.setPayPrice(payResult.getPayPrice1());
		data.setCardNo(payResult.getCardNo1());
		data.setAppNo(payResult.getAppNo1());
		System.out.println(data);
		if(!data.getCardNo().equals("")&&data.getPayDiv().equals("카드")) {
		van = receiptInfoInqMapper.searchVan(data);
		data.setVan(van==null? "" : van.getVan());	
		}
		
		
		resultList.add(data);
		
		if(!payResult.getPayDiv2().equals("")){
		data2.setStsDiv("A");
		data2.setStartDt(request.getStartDt());
		data2.setJum(request.getJum());
		data2.setChit(payResult.getChit2());
		data2.setPayDiv(payResult.getPayDiv2());
		data2.setPayPrice(payResult.getPayPrice2());
		data2.setCardNo(payResult.getCardNo2());
		data2.setAppNo(payResult.getAppNo2());
		if(!data2.getCardNo().equals("")&&data2.getPayDiv().equals("카드")) {
		van = receiptInfoInqMapper.searchVan(data2);
		data2.setVan(van==null? "" : van.getVan());	
		}
		
		resultList.add(data2);
		}
		if(!payResult.getPayDiv3().equals("")) {
		data3.setStsDiv("A");
		data3.setStartDt(request.getStartDt());
		data3.setJum(request.getJum());
		data3.setChit(payResult.getChit3());
		data3.setPayDiv(payResult.getPayDiv3());
		data3.setPayPrice(payResult.getPayPrice3());
		data3.setCardNo(payResult.getCardNo3());
		data3.setAppNo(payResult.getAppNo3());
		if(!data3.getCardNo().equals("")&&data3.getPayDiv().equals("카드")) {
		van = receiptInfoInqMapper.searchVan(data3);
		data3.setVan(van==null? "" : van.getVan());	

		}
		resultList.add(data3);
		}
		if(!payResult.getPayDiv4().equals("")) {
		data4.setStsDiv("A");
		data4.setStartDt(request.getStartDt());
		data4.setJum(request.getJum());
		data4.setChit(payResult.getChit4());
		data4.setPayDiv(payResult.getPayDiv4());
		data4.setPayPrice(payResult.getPayPrice4());
		data4.setCardNo(payResult.getCardNo4());
		data4.setAppNo(payResult.getAppNo4());
		if(!data4.getCardNo().equals("")&&data4.getPayDiv().equals("카드")) {
		van = receiptInfoInqMapper.searchVan(data4);
		data4.setVan(van==null? "" : van.getVan());	
		}
		resultList.add(data4);
		}
		if(!payResult.getPayDiv5().equals("")) {
		data5.setStsDiv("A");
		data5.setStartDt(request.getStartDt());
		data5.setJum(request.getJum());
		data5.setChit(payResult.getChit5());
		data5.setPayDiv(payResult.getPayDiv5());
		data5.setPayPrice(payResult.getPayPrice5());
		data5.setCardNo(payResult.getCardNo5());
		data5.setAppNo(payResult.getAppNo5());
		if(!data5.getCardNo().equals("")&&data5.getPayDiv().equals("카드")) {
		van = receiptInfoInqMapper.searchVan(data5);
		data5.setVan(van==null? "" : van.getVan());	
		}
		
		resultList.add(data5);
		}

		
		
		for(ReceiptInfoInqModel eventModel :eventList) {
			if(eventList!=null) {
				eventModel.setStsDiv("E");
				resultList.add(eventModel);
				System.out.println(resultList);
			}
		}
		
		List<ReceiptInfoInqTrModel> result  = new ArrayList<ReceiptInfoInqTrModel>();
	    result = receiptInfoInqMapper.selectReceiptInfoInqList2(request);
	    
	    
	    
		for(ReceiptInfoInqTrModel model :result ) {
			
			for(Field field : model.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				Object value = field.get(model);
				
			
				String str =field.getName().substring(0,7).toString();
					
				
			if(str.equals(PDATA)) {
				
			if(value.toString().substring(0, 1).equals("3")){
				cardNo.setCardNo(value.toString().substring(6, 22));
				cardNo.setChit(value.toString().substring(1, 5));
				cardNo.setStsDiv("A");		
				}
				
				
		//전표가없으면 0으로 
			if(cardNo.getChit()==null){cardNo.setChit("0");}
			request.setChit(cardNo.getChit());
			System.out.println(cardNo.getCardNo()+"전표"+cardNo.getChit());
			//------------------포 인 트 카 드----------------------------			
			if(value.toString().substring(0,1).equals("6")){
				System.out.println("P1");
				point=receiptInfoInqMapper.findPoint(request);
				if(point!=null) {
					point.setStsDiv("6");
				resultList.add(point);
				}
			
			}
			if(point.getPointNum()==null) {
				point1=receiptInfoInqMapper.findPointafter(request);
				if(point1!=null) {
				point.setStsDiv("6");
				point.setPointNum(point1.getPointNum()==null? "" : point1.getPointNum());
				point.setTotPoint(point1.getTotPoint()==null? "" : point1.getTotPoint());
				resultList.add(point);
				}
			
			}
//			//------------------전 자 쿠 폰---------------------------- 
			
			if(value.toString().substring(0,1).equals("K")){
				System.out.println("전자쿠폰");
				coupon=receiptInfoInqMapper.findCoupon(request);
				if(coupon!=null) {
					coupon.setStsDiv("K");
				resultList.add(coupon);
				}
			}
			
			
			//------------------메 세 지 쿠 폰---------------------------- 
			
			if(value.toString().substring(0,1).equals("M")){
				System.out.println("메세지쿠폰");
				request.setCouponCd(value.toString().substring(1,21));
				coupon=receiptInfoInqMapper.findMessageCoupon(request);
				if(coupon!=null) {
					coupon.setStsDiv("K");
				resultList.add(coupon);
				}
			}
			
		
//------------------현 금 영 수 증 ---------------------------- 
			
			if(value.toString().substring(0,1).equals("B")){
				System.out.println("현금영수증");
				cash.setCashNum(value.toString().substring(6,24));
				cash.setStsDiv("B");
				resultList.add(cash);
			
			}
			
			
			cashAfter=receiptInfoInqMapper.findCash(request);
			if(cashAfter!=null) {
				if(cash.getCashNum()==null) {
					System.out.println("사후현금영수증");
					cash.setCashNum(cashAfter.getCashNum());
				}
				cash.setCashApp(cashAfter.getCashApp());
				cash.setStsDiv("B");
				resultList.add(cash);
			}
//------------------상 품 권 ---------------------------- 
			
			if(value.toString().substring(0,1).equals("2")){
				System.out.println("자사상품권");
				gift1.setGiftNum(value.toString().substring(6,19));
				gift1.setGiftNm("자사상품권");
				gift1.setStsDiv("2");
				resultList.add(gift1);
			
			}
			else if(value.toString().substring(0,1).equals("4")||value.toString().substring(0,1).equals("8")||value.toString().substring(0,1).equals("9")||value.toString().substring(0,1).equals("a")){
				System.out.println("제휴상품권");
				gift1.setGiftNum(value.toString().substring(6,19));
				gift1.setGiftNm("제휴상품권");
				gift1.setStsDiv("2");
				resultList.add(gift1);
			}
			
			//------------------아 이 템 ----------------------------
			if(value.toString().substring(0,1).equals("1")){
				if(value.toString().substring(1,2).equals(" ")||value.toString().substring(1,2).equals("C")||value.toString().substring(1,2).equals("D"))
				{	classChk.setJum(request.getJum());
					classChk.setCls(value.toString().substring(16,23));
					System.out.println("아이템");
					cls = receiptInfoInqMapper.findCls(classChk);
					cls.setCls(value.toString().substring(16,23));
					cls.setNum(Integer.parseInt(value.toString().substring(31,34)));
					cls.setPrice(Integer.parseInt(value.toString().substring(23,31)));
					cls.setItemDiscount(Integer.parseInt(value.toString().substring(37,44)));
					cls.setTotPrice(cls.getNum()*cls.getPrice());
					cls.setNetsales(cls.getTotPrice()-cls.getItemDiscount());
					cls.setStsDiv("1");
					resultList.add(cls);
				}
				else {
					itemChk.setJum(request.getJum());
					itemChk.setPosNum(request.getPosNum());
					itemChk.setCls(value.toString().substring(3,16));
					item = receiptInfoInqMapper.findItem(itemChk);
					item.setNum(Integer.parseInt(value.toString().substring(31,34)));
					item.setPrice(Integer.parseInt(value.toString().substring(23,31)));
					item.setItemDiscount(Integer.parseInt(value.toString().substring(37,44)));
					item.setTotPrice(cls.getNum()*cls.getPrice());
					item.setNetsales(item.getTotPrice()-item.getItemDiscount());
					item.setStsDiv("1");
					
					resultList.add(item);
				}
			}
			
			}	
			}
		}
	
	
		
		return resultList;

	}


}