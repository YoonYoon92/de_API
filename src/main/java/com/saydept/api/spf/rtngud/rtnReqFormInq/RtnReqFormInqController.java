package com.saydept.api.spf.rtngud.rtnReqFormInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.rtngud.rtnReqFormInq.model.RtnReqFormInqModel;

@CrossOrigin(origins = "*")
@RestController
public class RtnReqFormInqController {

	@Autowired
	private RtnReqFormInqService rtnReqFormInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/rtnReqFormInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectRtnReqFormInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/rtnReqFormInq/selectRtnReqFormInqList", method = RequestMethod.POST)
	public List<RtnReqFormInqModel> selectRtnReqFormInqList(@RequestBody RtnReqFormInqModel request)throws Exception {

		List<RtnReqFormInqModel> result = rtnReqFormInqService.selectRtnReqFormInqList(request);
		return result;
	}
	//상세조회
	@RequestMapping(value = "api/rtnReqFormInq/selectDetailList", method = RequestMethod.POST)
	public List<RtnReqFormInqModel> selectDetailList(@RequestBody RtnReqFormInqModel request)throws Exception {

		List<RtnReqFormInqModel> result = rtnReqFormInqService.selectDetailList(request);
		return result;
	}


}