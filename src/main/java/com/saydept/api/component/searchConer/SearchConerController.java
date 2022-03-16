package com.saydept.api.component.searchConer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.comm.model.ResModel;
import com.saydept.api.component.searchConer.model.SearchConerModel;
import com.saydept.api.component.searchConer.model.SearchConerParamModel;
import com.saydept.utils.SayUtils;

@CrossOrigin(origins = "*")
@RestController
public class SearchConerController {

	@Autowired
	private SearchConerService SearchConerService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/selectSearchConer", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectBuyReqDocRegistList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/component/selectSearchConer", method = RequestMethod.POST)
	public ResModel selectSearchConer(@RequestBody SearchConerParamModel request)throws Exception {
		ResModel resModel = new ResModel();
		System.out.println(request);
		System.out.println("-----------controller-----------------------------------");
		request.setSearchConerUpper(request.getSearchConer().toUpperCase());
		request.setSearchConerLower(request.getSearchConer().toLowerCase());
		request.setSearchConerFullChar(SayUtils.toFullChar(request.getSearchConer()));
		request.setSearchConerFullCharUpper(SayUtils.toFullChar(request.getSearchConerUpper()));
		request.setSearchConerFullCharLower(SayUtils.toFullChar(request.getSearchConerLower()));
		
		
		List<SearchConerModel> result = SearchConerService.selectSearchConer(request);
		
		if(result != null) {
			resModel.setCode("000");
			resModel.setMessage("정상입니다.");
			resModel.setData(result);
		} else {
			resModel.setCode("900");
			resModel.setMessage("데이터 없음.");
			resModel.setData(null);
		}	
		
		return resModel;
	}
	


}