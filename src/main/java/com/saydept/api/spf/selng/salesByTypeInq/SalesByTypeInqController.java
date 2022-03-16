package com.saydept.api.spf.selng.salesByTypeInq;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.selng.salesByTypeInq.model.SalesByTypeInqDetailGridModel;
import com.saydept.api.spf.selng.salesByTypeInq.model.SalesByTypeInqDetailModel;
import com.saydept.api.spf.selng.salesByTypeInq.model.SalesByTypeInqModel;
import com.saydept.api.spf.selng.salesByTypeInq.model.SalesByTypeInqParamModel;

@CrossOrigin(origins = "*")
@RestController
public class SalesByTypeInqController {

	@Autowired
	private SalesByTypeInqService SalesByTypeInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/spf/selng/selectSalesByTypeInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectSalesByTypeInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/spf/selng/selectSalesByTypeInqList", method = RequestMethod.POST)
	public List<SalesByTypeInqModel> selectSalesByTypeInqList(@RequestBody SalesByTypeInqParamModel request)throws Exception {
        
		ArrayList<SalesByTypeInqModel> result = new ArrayList<SalesByTypeInqModel>();
		SalesByTypeInqModel salesByTypeInqSumModel = new SalesByTypeInqModel();
		SalesByTypeInqModel salesByTypeInqCompositionRatioModel = new SalesByTypeInqModel();
		
		List<SalesByTypeInqModel> salesByTypeInqModel = SalesByTypeInqService.selectSalesByTypeInqList(request);
		for (SalesByTypeInqModel saleRecord: salesByTypeInqModel) {
			
			//합계 생성
			salesByTypeInqSumModel.setOrgName("합계");
			salesByTypeInqSumModel.setCash(salesByTypeInqSumModel.getCash() + saleRecord.getCash());
			salesByTypeInqSumModel.setCard(salesByTypeInqSumModel.getCard() + saleRecord.getCard());
			salesByTypeInqSumModel.setNorCrdt(salesByTypeInqSumModel.getNorCrdt() + saleRecord.getNorCrdt());
			salesByTypeInqSumModel.setGift(salesByTypeInqSumModel.getGift() + saleRecord.getGift());
			salesByTypeInqSumModel.setCod(salesByTypeInqSumModel.getCod() + saleRecord.getCod());
			salesByTypeInqSumModel.setEtc(salesByTypeInqSumModel.getEtc() + saleRecord.getEtc());
			salesByTypeInqSumModel.setNormal(salesByTypeInqSumModel.getNormal() + saleRecord.getNormal());
			salesByTypeInqSumModel.setEvent(salesByTypeInqSumModel.getEvent() + saleRecord.getEvent());
			salesByTypeInqSumModel.setUniform(salesByTypeInqSumModel.getUniform() + saleRecord.getUniform());
			salesByTypeInqSumModel.setNetAmount(salesByTypeInqSumModel.getNetAmount() + saleRecord.getNetAmount());
			salesByTypeInqSumModel.setSaleAmount(salesByTypeInqSumModel.getSaleAmount() + saleRecord.getSaleAmount());
			salesByTypeInqSumModel.setTotalAmount(salesByTypeInqSumModel.getTotalAmount() + saleRecord.getTotalAmount());
			salesByTypeInqSumModel.setCustomCnt(salesByTypeInqSumModel.getCustomCnt() + saleRecord.getCustomCnt());			
		}
		
		//구성비 생성
		salesByTypeInqCompositionRatioModel.setOrgName("구성비");
		salesByTypeInqCompositionRatioModel.setCash(salesByTypeInqSumModel.getCash() / salesByTypeInqSumModel.getNetAmount()*100);
		salesByTypeInqCompositionRatioModel.setCard(salesByTypeInqSumModel.getCard() / salesByTypeInqSumModel.getNetAmount()*100);
		salesByTypeInqCompositionRatioModel.setNorCrdt(salesByTypeInqSumModel.getNorCrdt() / salesByTypeInqSumModel.getNetAmount()*100);
		salesByTypeInqCompositionRatioModel.setGift(salesByTypeInqSumModel.getGift() / salesByTypeInqSumModel.getNetAmount()*100);
		salesByTypeInqCompositionRatioModel.setCod(salesByTypeInqSumModel.getCod() / salesByTypeInqSumModel.getNetAmount()*100);
		salesByTypeInqCompositionRatioModel.setEtc(salesByTypeInqSumModel.getEtc() / salesByTypeInqSumModel.getNetAmount()*100);
		salesByTypeInqCompositionRatioModel.setNormal(salesByTypeInqSumModel.getNormal() / salesByTypeInqSumModel.getNetAmount()*100);
		salesByTypeInqCompositionRatioModel.setEvent(salesByTypeInqSumModel.getEvent() / salesByTypeInqSumModel.getNetAmount()*100);
		salesByTypeInqCompositionRatioModel.setUniform(salesByTypeInqSumModel.getUniform() / salesByTypeInqSumModel.getNetAmount()*100);
		salesByTypeInqCompositionRatioModel.setNetAmount(salesByTypeInqSumModel.getNetAmount() / salesByTypeInqSumModel.getTotalAmount()*100);
		salesByTypeInqCompositionRatioModel.setSaleAmount(salesByTypeInqSumModel.getSaleAmount() / salesByTypeInqSumModel.getTotalAmount()*100);
		salesByTypeInqCompositionRatioModel.setTotalAmount(salesByTypeInqSumModel.getTotalAmount() / salesByTypeInqSumModel.getTotalAmount()*100);
		
		result.addAll(salesByTypeInqModel);
		result.add(salesByTypeInqSumModel);
		result.add(salesByTypeInqCompositionRatioModel);
		
		System.out.println(result);
		
		return result;
	}
	
	
	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectSalesByTypeInqDetail
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/spf/selng/selectSalesByTypeInqDetail", method = RequestMethod.POST)
	public List<SalesByTypeInqDetailGridModel> selectSalesByTypeInqDetail(@RequestBody SalesByTypeInqParamModel request)throws Exception {
		
		List<SalesByTypeInqDetailGridModel> result = new ArrayList<SalesByTypeInqDetailGridModel>();
		SalesByTypeInqDetailGridModel salesByTypeInqDetailGridModel = new SalesByTypeInqDetailGridModel();
		System.out.println(request.getDetailInqOrgCd());
		
		request.setKey(null);
		request.setCorner(null);
		request.setPc(null);
		request.setTim(null);
		request.setBu(null);
		request.setJum(null);
		
		if(request.getDetailInqOrgCd().length() > 13) {
			request.setKey(request.getDetailInqOrgCd().substring(13, 15));
		}
		if(request.getDetailInqOrgCd().length() > 8) {
			request.setCorner(request.getDetailInqOrgCd().substring(8, 13));
		} 
		if(request.getDetailInqOrgCd().length() > 6) {
			request.setPc(request.getDetailInqOrgCd().substring(6, 8));
		}
		if(request.getDetailInqOrgCd().length() > 4) {
			request.setTim(request.getDetailInqOrgCd().substring(4, 6));
		} 
		if(request.getDetailInqOrgCd().length() > 2) {
			request.setBu(request.getDetailInqOrgCd().substring(2, 4));
		} 
		request.setJum(request.getDetailInqOrgCd().substring(0, 2));
		
		System.out.println(request.getJum() + " " + request.getBu() + " " + request.getTim() + " " + request.getPc() + " " + request.getCorner() + " " + request.getKey());
		
		SalesByTypeInqDetailModel salesByTypeInqDetailModel = SalesByTypeInqService.selectSalesByTypeInqDetail(request);
		
		if(salesByTypeInqDetailModel != null) {
			System.out.println(salesByTypeInqDetailModel);
			
			salesByTypeInqDetailGridModel.setSortation("현금");
			salesByTypeInqDetailGridModel.setDetailNormal(salesByTypeInqDetailModel.getCash01());
			salesByTypeInqDetailGridModel.setDetailEvent(salesByTypeInqDetailModel.getCash02());
			salesByTypeInqDetailGridModel.setDetailUniform(salesByTypeInqDetailModel.getCash03());
			salesByTypeInqDetailGridModel.setDetailTotal(salesByTypeInqDetailModel.getCash());
			result.add(salesByTypeInqDetailGridModel);
			
			salesByTypeInqDetailGridModel = new SalesByTypeInqDetailGridModel();
			salesByTypeInqDetailGridModel.setSortation("카드");
			salesByTypeInqDetailGridModel.setDetailNormal(salesByTypeInqDetailModel.getCard01());
			salesByTypeInqDetailGridModel.setDetailEvent(salesByTypeInqDetailModel.getCard02());
			salesByTypeInqDetailGridModel.setDetailUniform(salesByTypeInqDetailModel.getCard03());
			salesByTypeInqDetailGridModel.setDetailTotal(salesByTypeInqDetailModel.getCard());
			result.add(salesByTypeInqDetailGridModel);
			
			salesByTypeInqDetailGridModel = new SalesByTypeInqDetailGridModel();
			salesByTypeInqDetailGridModel.setSortation("일반외상");
			salesByTypeInqDetailGridModel.setDetailNormal(salesByTypeInqDetailModel.getNorCrdt01());
			salesByTypeInqDetailGridModel.setDetailEvent(salesByTypeInqDetailModel.getNorCrdt02());
			salesByTypeInqDetailGridModel.setDetailUniform(salesByTypeInqDetailModel.getNorCrdt03());
			salesByTypeInqDetailGridModel.setDetailTotal(salesByTypeInqDetailModel.getNorCrdt());
			result.add(salesByTypeInqDetailGridModel);
		  
			salesByTypeInqDetailGridModel = new SalesByTypeInqDetailGridModel();
			salesByTypeInqDetailGridModel.setSortation("상품권");
			salesByTypeInqDetailGridModel.setDetailNormal(salesByTypeInqDetailModel.getGift01());
			salesByTypeInqDetailGridModel.setDetailEvent(salesByTypeInqDetailModel.getGift02());
			salesByTypeInqDetailGridModel.setDetailUniform(salesByTypeInqDetailModel.getGift03());
			salesByTypeInqDetailGridModel.setDetailTotal(salesByTypeInqDetailModel.getGift());
			result.add(salesByTypeInqDetailGridModel);
			
			salesByTypeInqDetailGridModel = new SalesByTypeInqDetailGridModel();
			salesByTypeInqDetailGridModel.setSortation("C.O.D");
			salesByTypeInqDetailGridModel.setDetailNormal(salesByTypeInqDetailModel.getCod01());
			salesByTypeInqDetailGridModel.setDetailEvent(salesByTypeInqDetailModel.getCod02());
			salesByTypeInqDetailGridModel.setDetailUniform(salesByTypeInqDetailModel.getCod03());
			salesByTypeInqDetailGridModel.setDetailTotal(salesByTypeInqDetailModel.getCod());
			result.add(salesByTypeInqDetailGridModel);
			
			salesByTypeInqDetailGridModel = new SalesByTypeInqDetailGridModel();
			salesByTypeInqDetailGridModel.setSortation("기타");
			salesByTypeInqDetailGridModel.setDetailNormal(salesByTypeInqDetailModel.getEtc01());
			salesByTypeInqDetailGridModel.setDetailEvent(salesByTypeInqDetailModel.getEtc02());
			salesByTypeInqDetailGridModel.setDetailUniform(salesByTypeInqDetailModel.getEtc03());
			salesByTypeInqDetailGridModel.setDetailTotal(salesByTypeInqDetailModel.getEtc());
			result.add(salesByTypeInqDetailGridModel);
			
			salesByTypeInqDetailGridModel = new SalesByTypeInqDetailGridModel();
			salesByTypeInqDetailGridModel.setSortation("순매출액");
			salesByTypeInqDetailGridModel.setDetailNormal(salesByTypeInqDetailModel.getNetAmount01());
			salesByTypeInqDetailGridModel.setDetailEvent(salesByTypeInqDetailModel.getNetAmount02());
			salesByTypeInqDetailGridModel.setDetailUniform(salesByTypeInqDetailModel.getNetAmount03());
			salesByTypeInqDetailGridModel.setDetailTotal(salesByTypeInqDetailModel.getNetAmount());
			result.add(salesByTypeInqDetailGridModel);
			
			salesByTypeInqDetailGridModel = new SalesByTypeInqDetailGridModel();
			salesByTypeInqDetailGridModel.setSortation("할인");
			salesByTypeInqDetailGridModel.setDetailNormal(salesByTypeInqDetailModel.getSaleAmount01());
			salesByTypeInqDetailGridModel.setDetailEvent(salesByTypeInqDetailModel.getSaleAmount02());
			salesByTypeInqDetailGridModel.setDetailUniform(salesByTypeInqDetailModel.getSaleAmount03());
			salesByTypeInqDetailGridModel.setDetailTotal(salesByTypeInqDetailModel.getSaleAmount());
			result.add(salesByTypeInqDetailGridModel);
			
			salesByTypeInqDetailGridModel = new SalesByTypeInqDetailGridModel();
			salesByTypeInqDetailGridModel.setSortation("총매출액");
			salesByTypeInqDetailGridModel.setDetailNormal(salesByTypeInqDetailModel.getTotalAmount01());
			salesByTypeInqDetailGridModel.setDetailEvent(salesByTypeInqDetailModel.getTotalAmount02());
			salesByTypeInqDetailGridModel.setDetailUniform(salesByTypeInqDetailModel.getTotalAmount03());
			salesByTypeInqDetailGridModel.setDetailTotal(salesByTypeInqDetailModel.getTotalAmount());
			result.add(salesByTypeInqDetailGridModel);
			
			salesByTypeInqDetailGridModel = new SalesByTypeInqDetailGridModel();
			salesByTypeInqDetailGridModel.setSortation("고객수");
			salesByTypeInqDetailGridModel.setDetailNormal(salesByTypeInqDetailModel.getCustomCnt01());
			salesByTypeInqDetailGridModel.setDetailEvent(salesByTypeInqDetailModel.getCustomCnt02());
			salesByTypeInqDetailGridModel.setDetailUniform(salesByTypeInqDetailModel.getCustomCnt03());
			salesByTypeInqDetailGridModel.setDetailTotal(salesByTypeInqDetailModel.getCustomCnt());
			result.add(salesByTypeInqDetailGridModel);
		}
		System.out.println(result);
		return result;
	}

}