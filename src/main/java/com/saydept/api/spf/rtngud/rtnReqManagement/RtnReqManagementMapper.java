package com.saydept.api.spf.rtngud.rtnReqManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.puchas.buyReqManagement.model.BuyReqManagementModel;
import com.saydept.api.spf.rtngud.rtnReqManagement.model.RtnReqManagementModel;

@Mapper
public interface RtnReqManagementMapper {

	RtnReqManagementModel selectRtnReqManagement(RtnReqManagementModel request);
	
	RtnReqManagementModel checkPartner(RtnReqManagementModel request);

    RtnReqManagementModel itemDetail(RtnReqManagementModel request);
    
    RtnReqManagementModel checkChitNum(RtnReqManagementModel request);
    
    RtnReqManagementModel itemsCdCheck(RtnReqManagementModel request);
    
    RtnReqManagementModel chitSearchResult(RtnReqManagementModel request);
    
    List<RtnReqManagementModel> chitSearchResultDetail(RtnReqManagementModel request);
	
	List<RtnReqManagementModel> selectRtnReqManagementList(RtnReqManagementModel request);

	List<RtnReqManagementModel> chitYearList(RtnReqManagementModel request);
	
	List<RtnReqManagementModel> itemList(RtnReqManagementModel request);
	
	int updateRtnReqManagement(RtnReqManagementModel request);

	int insertRtnReqManagement(RtnReqManagementModel request);

	int saveRtnReqManagement(RtnReqManagementModel request);

	int deleteRtnReqManagement(RtnReqManagementModel request);

	int deleteSpfc01pf(RtnReqManagementModel request);
	
	int insertChitNum(RtnReqManagementModel request);

	int insertSpfc01pf(RtnReqManagementModel request);

	int insertSpfc02pf(RtnReqManagementModel request);
	
	int updateSpfc01pf(RtnReqManagementModel request);
	
	int updateChitNum(RtnReqManagementModel request);
}