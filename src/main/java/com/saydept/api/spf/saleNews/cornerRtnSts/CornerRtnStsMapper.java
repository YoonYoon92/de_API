package com.saydept.api.spf.saleNews.cornerRtnSts;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.saleNews.cornerRtnSts.model.CornerRtnStsModel;
import com.saydept.api.spf.saleNews.cornerRtnSts.model.CornerRtnStsParamModel;

@Mapper
public interface CornerRtnStsMapper {

	List<CornerRtnStsModel> selectCornerRtnStsList(CornerRtnStsParamModel request);


}