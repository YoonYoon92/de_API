package com.saydept.api.spf.goods.partnerManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.goods.partnerManagement.model.PartnerManagementModel;

@CrossOrigin(origins = "*")
@RestController
public class PartnerManagementController {

	@Autowired
	private PartnerManagementService partnerManagementService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/partnerManagement", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectPartnerManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/partnerManagement/selectPartnerManagement", method = RequestMethod.POST)
	public PartnerManagementModel selectPartnerManagement(@RequestBody PartnerManagementModel request)throws Exception {

		PartnerManagementModel result = partnerManagementService.selectPartnerManagement(request);
		System.out.println(result);
		return result;
		
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectPartnerManagementList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/partnerManagement/selectPartnerManagementList", method = RequestMethod.POST)
	public List<PartnerManagementModel> selectPartnerManagementList(@RequestBody PartnerManagementModel request)throws Exception {

		List<PartnerManagementModel> result = partnerManagementService.selectPartnerManagementList(request);
		return result;
	}

	/**
	 * 데이터 수정
	 * 작성방법은 update'업무를 구분할 명칭'
	 * Ex)updatePartnerManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/partnerManagement/updatePartnerManagement", method = RequestMethod.POST)
	public int updatePartnerManagement(@RequestBody PartnerManagementModel request)throws Exception {

		int result = partnerManagementService.updatePartnerManagement(request);
		return result;
	}

	/**
	 * 데이터 등록
	 * 작성방법은 insert'업무를 구분할 명칭'
	 * Ex)insertPartnerManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/partnerManagement/insertPartnerManagement", method = RequestMethod.POST)
	public int insertPartnerManagement(@RequestBody PartnerManagementModel request)throws Exception {

		int result = partnerManagementService.insertPartnerManagement(request);
		return result;
	}

	/**
	 * 데이터 수정+등록 Ex) 데이터가 없으면 insert 없으면 update 작업을 동시 처리할때
	 * 작성방법은 save'업무를 구분할 명칭'
	 * Ex)savePartnerManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/partnerManagement/savePartnerManagement", method = RequestMethod.POST)
	public int savePartnerManagement(@RequestBody PartnerManagementModel request)throws Exception {

		int result = partnerManagementService.savePartnerManagement(request);
		return result;
	}

	/**
	 * 데이터 삭제
	 * 작성방법은 delete'업무를 구분할 명칭'
	 * Ex)deletePartnerManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/partnerManagement/deletePartnerManagement", method = RequestMethod.POST)
	public int deletePartnerManagement(@RequestBody PartnerManagementModel request)throws Exception {

		int result = partnerManagementService.deletePartnerManagement(request);
		return result;
	}

}