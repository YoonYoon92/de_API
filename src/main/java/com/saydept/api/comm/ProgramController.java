package com.saydept.api.comm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.comm.model.ProgModel;
import com.saydept.api.comm.model.AccountModel;
import com.saydept.api.comm.model.UserProgModel;

@CrossOrigin(origins = "*")
@RestController
public class ProgramController {

	@Autowired
	private ProgramService programService;
	
	/**
	 * API 상태체크
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "api/program", method = RequestMethod.GET)
	public String condition() throws ParseException {
		
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	/**
	 * 프로그램 hit count
	 * @param request
	 * @return
	 * @throws Exception
	 */
//	@RequestMapping(value = "api/program/updateHitCount", method = RequestMethod.POST)
//	public ProgModel updateHitCount(@RequestBody ProgModel request)throws Exception {
//		
//		
//		
//		return request;
//	}
	 @RequestMapping(value = "api/program/updateHitCount", method = RequestMethod.POST)
	   public int updateHitCount(@RequestBody ProgModel request)throws Exception {
	          
	      return programService.updateHitCount(request);
	   }
	/**
	 * 프로그램 목록
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/program/selectUserEnvProgList", method = RequestMethod.POST)
	public List<ProgModel> selectCommEnvProgList(@RequestBody AccountModel request)throws Exception {
		
		ProgModel rootMenu = new ProgModel();
		rootMenu.setId("00");
		programService.selectEnvProgList(rootMenu);
		
		return rootMenu.getChildren();
	}
	
	
	/**
	 * 프로그램 목록
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/program/selectCommProgList", method = RequestMethod.POST)
	public List<ProgModel> selectCommProgList(@RequestBody AccountModel request)throws Exception {
		
		ProgModel rootMenu = new ProgModel();
		rootMenu.setId("00");
		programService.selectProgList(rootMenu);
		
		return rootMenu.getChildren();
	}
	
	
	/**
	 * 프로그램 목록 - Admin
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/program/selectAdminProgList", method = RequestMethod.POST)
	public List<ProgModel> selectAdminProgList(@RequestBody AccountModel request)throws Exception {
		
		
		ProgModel rootMenu = new ProgModel();
		rootMenu.setUserId(request.getUserId());
		rootMenu.setId("00");
		programService.selectAdminProgList(rootMenu);
		
		return rootMenu.getChildren();
	}
	
	/**
	 * 프로그램 목록 - Admin
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/program/saveAdminProgList", method = RequestMethod.POST)
	public void saveAdminProgList(@RequestBody List<UserProgModel> request)throws Exception {
		
		programService.saveAdminProgList(request);		
	}
	
	/**
	 * 프로그램 목록 - User
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/program/selectUserProgList", method = RequestMethod.POST)
	public List<ProgModel> selectUserProgList(@RequestBody AccountModel request)throws Exception {
		
		ProgModel rootMenu = new ProgModel();
		rootMenu.setUserId(request.getUserId());
		rootMenu.setId("00");
		programService.selectUserProgList(rootMenu);
		
		programService.selectUserLastProgList(rootMenu);
		
		return rootMenu.getChildren();
	}
	

}