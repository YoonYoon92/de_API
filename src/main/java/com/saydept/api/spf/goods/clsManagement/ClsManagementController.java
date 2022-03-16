package com.saydept.api.spf.goods.clsManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.goods.clsManagement.model.ClsManagementModel;

@CrossOrigin(origins = "*")
@RestController
public class ClsManagementController {

	@Autowired
	private ClsManagementService clsManagementService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/clsManagement", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectClsManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/clsManagement/selectClsManagement", method = RequestMethod.POST)
	public ClsManagementModel selectClsManagement(@RequestBody ClsManagementModel request)throws Exception {
		
		ClsManagementModel result = clsManagementService.selectClsManagement(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectClsManagementList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/clsManagement/selectConerList", method = RequestMethod.POST)
	public List<ClsManagementModel> selectConerList(@RequestBody ClsManagementModel request)throws Exception {

		List<ClsManagementModel> result = clsManagementService.selectConerList(request);
		return result;
	}

	@RequestMapping(value = "api/clsManagement/selectClsManagementList", method = RequestMethod.POST)
	public List<ClsManagementModel> selectClsManagementList(@RequestBody ClsManagementModel request)throws Exception {

		List<ClsManagementModel> result = clsManagementService.selectClsManagementList(request);
		return result;
	}
	//키조회
	@RequestMapping(value = "api/clsManagement/selectKeyList", method = RequestMethod.POST)
	public List<ClsManagementModel> selectKeyList(@RequestBody ClsManagementModel request)throws Exception {

		List<ClsManagementModel> result = clsManagementService.selectKeyList(request);
		return result;
	}
	/**
	 * 데이터 수정
	 * 작성방법은 update'업무를 구분할 명칭'
	 * Ex)updateClsManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/clsManagement/updateClsManagement", method = RequestMethod.POST)
	public int updateClsManagement(@RequestBody ClsManagementModel request)throws Exception {

		int result = clsManagementService.updateClsManagement(request);
		return result;
	}

	/**
	 * 데이터 등록
	 * 작성방법은 insert'업무를 구분할 명칭'
	 * Ex)insertClsManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/clsManagement/insertClsManagement", method = RequestMethod.POST)
	public int insertClsManagement(@RequestBody ClsManagementModel request)throws Exception {

		int result = clsManagementService.insertClsManagement(request);
		return result;
	}

	/**
	 * 데이터 수정+등록 Ex) 데이터가 없으면 insert 없으면 update 작업을 동시 처리할때
	 * 작성방법은 save'업무를 구분할 명칭'
	 * Ex)saveClsManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/clsManagement/saveClsManagement", method = RequestMethod.POST)
	public int saveClsManagement(@RequestBody ClsManagementModel request)throws Exception {

		int result = clsManagementService.saveClsManagement(request);
		return result;
	}

	/**
	 * 데이터 삭제
	 * 작성방법은 delete'업무를 구분할 명칭'
	 * Ex)deleteClsManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/clsManagement/deleteClsManagement", method = RequestMethod.POST)
	public int deleteClsManagement(@RequestBody ClsManagementModel request)throws Exception {

		int result = clsManagementService.deleteClsManagement(request);
		return result;
	}

}