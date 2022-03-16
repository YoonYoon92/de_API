package com.saydept.api.spf.org.zoneLinkManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.org.zoneLinkManagement.model.ZoneLinkManagementModel;

@Mapper
public interface ZoneLinkManagementMapper {

	ZoneLinkManagementModel selectZoneLinkManagement(ZoneLinkManagementModel request);
	//코너체크
	ZoneLinkManagementModel selectConerchk(ZoneLinkManagementModel request);

	List<ZoneLinkManagementModel> selectZoneLinkManagementList(ZoneLinkManagementModel request);
	//존목록조회
	List<ZoneLinkManagementModel> selectzoneStoreList(ZoneLinkManagementModel request);

	int updateZoneLinkManagement(ZoneLinkManagementModel request);

	int insertZoneLinkManagement(ZoneLinkManagementModel request);

	int saveZoneLinkManagement(ZoneLinkManagementModel request);

	int deleteZoneLinkManagement(ZoneLinkManagementModel request);

}