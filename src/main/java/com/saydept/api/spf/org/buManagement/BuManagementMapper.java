package com.saydept.api.spf.org.buManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.comm.notice.model.NoticeModel;
//import com.saydept.api.comm.notice.model.NoticeModel;
//import com.saydept.api.comm.notice.model.NoticeSaveModel;
import com.saydept.api.spf.org.buManagement.model.BuManagementModel;
import com.saydept.api.spf.org.buManagement.model.BuManagementSaveModel;

@Mapper
public interface BuManagementMapper {

	BuManagementSaveModel selectBuManagement(BuManagementSaveModel request);
	List<BuManagementModel> selectBuList(BuManagementModel request);
	int updateBuManagement(BuManagementSaveModel request);
	int insertBuManagement(BuManagementSaveModel request);
	
	//	int selectBuManagement(BuManagementSaveModel request);
	//	List<BuManagementModel> selectBuManagementList(BuManagementSaveModel request);
	//	List<BuManagementModel> selectClsList(BuManagementModel request);
	//	List<BuManagementModel> selectCls2List(BuManagementModel request);
	//	int updateBuManagement(BuManagementModel request);
	//	int saveBuManagement2(BuManagementSaveModel request);

	
}