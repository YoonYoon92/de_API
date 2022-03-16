package com.saydept.api.scd.custmer.pointSalesInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.scd.custmer.pointSalesInq.model.PointSalesInqModel;

@CrossOrigin(origins = "*")
@RestController
public class PointSalesInqController {

	@Autowired
	private PointSalesInqService pointSalesInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/pointSalesInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectPointSalesInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/pointSalesInq/selectPointSalesInq", method = RequestMethod.POST)
	public PointSalesInqModel selectPointSalesInq(@RequestBody PointSalesInqModel request)throws Exception {

		PointSalesInqModel result = pointSalesInqService.selectPointSalesInq(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectPointSalesInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/pointSalesInq/selectPointSalesInqList", method = RequestMethod.POST)
	public List<PointSalesInqModel> selectPointSalesInqList(@RequestBody PointSalesInqModel request)throws Exception {

		List<PointSalesInqModel> result = pointSalesInqService.selectPointSalesInqList(request);
		return result;
	}

	

}