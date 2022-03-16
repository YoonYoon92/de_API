package com.saydept.api.spf.goods.marginExchangeInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.goods.clsInq.model.ClsInqModel;
import com.saydept.api.spf.goods.marginExchangeInq.model.MarginExchangeInqModel;

@CrossOrigin(origins = "*")
@RestController
public class MarginExchangeInqController {

	@Autowired
	private MarginExchangeInqService marginExchangeInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/marginExchangeInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectMarginExchangeInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/marginExchangeInq/selectMarginExchangeInq", method = RequestMethod.POST)
	public MarginExchangeInqModel selectMarginExchangeInq(@RequestBody MarginExchangeInqModel request)throws Exception {

		MarginExchangeInqModel result = marginExchangeInqService.selectMarginExchangeInq(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectMarginExchangeInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/marginExchangeInq/selectMarginExchangeInqList", method = RequestMethod.POST)
	public List<MarginExchangeInqModel> selectMarginExchangeInqList(@RequestBody MarginExchangeInqModel request)throws Exception {

		List<MarginExchangeInqModel> result = marginExchangeInqService.selectMarginExchangeInqList(request);
		return result;
	}

	//클래스목록조회
		@RequestMapping(value = "api/marginExchangeInq/selectConerList", method = RequestMethod.POST)
		public List<MarginExchangeInqModel> selectConerList(@RequestBody MarginExchangeInqModel request)throws Exception {

			List<MarginExchangeInqModel> result = marginExchangeInqService.selectConerList(request);
			return result;
		}

}