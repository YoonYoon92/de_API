package com.saydept.api.spf.org.zoneManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.comm.notice.model.NoticeModel;
//import com.saydept.api.comm.notice.model.NoticeModel;
//import com.saydept.api.comm.notice.model.NoticeSaveModel;
import com.saydept.api.spf.org.zoneManagement.model.ZoneManagementModel;
import com.saydept.api.spf.org.zoneManagement.model.ZoneManagementSaveModel;

@Mapper
public interface ZoneManagementMapper {

	ZoneManagementSaveModel selectZoneManagement(ZoneManagementSaveModel request);
	List<ZoneManagementModel> selectBuList(ZoneManagementModel request);
	List<ZoneManagementModel> selectTimList(ZoneManagementModel request);
	List<ZoneManagementModel> selectPcList(ZoneManagementModel request);
	List<ZoneManagementModel> selectZoneList(ZoneManagementModel request);
	int updateZoneManagement(ZoneManagementSaveModel request);
	int insertZoneManagement(ZoneManagementSaveModel request);
	
	//	int selectZoneManagement(ZoneManagementSaveModel request);
	//	List<ZoneManagementModel> selectZoneManagementList(ZoneManagementSaveModel request);
	//	List<ZoneManagementModel> selectClsList(ZoneManagementModel request);
	//	List<ZoneManagementModel> selectCls2List(ZoneManagementModel request);
	//	int updateZoneManagement(ZoneManagementModel request);
	//	int saveZoneManagement2(ZoneManagementSaveModel request);

	
}