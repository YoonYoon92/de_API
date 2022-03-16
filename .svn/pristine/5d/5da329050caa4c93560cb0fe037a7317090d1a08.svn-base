package com.saydept.api.Template.tamplate1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.Template.tamplate1.model.Tamplate1Model;
import com.saydept.api.comm.model.SearchModel;

	@Service
	public class Tamplate1Service {

	@Autowired
	private Tamplate1Mapper tamplate1Mapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Tamplate1Model selectTamplate1(Tamplate1Model request)throws Exception {

		Tamplate1Model result = tamplate1Mapper.selectTamplate1(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Tamplate1Model> selectTamplate1List(SearchModel request)throws Exception {

		List<Tamplate1Model> result = tamplate1Mapper.selectTamplate1List(request);
		return result;

	}
	
	public List<Tamplate1Model> selectTamplate1List2(SearchModel request) {

		List<Tamplate1Model> result = tamplate1Mapper.selectTamplate1List2(request);
		return result;
	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateTamplate1(Tamplate1Model request)throws Exception {

		int result = tamplate1Mapper.updateTamplate1(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int insertTamplate1(Tamplate1Model request) {

		int result = tamplate1Mapper.insertTamplate1(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int saveTamplate1(Tamplate1Model request) {

		int result = tamplate1Mapper.saveTamplate1(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteTamplate1(Tamplate1Model request) {

		int result = tamplate1Mapper.deleteTamplate1(request);
		return result;

	}

}