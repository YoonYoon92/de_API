package com.saydept.api.comm;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.comm.model.AccountInput;
import com.saydept.api.comm.model.CommModel;
import com.saydept.api.comm.model.StoreModel;
import com.saydept.api.comm.model.AccountModel;

@Mapper
public interface CommMapper {

	//공통코드 조회
	List<CommModel> selectCommCodeList(CommModel request);
	
	//사용자 로그인
	AccountModel selectUserLogin(AccountInput request);
	
	//로그인 사용자 account(조직) 정보 
	AccountModel selectUserOrgInfo(AccountInput request);
	
	//사용자 정보
	AccountModel userInfo(AccountInput request);
		
	//로그 기록
	int insertlog(AccountInput request);	

	//사용자 리스트
	List<AccountModel> selectUserList();
	
	//매장목록 조회
	List<CommModel> selectCommStoreList(CommModel request);

	//POS목록 조회
	List<CommModel> selectCommPosList(CommModel request);


	//조직조회(정)
	List<StoreModel> selectStoreLv1List(StoreModel request);

	//조직조회(부)
	List<StoreModel> selectStoreLv2List(StoreModel request);

	//조직조회(팀)
	List<StoreModel> selectStoreLv3List(StoreModel request);

	//조직조회(세분류)
	List<StoreModel> selectStoreLv4List(StoreModel request);

	//조직조회(코너)
	List<StoreModel> selectStoreLv5List(StoreModel request);

	//조직조회(클래스)
	List<StoreModel> selectStoreLv6List(StoreModel request);

	//조직조회(점) 콤보박스 조회
	List<CommModel> selectStoreComboLv1List(CommModel request);

	//조직조회(부) 콤보박스 조회
	List<CommModel> selectStoreComboLv2List(CommModel request);
	List<CommModel> selectStoreComboLv2ListInsa(CommModel request);
	
	//조직조회(팀) 콤보박스 조회
	List<CommModel> selectStoreComboLv3List(CommModel request);
	List<CommModel> selectStoreComboLv3ListInsa(CommModel request);
	
	//조직조회(PC) 콤보박스 조회
	List<CommModel> selectStoreComboLv4List(CommModel request);

	//조직조회(코너) 콤보박스 조회
	List<CommModel> selectStoreComboLv5List(CommModel request);

	//조직조회(class) 콤보박스 조회
	List<CommModel> selectStoreComboLv6List(CommModel request);

}