package com.saydept.api.spf.selng.trdetailInfoInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.selng.trdetailInfoInq.model.TrdetailInfoInqModel;
import com.saydept.api.spf.selng.trdetailInfoInq.model.TrdetailInfoInqParamModel;

@Mapper
public interface TrdetailInfoInqMapper {

	TrdetailInfoInqModel selectTrdetailInfoInq(TrdetailInfoInqParamModel request);

	List<TrdetailInfoInqModel> selectTrdetailInfoInqList(TrdetailInfoInqParamModel request);
	List<TrdetailInfoInqParamModel> dataList(TrdetailInfoInqParamModel request);
	//카드번호가져오기
	TrdetailInfoInqParamModel selectVanChk(TrdetailInfoInqParamModel request);

}