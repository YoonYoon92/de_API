package com.saydept.api.spf.saleNews.newBrandSaleInq;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.saleNews.newBrandSaleInq.model.NewBrandSaleInqModel;
import com.saydept.api.spf.saleNews.newBrandSaleInq.model.NewBrandSaleInqParamModel;

@Mapper
public interface NewBrandSaleInqMapper {


	List<NewBrandSaleInqModel> selectNewBrandSaleInqList(NewBrandSaleInqParamModel request);


}