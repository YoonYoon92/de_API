package com.saydept.api.app.appSayMsgCoupon;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.app.appSayMsgCoupon.model.AppSayMsgCouponModel;
import com.saydept.api.app.appSayMsgCoupon.model.AppSayMsgCouponParamModel;

@Mapper
public interface AppSayMsgCouponMapper {

		//전체 목록 조회
		List<AppSayMsgCouponModel> getAppSayMsgCouponlist(AppSayMsgCouponParamModel storeParam);
		

}
