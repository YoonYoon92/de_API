package com.saydept.api.spf.saleNews.closeBefProfitInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.saleNews.closeBefProfitInq.model.CloseBefProfitInqModel;
import com.saydept.api.spf.saleNews.closeBefProfitInq.model.CloseBefProfitInqParamModel;

@Mapper
public interface CloseBefProfitInqMapper {
	
	void createCloseBefProfitInqI01();
	void createCloseBefProfitInqI01L();
	void createCloseBefProfitInqI02();
	void createCloseBefProfitInqI02L();
	void createCloseBefProfitInqTB1();
	void createCloseBefProfitInqTB2();
	void createCloseBefProfitInqTB3();
	
	void deleteCloseBefProfitInqI01();
	void deleteCloseBefProfitInqI01L();
	void deleteCloseBefProfitInqI02();
	void deleteCloseBefProfitInqI02L();
	void deleteCloseBefProfitInqTB1();
	void deleteCloseBefProfitInqTB2();
	void deleteCloseBefProfitInqTB3();
	
	Integer selectCloseBefProfitInqMchk(CloseBefProfitInqParamModel request);
	
	void insertCloseBefProfitInqI01(CloseBefProfitInqParamModel request);	
	void insertCloseBefProfitInqI01L(CloseBefProfitInqParamModel request);
	void insertCloseBefProfitInqI02(CloseBefProfitInqParamModel request);	
	void insertCloseBefProfitInqI02L(CloseBefProfitInqParamModel request);		
	
	void updateCloseBefProfitInq21();
	void updateCloseBefProfitInq22();	
	
	void insertCloseBefProfitInq31(CloseBefProfitInqParamModel request);
	void insertCloseBefProfitInq32(CloseBefProfitInqParamModel request);
	void insertCloseBefProfitInq33(CloseBefProfitInqParamModel request);
	
	Integer insertCloseBefProfitInq41(CloseBefProfitInqParamModel request);
	Integer insertCloseBefProfitInq42(CloseBefProfitInqParamModel request);


	List<CloseBefProfitInqModel> selectCloseBefProfitInqListLvJum(CloseBefProfitInqParamModel request);
	List<CloseBefProfitInqModel> selectCloseBefProfitInqListLvBu(CloseBefProfitInqParamModel request);
	List<CloseBefProfitInqModel> selectCloseBefProfitInqListLvTim(CloseBefProfitInqParamModel request);
	List<CloseBefProfitInqModel> selectCloseBefProfitInqListLvPc(CloseBefProfitInqParamModel request);
	
	List<CloseBefProfitInqModel> selectCloseBefProfitInqList1(CloseBefProfitInqParamModel request);
	List<CloseBefProfitInqModel> selectCloseBefProfitInqList2(CloseBefProfitInqParamModel request);
}