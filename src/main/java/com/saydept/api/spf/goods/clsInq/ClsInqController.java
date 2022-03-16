package com.saydept.api.spf.goods.clsInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.giftEvent.giftEventInq.model.GiftEventInqModel;
import com.saydept.api.spf.goods.clsInq.model.ClsInqModel;
import com.saydept.api.spf.selng.conerDcntListInq.model.ConerDcntListInqModel;

@CrossOrigin(origins = "*")
@RestController
public class ClsInqController {

	@Autowired
	private ClsInqService classInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/classInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	
	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectClassInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/clsInq/selectClsInqList", method = RequestMethod.POST)
	public List<ClsInqModel> selectClassInqList(@RequestBody ClsInqModel request)throws Exception {

		List<ClsInqModel> result = classInqService.selectClassInqList(request);
		return result;
	}
	//클래스목록조회
	@RequestMapping(value = "api/clsInq/selectConerList", method = RequestMethod.POST)
	public List<ClsInqModel> selectConerList(@RequestBody ClsInqModel request)throws Exception {

		List<ClsInqModel> result = classInqService.selectConerList(request);
		return result;
	}
	//클래스목록상세조회
	@RequestMapping(value = "api/clsInq/selectDetailClsList", method = RequestMethod.POST)
	public ClsInqModel selectGiftEventInq(@RequestBody ClsInqModel request)throws Exception {

		ClsInqModel result = classInqService.selectDetailClsList(request);
		return result;
	}
	//클래스마진조회
	@RequestMapping(value = "api/clsInq/selectDetailClsMargin", method = RequestMethod.POST)
	public List<ClsInqModel> selectDetailClsMargin(@RequestBody ClsInqModel request)throws Exception {

		List<ClsInqModel> result = classInqService.selectDetailClsMargin(request);
		return result;
	}
	//클래

}