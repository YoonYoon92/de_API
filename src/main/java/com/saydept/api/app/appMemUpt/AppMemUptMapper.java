package com.saydept.api.app.appMemUpt;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.app.appMemUpt.model.AppMemUptModel;
import com.saydept.api.app.appMemUpt.model.AppMemUptParamModel;

@Mapper
public interface AppMemUptMapper {

	AppMemUptModel selectAppMemUpt(AppMemUptModel request);

	List<AppMemUptModel> selectAppMemUptList(AppMemUptModel request);

	AppMemUptParamModel selectJuminchk(AppMemUptParamModel request);

	int logAppMemUpt(AppMemUptParamModel request);
	
	int insertAppMemUpt(AppMemUptParamModel request);
	
	AppMemUptModel getAppSayPlusMemInfoCheck(AppMemUptParamModel request);



}