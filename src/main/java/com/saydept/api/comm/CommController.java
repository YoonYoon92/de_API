package com.saydept.api.comm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.comm.model.AccountInput;
import com.saydept.api.comm.model.AccountModel;
import com.saydept.api.comm.model.CommModel;
import com.saydept.api.comm.model.DbConfig;
import com.saydept.api.comm.model.EnvSetModel;
import com.saydept.api.comm.model.ResModel;
import com.saydept.api.comm.model.StoreModel;
import com.saydept.api.spf.saleNews.corpSaleNews.CorpSaleNewsService;

@CrossOrigin(origins = "*")
@RestController
public class CommController {

	@Autowired
	private CommService commService;
	
	@Autowired
	private EnvSetModel envSetModel;
	
	@Autowired
	private CorpSaleNewsService corpSaleNewsService;
	
	/**
	 * API 상태체크
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "api/comm", method = RequestMethod.GET)
	public String condition() throws ParseException {
		
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	/**
	 * 사용자 Login
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/comm/selectUserLogin", method = RequestMethod.POST)
	public ResModel selectUserLogin(@RequestBody AccountInput request, HttpServletRequest httpServletRequest)throws Exception {
		DbConfig.getInstance().setDbType(envSetModel.getDbType());
		System.out.println("서버타입 : "+envSetModel.getDesc());
		System.out.println("클라이언트IP : "+httpServletRequest.getRemoteAddr());
	

		//request.setDbType("TS");
		AccountModel result = commService.selectUserLogin(request,httpServletRequest);
		//LoginModel result = new LoginModel();			
		
		ResModel resModel = new ResModel();
		if(result != null) {
			resModel.setCode("000");
			resModel.setMessage("정상입니다.");
			resModel.setData(result);
		} else {
			resModel.setCode("900");
			resModel.setMessage("아이디 혹은 비밀번호가 일치하지 않습니다.");
			resModel.setData(null);
		}		
		
    	return resModel;
	}
	
	/**
	 * 사용자 List (사용자 권한 설정위한 목록 가져오기)
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/comm/selectUserList", method = RequestMethod.POST)
	public List<AccountModel> selectUserList()throws Exception {
		
		List<AccountModel> result = commService.selectUserList();
		
    	return result;
	}
	/**
	 * 사용자 log 기록
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/comm/insertlog", method = RequestMethod.POST)
	public int insertlog(@RequestBody AccountInput request, HttpServletRequest httpServletRequest)throws Exception {
		System.out.println("------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------");
		
    	return commService.insertlog(request,httpServletRequest);
	}
	
	

	
	
	/**
	 * 공통코드 조회
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/comm/selectCommCodeList", method = RequestMethod.POST)
	public List<CommModel> selectCommCodeList(@RequestBody CommModel request)throws Exception {

		List<CommModel> result = commService.selectCommCodeList(request);
		return result;
	}

	/**
	 * 매장목록 조회
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/comm/selectCommStoreList", method = RequestMethod.POST)
	public List<CommModel> selectCommStoreList(@RequestBody CommModel request)throws Exception {

		List<CommModel> result = commService.selectCommStoreList(request);
		return result;
	}
	
	/**
	 * 매장목록 조회
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/comm/selectCommPosList", method = RequestMethod.POST)
	public List<CommModel> selectCommPosList(@RequestBody CommModel request)throws Exception {

		List<CommModel> result = commService.selectCommPosList(request);
		return result;
	}
	

	
	/**
	 * 조직목록 조회
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/comm/selectStoreList", method = RequestMethod.POST)
	public List<StoreModel> selectStoreList()throws Exception {
		
		StoreModel rootStore = new StoreModel();
		commService.selectStoreList(rootStore);
		
		return rootStore.getChildren();
	}
	
	/**
	 * 조직(점) 콤보박스 조회
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/comm/selectStoreComboLv1List", method = RequestMethod.POST)
	public List<CommModel> selectStoreComboLv1List(@RequestBody CommModel request)throws Exception {

		List<CommModel> result = commService.selectStoreComboLv1List(request);
		System.out.println(result);
		return result;
		
	}
	
	/**
	 * 조직(부) 콤보박스 조회
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/comm/selectStoreComboLv2List", method = RequestMethod.POST)
	public List<CommModel> selectStoreComboLv2List(@RequestBody CommModel request)throws Exception {

		List<CommModel> result = commService.selectStoreComboLv2List(request);
		System.out.println(result);
		return result;
	}
	@RequestMapping(value = "api/comm/selectStoreComboLv2ListInsa", method = RequestMethod.POST)
	public List<CommModel> selectStoreComboLv2ListInsa(@RequestBody CommModel request)throws Exception {

		List<CommModel> result = commService.selectStoreComboLv2ListInsa(request);
		System.out.println(result);
		return result;
	}
	/**
	 * 조직(팀) 콤보박스 조회
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/comm/selectStoreComboLv3List", method = RequestMethod.POST)
	public List<CommModel> selectStoreComboLv3List(@RequestBody CommModel request)throws Exception {

		List<CommModel> result = commService.selectStoreComboLv3List(request);
		System.out.println(result);
		return result;
	}
	@RequestMapping(value = "api/comm/selectStoreComboLv3ListInsa", method = RequestMethod.POST)
	public List<CommModel> selectStoreComboLv3ListInsa(@RequestBody CommModel request)throws Exception {

		List<CommModel> result = commService.selectStoreComboLv3ListInsa(request);
		System.out.println(result);
		return result;
	}
	
	/**
	 * 조직(PC) 콤보박스 조회
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/comm/selectStoreComboLv4List", method = RequestMethod.POST)
	public List<CommModel> selectStoreComboLv4List(@RequestBody CommModel request)throws Exception {

		List<CommModel> result = commService.selectStoreComboLv4List(request);
		System.out.println(result);
		return result;
	}
	
	/**
	 * 조직(코너) 콤보박스 조회
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/comm/selectStoreComboLv5List", method = RequestMethod.POST)
	public List<CommModel> selectStoreComboLv5List(@RequestBody CommModel request)throws Exception {

		List<CommModel> result = commService.selectStoreComboLv5List(request);
		System.out.println(result);
		return result;
	}
	
	/**
	 * 조직(class) 콤보박스 조회
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/comm/selectStoreComboLv6List", method = RequestMethod.POST)
	public List<CommModel> selectStoreComboLv6List(@RequestBody CommModel request)throws Exception {

		List<CommModel> result = commService.selectStoreComboLv6List(request);
		System.out.println(result);
		return result;
	}
}