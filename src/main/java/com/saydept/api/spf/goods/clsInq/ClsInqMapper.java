package com.saydept.api.spf.goods.clsInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.giftEvent.giftEventInq.model.GiftEventInqModel;
import com.saydept.api.spf.goods.clsInq.model.ClsInqModel;

@Mapper
public interface ClsInqMapper {

	
	//그리드조회
	List<ClsInqModel> selectClassInqList(ClsInqModel request);
	
	//코너목록조회
	List<ClsInqModel> selectConerList(ClsInqModel request);
	
	//클래스상세조회
	ClsInqModel selectDetailClsList(ClsInqModel request);
	
	//클래스마진조회
	List<ClsInqModel> selectDetailClsMargin(ClsInqModel request);
}