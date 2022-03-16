package com.saydept.api.spf.org.conerLinkManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.org.conerLinkManagement.model.ConerLinkManagementModel;

	@Service
	public class ConerLinkManagementService {

	@Autowired
	private ConerLinkManagementMapper conerLinkManagementMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public ConerLinkManagementModel selectConerLinkManagement(ConerLinkManagementModel request)throws Exception {

	ConerLinkManagementModel result = conerLinkManagementMapper.selectConerLinkManagement(request);
	System.out.println("************************************");
	System.out.println(result);
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<ConerLinkManagementModel> selectConerLinkManagementList(ConerLinkManagementModel request)throws Exception {
		System.out.println(request);
		List<ConerLinkManagementModel> result = conerLinkManagementMapper.selectConerLinkManagementList(request);
		System.out.println(result);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateConerLinkManagement(ConerLinkManagementModel request)throws Exception {

		int result = conerLinkManagementMapper.updateConerLinkManagement(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int insertConerLinkManagement(ConerLinkManagementModel request) {
		
		System.out.println(request);
		int result = conerLinkManagementMapper.insertConerLinkManagement(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int saveConerLinkManagement(ConerLinkManagementModel request) {

		int result = conerLinkManagementMapper.saveConerLinkManagement(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteConerLinkManagement(ConerLinkManagementModel request) {
		System.out.println(request);
		int result = conerLinkManagementMapper.deleteConerLinkManagement(request);
		System.out.println(result);
		return result;

	}

}