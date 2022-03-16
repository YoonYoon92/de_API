package com.saydept.api.spf.goods.discountClsManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.goods.discountClsManagement.model.DiscountClsManagementModel;

@Mapper
public interface DiscountClsManagementMapper {

	DiscountClsManagementModel selectDiscountClsManagement(DiscountClsManagementModel request);

	List<DiscountClsManagementModel> selectDiscountClsManagementList(DiscountClsManagementModel request);

	int updateDiscountClsManagement(DiscountClsManagementModel request);

	int insertDiscountClsManagement(DiscountClsManagementModel request);

	int saveDiscountClsManagement(DiscountClsManagementModel request);

	int deleteDiscountClsManagement(DiscountClsManagementModel request);

}