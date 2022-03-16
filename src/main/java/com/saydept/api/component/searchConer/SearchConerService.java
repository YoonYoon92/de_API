package com.saydept.api.component.searchConer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.saydept.api.component.searchConer.model.SearchConerModel;
import com.saydept.api.component.searchConer.model.SearchConerParamModel;

	@Service
	public class SearchConerService {

	@Autowired
	private SearchConerMapper searchConerMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<SearchConerModel> selectSearchConer(SearchConerParamModel request)throws Exception {
		System.out.println(request);
		List<SearchConerModel> result = searchConerMapper.selectSearchConer(request);
		return result;

	}

}