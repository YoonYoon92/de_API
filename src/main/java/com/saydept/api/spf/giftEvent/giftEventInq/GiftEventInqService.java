package com.saydept.api.spf.giftEvent.giftEventInq;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.giftEvent.giftEventInq.model.GiftEventInqModel;

	@Service
	public class GiftEventInqService {

	@Autowired
	private GiftEventInqMapper giftEventInqMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public GiftEventInqModel selectGiftEventInq(GiftEventInqModel request)throws Exception {

	GiftEventInqModel result = giftEventInqMapper.selectGiftEventInq(request);
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<GiftEventInqModel> selectGiftEventInqList(GiftEventInqModel request)throws Exception {

		List<GiftEventInqModel> result = giftEventInqMapper.selectGiftEventInqList(request);
		System.out.println(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateGiftEventInq(GiftEventInqModel request)throws Exception {

		int result = giftEventInqMapper.updateGiftEventInq(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int insertGiftEventInq(GiftEventInqModel request) {

		int result = giftEventInqMapper.insertGiftEventInq(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int saveGiftEventInq(GiftEventInqModel request) {

		int result = giftEventInqMapper.saveGiftEventInq(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteGiftEventInq(GiftEventInqModel request) {

		int result = giftEventInqMapper.deleteGiftEventInq(request);
		return result;

	}

}