package com.saydept.api.comm.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.comm.notice.model.NoticeModel;
import com.saydept.api.comm.notice.model.NoticeSaveModel;

@Mapper
public interface NoticeMapper {

	NoticeModel selectNotice(NoticeModel request);

	List<NoticeModel> selectNoticeList(NoticeModel request);

	int updateNotice(NoticeModel request);

	int saveNotice1(NoticeSaveModel request);
	int saveNotice2(NoticeSaveModel request);

	int saveNotice(NoticeSaveModel request);

	int deleteNotice(NoticeModel request);

}