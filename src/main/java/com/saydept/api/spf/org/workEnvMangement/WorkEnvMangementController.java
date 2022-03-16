package com.saydept.api.spf.org.workEnvMangement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.org.workEnvMangement.model.WorkEnvMangementModel;

@CrossOrigin(origins = "*")
@RestController
public class WorkEnvMangementController {

	@Autowired
	private WorkEnvMangementService workEnvMangementService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/workEnvMangement", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectWorkEnvMangement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/workEnvMangement/selectWorkEnvMangement", method = RequestMethod.POST)
	public WorkEnvMangementModel selectWorkEnvMangement(@RequestBody WorkEnvMangementModel request)throws Exception {

		WorkEnvMangementModel result = workEnvMangementService.selectWorkEnvMangement(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectWorkEnvMangementList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/workEnvMangement/selectWorkEnvMangementList", method = RequestMethod.POST)
	public List<WorkEnvMangementModel> selectWorkEnvMangementList(@RequestBody WorkEnvMangementModel request)throws Exception {

		List<WorkEnvMangementModel> result = workEnvMangementService.selectWorkEnvMangementList(request);
		return result;
	}

	/**
	 * 데이터 수정
	 * 작성방법은 update'업무를 구분할 명칭'
	 * Ex)updateWorkEnvMangement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/workEnvMangement/updateWorkEnvMangement", method = RequestMethod.POST)
	public int updateWorkEnvMangement(@RequestBody WorkEnvMangementModel request)throws Exception {

		int result = workEnvMangementService.updateWorkEnvMangement(request);
		return result;
	}

	/**
	 * 데이터 등록
	 * 작성방법은 insert'업무를 구분할 명칭'
	 * Ex)insertWorkEnvMangement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/workEnvMangement/insertWorkEnvMangement", method = RequestMethod.POST)
	public int insertWorkEnvMangement(@RequestBody WorkEnvMangementModel request)throws Exception {

		int result = workEnvMangementService.insertWorkEnvMangement(request);
		return result;
	}

	/**
	 * 데이터 수정+등록 Ex) 데이터가 없으면 insert 없으면 update 작업을 동시 처리할때
	 * 작성방법은 save'업무를 구분할 명칭'
	 * Ex)saveWorkEnvMangement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/workEnvMangement/saveWorkEnvMangement", method = RequestMethod.POST)
	public int saveWorkEnvMangement(@RequestBody WorkEnvMangementModel request)throws Exception {

		int result = workEnvMangementService.saveWorkEnvMangement(request);
		return result;
	}

	/**
	 * 데이터 삭제
	 * 작성방법은 delete'업무를 구분할 명칭'
	 * Ex)deleteWorkEnvMangement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/workEnvMangement/deleteWorkEnvMangement", method = RequestMethod.POST)
	public int deleteWorkEnvMangement(@RequestBody WorkEnvMangementModel request)throws Exception {

		int result = workEnvMangementService.deleteWorkEnvMangement(request);
		return result;
	}

}