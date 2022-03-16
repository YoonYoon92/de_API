package com.saydept.api.spf.saleNews.closeBefZoneSale;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.saleNews.closeBefZoneSale.model.CloseBefZoneSaleModel;

	@Service
	public class CloseBefZoneSaleService {

	@Autowired
	private CloseBefZoneSaleMapper closeBefZoneSaleMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public CloseBefZoneSaleModel selectCloseBefZoneSale(CloseBefZoneSaleModel request)throws Exception {

	CloseBefZoneSaleModel result = closeBefZoneSaleMapper.selectCloseBefZoneSale(request);
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<CloseBefZoneSaleModel> selectCloseBefZoneSaleList(CloseBefZoneSaleModel request)throws Exception {

		List<CloseBefZoneSaleModel> result = closeBefZoneSaleMapper.selectCloseBefZoneSaleList(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateCloseBefZoneSale(CloseBefZoneSaleModel request)throws Exception {

		int result = closeBefZoneSaleMapper.updateCloseBefZoneSale(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int insertCloseBefZoneSale(CloseBefZoneSaleModel request) {

		int result = closeBefZoneSaleMapper.insertCloseBefZoneSale(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int saveCloseBefZoneSale(CloseBefZoneSaleModel request) {

		int result = closeBefZoneSaleMapper.saveCloseBefZoneSale(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteCloseBefZoneSale(CloseBefZoneSaleModel request) {

		int result = closeBefZoneSaleMapper.deleteCloseBefZoneSale(request);
		return result;

	}

}