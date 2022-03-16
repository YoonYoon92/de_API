package com.saydept.api.component.searchClass;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.component.searchClass.model.SearchClassModel;
import com.saydept.api.component.searchClass.model.SearchClassParamModel;

@Mapper
public interface SearchClassMapper {

	List<SearchClassModel> selectSearchClass(SearchClassParamModel request);

}