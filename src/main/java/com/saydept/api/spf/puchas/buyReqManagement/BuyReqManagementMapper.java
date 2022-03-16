package com.saydept.api.spf.puchas.buyReqManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.puchas.buyReqManagement.model.BuyReqManagementModel;

@Mapper
public interface BuyReqManagementMapper {

	BuyReqManagementModel selectBuyReqManagement(BuyReqManagementModel request);
	
	BuyReqManagementModel checkPartner(BuyReqManagementModel request);

    BuyReqManagementModel itemDetail(BuyReqManagementModel request);
    
    BuyReqManagementModel checkChitNum(BuyReqManagementModel request);
    
    BuyReqManagementModel itemsCdCheck(BuyReqManagementModel request);
    
    BuyReqManagementModel chitSearchResult(BuyReqManagementModel request);
    
    List<BuyReqManagementModel> chitSearchResultDetail(BuyReqManagementModel request);
    
	List<BuyReqManagementModel> selectBuyReqManagementList(BuyReqManagementModel request);

	List<BuyReqManagementModel> chitYearList(BuyReqManagementModel request);
	
	List<BuyReqManagementModel> itemList(BuyReqManagementModel request);
	
	int updateBuyReqManagement(BuyReqManagementModel request);

	int insertBuyReqManagement(BuyReqManagementModel request);

	int saveBuyReqManagement(BuyReqManagementModel request);

	int deleteBuyReqManagement(BuyReqManagementModel request);

	int insertChitNum(BuyReqManagementModel request);

	int insertSpfo01pf(BuyReqManagementModel request);

	int insertSpfo02pf(BuyReqManagementModel request);
	
	int updateChitNum(BuyReqManagementModel request);
	
	int updateSpfo01pf(BuyReqManagementModel request);
	
}