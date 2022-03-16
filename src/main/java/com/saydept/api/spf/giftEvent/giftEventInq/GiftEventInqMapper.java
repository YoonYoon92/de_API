package com.saydept.api.spf.giftEvent.giftEventInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.giftEvent.giftEventInq.model.GiftEventInqModel;

@Mapper
public interface GiftEventInqMapper {

	GiftEventInqModel selectGiftEventInq(GiftEventInqModel request);

	List<GiftEventInqModel> selectGiftEventInqList(GiftEventInqModel request);

	int updateGiftEventInq(GiftEventInqModel request);

	int insertGiftEventInq(GiftEventInqModel request);

	int saveGiftEventInq(GiftEventInqModel request);

	int deleteGiftEventInq(GiftEventInqModel request);

}