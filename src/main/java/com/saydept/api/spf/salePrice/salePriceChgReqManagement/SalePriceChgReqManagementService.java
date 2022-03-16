package com.saydept.api.spf.salePrice.salePriceChgReqManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.rtngud.rtnReqManagement.model.RtnReqManagementModel;
import com.saydept.api.spf.salePrice.salePriceChgReqManagement.model.SalePriceChgReqManagementModel;

	@Service
	public class SalePriceChgReqManagementService {

	@Autowired
	private SalePriceChgReqManagementMapper salePriceChgReqManagementMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public SalePriceChgReqManagementModel selectSalePriceChgReqManagement(SalePriceChgReqManagementModel request)throws Exception {

	SalePriceChgReqManagementModel result = salePriceChgReqManagementMapper.selectSalePriceChgReqManagement(request);
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<SalePriceChgReqManagementModel> selectSalePriceChgReqManagementList(SalePriceChgReqManagementModel request)throws Exception {

		List<SalePriceChgReqManagementModel> result = salePriceChgReqManagementMapper.selectSalePriceChgReqManagementList(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateSalePriceChgReqManagement(List<SalePriceChgReqManagementModel> request)throws Exception {
		int sumPrice=0;
		int sumCost=0;
		int count=0;
		int result=0;
		int checkNum=0;
		String chitYear="";
		String chitId="";
		SalePriceChgReqManagementModel updateSpfp01pf = new SalePriceChgReqManagementModel();
		
		for( SalePriceChgReqManagementModel model :  request) {
			System.out.println(model);
			
			count=count+1;

			if(count==1) {
			
				result = salePriceChgReqManagementMapper.deleteSalePriceChgReqManagement(model);
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
				result += salePriceChgReqManagementMapper.insertSpfp02pf(model);
			}
		}
		
		System.out.println("sumPrice:"+sumPrice);
		System.out.println("sumCost:"+sumCost);
		updateSpfp01pf.setChitNum(checkNum);
		updateSpfp01pf.setChitYear(chitYear);
		updateSpfp01pf.setTotCost(sumCost);
		updateSpfp01pf.setTotPrice(sumPrice);
		result += salePriceChgReqManagementMapper.updateSpfp01pf(updateSpfp01pf);
		
		
	
		
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int insertSalePriceChgReqManagement(List<SalePriceChgReqManagementModel> request) {
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
		System.out.println(request);
		for( SalePriceChgReqManagementModel model :  request) {
			count=count+1;
			model.setWriteTime(time1);
			model.setWriteTime2(time2);
//			System.out.println(count);
			System.out.println("request:"+request);
			if(count==1) {
				System.out.println("title:"+model);
				try {
					result += salePriceChgReqManagementMapper.updateChitNum(model);
					if (result==0) {
									throw new Exception();
									}
					}
				
				catch (Exception e )
					{
					System.out.println("--------------------------------------------");
					result += salePriceChgReqManagementMapper.insertChitNum(model);			
					}
				SalePriceChgReqManagementModel check =salePriceChgReqManagementMapper.checkChitNum(model);
				
				
				System.out.println(check.getChitNum());
				checkNum=check.getChitNum();
				chitYear=model.getChitYear();
				chitId=model.getUserId();
				model.setChitNum(checkNum);
				result += salePriceChgReqManagementMapper.insertSpfp01pf(model);
				
			}
			else {
				model.setChitNum(checkNum);
				model.setChitYear(chitYear);
				model.setChitCount(count-1);
				model.setUserId(chitId);
				System.out.println("model:"+model);
				result += salePriceChgReqManagementMapper.insertSpfp02pf(model);
			}
				
		}
//		int result = salePriceChgReqManagementMapper.insertSalePriceChgReqManagement(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int saveSalePriceChgReqManagement(SalePriceChgReqManagementModel request) {

		int result = salePriceChgReqManagementMapper.saveSalePriceChgReqManagement(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteSalePriceChgReqManagement(SalePriceChgReqManagementModel request) {

		int result = salePriceChgReqManagementMapper.deleteSpfc01pf(request);
		return result;

	}

	
	public SalePriceChgReqManagementModel checkPartner(SalePriceChgReqManagementModel request)throws Exception {
		System.out.println(request);
		SalePriceChgReqManagementModel result = salePriceChgReqManagementMapper.checkPartner(request);
		return result;
		}
	
	public List<SalePriceChgReqManagementModel> itemList(SalePriceChgReqManagementModel request)throws Exception {

		List<SalePriceChgReqManagementModel> result = salePriceChgReqManagementMapper.itemList(request);
		return result;

	}
	
	public SalePriceChgReqManagementModel itemDetail(SalePriceChgReqManagementModel request)throws Exception {
		System.out.println(request);
		SalePriceChgReqManagementModel result = salePriceChgReqManagementMapper.itemDetail(request);
		return result;
		}
	
	public SalePriceChgReqManagementModel itemsCdCheck(SalePriceChgReqManagementModel request)throws Exception {
		System.out.println(request);
		SalePriceChgReqManagementModel result = salePriceChgReqManagementMapper.itemsCdCheck(request);
		return result;
	}
	
	//전표찾기
			public SalePriceChgReqManagementModel chitSearchResult(SalePriceChgReqManagementModel request)throws Exception {
				System.out.println(request);
				SalePriceChgReqManagementModel result = salePriceChgReqManagementMapper.chitSearchResult(request);
				System.out.println(result);
				return result;

				}
			
			public List<SalePriceChgReqManagementModel> chitSearchResultDetail(SalePriceChgReqManagementModel request)throws Exception {
				System.out.println(request);
				List<SalePriceChgReqManagementModel> result = salePriceChgReqManagementMapper.chitSearchResultDetail(request);
				return result;

				}
}