package com.saydept.api.spf.selng.selngrcpt.trLogConerSaleInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.selng.selngrcpt.trLogConerSaleInq.model.TrLogConerSaleInqModel;
import com.saydept.api.spf.selng.selngrcpt.trLogConerSaleInq.model.TrLogConerSaleInqParamModel;

@Mapper
public interface TrLogConerSaleInqMapper {

	TrLogConerSaleInqModel selectTrLogConerSaleInq(TrLogConerSaleInqModel request);
	//종료일있을경우
	//일반결제
	List<TrLogConerSaleInqModel> selectTrLogConerSaleInqList(TrLogConerSaleInqParamModel request);
	//선수금
	List<TrLogConerSaleInqModel> selectTrLogConerSaleInqList73(TrLogConerSaleInqParamModel request);
	//일반외상
	List<TrLogConerSaleInqModel> selectTrLogConerSaleInqListCredit(TrLogConerSaleInqParamModel request);
	
	//종료일없을경우
	//일반결제
	List<TrLogConerSaleInqModel> noEndDtselectTrLogConerSaleInqList(TrLogConerSaleInqParamModel request);
	//선수금
	List<TrLogConerSaleInqModel> noEndDtselectTrLogConerSaleInqList73(TrLogConerSaleInqParamModel request);
	//일반외상
	List<TrLogConerSaleInqModel> noEndDtselectTrLogConerSaleInqListCredit(TrLogConerSaleInqParamModel request);
	

}