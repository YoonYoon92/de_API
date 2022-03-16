package com.saydept.api.app.appSayCash;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.app.appSayCash.model.AppSayCashModel;

@Mapper
public interface AppSayCashMapper {

	AppSayCashModel selectAppSayCash(AppSayCashModel request);

	List<AppSayCashModel> selectAppSayCashList(AppSayCashModel request);
	
	List<AppSayCashModel> AppSayCashDetail(AppSayCashModel request);
	
	List<AppSayCashModel> eventReceipt(AppSayCashModel request);
	

	int updateAppSayCash(AppSayCashModel request);

	int insertAppSayCash(AppSayCashModel request);

	int saveAppSayCash(AppSayCashModel request);

	int deleteAppSayCash(AppSayCashModel request);

}