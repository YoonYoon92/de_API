package com.saydept.api.spf.selng.receiptInfoInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.selng.receiptInfoInq.model.ReceiptInfoInqModel;

@CrossOrigin(origins = "*")
@RestController
public class ReceiptInfoInqController {

	@Autowired
	private ReceiptInfoInqService receiptInfoInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/receiptInfoInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectReceiptInfoInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/receiptInfoInq/selectReceiptInfoInq", method = RequestMethod.POST)
	public ReceiptInfoInqModel selectReceiptInfoInq(@RequestBody ReceiptInfoInqModel request)throws Exception {

		ReceiptInfoInqModel result = receiptInfoInqService.selectReceiptInfoInq(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectReceiptInfoInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
//	@RequestMapping(value = "api/receiptInfoInq/selectReceiptInfoInqList", method = RequestMethod.POST)
//	public List<ReceiptInfoInqModel> selectReceiptInfoInqList(@RequestBody ReceiptInfoInqModel request)throws Exception {
//
//		List<ReceiptInfoInqModel> result = receiptInfoInqService.selectReceiptInfoInqList(request);
//		return result;
//	}
	@RequestMapping(value = "api/receiptInfoInq/selectReceiptInfoInqList3", method = RequestMethod.POST)
	public List<ReceiptInfoInqModel> selectReceiptInfoInqList3(@RequestBody ReceiptInfoInqModel request)throws Exception {

		List<ReceiptInfoInqModel> result = receiptInfoInqService.selectReceiptInfoInqList3(request);
		
		return result;
	}

	

}