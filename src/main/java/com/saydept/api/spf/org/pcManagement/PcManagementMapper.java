package com.saydept.api.spf.org.pcManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.comm.notice.model.NoticeModel;
//import com.saydept.api.comm.notice.model.NoticeModel;
//import com.saydept.api.comm.notice.model.NoticeSaveModel;
import com.saydept.api.spf.org.pcManagement.model.PcManagementModel;
import com.saydept.api.spf.org.pcManagement.model.PcManagementSaveModel;

@Mapper
public interface PcManagementMapper {

	PcManagementSaveModel selectPcManagement(PcManagementSaveModel request);
	List<PcManagementModel> selectBuList(PcManagementModel request);
	List<PcManagementModel> selectTimList(PcManagementModel request);
	List<PcManagementModel> selectPcList(PcManagementModel request);
	int updatePcManagement(PcManagementSaveModel request);
	int insertPcManagement(PcManagementSaveModel request);
	
	//	int selectPcManagement(PcManagementSaveModel request);
	//	List<PcManagementModel> selectPcManagementList(PcManagementSaveModel request);
	//	List<PcManagementModel> selectClsList(PcManagementModel request);
	//	List<PcManagementModel> selectCls2List(PcManagementModel request);
	//	int updatePcManagement(PcManagementModel request);
	//	int savePcManagement2(PcManagementSaveModel request);

	
}