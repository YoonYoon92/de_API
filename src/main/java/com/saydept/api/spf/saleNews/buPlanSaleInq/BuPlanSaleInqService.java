package com.saydept.api.spf.saleNews.buPlanSaleInq;

import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.saleNews.buPlanSaleInq.model.BuPlanSaleInqModel;
import com.saydept.api.spf.saleNews.buPlanSaleInq.model.BuPlanSaleInqParamModel;
import com.saydept.utils.SayUtils;

	@Service
	public class BuPlanSaleInqService {

	@Autowired
	private BuPlanSaleInqMapper buPlanSaleInqMapper;

	@Autowired
	private SayUtils sayUtils;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public  List<BuPlanSaleInqModel> selectBuPlanSaleInqList(BuPlanSaleInqParamModel request)throws ParseException {
		request.setLastyearstartDt(sayUtils.getCusomYear(request.getStartDt(), -1 ));
		request.setLastyearendDt(sayUtils.getCusomYear(request.getEndDt(), -1 ));
		
		List<BuPlanSaleInqModel> result = buPlanSaleInqMapper.selectBuPlanSaleInqList(request);
		return result;

	}


}