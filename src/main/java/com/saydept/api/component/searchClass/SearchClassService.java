package com.saydept.api.component.searchClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.component.searchClass.model.SearchClassModel;
import com.saydept.api.component.searchClass.model.SearchClassParamModel;

	@Service
	public class SearchClassService {

	@Autowired
	private SearchClassMapper searchClassMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<SearchClassModel> selectSearchClass(SearchClassParamModel request)throws Exception {

		List<SearchClassModel> result = searchClassMapper.selectSearchClass(request);
		return result;

	}

}