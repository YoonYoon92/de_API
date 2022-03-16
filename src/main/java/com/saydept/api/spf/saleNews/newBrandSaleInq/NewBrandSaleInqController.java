package com.saydept.api.spf.saleNews.newBrandSaleInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.saleNews.newBrandSaleInq.model.NewBrandSaleInqModel;
import com.saydept.api.spf.saleNews.newBrandSaleInq.model.NewBrandSaleInqParamModel;

@CrossOrigin(origins = "*")
@RestController
public class NewBrandSaleInqController {

	@Autowired
	private NewBrandSaleInqService NewBrandSaleInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/NewBrandSaleInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectNewBrandSaleInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/newBrandSaleInq/selectNewBrandSaleInqList", method = RequestMethod.POST)
	public List<NewBrandSaleInqModel> selectNewBrandSaleInqList(@RequestBody NewBrandSaleInqParamModel request)throws Exception {

		List<NewBrandSaleInqModel> result = NewBrandSaleInqService.selectNewBrandSaleInqList(request);
		return result;
	}
	
	/**
	 * 복수 대상 조회(test)
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectNewBrandSaleInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/newBrandSaleInq/selectNewBrandSaleInqListTest")
	public List<NewBrandSaleInqModel> selectNewBrandSaleInqList()throws Exception {
		
		NewBrandSaleInqParamModel param = new NewBrandSaleInqParamModel();
		
		param.setJum("01");
		param.setStartDt("20200501");
		param.setEndDt("20200716");
		
		List<NewBrandSaleInqModel> result = NewBrandSaleInqService.selectNewBrandSaleInqList(param);
		return result;
	}

}