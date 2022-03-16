package com.saydept.api.spf.org.conerHistoryInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.org.conerHistoryInq.model.ConerHistoryInqModel;
import com.saydept.api.spf.org.conerHistoryInq.model.ConerHistoryInqParamModel;

@CrossOrigin(origins = "*")
@RestController
public class ConerHistoryInqController {

	@Autowired
	private ConerHistoryInqService conerHistoryInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/conerHistoryInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectConerHistoryInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/conerHistoryInq/selectConerHistoryInq", method = RequestMethod.POST)
	public ConerHistoryInqModel selectConerHistoryInq(@RequestBody ConerHistoryInqModel request)throws Exception {

		ConerHistoryInqModel result = conerHistoryInqService.selectConerHistoryInq(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectConerHistoryInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/conerHistoryInq/selectConerHistoryInqList", method = RequestMethod.POST)
	public List<ConerHistoryInqModel> selectConerHistoryInqList(@RequestBody ConerHistoryInqParamModel request)throws Exception {

		List<ConerHistoryInqModel> result = conerHistoryInqService.selectConerHistoryInqList(request);
		return result;
	}

	/**
	 * 데이터 수정
	 * 작성방법은 update'업무를 구분할 명칭'
	 * Ex)updateConerHistoryInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/conerHistoryInq/updateConerHistoryInq", method = RequestMethod.POST)
	public int updateConerHistoryInq(@RequestBody ConerHistoryInqModel request)throws Exception {

		int result = conerHistoryInqService.updateConerHistoryInq(request);
		return result;
	}

	/**
	 * 데이터 등록
	 * 작성방법은 insert'업무를 구분할 명칭'
	 * Ex)insertConerHistoryInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/conerHistoryInq/insertConerHistoryInq", method = RequestMethod.POST)
	public int insertConerHistoryInq(@RequestBody ConerHistoryInqModel request)throws Exception {

		int result = conerHistoryInqService.insertConerHistoryInq(request);
		return result;
	}

	/**
	 * 데이터 수정+등록 Ex) 데이터가 없으면 insert 없으면 update 작업을 동시 처리할때
	 * 작성방법은 save'업무를 구분할 명칭'
	 * Ex)saveConerHistoryInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/conerHistoryInq/saveConerHistoryInq", method = RequestMethod.POST)
	public int saveConerHistoryInq(@RequestBody ConerHistoryInqModel request)throws Exception {

		int result = conerHistoryInqService.saveConerHistoryInq(request);
		return result;
	}

	/**
	 * 데이터 삭제
	 * 작성방법은 delete'업무를 구분할 명칭'
	 * Ex)deleteConerHistoryInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/conerHistoryInq/deleteConerHistoryInq", method = RequestMethod.POST)
	public int deleteConerHistoryInq(@RequestBody ConerHistoryInqModel request)throws Exception {

		int result = conerHistoryInqService.deleteConerHistoryInq(request);
		return result;
	}

}