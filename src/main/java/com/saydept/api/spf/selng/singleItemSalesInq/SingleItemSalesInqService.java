package com.saydept.api.spf.selng.singleItemSalesInq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.selng.singleItemSalesInq.model.SingleItemSalesInqModel;
import com.saydept.api.spf.selng.singleItemSalesInq.model.SingleItemSalesInqParamModel;

	@Service
	public class SingleItemSalesInqService {

	@Autowired
	private SingleItemSalesInqMapper SingleItemSaleInqMapper;
	

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<SingleItemSalesInqModel> selectSingleItemSalesInqList(SingleItemSalesInqParamModel request)throws Exception {

		List<SingleItemSalesInqModel> result = SingleItemSaleInqMapper.selectSingleItemSalesInqList(request);
		return result;

	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<SingleItemSalesInqParamModel> selectStoreComboLargeCatList()throws Exception {

		List<SingleItemSalesInqParamModel> result = SingleItemSaleInqMapper.selectStoreComboLargeCatList();
		return result;

	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<SingleItemSalesInqParamModel> selectStoreComboMidiumCatList(SingleItemSalesInqParamModel request)throws Exception {

		List<SingleItemSalesInqParamModel> result = SingleItemSaleInqMapper.selectStoreComboMidiumCatList(request);
		return result;

	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<SingleItemSalesInqParamModel> selectStoreComboSmallCatList(SingleItemSalesInqParamModel request)throws Exception {

		List<SingleItemSalesInqParamModel> result = SingleItemSaleInqMapper.selectStoreComboSmallCatList(request);
		return result;

	}


}