package com.saydept.api.app.appSaySignUp;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.app.appSaySignUp.model.AppSaySignUpModel;
import com.saydept.api.app.appSaySignUp.model.AppSaySignUpParamModel;

@Mapper
public interface AppSaySignUpMapper {

	AppSaySignUpModel selectAppSaySignUp(AppSaySignUpModel request);

	List<AppSaySignUpModel> selectAppSaySignUpList(AppSaySignUpModel request);

	AppSaySignUpParamModel selectJuminchk(AppSaySignUpParamModel request);

	int logAppSaySignUp(AppSaySignUpParamModel request);
	
	int insertAppSaySignUp(AppSaySignUpParamModel request);
	
	AppSaySignUpModel getAppSayPlusMemInfoCheck(AppSaySignUpParamModel request);



}