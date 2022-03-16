package com.saydept.api.spf.org.timManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.comm.notice.model.NoticeModel;
//import com.saydept.api.comm.notice.model.NoticeModel;
//import com.saydept.api.comm.notice.model.NoticeSaveModel;
import com.saydept.api.spf.org.timManagement.model.TimManagementModel;
import com.saydept.api.spf.org.timManagement.model.TimManagementSaveModel;

@Mapper
public interface TimManagementMapper {

	TimManagementSaveModel selectTimManagement(TimManagementSaveModel request);
	List<TimManagementModel> selectBuList(TimManagementModel request);
	List<TimManagementModel> selectTimList(TimManagementModel request);
	int updateTimManagement(TimManagementSaveModel request);
	int insertTimManagement(TimManagementSaveModel request);
	
	//	int selectTimManagement(TimManagementSaveModel request);
	//	List<TimManagementModel> selectTimManagementList(TimManagementSaveModel request);
	//	List<TimManagementModel> selectClsList(TimManagementModel request);
	//	List<TimManagementModel> selectCls2List(TimManagementModel request);
	//	int updateTimManagement(TimManagementModel request);
	//	int saveTimManagement2(TimManagementSaveModel request);

	
}