package com.saydept.api.Template.tamplate1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.Template.tamplate1.model.Tamplate1Model;
import com.saydept.api.comm.model.SearchModel;

@Mapper
public interface Tamplate1Mapper {

	Tamplate1Model selectTamplate1(Tamplate1Model request);

	List<Tamplate1Model> selectTamplate1List(SearchModel request);

	int updateTamplate1(Tamplate1Model request);

	int insertTamplate1(Tamplate1Model request);

	int saveTamplate1(Tamplate1Model request);

	int deleteTamplate1(Tamplate1Model request);

	List<Tamplate1Model> selectTamplate1List2(SearchModel request);

}