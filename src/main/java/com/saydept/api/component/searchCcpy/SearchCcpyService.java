package com.saydept.api.component.searchCcpy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.component.searchCcpy.model.SearchCcpyModel;
import com.saydept.api.component.searchCcpy.model.SearchCcpyParamModel;

	@Service
	public class SearchCcpyService {

	@Autowired
	private SearchCcpyMapper searchCcpyMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<SearchCcpyModel> selectSearchCcpy(SearchCcpyParamModel request)throws Exception {

		List<SearchCcpyModel> result = searchCcpyMapper.selectSearchCcpy(request);
		return result;

	}

}