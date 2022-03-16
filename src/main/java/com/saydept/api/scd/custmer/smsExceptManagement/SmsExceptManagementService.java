package com.saydept.api.scd.custmer.smsExceptManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.scd.custmer.smsExceptManagement.model.SmsExceptManagementModel;

	@Service
	public class SmsExceptManagementService {

	@Autowired
	private SmsExceptManagementMapper smsExceptManagementMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public SmsExceptManagementModel selectSmsExceptManagement(SmsExceptManagementModel request)throws Exception {

	SmsExceptManagementModel result = smsExceptManagementMapper.selectSmsExceptManagement(request);
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<SmsExceptManagementModel> selectSmsExceptManagementList(SmsExceptManagementModel request)throws Exception {

		List<SmsExceptManagementModel> result = smsExceptManagementMapper.selectSmsExceptManagementList(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateSmsExceptManagement(SmsExceptManagementModel request)throws Exception {

		int result = smsExceptManagementMapper.updateSmsExceptManagement(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int insertSmsExceptManagement(SmsExceptManagementModel request) {

		int result = smsExceptManagementMapper.insertSmsExceptManagement(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int saveSmsExceptManagement(SmsExceptManagementModel request) {

		int result = smsExceptManagementMapper.saveSmsExceptManagement(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteSmsExceptManagement(SmsExceptManagementModel request) {

		int result = smsExceptManagementMapper.deleteSmsExceptManagement(request);
		return result;

	}

}