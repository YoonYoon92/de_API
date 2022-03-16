package com.saydept.api.comm.pwdChg;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.comm.pwdChg.model.PwdChgModel;

@CrossOrigin(origins = "*")
@RestController
public class PwdChgController {

	@Autowired
	private PwdChgService pwdChgService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/pwdChg", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectPwdChg
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/pwdChg/selectPwdChg", method = RequestMethod.POST)
	public int selectPwdChg(@RequestBody PwdChgModel request)throws Exception {

		int result = pwdChgService.selectPwdChg(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectPwdChgList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/pwdChg/selectPwdChgList", method = RequestMethod.POST)
	public List<PwdChgModel> selectPwdChgList(@RequestBody PwdChgModel request)throws Exception {

		List<PwdChgModel> result = pwdChgService.selectPwdChgList(request);
		return result;
	}

	/**
	 * 데이터 수정
	 * 작성방법은 update'업무를 구분할 명칭'
	 * Ex)updatePwdChg
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/pwdChg/updatePwdChg", method = RequestMethod.POST)
	public int updatePwdChg(@RequestBody PwdChgModel request)throws Exception {
		
		int result = pwdChgService.selectPwdChg(request);
		System.out.println("*****************a;slkdfa';ldksf'a;lksdf'a;lksdf';alksdf'lkasdf'*(*************");
		System.out.println("*****************a;slkdfa';ldksf'a;lksdf'a;lksdf';alksdf'lkasdf'*(*************");
		System.out.println("*****************a;slkdfa';ldksf'a;lksdf'a;lksdf';alksdf'lkasdf'*(*************");
		System.out.println(request);
		System.out.println("result=  " + result);
		if (result == 1)	
		{
			int result2 = pwdChgService.updatePwdChg(request);
			System.out.println("result2=  " + result2);
		}
		System.out.println("*****************a;slkdfa';ldksf'a;lksdf'a;lksdf';alksdf'lkasdf'*(*************");
		System.out.println("*****************a;slkdfa';ldksf'a;lksdf'a;lksdf';alksdf'lkasdf'*(*************");
		System.out.println("*****************a;slkdfa';ldksf'a;lksdf'a;lksdf';alksdf'lkasdf'*(*************");
		return result;
	}

	/**
	 * 데이터 등록
	 * 작성방법은 insert'업무를 구분할 명칭'
	 * Ex)insertPwdChg
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/pwdChg/insertPwdChg", method = RequestMethod.POST)
	public int insertPwdChg(@RequestBody PwdChgModel request)throws Exception {

		int result = pwdChgService.insertPwdChg(request);
		return result;
	}

	/**
	 * 데이터 수정+등록 Ex) 데이터가 없으면 insert 없으면 update 작업을 동시 처리할때
	 * 작성방법은 save'업무를 구분할 명칭'
	 * Ex)savePwdChg
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/pwdChg/savePwdChg", method = RequestMethod.POST)
	public int savePwdChg(@RequestBody PwdChgModel request)throws Exception {

		int result = pwdChgService.savePwdChg(request);
		return result;
	}

	/**
	 * 데이터 삭제
	 * 작성방법은 delete'업무를 구분할 명칭'
	 * Ex)deletePwdChg
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/pwdChg/deletePwdChg", method = RequestMethod.POST)
	public int deletePwdChg(@RequestBody PwdChgModel request)throws Exception {

		int result = pwdChgService.deletePwdChg(request);
		return result;
	}

}