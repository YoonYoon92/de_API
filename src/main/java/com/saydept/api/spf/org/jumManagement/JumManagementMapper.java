package com.saydept.api.spf.org.jumManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

//import com.saydept.api.comm.notice.model.NoticeModel;
//import com.saydept.api.spf.org.buManagement.model.BuManagementModel;
//import com.saydept.api.comm.notice.model.NoticeModel;
//import com.saydept.api.comm.notice.model.NoticeSaveModel;
import com.saydept.api.spf.org.jumManagement.model.JumManagementModel;
import com.saydept.api.spf.org.jumManagement.model.JumManagementSaveModel;

@Mapper
public interface JumManagementMapper {

	JumManagementSaveModel selectJumManagement(JumManagementSaveModel request);
	List<JumManagementModel> selectJumList(JumManagementModel request);
	int updateJumManagement(JumManagementSaveModel request);
	int insertJumManagement(JumManagementSaveModel request);
	int saveJumManagement(JumManagementSaveModel request);
	
	//	int selectJumManagement(JumManagementSaveModel request);
	//	List<JumManagementModel> selectJumManagementList(JumManagementSaveModel request);
	//	List<JumManagementModel> selectClsList(JumManagementModel request);
	//	List<JumManagementModel> selectCls2List(JumManagementModel request);
	//	int updateJumManagement(JumManagementModel request);
	//	int saveJumManagement2(JumManagementSaveModel request);

	
}