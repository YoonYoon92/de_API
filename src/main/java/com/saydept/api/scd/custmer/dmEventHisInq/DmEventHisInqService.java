package com.saydept.api.scd.custmer.dmEventHisInq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.scd.custmer.dmEventHisInq.model.DmEventHisInqModel;
import com.saydept.api.scd.custmer.dmEventHisInq.model.DmEventHisInqParamModel;
import com.saydept.api.scd.custmer.dmEventHisInq.model.DmEventHisInqT03Model;
import com.saydept.api.scd.custmer.dmEventHisInq.model.DmEventHisInqT04Model;

	@Service
	public class DmEventHisInqService {

	@Autowired
	private DmEventHisInqMapper dmEventHisInqMapper;
	

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<DmEventHisInqModel> selectDmEventHisInqList(DmEventHisInqParamModel request)throws Exception {

		List<DmEventHisInqModel> result = dmEventHisInqMapper.selectDmEventHisInqList(request);
		return result;

	}
	
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public DmEventHisInqModel selectDmEventHisInqT04Count(DmEventHisInqParamModel request)throws Exception {

		DmEventHisInqModel result = dmEventHisInqMapper.selectDmEventHisInqT04Count(request);
		return result;

	}
		
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateDmEventT02End(DmEventHisInqParamModel request)throws Exception {

		int result = dmEventHisInqMapper.updateDmEventT02End(request);
		return result;

	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateDmEventT02ReWork(DmEventHisInqParamModel request)throws Exception {

		int result = dmEventHisInqMapper.updateDmEventT02ReWork(request);
		return result;

	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateDmEventT02XWork(DmEventHisInqParamModel request)throws Exception {

		int result = dmEventHisInqMapper.updateDmEventT02XWork(request);
		return result;

	}	
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateDmEventT02Init(DmEventHisInqParamModel request)throws Exception {

		int result = dmEventHisInqMapper.updateDmEventT02Init(request);
		return result;

	}	

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateDmEventT02SendCnt(DmEventHisInqParamModel request)throws Exception {

		int result = dmEventHisInqMapper.updateDmEventT02SendCnt(request);
		return result;

	}	
	
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteDmEventT04Init(DmEventHisInqParamModel request) {

		int result = dmEventHisInqMapper.deleteDmEventT04Init(request);
		return result;

	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteDmEventT05Init(DmEventHisInqParamModel request) {

		int result = dmEventHisInqMapper.deleteDmEventT05Init(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteDmEventT04DelUp(DmEventHisInqParamModel request) {

		int result = dmEventHisInqMapper.deleteDmEventT04DelUp(request);
		return result;

	}
	

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteDmEventT04DelDown(DmEventHisInqParamModel request) {

		int result = dmEventHisInqMapper.deleteDmEventT04DelDown(request);
		return result;

	}
	
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<DmEventHisInqT03Model> selectDmEventHisInqT03(DmEventHisInqParamModel request)throws Exception {

		List<DmEventHisInqT03Model> result = dmEventHisInqMapper.selectDmEventHisInqT03(request);
		return result;

	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<DmEventHisInqT03Model> selectDmEventHisInqT04MaxMin(DmEventHisInqParamModel request)throws Exception {

		List<DmEventHisInqT03Model> result = dmEventHisInqMapper.selectDmEventHisInqT04MaxMin(request);
		return result;

	}
	
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<DmEventHisInqT04Model> selectDmEventHisInqT04CrtPson(DmEventHisInqParamModel request)throws Exception {

		List<DmEventHisInqT04Model> result = dmEventHisInqMapper.selectDmEventHisInqT04CrtPson(request);
		return result;

	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public DmEventHisInqModel selectDmEventHisInqT02(DmEventHisInqParamModel request)throws Exception {

		DmEventHisInqModel result = dmEventHisInqMapper.selectDmEventHisInqT02(request);
		return result;

	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public DmEventHisInqModel selectDmEventHisInqM12(DmEventHisInqParamModel request)throws Exception {

		DmEventHisInqModel result = dmEventHisInqMapper.selectDmEventHisInqM12(request);
		return result;

	}

}