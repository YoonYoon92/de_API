package com.saydept.api.app.appSayResign;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.app.appSayResign.model.AppSayResignModel;

@CrossOrigin(origins = "*")
@RestController
public class AppSayResignController {

	@Autowired
	private AppSayResignService appSayResignService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/appSayResign", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectAppSayResign
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/appSayResign/selectAppSayResign", method = RequestMethod.POST)
	public AppSayResignModel selectAppSayResign(@RequestBody AppSayResignModel request)throws Exception {

		AppSayResignModel result = appSayResignService.selectAppSayResign(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectAppSayResignList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/appSayResign/selectAppSayResignList", method = RequestMethod.POST)
	public List<AppSayResignModel> selectAppSayResignList(@RequestBody AppSayResignModel request)throws Exception {

		List<AppSayResignModel> result = appSayResignService.selectAppSayResignList(request);
		return result;
	}

	/**
	 * 데이터 수정
	 * 작성방법은 update'업무를 구분할 명칭'
	 * Ex)updateAppSayResign
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/appSayResign/updateAppSayResign", method = RequestMethod.POST)
	public int updateAppSayResign(@RequestBody AppSayResignModel request)throws Exception {

		int result = appSayResignService.updateAppSayResign(request);
		return result;
	}

	/**
	 * 데이터 등록
	 * 작성방법은 insert'업무를 구분할 명칭'
	 * Ex)insertAppSayResign
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/appSayResign/insertAppSayResign", method = RequestMethod.POST)
	public int insertAppSayResign(@RequestBody AppSayResignModel request)throws Exception {

		int result = appSayResignService.insertAppSayResign(request);
		return result;
	}

	/**
	 * 데이터 수정+등록 Ex) 데이터가 없으면 insert 없으면 update 작업을 동시 처리할때
	 * 작성방법은 save'업무를 구분할 명칭'
	 * Ex)saveAppSayResign
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/appSayResign/saveAppSayResign", method = RequestMethod.POST)
	public int saveAppSayResign(@RequestBody AppSayResignModel request)throws Exception {

		int result = appSayResignService.saveAppSayResign(request);
		return result;
	}

	/**
	 * 데이터 삭제
	 * 작성방법은 delete'업무를 구분할 명칭'
	 * Ex)deleteAppSayResign
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/appSayResign/deleteAppSayResign", method = RequestMethod.POST)
	public int deleteAppSayResign(@RequestBody AppSayResignModel request)throws Exception {

		int result = appSayResignService.deleteAppSayResign(request);
		return result;
	}

}