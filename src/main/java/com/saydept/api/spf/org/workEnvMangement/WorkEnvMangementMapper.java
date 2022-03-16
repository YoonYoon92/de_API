package com.saydept.api.spf.org.workEnvMangement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.org.workEnvMangement.model.WorkEnvMangementModel;

@Mapper
public interface WorkEnvMangementMapper {

	WorkEnvMangementModel selectWorkEnvMangement(WorkEnvMangementModel request);

	List<WorkEnvMangementModel> selectWorkEnvMangementList(WorkEnvMangementModel request);

	int updateWorkEnvMangement(WorkEnvMangementModel request);

	int insertWorkEnvMangement(WorkEnvMangementModel request);

	int saveWorkEnvMangement(WorkEnvMangementModel request);

	int deleteWorkEnvMangement(WorkEnvMangementModel request);

}