package com.saydept.api.app.appSayPlusCoupon;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.app.appSayPlusCoupon.model.AppSayPlusCouponModel;
import com.saydept.api.app.appSayPlusCoupon.model.AppSayPlusCouponParamModel;
import com.saydept.api.app.appSayResign.model.AppSayResignModel;

@Mapper
public interface AppSayPlusCouponMapper {

		//전체 목록 조회
		List<AppSayPlusCouponModel> getAppSayPlusCouponlist(AppSayPlusCouponParamModel storeParam);
		List<AppSayPlusCouponModel> getAppSayPlusCouponlistA(AppSayPlusCouponParamModel storeParam);
		
		int getUseCoupon(AppSayPlusCouponModel request);
		AppSayPlusCouponModel getcpJnoCheck(AppSayPlusCouponModel request);
		
}
