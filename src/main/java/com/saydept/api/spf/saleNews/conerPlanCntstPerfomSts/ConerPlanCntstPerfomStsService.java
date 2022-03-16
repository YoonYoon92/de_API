package com.saydept.api.spf.saleNews.conerPlanCntstPerfomSts;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.saleNews.conerPlanCntstPerfomSts.model.ConerPlanCntstPerfomStsModel;
import com.saydept.api.spf.saleNews.eventHallSaleInq.model.EventHallSaleInqSearchModel;
import com.saydept.utils.SayUtils;

	@Service
	public class ConerPlanCntstPerfomStsService {

	@Autowired
	private ConerPlanCntstPerfomStsMapper conerPlanCntstPerfomStsMapper;
	@Autowired
	private SayUtils sayUtils;
	
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<ConerPlanCntstPerfomStsModel> selectConerPlanCntstPerfomStsList(ConerPlanCntstPerfomStsModel request)throws Exception {
		request.setLastyearstartDt(sayUtils.getCusomYear(request.getStartDt(), -1 ));
		List<ConerPlanCntstPerfomStsModel> result = conerPlanCntstPerfomStsMapper.selectConerPlanCntstPerfomStsList(request);
		return result;

	}



	public ArrayList<ConerPlanCntstPerfomStsModel> selectConerPlanCntstPerfomStsList() {
		ArrayList<ConerPlanCntstPerfomStsModel> result = conerPlanCntstPerfomStsMapper.selectConerPlanCntstPerfomStsList1();
		return result;
	}



	public List<ConerPlanCntstPerfomStsModel> PcList(ConerPlanCntstPerfomStsModel request) {
		  	System.out.println(request);
			
			List<ConerPlanCntstPerfomStsModel> result = conerPlanCntstPerfomStsMapper.PcList(request);
			 System.out.println(request);
			
			 
			return result;
	}

	
	


	

}