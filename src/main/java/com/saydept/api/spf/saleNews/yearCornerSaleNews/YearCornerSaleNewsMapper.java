package com.saydept.api.spf.saleNews.yearCornerSaleNews;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.saleNews.yearCornerSaleNews.model.YearCornerSaleNewsParamModel;
import com.saydept.api.spf.saleNews.yearCornerSaleNews.model.YearCornerSaleNewsModel;

@Mapper
public interface YearCornerSaleNewsMapper {

	YearCornerSaleNewsModel selectYearCornerSaleNews(YearCornerSaleNewsParamModel request);

	List<YearCornerSaleNewsModel> selectYearCornerSaleNewsListCorner(YearCornerSaleNewsParamModel request);
	
	List<YearCornerSaleNewsModel> selectYearCornerSaleNewsList(YearCornerSaleNewsParamModel request);
	

	int updateYearCornerSaleNews(YearCornerSaleNewsParamModel request);

	int insertYearCornerSaleNews(YearCornerSaleNewsParamModel request);

	int saveYearCornerSaleNews(YearCornerSaleNewsParamModel request);

	int deleteYearCornerSaleNews(YearCornerSaleNewsParamModel request);

}