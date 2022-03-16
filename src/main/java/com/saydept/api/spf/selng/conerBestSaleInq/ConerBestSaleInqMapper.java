package com.saydept.api.spf.selng.conerBestSaleInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.selng.conerBestSaleInq.model.ConerBestSaleInqModel;
import com.saydept.api.spf.selng.conerBestSaleInq.model.ConerBestSaleInqParamModel;

@Mapper
public interface ConerBestSaleInqMapper {

	ConerBestSaleInqModel selectConerBestSaleInq(ConerBestSaleInqParamModel request);

	List<ConerBestSaleInqModel> selectConerBestSaleInqList(ConerBestSaleInqParamModel request);

	int updateConerBestSaleInq(ConerBestSaleInqParamModel request);

	int insertConerBestSaleInq(ConerBestSaleInqParamModel request);

	int saveConerBestSaleInq(ConerBestSaleInqParamModel request);

	int deleteConerBestSaleInq(ConerBestSaleInqParamModel request);
	
	void createConerBestSaleInqTempTable1();
	
	void createConerBestSaleInqTempTable2();
	
	void createConerBestSaleInqTempTable3();

	void insertConerBestSaleInqTempTable11(ConerBestSaleInqParamModel request);
	
	void insertConerBestSaleInqTempTable12(ConerBestSaleInqParamModel request);
	
	void insertConerBestSaleInqTempTable13(ConerBestSaleInqParamModel request);
	
	void insertConerBestSaleInqTempTable14(ConerBestSaleInqParamModel request);
	
	void insertConerBestSaleInqTempTable15(ConerBestSaleInqParamModel request);
	
	void insertConerBestSaleInqTempTable21(ConerBestSaleInqParamModel request);
	
	void insertConerBestSaleInqTempTable22(ConerBestSaleInqParamModel request);
	
	void insertConerBestSaleInqTempTable23(ConerBestSaleInqParamModel request);
	
	void insertConerBestSaleInqTempTable24(ConerBestSaleInqParamModel request);
	
	void insertConerBestSaleInqTempTable25(ConerBestSaleInqParamModel request);
	
	void insertConerBestSaleInqTempTable31(ConerBestSaleInqParamModel request);
}