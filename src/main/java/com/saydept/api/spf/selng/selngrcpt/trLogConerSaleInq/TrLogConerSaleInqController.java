package com.saydept.api.spf.selng.selngrcpt.trLogConerSaleInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.selng.selngrcpt.trLogConerSaleInq.model.TrLogConerSaleInqModel;
import com.saydept.api.spf.selng.selngrcpt.trLogConerSaleInq.model.TrLogConerSaleInqParamModel;

@CrossOrigin(origins = "*")
@RestController
public class TrLogConerSaleInqController {

	@Autowired
	private TrLogConerSaleInqService trLogConerSaleInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/TrLogConerSaleInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	
	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectTrLogConerSaleInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/TrLogConerSaleInq/selectTrLogConerSaleInqList", method = RequestMethod.POST)
	public List<TrLogConerSaleInqModel> selectTrLogConerSaleInqList(@RequestBody TrLogConerSaleInqParamModel request)throws Exception {

		List<TrLogConerSaleInqModel> result = trLogConerSaleInqService.selectTrLogConerSaleInqList(request);
		System.out.println(request);
		return result;
	}

	

}