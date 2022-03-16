package com.saydept.api.spf.selng.receiptInfoInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.saydept.api.spf.selng.receiptInfoInq.model.ReceiptInfoInqModel;
import com.saydept.api.spf.selng.receiptInfoInq.model.ReceiptInfoInqTrModel;

@Mapper
public interface ReceiptInfoInqMapper {

	ReceiptInfoInqModel selectReceiptInfoInq(ReceiptInfoInqModel request);
	
	ReceiptInfoInqModel searchVan(ReceiptInfoInqModel request);
	
	//List<ReceiptInfoInqModel> selectReceiptInfoInqList(ReceiptInfoInqModel request);
	
	ReceiptInfoInqModel selectReceiptInfoInqList(ReceiptInfoInqModel request);
	
	List<ReceiptInfoInqTrModel> selectReceiptInfoInqList2(ReceiptInfoInqModel request);
	
	List<ReceiptInfoInqModel> selectReceiptInfoInqList4(ReceiptInfoInqModel request);
	
	List<ReceiptInfoInqModel> findEvent(ReceiptInfoInqModel request);
	
	ReceiptInfoInqModel findCls(ReceiptInfoInqModel request);
	
	ReceiptInfoInqModel findItem(ReceiptInfoInqModel request);
	
	ReceiptInfoInqModel findPoint(ReceiptInfoInqModel request);
	
	ReceiptInfoInqModel findPointafter(ReceiptInfoInqModel request);
	
	ReceiptInfoInqModel findCoupon(ReceiptInfoInqModel request);
	
	ReceiptInfoInqModel findMessageCoupon(ReceiptInfoInqModel request);
	
	ReceiptInfoInqModel findCash(ReceiptInfoInqModel request);
	
	int updateReceiptInfoInq(ReceiptInfoInqModel request);

	int insertReceiptInfoInq(ReceiptInfoInqModel request);

	int saveReceiptInfoInq(ReceiptInfoInqModel request);

	int deleteReceiptInfoInq(ReceiptInfoInqModel request);

}