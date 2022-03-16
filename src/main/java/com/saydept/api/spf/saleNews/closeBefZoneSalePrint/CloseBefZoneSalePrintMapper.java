package com.saydept.api.spf.saleNews.closeBefZoneSalePrint;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.saleNews.closeBefZoneSalePrint.model.CloseBefZoneSalePrintModel;
import com.saydept.api.spf.saleNews.closeBefZoneSalePrint.model.CloseBefZoneSalePrintParamModel;

@Mapper
public interface CloseBefZoneSalePrintMapper {
	
	void createCloseBefZoneSalePrintI01();
	void createCloseBefZoneSalePrintI01L();
	void createCloseBefZoneSalePrintI02();
	void createCloseBefZoneSalePrintI02L();
	void createCloseBefZoneSalePrintTB1();
	void createCloseBefZoneSalePrintTB2();
	void createCloseBefZoneSalePrintTB3();
	
	void deleteCloseBefZoneSalePrintI01();
	void deleteCloseBefZoneSalePrintI01L();
	void deleteCloseBefZoneSalePrintI02();
	void deleteCloseBefZoneSalePrintI02L();
	void deleteCloseBefZoneSalePrintTB1();
	void deleteCloseBefZoneSalePrintTB2();
	void deleteCloseBefZoneSalePrintTB3();
	
	Integer selectCloseBefZoneSalePrintMchk(CloseBefZoneSalePrintParamModel request);
	
	void insertCloseBefZoneSalePrintI01(CloseBefZoneSalePrintParamModel request);	
	void insertCloseBefZoneSalePrintI01L(CloseBefZoneSalePrintParamModel request);
	void insertCloseBefZoneSalePrintI02(CloseBefZoneSalePrintParamModel request);	
	void insertCloseBefZoneSalePrintI02L(CloseBefZoneSalePrintParamModel request);		
	
	void updateCloseBefZoneSalePrint21();
	void updateCloseBefZoneSalePrint22();	
	
	void insertCloseBefZoneSalePrint31(CloseBefZoneSalePrintParamModel request);
	void insertCloseBefZoneSalePrint32(CloseBefZoneSalePrintParamModel request);
//	void insertCloseBefZoneSalePrint33(CloseBefZoneSalePrintParamModel request);
	
	Integer insertCloseBefZoneSalePrint41(CloseBefZoneSalePrintParamModel request);
	Integer insertCloseBefZoneSalePrint42(CloseBefZoneSalePrintParamModel request);


	List<CloseBefZoneSalePrintModel> selectCloseBefZoneSalePrintListLvJum(CloseBefZoneSalePrintParamModel request);
	List<CloseBefZoneSalePrintModel> selectCloseBefZoneSalePrintListLvBu(CloseBefZoneSalePrintParamModel request);
	List<CloseBefZoneSalePrintModel> selectCloseBefZoneSalePrintListLvTim(CloseBefZoneSalePrintParamModel request);
	List<CloseBefZoneSalePrintModel> selectCloseBefZoneSalePrintListLvPc(CloseBefZoneSalePrintParamModel request);
	
	List<CloseBefZoneSalePrintModel> selectCloseBefZoneSalePrintList1(CloseBefZoneSalePrintParamModel request);
	List<CloseBefZoneSalePrintModel> selectCloseBefZoneSalePrintList2(CloseBefZoneSalePrintParamModel request);
}