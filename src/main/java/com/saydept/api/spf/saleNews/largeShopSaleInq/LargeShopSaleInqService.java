package com.saydept.api.spf.saleNews.largeShopSaleInq;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.saleNews.largeShopSaleInq.model.LargeShopSaleInqModel;

	@Service
	public class LargeShopSaleInqService {

	@Autowired
	private LargeShopSaleInqMapper largeShopSaleInqMapper;



	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<LargeShopSaleInqModel> selectLargeShopSaleInqList(LargeShopSaleInqModel request)throws Exception {
		System.out.println(request);
		List<LargeShopSaleInqModel> result = largeShopSaleInqMapper.selectLargeShopSaleInqList(request);
		return result;

	}

	


}