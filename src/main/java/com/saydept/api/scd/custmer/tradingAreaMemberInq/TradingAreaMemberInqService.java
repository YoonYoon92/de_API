package com.saydept.api.scd.custmer.tradingAreaMemberInq;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.scd.custmer.tradingAreaMemberInq.model.TradingAreaMemberInqModel;
import com.saydept.api.spf.saleNews.corpSaleNews.model.CorpSaleNewsModel;

	@Service
	public class TradingAreaMemberInqService {

	@Autowired
	private TradingAreaMemberInqMapper tradingAreaMemberInqMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public TradingAreaMemberInqModel selectTradingAreaMemberInq(TradingAreaMemberInqModel request)throws Exception {

	TradingAreaMemberInqModel result = tradingAreaMemberInqMapper.selectTradingAreaMemberInq(request);
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<TradingAreaMemberInqModel> selectTradingAreaMemberInqList(TradingAreaMemberInqModel request)throws Exception {
		List<TradingAreaMemberInqModel> resultList = new ArrayList<TradingAreaMemberInqModel>();
		System.out.println(request);
		double TotCdNum =0;
		double TotPlusNum =0;
		double TotUseNum =0;
		double TotUseAmt =0;
		//상권별조회
		if(request.getSearchCd().equals("1")){
			
			if(request.getTradingAreaCd().equals("")&&request.getAreaCd().equals("")) {
				List<TradingAreaMemberInqModel> result = tradingAreaMemberInqMapper.TradingAreaList(request);
				System.out.println("result:"+result);
				if(result!=null) {
					System.out.println(result);
					for(TradingAreaMemberInqModel data: result) {
						TotCdNum=TotCdNum+data.getCdMember();
						TotPlusNum=TotPlusNum+data.getPlusMember();
						TotUseNum=TotUseNum+data.getUseMember();
						TotUseAmt=TotUseAmt+data.getMemberAmt();
					}
					System.out.println("TotCdNum"+TotCdNum);
					System.out.println("TotPlusNum"+TotPlusNum);
					System.out.println("TotUseNum"+TotUseNum);
					System.out.println("TotUseNum"+TotUseAmt);
						for(TradingAreaMemberInqModel data: result) {
							if(data.getCdMember()>0) {
								data.setCdRate((data.getCdMember()/TotCdNum)*100);
							}
							if(data.getPlusMember()>0) {
								data.setPlusRate((data.getPlusMember()/TotPlusNum)*100);
							
							}
							if(data.getUseMember()>0) {
								data.setUseRate((data.getUseMember()/TotUseNum)*100);
							}
							if(data.getMemberAmt()>0) {
								data.setMemberAmtRate((data.getMemberAmt()/TotUseAmt)*100);
								data.setMemberPrice(data.getMemberAmt()/data.getUseMember());
							}
							resultList.add(data);
							}
					}
				}
			else if(!request.getTradingAreaCd().equals("")&&request.getAreaCd().equals("")) {
				List<TradingAreaMemberInqModel> result = tradingAreaMemberInqMapper.TradingAreaList2(request);
				for(TradingAreaMemberInqModel data: result) {
					TotCdNum=TotCdNum+data.getCdMember();
					TotPlusNum=TotPlusNum+data.getPlusMember();
					TotUseNum=TotUseNum+data.getUseMember();
					TotUseAmt=TotUseAmt+data.getMemberAmt();
				}
				System.out.println("TotCdNum"+TotCdNum);
				System.out.println("TotPlusNum"+TotPlusNum);
				System.out.println("TotUseNum"+TotUseNum);
				System.out.println("TotUseNum"+TotUseAmt);
				
					for(TradingAreaMemberInqModel data: result) {
						if(data.getCdMember()>0) {
							data.setCdRate((data.getCdMember()/TotCdNum)*100);
						}
						if(data.getPlusMember()>0) {
							data.setPlusRate((data.getPlusMember()/TotPlusNum)*100);
						
						}
						if(data.getUseMember()>0) {
							data.setUseRate((data.getUseMember()/TotUseNum)*100);
						}
						if(data.getMemberAmt()>0) {
							data.setMemberAmtRate((data.getMemberAmt()/TotUseAmt)*100);
							data.setMemberPrice(data.getMemberAmt()/data.getUseMember());
						}
						resultList.add(data);
						}
				}
			else if(!request.getTradingAreaCd().equals("")&&!request.getAreaCd().equals("")) {
				List<TradingAreaMemberInqModel> result = tradingAreaMemberInqMapper.TradingAreaList3(request);
				for(TradingAreaMemberInqModel data: result) {
					TotCdNum=TotCdNum+data.getCdMember();
					TotPlusNum=TotPlusNum+data.getPlusMember();
					TotUseNum=TotUseNum+data.getUseMember();
					TotUseAmt=TotUseAmt+data.getMemberAmt();
				}
				System.out.println("TotCdNum"+TotCdNum);
				System.out.println("TotPlusNum"+TotPlusNum);
				System.out.println("TotUseNum"+TotUseNum);
				System.out.println("TotUseNum"+TotUseAmt);
					for(TradingAreaMemberInqModel data: result) {
						if(data.getCdMember()>0) {
							data.setCdRate((data.getCdMember()/TotCdNum)*100);
						}
						if(data.getPlusMember()>0) {
							data.setPlusRate((data.getPlusMember()/TotPlusNum)*100);
						
						}
						if(data.getUseMember()>0) {
							data.setUseRate((data.getUseMember()/TotUseNum)*100);
						}
						if(data.getMemberAmt()>0) {
							data.setMemberAmtRate((data.getMemberAmt()/TotUseAmt)*100);
							data.setMemberPrice(data.getMemberAmt()/data.getUseMember());
							
						}
						resultList.add(data);
						}
				}
		
		}
		else {
			List<TradingAreaMemberInqModel> result = tradingAreaMemberInqMapper.TradingAreaList4(request);
			for(TradingAreaMemberInqModel data: result) {
				TotCdNum=TotCdNum+data.getCdMember();
				TotPlusNum=TotPlusNum+data.getPlusMember();
				TotUseNum=TotUseNum+data.getUseMember();
				TotUseAmt=TotUseAmt+data.getMemberAmt();
			}
			System.out.println("TotCdNum"+TotCdNum);
			System.out.println("TotPlusNum"+TotPlusNum);
			System.out.println("TotUseNum"+TotUseNum);
			System.out.println("TotUseNum"+TotUseAmt);
			
				for(TradingAreaMemberInqModel data: result) {
					if(data.getCdMember()>0) {
						data.setCdRate((data.getCdMember()/TotCdNum)*100);
					}
					if(data.getPlusMember()>0) {
						data.setPlusRate((data.getPlusMember()/TotPlusNum)*100);
					
					}
					if(data.getUseMember()>0) {
						data.setUseRate((data.getUseMember()/TotUseNum)*100);
					}
					if(data.getMemberAmt()>0) {
						data.setMemberAmtRate((data.getMemberAmt()/TotUseAmt)*100);
						data.setMemberPrice(data.getMemberAmt()/data.getUseMember());
					}
					resultList.add(data);
					}
		}
		return resultList;

	}
	//상권구분
	public List<TradingAreaMemberInqModel> tradingAreaCdList(TradingAreaMemberInqModel request)throws Exception {

		List<TradingAreaMemberInqModel> result = tradingAreaMemberInqMapper.tradingAreaCdList(request);		

		return result;
	}
	//지역구분
	public List<TradingAreaMemberInqModel> areaCdList(TradingAreaMemberInqModel request)throws Exception {
		System.out.println(request);
		List<TradingAreaMemberInqModel> result = tradingAreaMemberInqMapper.areaCdList(request);		
		System.out.println(result);
		return result;
	}

}