package com.saydept.api.comm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.comm.model.CommModel;
import com.saydept.api.comm.model.ProgModel;
import com.saydept.api.comm.model.StoreModel;
import com.saydept.api.comm.model.UserProgModel;

@Service
public class ProgramService {

	@Autowired
	private ProgramMapper programMapper;

	//프로그램 목록
	public void selectEnvProgList(ProgModel request) {
		// TODO Auto-generated method stub
		
//		List<ProgModel> menuLvList = new ArrayList<ProgModel>();
//		ProgModel progModel = new ProgModel();
//		//progModel.set
//		
//		menuLvList.add(progModel);
//
//		request.setChildren(menuLvList);
	
		List<ProgModel> menuLvList = programMapper.selectEnvMenuList(request);
		for( ProgModel menuLv :  menuLvList) {
			selectProgList(menuLv);
			System.out.println(menuLv);
		}
		List<ProgModel> progLvList = programMapper.selectProgList(request);

		menuLvList.addAll(progLvList);

		request.setChildren(menuLvList);
		
	}
	
	//프로그램 목록
		public void selectProgList(ProgModel request) {
			// TODO Auto-generated method stub
			System.out.println("★★★★★★★★★★★★★");
			System.out.println(request);
			List<ProgModel> menuLvList = programMapper.selectMenuList(request);
			
			for( ProgModel menuLv :  menuLvList) {
				selectProgList(menuLv);
				System.out.println(menuLv);
			}
			List<ProgModel> progLvList = programMapper.selectProgList(request);
			
			
			
		
			menuLvList.addAll(progLvList);
			
			request.setChildren(menuLvList);
			
		}
	
	//프로그램 목록 -- Admin
	public void selectAdminProgList(ProgModel request) {
		// TODO Auto-generated method stub

		List<ProgModel> menuLvList = programMapper.selectAdminMenuList(request);
		
		for( ProgModel menuLv :  menuLvList) {
			menuLv.setUserId(request.getUserId());
			selectAdminProgList(menuLv);
		}
		
		List<ProgModel> progLvList = programMapper.selectAdminProgList(request);
		System.out.println(request);
		menuLvList.addAll(progLvList);

		request.setChildren(menuLvList);
	}
	
	//프로그램 목록 저장 -- Admin
	public void saveAdminProgList(List<UserProgModel> request) {
		// TODO Auto-generated method stub
		
		for( UserProgModel model :  request) {
			try {
				programMapper.insertAdminProgList(model);
			} catch(Exception e) {
				programMapper.updateAdminProgList(model);
			} 			
		}
	}
	
	//프로그램 목록 -- User
	public void selectUserProgList(ProgModel request) {
		// TODO Auto-generated method stub

		List<ProgModel> menuLvList = programMapper.selectUserMenuList(request);
		for( ProgModel menuLv :  menuLvList) {
			//System.out.println(request.getUserId());
			menuLv.setUserId(request.getUserId());
			selectUserProgList(menuLv);
		}
		
		List<ProgModel> progLvList = programMapper.selectUserProgList(request);
		for( ProgModel progLv :  progLvList) {
			//System.out.println(request.getUserId());
			progLv.setUserId(request.getUserId());
			selectUserProgList(progLv);
		}
		
		menuLvList.addAll(progLvList);

		request.setChildren(menuLvList);		
	}	
	public void selectUserLastProgList(ProgModel request) {
		ProgModel progModel = new ProgModel();	
		progModel.setLeaf(false);
		progModel.setIconCls("x-fa fa-compass");
		progModel.setChecked(false);
		progModel.setUserId(request.getUserId());
		progModel.setId("123");
		progModel.setName("최근 사용 APP");
		//화면에표시되는 이름
		progModel.setText("최근 사용 APP");
	
		
		List<ProgModel> menuLvList = programMapper.selectUserLastMenuList(progModel);
		progModel.setChildren(menuLvList);
		
		request.getChildren().add(0, progModel);
	}	
	
	
	public int updateHitCount(ProgModel request) {

		System.out.println(request);
		int result = 0;
		
		try {
			result += programMapper.UpdateHitCount1(request);
			if (result==0) {
							throw new Exception();
							}
			}
		
		catch (Exception e )
			{
			System.out.println("--------------------------------------------");
			result += programMapper.UpdateHitCount2(request);			
			}
		
	
		
		return result;
	}


}