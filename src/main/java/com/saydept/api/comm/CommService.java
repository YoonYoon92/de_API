package com.saydept.api.comm;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.comm.model.AccountInput;
import com.saydept.api.comm.model.AccountModel;
import com.saydept.api.comm.model.CommModel;
import com.saydept.api.comm.model.StoreModel;


@Service
public class CommService {

	@Autowired
	private CommMapper commMapper;

	//공통코드 조회
	public List<CommModel> selectCommCodeList(CommModel request) {
		// TODO Auto-generated method stub
		return commMapper.selectCommCodeList(request);
	}
	
	/**
	 * 사용자로그인
	 * @param request
	 * @return
	 */
	public AccountModel selectUserLogin(AccountInput request, HttpServletRequest httpServletRequest) {
		// TODO Auto-generated method stub
		AccountModel accountModel = commMapper.selectUserLogin(request);		
		
		// selectUserLogin 정보가 있는 것만 조직정보 get
		if(accountModel != null) { 
			// 로그인 user의 조직정보 get
			AccountModel userOrg = commMapper.selectUserOrgInfo(request);
			
			//테스트를 위한 점코드
			accountModel.setJum(userOrg.getJum());
			//accountModel.setJumName("");
			
			//테스트를 위한 부코드
			accountModel.setBu(userOrg.getBu());
			//accountModel.setBuName("");
			
			//테스트를 위한 부코드
			accountModel.setTeam(userOrg.getTeam());
			accountModel.setTeamName(userOrg.getTeamName());
			
			System.out.println("클라이언트IP    : "+httpServletRequest.getRemoteAddr());
			//----기타정보----
			System.out.println("클라이언트Host : "+httpServletRequest.getRemoteHost());
			System.out.println("클라이언트Port : "+httpServletRequest.getRemotePort());
			InetAddress local = null;
			
//			try {
//				local = InetAddress.getLocalHost(); //본인ip
//
//			} catch (UnknownHostException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			String ip = local.getHostAddress(); 
			
			String ip = httpServletRequest.getRemoteAddr();
			accountModel.setUserIp(ip);
			
			
			System.out.println(ip);
			request.setUserIp(ip);
//
			AccountModel userInfo = commMapper.userInfo(request);
			accountModel.setLateDate(userInfo.getLateDate());
			accountModel.setLatePgm(userInfo.getLatePgm());
		}
		System.out.println(accountModel);
		return accountModel;
	}
	
	
	/**
	 * 로그기록
	 * @param request
	 * @return
	 */
	public int insertlog(AccountInput request, HttpServletRequest httpServletRequest) {

		InetAddress local = null;
//		try {
//			local = InetAddress.getLocalHost();
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String ip = local.getHostAddress();
		String ip = httpServletRequest.getRemoteAddr();
		
		System.out.println(ip);
		request.setUserIp(ip);
		
		int result=0;
//		String ip=request.getUserId();
		System.out.println(request);
	
		result += commMapper.insertlog(request);
		return result;
	}
	
	/**
	 * 사용자리스트(메뉴및 프로그램 권한 설정용)
	 * @param request
	 * @return
	 */
//	public List<AccountModel> selectUserList() {
//		// TODO Auto-generated method stub
//		return commMapper.selectUserList();
//	}
	
	public List<AccountModel> selectUserList() {
		// TODO Auto-generated method stub
		List<AccountModel> resultList = new ArrayList<AccountModel>();		
		List<AccountModel> accountModel = commMapper.selectUserList();
		
		AccountInput request = new AccountInput();
		
		for(AccountModel data: accountModel) {
			if(data != null) { 				
				
				request.setUserId(data.getUserId());
				request.setUserPw(data.getUserPw());
				AccountModel userOrg = commMapper.selectUserOrgInfo(request);
				if(userOrg != null) {
					System.out.println(userOrg);
					data.setTeam(userOrg.getTeam());
					data.setTeamName(userOrg.getTeamName());
				}
			}
			
			resultList.add(data);
			
		}
		System.out.println(resultList);
		return resultList;
	}
	
	private AccountInput AccountInput() {
		// TODO Auto-generated method stub
		return null;
	}

	//매장목록 조회
	public List<CommModel> selectCommStoreList(CommModel request) {
		// TODO Auto-generated method stub
		return commMapper.selectCommStoreList(request);
	}

