package com.saydept.api.component.searchConer;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.saydept.api.component.searchConer.model.SearchConerModel;
import com.saydept.api.component.searchConer.model.SearchConerParamModel;

@Mapper
public interface SearchConerMapper {

	List<SearchConerModel> selectSearchConer(SearchConerParamModel request);

}