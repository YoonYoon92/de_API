package com.saydept.api.spf.goods.clsSendHistory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.goods.clsSendHistory.model.ClsSendHistoryModel;

@CrossOrigin(origins = "*")
@RestController
public class ClsSendHistoryController {

	@Autowired
	private ClsSendHistoryService clsSendHistoryService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/clsSendHistory", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectClsSendHistoryList
	 * @param request
	 * @return
	 * @throws Exception
	 */		
	@RequestMapping(value = "api/clsSendHistory/selectClsSendHistoryList", method = RequestMethod.POST)
	public List<ClsSendHistoryModel> selectClsSendHistoryList(@RequestBody ClsSendHistoryModel request)throws Exception {
		if(request.getCls1() == null) {
			request.setCls1("");
		}
		if(request.getCls2() == null) {
			request.setCls2("");
		}
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<ClsSendHistoryModel> result = clsSendHistoryService.selectClsSendHistoryList(request);
		return result;
	}

	 @RequestMapping(value = "api/clsSendHistory/selectClsList", method = RequestMethod.POST)
		public List<ClsSendHistoryModel> selectClsList(@RequestBody ClsSendHistoryModel request)throws Exception {
		 System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
			System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
			List<ClsSendHistoryModel> result = clsSendHistoryService.selectClsList(request);
			return result;
	}
	 @RequestMapping(value = "api/clsSendHistory/selectCls2List", method = RequestMethod.POST)
		public List<ClsSendHistoryModel> selectCls2List(@RequestBody ClsSendHistoryModel request)throws Exception {
		 System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
			System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
			List<ClsSendHistoryModel> result = clsSendHistoryService.selectCls2List(request);
			return result;
	}

}