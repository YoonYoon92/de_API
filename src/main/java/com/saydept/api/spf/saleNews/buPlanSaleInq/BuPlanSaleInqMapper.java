package com.saydept.api.spf.saleNews.buPlanSaleInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.saleNews.buPlanSaleInq.model.BuPlanSaleInqModel;
import com.saydept.api.spf.saleNews.buPlanSaleInq.model.BuPlanSaleInqParamModel;

@Mapper
public interface BuPlanSaleInqMapper {


	List<BuPlanSaleInqModel> selectBuPlanSaleInqList(BuPlanSaleInqParamModel request);


}