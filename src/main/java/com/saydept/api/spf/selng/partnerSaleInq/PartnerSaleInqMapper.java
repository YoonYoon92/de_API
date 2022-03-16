package com.saydept.api.spf.selng.partnerSaleInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.selng.partnerSaleInq.model.PartnerSaleInqModel;

@Mapper
public interface PartnerSaleInqMapper {


	//협력업체 리스트 selectItemList
	List<PartnerSaleInqModel> selectPartnerList(PartnerSaleInqModel request);
	
	//클래스 리스트
	List<PartnerSaleInqModel> selectClsList(PartnerSaleInqModel request);
	
	//품목코드 리스트
	List<PartnerSaleInqModel> selectGlsList(PartnerSaleInqModel request);
	
	//조회리스트
	List<PartnerSaleInqModel> selectPartnerSaleInqList(PartnerSaleInqModel request);


}