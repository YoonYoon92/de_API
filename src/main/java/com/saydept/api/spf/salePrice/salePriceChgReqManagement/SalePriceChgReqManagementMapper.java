package com.saydept.api.spf.salePrice.salePriceChgReqManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.rtngud.rtnReqManagement.model.RtnReqManagementModel;
import com.saydept.api.spf.salePrice.salePriceChgReqManagement.model.SalePriceChgReqManagementModel;

@Mapper
public interface SalePriceChgReqManagementMapper {

	SalePriceChgReqManagementModel selectSalePriceChgReqManagement(SalePriceChgReqManagementModel request);

	List<SalePriceChgReqManagementModel> selectSalePriceChgReqManagementList(SalePriceChgReqManagementModel request);

	int updateSalePriceChgReqManagement(SalePriceChgReqManagementModel request);

	int insertSalePriceChgReqManagement(List<SalePriceChgReqManagementModel> request);

	int saveSalePriceChgReqManagement(SalePriceChgReqManagementModel request);

	int deleteSalePriceChgReqManagement(SalePriceChgReqManagementModel model);
	
	SalePriceChgReqManagementModel checkPartner(SalePriceChgReqManagementModel request);
	
	List<SalePriceChgReqManagementModel> itemList(SalePriceChgReqManagementModel request);
	
	
	SalePriceChgReqManagementModel itemDetail(SalePriceChgReqManagementModel request);
	
	SalePriceChgReqManagementModel itemsCdCheck(SalePriceChgReqManagementModel request);
	
	int updateChitNum(SalePriceChgReqManagementModel request);
	
	int insertChitNum(SalePriceChgReqManagementModel request);
	
	SalePriceChgReqManagementModel checkChitNum(SalePriceChgReqManagementModel request);
	
	int insertSpfp01pf(SalePriceChgReqManagementModel model);
	
	int insertSpfp02pf(SalePriceChgReqManagementModel model);
	
	int updateSpfp01pf(SalePriceChgReqManagementModel model);
	
	int deleteSpfc01pf(SalePriceChgReqManagementModel model);
	
	SalePriceChgReqManagementModel chitSearchResult(SalePriceChgReqManagementModel request);
    
    List<SalePriceChgReqManagementModel> chitSearchResultDetail(SalePriceChgReqManagementModel request);
}