package com.saydept.api.spf.giftEvent.giftEventInq;

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

@CrossOrigin(origins = "*")
@RestController
public class GiftEventInqController {

	@Autowired
	private GiftEventInqService giftEventInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/giftEventInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectGiftEventInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/giftEventInq/selectGiftEventInq", method = RequestMethod.POST)
	public GiftEventInqModel selectGiftEventInq(@RequestBody GiftEventInqModel request)throws Exception {

		GiftEventInqModel result = giftEventInqService.selectGiftEventInq(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectGiftEventInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/giftEventInq/selectGiftEventInqList", method = RequestMethod.POST)
	public List<GiftEventInqModel> selectGiftEventInqList(@RequestBody GiftEventInqModel request)throws Exception {

		List<GiftEventInqModel> result = giftEventInqService.selectGiftEventInqList(request);
		return result;
	}

	/**
	 * 데이터 수정
	 * 작성방법은 update'업무를 구분할 명칭'
	 * Ex)updateGiftEventInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/giftEventInq/updateGiftEventInq", method = RequestMethod.POST)
	public int updateGiftEventInq(@RequestBody GiftEventInqModel request)throws Exception {

		int result = giftEventInqService.updateGiftEventInq(request);
		return result;
	}

	/**
	 * 데이터 등록
	 * 작성방법은 insert'업무를 구분할 명칭'
	 * Ex)insertGiftEventInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/giftEventInq/insertGiftEventInq", method = RequestMethod.POST)
	public int insertGiftEventInq(@RequestBody GiftEventInqModel request)throws Exception {

		int result = giftEventInqService.insertGiftEventInq(request);
		return result;
	}

	/**
	 * 데이터 수정+등록 Ex) 데이터가 없으면 insert 없으면 update 작업을 동시 처리할때
	 * 작성방법은 save'업무를 구분할 명칭'
	 * Ex)saveGiftEventInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/giftEventInq/saveGiftEventInq", method = RequestMethod.POST)
	public int saveGiftEventInq(@RequestBody GiftEventInqModel request)throws Exception {

		int result = giftEventInqService.saveGiftEventInq(request);
		return result;
	}

	/**
	 * 데이터 삭제
	 * 작성방법은 delete'업무를 구분할 명칭'
	 * Ex)deleteGiftEventInq
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/giftEventInq/deleteGiftEventInq", method = RequestMethod.POST)
	public int deleteGiftEventInq(@RequestBody GiftEventInqModel request)throws Exception {

		int result = giftEventInqService.deleteGiftEventInq(request);
		return result;
	}

}