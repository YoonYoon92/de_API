package com.saydept.api.spf.puchas.buyReqManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.puchas.buyReqManagement.model.BuyReqManagementModel;


	@Service
	public class BuyReqManagementService {

	@Autowired
	private BuyReqManagementMapper buyReqManagementMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public BuyReqManagementModel selectBuyReqManagement(BuyReqManagementModel request)throws Exception {

	BuyReqManagementModel result = buyReqManagementMapper.selectBuyReqManagement(request);
	return result;

	}
	
	public BuyReqManagementModel checkPartner(BuyReqManagementModel request)throws Exception {
		System.out.println(request);
		BuyReqManagementModel result = buyReqManagementMapper.checkPartner(request);
		return result;

		}

	public BuyReqManagementModel itemDetail(BuyReqManagementModel request)throws Exception {
		System.out.println(request);
		BuyReqManagementModel result = buyReqManagementMapper.itemDetail(request);
		return result;

		}
	
	
	public BuyReqManagementModel itemsCdCheck(BuyReqManagementModel request)throws Exception {
		System.out.println(request);
		BuyReqManagementModel result = buyReqManagementMapper.itemsCdCheck(request);
		return result;
	}
	
	//전표찾기
	public BuyReqManagementModel chitSearchResult(BuyReqManagementModel request)throws Exception {
		System.out.println(request);
		BuyReqManagementModel result = buyReqManagementMapper.chitSearchResult(request);
		System.out.println(result);
		return result;

		}
	
	public List<BuyReqManagementModel> chitSearchResultDetail(BuyReqManagementModel request)throws Exception {
		System.out.println(request);
		List<BuyReqManagementModel> result = buyReqManagementMapper.chitSearchResultDetail(request);
		return result;

		}
	public List<BuyReqManagementModel> itemList(BuyReqManagementModel request)throws Exception {

		List<BuyReqManagementModel> result = buyReqManagementMapper.itemList(request);
		return result;

	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<BuyReqManagementModel> selectBuyReqManagementList(BuyReqManagementModel request)throws Exception {

		List<BuyReqManagementModel> result = buyReqManagementMapper.selectBuyReqManagementList(request);
		return result;

	}
	public List<BuyReqManagementModel> chitYearList(BuyReqManagementModel request)throws Exception {

		List<BuyReqManagementModel> result = buyReqManagementMapper.chitYearList(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateBuyReqManagement(List<BuyReqManagementModel> request)throws Exception {
		int sumPrice=0;
		int sumCost=0;
		int count=0;
		int result=0;
		int checkNum=0;
		String chitYear="";
		String chitId="";
		BuyReqManagementModel updateSpfo01pf = new BuyReqManagementModel();
		
		for( BuyReqManagementModel model :  request) {
			System.out.println(model);
			
			count=count+1;

			if(count==1) {
			
				result = buyReqManagementMapper.deleteBuyReqManagement(model);
				checkNum=model.getChitNum();
				chitYear=model.getChitYear();
				chitId=model.getUserId();
			}
			else {
				sumPrice=sumPrice+model.getTotPrice();
				sumCost=sumCost+model.getTotCost();
				model.setChitNum(checkNum);
				model.setChitYear(chitYear);
				model.setChitCount(count-1);
				model.setUserId(chitId);
				System.out.println("model:"+model);
				result += buyReqManagementMapper.insertSpfo02pf(model);
			}
		}
		
		System.out.println("sumPrice:"+sumPrice);
		System.out.println("sumCost:"+sumCost);
		updateSpfo01pf.setChitNum(checkNum);
		updateSpfo01pf.setChitYear(chitYear);
		updateSpfo01pf.setTotCost(sumCost);
		updateSpfo01pf.setTotPrice(sumPrice);
		result += buyReqManagementMapper.updateSpfo01pf(updateSpfo01pf);
		
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int insertBuyReqManagement(BuyReqManagementModel request) {
		int result =0;
//		System.out.println(request);
//		
//		try {
//			result += buyReqManagementMapper.updateChitNum(request);
//			if (result==0) {
//							throw new Exception();
//							}
//			}
//		
//		catch (Exception e )
//			{
//			System.out.println("--------------------------------------------");
//			result += buyReqManagementMapper.insertChitNum(request);			
//			}
//		BuyReqManagementModel check =buyReqManagementMapper.checkChitNum(request);
//		System.out.println(check.getChitNum());
//		request.setChitNum(check.getChitNum());
		return result;
	}
	//저장
	public int insertBuyReqManagement2(List<BuyReqManagementModel> request) {
		int result =0;
		int count=0;
		int checkNum=0;
		String chitYear="";
		String chitId="";
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMdd");
		SimpleDateFormat format2 = new SimpleDateFormat ( "HHmmss");
		Date time = new Date();
		String time1 = format1.format(time);
		String time2 = format2.format(time);
		for( BuyReqManagementModel model :  request) {
			count=count+1;
			model.setWriteTime(time1);
//			System.out.println(count);
//			System.out.println("request:"+request);
			if(count==1) {
				System.out.println("title:"+model);
				try {
					result += buyReqManagementMapper.updateChitNum(model);
					if (result==0) {
									throw new Exception();
									}
					}
				
				catch (Exception e )
					{
					System.out.println("--------------------------------------------");
					result += buyReqManagementMapper.insertChitNum(model);			
					}
				BuyReqManagementModel check =buyReqManagementMapper.checkChitNum(model);
				
				
				System.out.println(check.getChitNum());
				checkNum=check.getChitNum();
				chitYear=model.getChitYear();
				chitId=model.getUserId();
				model.setChitNum(checkNum);
				result += buyReqManagementMapper.insertSpfo01pf(model);
				
			}
			else {
				model.setChitNum(checkNum);
				model.setChitYear(chitYear);
				model.setChitCount(count-1);
				model.setUserId(chitId);
				System.out.println("model:"+model);
				result += buyReqManagementMapper.insertSpfo02pf(model);
			}
				
		}
//		int result = buyReqManagementMapper.insertBuyReqManagement(request);
		return result;

	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	public int saveBuyReqManagement(BuyReqManagementModel request) {

		int result = buyReqManagementMapper.saveBuyReqManagement(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteBuyReqManagement(BuyReqManagementModel request) {
		System.out.println(request);
		int result=0;
		String chitYear="";
		String chitId="";
		BuyReqManagementModel updateSpfo01pf = new BuyReqManagementModel();
		result = buyReqManagementMapper.deleteBuyReqManagement(request);
		updateSpfo01pf.setChitNum(request.getChitNum());
		updateSpfo01pf.setChitYear(request.getChitYear());
		updateSpfo01pf.setTotCost(0);
		updateSpfo01pf.setTotPrice(0);
		result += buyReqManagementMapper.updateSpfo01pf(updateSpfo01pf);
		return result;

	}

}