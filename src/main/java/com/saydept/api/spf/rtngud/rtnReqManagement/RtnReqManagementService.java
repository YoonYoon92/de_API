package com.saydept.api.spf.rtngud.rtnReqManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.puchas.buyReqManagement.model.BuyReqManagementModel;
import com.saydept.api.spf.rtngud.rtnReqManagement.model.RtnReqManagementModel;


	@Service
	public class RtnReqManagementService {

	@Autowired
	private RtnReqManagementMapper rtnReqManagementMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public RtnReqManagementModel selectRtnReqManagement(RtnReqManagementModel request)throws Exception {

	RtnReqManagementModel result = rtnReqManagementMapper.selectRtnReqManagement(request);
	return result;

	}
	
	public RtnReqManagementModel checkPartner(RtnReqManagementModel request)throws Exception {
		System.out.println(request);
		RtnReqManagementModel result = rtnReqManagementMapper.checkPartner(request);
		return result;

		}

	public RtnReqManagementModel itemDetail(RtnReqManagementModel request)throws Exception {
		System.out.println(request);
		RtnReqManagementModel result = rtnReqManagementMapper.itemDetail(request);
		return result;

		}
	
	
	public RtnReqManagementModel itemsCdCheck(RtnReqManagementModel request)throws Exception {
		System.out.println(request);
		RtnReqManagementModel result = rtnReqManagementMapper.itemsCdCheck(request);
		return result;
	}
	public List<RtnReqManagementModel> itemList(RtnReqManagementModel request)throws Exception {

		List<RtnReqManagementModel> result = rtnReqManagementMapper.itemList(request);
		return result;

	}
	
	//전표찾기
		public RtnReqManagementModel chitSearchResult(RtnReqManagementModel request)throws Exception {
			System.out.println(request);
			RtnReqManagementModel result = rtnReqManagementMapper.chitSearchResult(request);
			System.out.println(result);
			return result;

			}
		
		public List<RtnReqManagementModel> chitSearchResultDetail(RtnReqManagementModel request)throws Exception {
			System.out.println(request);
			List<RtnReqManagementModel> result = rtnReqManagementMapper.chitSearchResultDetail(request);
			return result;

			}
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<RtnReqManagementModel> selectRtnReqManagementList(RtnReqManagementModel request)throws Exception {

		List<RtnReqManagementModel> result = rtnReqManagementMapper.selectRtnReqManagementList(request);
		return result;

	}
	public List<RtnReqManagementModel> chitYearList(RtnReqManagementModel request)throws Exception {

		List<RtnReqManagementModel> result = rtnReqManagementMapper.chitYearList(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateRtnReqManagement(List<RtnReqManagementModel> request)throws Exception {
		int sumPrice=0;
		int sumCost=0;
		int count=0;
		int result=0;
		int checkNum=0;
		String chitYear="";
		String chitId="";
		RtnReqManagementModel updateSpfc01pf = new RtnReqManagementModel();
		
		for( RtnReqManagementModel model :  request) {
			System.out.println(model);
			
			count=count+1;

			if(count==1) {
			
				result = rtnReqManagementMapper.deleteRtnReqManagement(model);
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
				result += rtnReqManagementMapper.insertSpfc02pf(model);
			}
		}
		
		System.out.println("sumPrice:"+sumPrice);
		System.out.println("sumCost:"+sumCost);
		updateSpfc01pf.setChitNum(checkNum);
		updateSpfc01pf.setChitYear(chitYear);
		updateSpfc01pf.setTotCost(sumCost);
		updateSpfc01pf.setTotPrice(sumPrice);
		result += rtnReqManagementMapper.updateSpfc01pf(updateSpfc01pf);
		
		
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int insertRtnReqManagement(RtnReqManagementModel request) {
		int result =0;
//		System.out.println(request);
//		
//		try {
//			result += rtnReqManagementMapper.updateChitNum(request);
//			if (result==0) {
//							throw new Exception();
//							}
//			}
//		
//		catch (Exception e )
//			{
//			System.out.println("--------------------------------------------");
//			result += rtnReqManagementMapper.insertChitNum(request);			
//			}
//		RtnReqManagementModel check =rtnReqManagementMapper.checkChitNum(request);
//		System.out.println(check.getChitNum());
//		request.setChitNum(check.getChitNum());
		return result;
	}
	//저장
	public int insertRtnReqManagement2(List<RtnReqManagementModel> request) {
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
		for( RtnReqManagementModel model :  request) {
			count=count+1;
			model.setWriteTime(time1);
			model.setWriteTime2(time2);
//			System.out.println(count);
//			System.out.println("request:"+request);
			if(count==1) {
				System.out.println("title:"+model);
				try {
					result += rtnReqManagementMapper.updateChitNum(model);
					if (result==0) {
									throw new Exception();
									}
					}
				
				catch (Exception e )
					{
					System.out.println("--------------------------------------------");
					result += rtnReqManagementMapper.insertChitNum(model);			
					}
				RtnReqManagementModel check =rtnReqManagementMapper.checkChitNum(model);
				
				
				System.out.println(check.getChitNum());
				checkNum=check.getChitNum();
				chitYear=model.getChitYear();
				chitId=model.getUserId();
				model.setChitNum(checkNum);
				result += rtnReqManagementMapper.insertSpfc01pf(model);
				
			}
			else {
				model.setChitNum(checkNum);
				model.setChitYear(chitYear);
				model.setChitCount(count-1);
				model.setUserId(chitId);
				System.out.println("model:"+model);
				result += rtnReqManagementMapper.insertSpfc02pf(model);
			}
				
		}
//		int result = rtnReqManagementMapper.insertRtnReqManagement(request);
		return result;

	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	public int saveRtnReqManagement(RtnReqManagementModel request) {

		int result = rtnReqManagementMapper.saveRtnReqManagement(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteRtnReqManagement(RtnReqManagementModel request) {

		int result = rtnReqManagementMapper.deleteSpfc01pf(request);
		return result;

	}

}