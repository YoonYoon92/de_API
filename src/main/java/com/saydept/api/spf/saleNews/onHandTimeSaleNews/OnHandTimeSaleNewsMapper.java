package com.saydept.api.spf.saleNews.onHandTimeSaleNews;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.saleNews.onHandTimeSaleNews.model.OnHandTimeSaleNewsModel;
import com.saydept.api.spf.saleNews.onHandTimeSaleNews.model.OnHandTimeSaleNewsParamModel;
import com.saydept.api.spf.saleNews.onHandTimeSaleNews.model.OnHandTimeSaleNewsTotalModel;

@Mapper
public interface OnHandTimeSaleNewsMapper {

	OnHandTimeSaleNewsTotalModel selectOnHandTimeSaleNews(OnHandTimeSaleNewsParamModel request);

	List<OnHandTimeSaleNewsModel> selectOnHandTimeSaleNewsList(OnHandTimeSaleNewsParamModel request);

}