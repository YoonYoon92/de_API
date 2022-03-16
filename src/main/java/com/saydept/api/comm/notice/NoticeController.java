package com.saydept.api.comm.notice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.comm.notice.model.NoticeModel;
import com.saydept.api.comm.notice.model.NoticeSaveModel;

@CrossOrigin(origins = "*")
@RestController
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/notice", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectNoticeList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/notice/selectNoticeList", method = RequestMethod.POST)
	public List<NoticeModel> selectNoticeList(@RequestBody NoticeModel request)throws Exception {
		
		System.out.println(request);
		
		
		List<NoticeModel> result = noticeService.selectNoticeList(request);		
		return result;
		

	}




	/**
	 * 데이터 수정+등록 Ex) 데이터가 없으면 insert 없으면 update 작업을 동시 처리할때
	 * 작성방법은 save'업무를 구분할 명칭'
	 * Ex)saveNotice
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/notice/saveNotice", method = RequestMethod.POST)
	public int saveNotice(@RequestBody NoticeSaveModel request)throws Exception {
		
		System.out.println(request);	
		
		
		int result = noticeService.saveNotice(request);
		return result;
	}



}