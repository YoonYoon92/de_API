package com.saydept.api.comm.pwdChg;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.comm.pwdChg.model.PwdChgModel;

	@Service
	public class PwdChgService {

	@Autowired
	private PwdChgMapper pwdChgMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int selectPwdChg(PwdChgModel request)throws Exception {

	int result = pwdChgMapper.selectPwdChg(request);
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PwdChgModel> selectPwdChgList(PwdChgModel request)throws Exception {

		List<PwdChgModel> result = pwdChgMapper.selectPwdChgList(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updatePwdChg(PwdChgModel request)throws Exception {

		int result = pwdChgMapper.updatePwdChg(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int insertPwdChg(PwdChgModel request) {

		int result = pwdChgMapper.insertPwdChg(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int savePwdChg(PwdChgModel request) {

		int result = pwdChgMapper.savePwdChg(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deletePwdChg(PwdChgModel request) {

		int result = pwdChgMapper.deletePwdChg(request);
		return result;

	}

}