	//POS목록 조화
	public List<CommModel> selectCommPosList(CommModel request) {
		// TODO Auto-generated method stub
		return commMapper.selectCommPosList(request);
	}


	//조직조회(점)
	public void selectStoreList(StoreModel request) {
		// TODO Auto-generated method stub
		List<StoreModel> storeLvList = commMapper.selectStoreLv1List(request);

		request.setChildren(storeLvList);
		for( StoreModel storeLv :  storeLvList) {
			selectStoreLv2List(storeLv);
		}
	}

	//조직조회(부)
	public void selectStoreLv2List(StoreModel request) {
		// TODO Auto-generated method stub
		List<StoreModel> storeLvList = commMapper.selectStoreLv2List(request);

		request.setChildren(storeLvList);
		for( StoreModel storeLv :  storeLvList) {
			selectStoreLv3List(storeLv);
		}
	}

	//조직조회(팀)
	public void selectStoreLv3List(StoreModel request) {
		// TODO Auto-generated method stub
		List<StoreModel> storeLvList = commMapper.selectStoreLv3List(request);

		request.setChildren(storeLvList);
		for( StoreModel storeLv :  storeLvList) {
			selectStoreLv4List(storeLv);
		}
	}

	//조직조회(세분류)
	public void selectStoreLv4List(StoreModel request) {
		// TODO Auto-generated method stub
		List<StoreModel> storeLvList = commMapper.selectStoreLv4List(request);

		request.setChildren(storeLvList);
		//		for( StoreModel storeLv :  storeLvList) {
		//			selectStoreLv5List(storeLv);
		//		}
	}

	//조직조회(코너)
	public void selectStoreLv5List(StoreModel request) {
		// TODO Auto-generated method stub
		List<StoreModel> storeLvList = commMapper.selectStoreLv5List(request);

		request.setChildren(storeLvList);
		for( StoreModel storeLv :  storeLvList) {
			selectStoreLv6List(storeLv);
		}
	}

	//조직조회(클래스)
	public void selectStoreLv6List(StoreModel request) {
		// TODO Auto-generated method stub
		
		List<StoreModel> storeLvList = commMapper.selectStoreLv6List(request);
		request.setChildren(storeLvList);
	}

	//조직조회(점) 콤보박스 조회
	public List<CommModel> selectStoreComboLv1List(CommModel request) {
		// TODO Auto-generated method stub
		return commMapper.selectStoreComboLv1List(request);
		
	}

	//조직조회(부) 콤보박스 조회
	public List<CommModel> selectStoreComboLv2List(CommModel request) {
		// TODO Auto-generated method stub
		return commMapper.selectStoreComboLv2List(request);
	}
	//조직조회(부) 콤보박스 조회 - 인사마스터 기준
	public List<CommModel> selectStoreComboLv2ListInsa(CommModel request) {
		// TODO Auto-generated method stub
		return commMapper.selectStoreComboLv2ListInsa(request);
	}

	//조직조회(팀) 콤보박스 조회
	public List<CommModel> selectStoreComboLv3List(CommModel request) {
		// TODO Auto-generated method stub
		return commMapper.selectStoreComboLv3List(request);
	}
	//조직조회(부) 콤보박스 조회 - 인사마스터 기준
	public List<CommModel> selectStoreComboLv3ListInsa(CommModel request) {
		// TODO Auto-generated method stub
		return commMapper.selectStoreComboLv3ListInsa(request);
	}

	//조직조회(PC) 콤보박스 조회
	public List<CommModel> selectStoreComboLv4List(CommModel request) {
		// TODO Auto-generated method stub
		return commMapper.selectStoreComboLv4List(request);
	}

	//조직조회(코너) 콤보박스 조회
	public List<CommModel> selectStoreComboLv5List(CommModel request) {
		// TODO Auto-generated method stub
		System.out.println(request);
		return commMapper.selectStoreComboLv5List(request);
	}

	//조직조회(class) 콤보박스 조회
	public List<CommModel> selectStoreComboLv6List(CommModel request) {
		// TODO Auto-generated method stub
		System.out.println(request);
		return commMapper.selectStoreComboLv6List(request);
	}
	
	



}