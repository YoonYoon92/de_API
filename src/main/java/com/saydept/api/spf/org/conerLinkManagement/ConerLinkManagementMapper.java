package com.saydept.api.spf.org.conerLinkManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.org.conerLinkManagement.model.ConerLinkManagementModel;

@Mapper
public interface ConerLinkManagementMapper {

	ConerLinkManagementModel selectConerLinkManagement(ConerLinkManagementModel request);

	List<ConerLinkManagementModel> selectConerLinkManagementList(ConerLinkManagementModel request);

	int updateConerLinkManagement(ConerLinkManagementModel request);

	int insertConerLinkManagement(ConerLinkManagementModel request);

	int saveConerLinkManagement(ConerLinkManagementModel request);

	int deleteConerLinkManagement(ConerLinkManagementModel request);

}