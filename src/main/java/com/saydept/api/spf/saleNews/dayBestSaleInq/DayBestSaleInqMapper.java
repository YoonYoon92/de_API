package com.saydept.api.spf.saleNews.dayBestSaleInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.saleNews.dayBestSaleInq.model.DayBestSaleInqModel;
import com.saydept.api.spf.saleNews.dayBestSaleInq.model.DayBestSaleInqParamModel;

@Mapper
public interface DayBestSaleInqMapper {

	DayBestSaleInqModel selectDayBestSaleInq(DayBestSaleInqModel request);

	List<DayBestSaleInqModel> selectDayBestSaleInqListLv1(DayBestSaleInqParamModel request);
	
	List<DayBestSaleInqModel> selectDayBestSaleInqListLv1Today(DayBestSaleInqParamModel request);
	
	List<DayBestSaleInqModel> selectDayBestSaleInqListLv2(DayBestSaleInqParamModel request);
	
	List<DayBestSaleInqModel> selectDayBestSaleInqListLv2Today(DayBestSaleInqParamModel request);
	
	List<DayBestSaleInqModel> selectDayBestSaleInqListLv3(DayBestSaleInqParamModel request);
	
	List<DayBestSaleInqModel> selectDayBestSaleInqListLv3Today(DayBestSaleInqParamModel request);


	int updateDayBestSaleInq(DayBestSaleInqModel request);

	int insertDayBestSaleInq(DayBestSaleInqModel request);

	int saveDayBestSaleInq(DayBestSaleInqModel request);

	int deleteDayBestSaleInq(DayBestSaleInqModel request);

}