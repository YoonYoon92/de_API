package com.saydept.api.app.appSayResign;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.app.appSayResign.model.AppSayResignModel;

	@Service
	public class AppSayResignService {

	@Autowired
	private AppSayResignMapper appSayResignMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public AppSayResignModel selectAppSayResign(AppSayResignModel request)throws Exception {

	AppSayResignModel result = appSayResignMapper.selectAppSayResign(request);
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<AppSayResignModel> selectAppSayResignList(AppSayResignModel request)throws Exception {

		List<AppSayResignModel> result = appSayResignMapper.selectAppSayResignList(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateAppSayResign(AppSayResignModel request)throws Exception {

		int result = appSayResignMapper.updateAppSayResign(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int insertAppSayResign(AppSayResignModel request) {

		int result = appSayResignMapper.insertAppSayResign(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int saveAppSayResign(AppSayResignModel request) {

		int result = appSayResignMapper.saveAppSayResign(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteAppSayResign(AppSayResignModel request) {

		int result = appSayResignMapper.deleteAppSayResign(request);
		return result;

	}

}