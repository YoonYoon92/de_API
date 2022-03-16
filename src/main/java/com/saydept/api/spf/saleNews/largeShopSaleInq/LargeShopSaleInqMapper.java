package com.saydept.api.spf.saleNews.largeShopSaleInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.saleNews.largeShopSaleInq.model.LargeShopSaleInqModel;

@Mapper
public interface LargeShopSaleInqMapper {


	List<LargeShopSaleInqModel> selectLargeShopSaleInqList(LargeShopSaleInqModel request);

	
}