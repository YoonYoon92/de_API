package com.saydept.api.spf.selng.cardApprLogInq;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.selng.cardApprLogInq.model.CardApprLogInqModel;
import com.saydept.api.spf.selng.cardApprLogInq.model.CardApprLogInqParamModel;

@Mapper
public interface CardApprLogInqMapper {


	List<CardApprLogInqModel> selectCardApprLogInqList(CardApprLogInqParamModel request);

	CardApprLogInqParamModel selectCardPrefixInqList(CardApprLogInqParamModel request);

}