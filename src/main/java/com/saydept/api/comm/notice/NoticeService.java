package com.saydept.api.comm.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.comm.notice.model.NoticeModel;
import com.saydept.api.comm.notice.model.NoticeSaveModel;

	@Service
	//@Transactional
	public class NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public NoticeModel selectNotice(NoticeModel request)throws Exception {

	NoticeModel result = noticeMapper.selectNotice(request);
	return result;

	}

	/**조직코드와 유저아이디 받고, 해당조직의 직원리스트 리턴
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<NoticeModel> selectNoticeList(NoticeModel request)throws Exception {
		List<NoticeModel> result;
		
		System.out.println(request);
	   
		result = noticeMapper.selectNoticeList(request);
		System.out.println("-----------------------------------------------------");
		System.out.println(result);
		return result;

	}


	/**
	 * 
	 * @param request
	 * @return
	 */
	public int saveNotice(NoticeSaveModel request) {
		
		int result = 0;
		
		noticeMapper.saveNotice1(request);
		System.out.println("svaenotice1complete");
		
		if(request.getMs82rsabuns()!=null) {
		for(String userId : request.getMs82rsabuns()) {
			request.setMs82rsabun(userId);
			
			result += noticeMapper.saveNotice2(request);
			System.out.println("svaenotice1complete2");
			}
		}		
		
		return result;
	}


}