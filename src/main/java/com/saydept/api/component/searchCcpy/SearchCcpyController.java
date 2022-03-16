package com.saydept.api.component.searchCcpy;

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
import com.saydept.api.component.searchCcpy.model.SearchCcpyModel;
import com.saydept.api.component.searchCcpy.model.SearchCcpyParamModel;
import com.saydept.utils.SayUtils;

@CrossOrigin(origins = "*")
@RestController
public class SearchCcpyController {

	@Autowired
	private SearchCcpyService SearchCcpyService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/selectSearchCcpy", method = RequestMethod.GET)
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
	@RequestMapping(value = "api/component/selectSearchCcpy", method = RequestMethod.POST)
//	public List<SearchClassModel> selectSearchClass(@RequestBody SearchClassParamModel request)throws Exception {
//		request.setSearchClassUpper(request.getSearchClass().toUpperCase());
//		request.setSearchClassLower(request.getSearchClass().toLowerCase());
//		request.setSearchClassFullChar(SayUtils.toFullChar(request.getSearchClass()));
//		request.setSearchClassFullCharUpper(SayUtils.toFullChar(request.getSearchClassUpper()));
//		request.setSearchClassFullCharLower(SayUtils.toFullChar(request.getSearchClassLower()));
//		List<SearchClassModel> result = SearchClasstService.selectSearchClass(request);
//		return result;
//	}
	
	public ResModel selectSearchCcpy(@RequestBody SearchCcpyParamModel request)throws Exception {
		ResModel resModel = new ResModel();
		
		request.setSearchCcpyUpper(request.getSearchCcpy().toUpperCase());
		request.setSearchCcpyLower(request.getSearchCcpy().toLowerCase());
		request.setSearchCcpyFullChar(SayUtils.toFullChar(request.getSearchCcpy()));
		request.setSearchCcpyFullCharUpper(SayUtils.toFullChar(request.getSearchCcpyUpper()));
		request.setSearchCcpyFullCharLower(SayUtils.toFullChar(request.getSearchCcpyLower()));
		
		List<SearchCcpyModel> result = SearchCcpyService.selectSearchCcpy(request);
		
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