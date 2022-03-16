package com.saydept.api.app.appSayResign;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.app.appSayResign.model.AppSayResignModel;

@Mapper
public interface AppSayResignMapper {

	AppSayResignModel selectAppSayResign(AppSayResignModel request);

	List<AppSayResignModel> selectAppSayResignList(AppSayResignModel request);

	int updateAppSayResign(AppSayResignModel request);

	int insertAppSayResign(AppSayResignModel request);

	int saveAppSayResign(AppSayResignModel request);

	int deleteAppSayResign(AppSayResignModel request);

}