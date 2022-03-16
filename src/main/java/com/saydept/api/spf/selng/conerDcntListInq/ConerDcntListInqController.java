package com.saydept.api.spf.selng.conerDcntListInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.selng.conerDcntListInq.model.ConerDcntListInqModel;

@CrossOrigin(origins = "*")
@RestController
public class ConerDcntListInqController {

	@Autowired
	private ConerDcntListInqService conerDcntListInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/conerDcntListInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectConerDcntListInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/conerDcntListInq/selectConerDcntListInqList", method = RequestMethod.POST)
	public List<ConerDcntListInqModel> selectConerDcntListInqList(@RequestBody ConerDcntListInqModel request)throws Exception {

		List<ConerDcntListInqModel> result = conerDcntListInqService.selectConerDcntListInqList(request);
		return result;
	}
	
	@RequestMapping(value = "api/conerDcntListInq/selectConerList", method = RequestMethod.POST)
	public List<ConerDcntListInqModel> selectConerList(@RequestBody ConerDcntListInqModel request)throws Exception {

		List<ConerDcntListInqModel> result = conerDcntListInqService.selectConerList(request);
		return result;
	}

	

}