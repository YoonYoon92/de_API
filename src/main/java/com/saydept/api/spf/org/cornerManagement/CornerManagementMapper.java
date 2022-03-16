package com.saydept.api.spf.org.cornerManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.comm.notice.model.NoticeModel;
//import com.saydept.api.comm.notice.model.NoticeModel;
//import com.saydept.api.comm.notice.model.NoticeSaveModel;
import com.saydept.api.spf.org.cornerManagement.model.CornerManagementModel;
import com.saydept.api.spf.org.cornerManagement.model.CornerManagementSaveModel;

@Mapper
public interface CornerManagementMapper {

	CornerManagementSaveModel selectCornerManagement(CornerManagementSaveModel request);
	List<CornerManagementModel> selectCornerList(CornerManagementModel request);
//	int updateCornerManagement(CornerManagementSaveModel request);
//	int insertCornerManagement(CornerManagementSaveModel request);
	
	//	int selectCornerManagement(CornerManagementSaveModel request);
	//	List<CornerManagementModel> selectCornerManagementList(CornerManagementSaveModel request);
	//	List<CornerManagementModel> selectClsList(CornerManagementModel request);
	//	List<CornerManagementModel> selectCls2List(CornerManagementModel request);
	//	int updateCornerManagement(CornerManagementModel request);
	//	int saveCornerManagement2(CornerManagementSaveModel request);

	
}