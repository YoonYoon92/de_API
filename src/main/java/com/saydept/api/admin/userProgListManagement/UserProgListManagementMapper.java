package com.saydept.api.admin.userProgListManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

//import com.saydept.api.comm.notice.model.NoticeModel;
//import com.saydept.api.spf.org.buManagement.model.BuManagementModel;
//import com.saydept.api.comm.notice.model.NoticeModel;
//import com.saydept.api.comm.notice.model.NoticeSaveModel;
import com.saydept.api.admin.userProgListManagement.model.UserProgListManagementModel;
import com.saydept.api.admin.userProgListManagement.model.UserProgListManagementSaveModel;

@Mapper
public interface UserProgListManagementMapper {

	UserProgListManagementSaveModel selectUserProgListManagement(UserProgListManagementSaveModel request);
	List<UserProgListManagementModel> selectPgmList(UserProgListManagementModel request);
	List<UserProgListManagementModel> selectMenuGroupIdList(UserProgListManagementModel request);
	List<UserProgListManagementModel> selectMenuIdList(UserProgListManagementModel request);
	int updateUserProgListManagement(UserProgListManagementSaveModel request);
	int insertUserProgListManagement(UserProgListManagementSaveModel request);
	int insertUserProgListManagement1(UserProgListManagementSaveModel request);
	int saveUserProgListManagement(UserProgListManagementSaveModel request);
	
	
	//	int selectUserProgListManagement(UserProgListManagementSaveModel request);
	//	List<UserProgListManagementModel> selectUserProgListManagementList(UserProgListManagementSaveModel request);
	//	List<UserProgListManagementModel> selectClsList(UserProgListManagementModel request);
	//	List<UserProgListManagementModel> selectCls2List(UserProgListManagementModel request);
	//	int updateUserProgListManagement(UserProgListManagementModel request);
	//	int saveUserProgListManagement2(UserProgListManagementSaveModel request);

	
}