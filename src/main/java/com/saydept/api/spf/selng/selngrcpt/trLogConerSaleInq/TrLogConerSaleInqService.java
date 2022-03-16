package com.saydept.api.spf.selng.selngrcpt.trLogConerSaleInq;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.rcptNoDanPumInq.model.RcptNoDanPumInqModel;
import com.saydept.api.spf.selng.selngrcpt.trLogConerSaleInq.model.TrLogConerSaleInqModel;
import com.saydept.api.spf.selng.selngrcpt.trLogConerSaleInq.model.TrLogConerSaleInqParamModel;

	@Service
	public class TrLogConerSaleInqService {

	@Autowired
	private TrLogConerSaleInqMapper trLogConerSaleInqMapper;


	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<TrLogConerSaleInqModel> selectTrLogConerSaleInqList(TrLogConerSaleInqParamModel request)throws Exception {
		
		List<TrLogConerSaleInqModel> result = new ArrayList<TrLogConerSaleInqModel>();
		if (request.getEndDt()!="") {
		if (request.getConer()==null) {
			request.setConer("");
		}
		System.out.println(request);
		if(request.getPrePayCheck().equals("N")) {
			result = trLogConerSaleInqMapper.selectTrLogConerSaleInqList(request);	
			System.out.println(result);
			System.out.println("일반결제");
			}
		
		else if(request.getPrePayCheck().equals("Y")) {
			result = trLogConerSaleInqMapper.selectTrLogConerSaleInqList73(request);
			System.out.println(result);
			System.out.println("선수금");
			}
		else if(request.getPrePayCheck().equals("C")) {
			result = trLogConerSaleInqMapper.selectTrLogConerSaleInqListCredit(request);
			System.out.println(result);
			System.out.println("일반외상");
			}
		}
		else
		{
			if(request.getPrePayCheck().equals("N")) {
				result = trLogConerSaleInqMapper.noEndDtselectTrLogConerSaleInqList(request);	
				System.out.println(result);
				System.out.println("종료일없는일반결제");
			}
			
			else if(request.getPrePayCheck().equals("Y")) {
				result = trLogConerSaleInqMapper.noEndDtselectTrLogConerSaleInqList73(request);
				System.out.println(result);
				System.out.println("종료일없는선수금");
			}
			else if(request.getPrePayCheck().equals("C")) {
				result = trLogConerSaleInqMapper.noEndDtselectTrLogConerSaleInqListCredit(request);
				System.out.println(result);
				System.out.println("종료일없는일반외상");
			}	
		}
		return result ;

		}		
		
	}
