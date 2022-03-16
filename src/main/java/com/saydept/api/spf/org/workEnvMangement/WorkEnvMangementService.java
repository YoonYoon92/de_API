package com.saydept.api.spf.org.workEnvMangement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.org.workEnvMangement.model.WorkEnvMangementModel;

	@Service
	public class WorkEnvMangementService {

	@Autowired
	private WorkEnvMangementMapper workEnvMangementMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public WorkEnvMangementModel selectWorkEnvMangement(WorkEnvMangementModel request)throws Exception {
		System.out.println(request);
		WorkEnvMangementModel result = workEnvMangementMapper.selectWorkEnvMangement(request);
		System.out.println(result);
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<WorkEnvMangementModel> selectWorkEnvMangementList(WorkEnvMangementModel request)throws Exception {

		List<WorkEnvMangementModel> result = workEnvMangementMapper.selectWorkEnvMangementList(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateWorkEnvMangement(WorkEnvMangementModel request)throws Exception {

		int result = workEnvMangementMapper.updateWorkEnvMangement(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int insertWorkEnvMangement(WorkEnvMangementModel request) {

		int result = workEnvMangementMapper.insertWorkEnvMangement(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int saveWorkEnvMangement(WorkEnvMangementModel request) {
		System.out.println(request);
		int result=0;
		//int result = workEnvMangementMapper.saveWorkEnvMangement(request);
		try {
			result = workEnvMangementMapper.updateWorkEnvMangement(request);
			if (result==0) {
							throw new Exception();
							}
			}
		
		catch (Exception e )
			{
			System.out.println("--------------------------------------------");
			result = workEnvMangementMapper.insertWorkEnvMangement(request);	
			result =2;
			}
		System.out.println(result);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteWorkEnvMangement(WorkEnvMangementModel request) {
		System.out.println(request);
		int result = workEnvMangementMapper.deleteWorkEnvMangement(request);
		System.out.println(result);
		return result;

	}

}