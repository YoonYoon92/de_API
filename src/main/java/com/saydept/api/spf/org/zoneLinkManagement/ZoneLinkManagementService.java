package com.saydept.api.spf.org.zoneLinkManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.org.conerLinkManagement.model.ConerLinkManagementModel;
import com.saydept.api.spf.org.zoneLinkManagement.model.ZoneLinkManagementModel;

	@Service
	public class ZoneLinkManagementService {

	@Autowired
	private ZoneLinkManagementMapper ZoneLinkManagementMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public ZoneLinkManagementModel selectZoneLinkManagement(ZoneLinkManagementModel request)throws Exception {

	ZoneLinkManagementModel result = ZoneLinkManagementMapper.selectZoneLinkManagement(request);
	System.out.println("************************************");
	System.out.println(result);
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<ZoneLinkManagementModel> selectZoneLinkManagementList(ZoneLinkManagementModel request)throws Exception {
		System.out.println(request);
		List<ZoneLinkManagementModel> result = ZoneLinkManagementMapper.selectZoneLinkManagementList(request);
		System.out.println(result);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateZoneLinkManagement(ZoneLinkManagementModel request)throws Exception {

		int result = ZoneLinkManagementMapper.updateZoneLinkManagement(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int insertZoneLinkManagement(ZoneLinkManagementModel request) {
		System.out.println("insert#########################");
		System.out.println(request);
		int result = 0;
		try {
			result +=ZoneLinkManagementMapper.insertZoneLinkManagement(request);
			if (result==0) {
							throw new Exception();
							}
			}
		
		catch (Exception e )
			{
			System.out.println("--------------------------------------------");
			result += 0;			
			}
		
		
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int saveZoneLinkManagement(ZoneLinkManagementModel request) {

		int result = ZoneLinkManagementMapper.saveZoneLinkManagement(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteZoneLinkManagement(ZoneLinkManagementModel request) {
		System.out.println(request);
		int result = ZoneLinkManagementMapper.deleteZoneLinkManagement(request);
		System.out.println(result);
		return result;

	}
	//존목록조회
	public List<ZoneLinkManagementModel> selectzoneStoreList(ZoneLinkManagementModel request)throws Exception {
		System.out.println(request);
		List<ZoneLinkManagementModel> result = ZoneLinkManagementMapper.selectzoneStoreList(request);
		System.out.println(result);
		return result;

	}
	
	public ZoneLinkManagementModel selectConerchk(ZoneLinkManagementModel request)throws Exception {

	ZoneLinkManagementModel result = ZoneLinkManagementMapper.selectConerchk(request);
	return result;

	}
}