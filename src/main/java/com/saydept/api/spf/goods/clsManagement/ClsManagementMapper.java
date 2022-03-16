package com.saydept.api.spf.goods.clsManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.goods.clsManagement.model.ClsManagementModel;

@Mapper
public interface ClsManagementMapper {

	ClsManagementModel selectClsManagement(ClsManagementModel request);

	List<ClsManagementModel> selectClsManagementList(ClsManagementModel request);
	
	List<ClsManagementModel> selectConerList(ClsManagementModel request);
	
	List<ClsManagementModel> selectKeyList(ClsManagementModel request);
	
	int updateClsManagement(ClsManagementModel request);

	int insertClsManagement(ClsManagementModel request);

	int saveClsManagement(ClsManagementModel request);

	int deleteClsManagement(ClsManagementModel request);

}