package com.saydept.api.component.searchCcpy;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.component.searchCcpy.model.SearchCcpyModel;
import com.saydept.api.component.searchCcpy.model.SearchCcpyParamModel;

@Mapper
public interface SearchCcpyMapper {

	List<SearchCcpyModel> selectSearchCcpy(SearchCcpyParamModel request);

}