package com.saydept.api.spf.goods.discountClsManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.goods.discountClsManagement.model.DiscountClsManagementModel;

	@Service
	public class DiscountClsManagementService {

	@Autowired
	private DiscountClsManagementMapper discountClsManagementMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public DiscountClsManagementModel selectDiscountClsManagement(DiscountClsManagementModel request)throws Exception {

	DiscountClsManagementModel result = discountClsManagementMapper.selectDiscountClsManagement(request);
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<DiscountClsManagementModel> selectDiscountClsManagementList(DiscountClsManagementModel request)throws Exception {

		List<DiscountClsManagementModel> result = discountClsManagementMapper.selectDiscountClsManagementList(request);
		System.out.println(result);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateDiscountClsManagement(DiscountClsManagementModel request)throws Exception {

		int result = discountClsManagementMapper.updateDiscountClsManagement(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int insertDiscountClsManagement(DiscountClsManagementModel request) {

		int result=0;
		try {
			result = discountClsManagementMapper.insertDiscountClsManagement(request);
			if (result==0) {
							throw new Exception();
							}
			}
		
		catch (Exception e )
			{
			System.out.println("--------------------------------------------");
			result += 0;			
			}
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int saveDiscountClsManagement(DiscountClsManagementModel request) {
		int result = 0;
		
		

		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteDiscountClsManagement(DiscountClsManagementModel request) {

	
		int result=0;
		try {
			result =discountClsManagementMapper.deleteDiscountClsManagement(request);
			if (result==0) {
							throw new Exception();
							}
			}
		
		catch (Exception e )
			{
			System.out.println("--------------------------------------------");
			result += 0;			
			}
		return result;
	

	}

}