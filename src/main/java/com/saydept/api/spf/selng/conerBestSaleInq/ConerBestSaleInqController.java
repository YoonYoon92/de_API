package com.saydept.api.spf.selng.conerBestSaleInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.selng.conerBestSaleInq.model.ConerBestSaleInqModel;
import com.saydept.api.spf.selng.conerBestSaleInq.model.ConerBestSaleInqParamModel;

@CrossOrigin(origins = "*")
@RestController
public class ConerBestSaleInqController {

	@Autowired
	private ConerBestSaleInqService conerBestSaleInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/conerBestSaleInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectConerBestSaleInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/conerBestSaleInq/selectConerBestSaleInq", method = RequestMethod.POST)
	public ConerBestSaleInqModel selectConerBestSaleInq(@RequestBody ConerBestSaleInqParamModel request)throws Exception {

		ConerBestSaleInqModel result = conerBestSaleInqService.selectConerBestSaleInq(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectConerBestSaleInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/conerBestSaleInq/selectConerBestSaleInqList", method = RequestMethod.POST)
	public List<ConerBestSaleInqModel> selectConerBestSaleInqList(@RequestBody ConerBestSaleInqParamModel request)throws Exception {

		List<ConerBestSaleInqModel> result = conerBestSaleInqService.selectConerBestSaleInqList(request);
		return result;
	}

	/**
	 * 데이터 수정
	 * 작성방법은 update'업무를 구분할 명칭'
	 * Ex)updateConerBestSaleInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/conerBestSaleInq/updateConerBestSaleInq", method = RequestMethod.POST)
	public int updateConerBestSaleInq(@RequestBody ConerBestSaleInqParamModel request)throws Exception {

		int result = conerBestSaleInqService.updateConerBestSaleInq(request);
		return result;
	}

	/**
	 * 데이터 등록
	 * 작성방법은 insert'업무를 구분할 명칭'
	 * Ex)insertConerBestSaleInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/conerBestSaleInq/insertConerBestSaleInq", method = RequestMethod.POST)
	public int insertConerBestSaleInq(@RequestBody ConerBestSaleInqParamModel request)throws Exception {

		int result = conerBestSaleInqService.insertConerBestSaleInq(request);
		return result;
	}

	/**
	 * 데이터 수정+등록 Ex) 데이터가 없으면 insert 없으면 update 작업을 동시 처리할때
	 * 작성방법은 save'업무를 구분할 명칭'
	 * Ex)saveConerBestSaleInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/conerBestSaleInq/saveConerBestSaleInq", method = RequestMethod.POST)
	public int saveConerBestSaleInq(@RequestBody ConerBestSaleInqParamModel request)throws Exception {

		int result = conerBestSaleInqService.saveConerBestSaleInq(request);
		return result;
	}

	/**
	 * 데이터 삭제
	 * 작성방법은 delete'업무를 구분할 명칭'
	 * Ex)deleteConerBestSaleInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/conerBestSaleInq/deleteConerBestSaleInq", method = RequestMethod.POST)
	public int deleteConerBestSaleInq(@RequestBody ConerBestSaleInqParamModel request)throws Exception {

		int result = conerBestSaleInqService.deleteConerBestSaleInq(request);
		return result;
	}

}