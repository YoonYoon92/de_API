package com.saydept.api.spf.saleNews.largeShopSaleInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.saleNews.largeShopSaleInq.model.LargeShopSaleInqModel;


@CrossOrigin(origins = "*")
@RestController
public class LargeShopSaleInqController {

	@Autowired
	private LargeShopSaleInqService largeShopSaleInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/largeShopSaleInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}



	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectLargeShopSaleInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/largeShopSaleInq/selectLargeShopSaleInqList", method = RequestMethod.POST)
	public List<LargeShopSaleInqModel> selectLargeShopSaleInqList(@RequestBody LargeShopSaleInqModel request)throws Exception {

		List<LargeShopSaleInqModel> result = largeShopSaleInqService.selectLargeShopSaleInqList(request);
		return result;
	}

	@RequestMapping(value = "api/selectLargeShopSaleInqList/TEST")
	public List<LargeShopSaleInqModel> TEST()throws Exception {
		LargeShopSaleInqModel result = new LargeShopSaleInqModel();

		result.setStartDt("20200701");
		result.setMmDt("20200701");
		result.setYyDt("20200101");
		return largeShopSaleInqService.selectLargeShopSaleInqList(result);
	}


}