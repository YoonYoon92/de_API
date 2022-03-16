package com.saydept.api.scd.custmer.smsExceptManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.scd.custmer.smsExceptManagement.model.SmsExceptManagementModel;

@CrossOrigin(origins = "*")
@RestController
public class SmsExceptManagementController {

	@Autowired
	private SmsExceptManagementService smsExceptManagementService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/smsExceptManagement", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectSmsExceptManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/smsExceptManagement/selectSmsExceptManagement", method = RequestMethod.POST)
	public SmsExceptManagementModel selectSmsExceptManagement(@RequestBody SmsExceptManagementModel request)throws Exception {

		SmsExceptManagementModel result = smsExceptManagementService.selectSmsExceptManagement(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectSmsExceptManagementList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/smsExceptManagement/selectSmsExceptManagementList", method = RequestMethod.POST)
	public List<SmsExceptManagementModel> selectSmsExceptManagementList(@RequestBody SmsExceptManagementModel request)throws Exception {

		List<SmsExceptManagementModel> result = smsExceptManagementService.selectSmsExceptManagementList(request);
		return result;
	}

	/**
	 * 데이터 수정
	 * 작성방법은 update'업무를 구분할 명칭'
	 * Ex)updateSmsExceptManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/smsExceptManagement/updateSmsExceptManagement", method = RequestMethod.POST)
	public int updateSmsExceptManagement(@RequestBody SmsExceptManagementModel request)throws Exception {

		int result = smsExceptManagementService.updateSmsExceptManagement(request);
		return result;
	}

	/**
	 * 데이터 등록
	 * 작성방법은 insert'업무를 구분할 명칭'
	 * Ex)insertSmsExceptManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/smsExceptManagement/insertSmsExceptManagement", method = RequestMethod.POST)
	public int insertSmsExceptManagement(@RequestBody SmsExceptManagementModel request)throws Exception {

		int result = smsExceptManagementService.insertSmsExceptManagement(request);
		return result;
	}

	/**
	 * 데이터 수정+등록 Ex) 데이터가 없으면 insert 없으면 update 작업을 동시 처리할때
	 * 작성방법은 save'업무를 구분할 명칭'
	 * Ex)saveSmsExceptManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/smsExceptManagement/saveSmsExceptManagement", method = RequestMethod.POST)
	public int saveSmsExceptManagement(@RequestBody SmsExceptManagementModel request)throws Exception {

		int result = smsExceptManagementService.saveSmsExceptManagement(request);
		return result;
	}

	/**
	 * 데이터 삭제
	 * 작성방법은 delete'업무를 구분할 명칭'
	 * Ex)deleteSmsExceptManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/smsExceptManagement/deleteSmsExceptManagement", method = RequestMethod.POST)
	public int deleteSmsExceptManagement(@RequestBody SmsExceptManagementModel request)throws Exception {

		int result = smsExceptManagementService.deleteSmsExceptManagement(request);
		return result;
	}

}