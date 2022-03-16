package com.saydept.api.spf.goods.partnerManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.goods.partnerManagement.model.PartnerManagementModel;

@Mapper
public interface PartnerManagementMapper {

	PartnerManagementModel selectPartnerManagement(PartnerManagementModel request);

	List<PartnerManagementModel> selectPartnerManagementList(PartnerManagementModel request);

	int updatePartnerManagement(PartnerManagementModel request);

	int insertPartnerManagement(PartnerManagementModel request);

	int savePartnerManagement(PartnerManagementModel request);

	int deletePartnerManagement(PartnerManagementModel request);

}