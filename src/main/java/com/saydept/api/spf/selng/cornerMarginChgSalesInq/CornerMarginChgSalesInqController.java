package com.saydept.api.spf.selng.cornerMarginChgSalesInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.selng.cornerMarginChgSalesInq.model.CornerMarginChgSalesInqModel;
import com.saydept.api.spf.selng.cornerMarginChgSalesInq.model.CornerMarginChgSalesInqParamModel;

@CrossOrigin(origins = "*")
@RestController
public class CornerMarginChgSalesInqController {

	@Autowired
	private CornerMarginChgSalesInqService cornerMarginChgSalesInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/spf/selng/selectCornerMarginChgSalesInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectCornerMarginChgSalesInqList
	 * @param request`
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/spf/selng/selectCornerMarginChgSalesInqList", method = RequestMethod.POST)
	public List<CornerMarginChgSalesInqModel> selectCornerMarginChgSalesInqList(@RequestBody CornerMarginChgSalesInqParamModel request)throws Exception {
	
		List<CornerMarginChgSalesInqModel> result = cornerMarginChgSalesInqService.selectCornerMarginChgSalesInqList(request);
		
		return result;
	}

}