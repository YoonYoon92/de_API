package com.saydept.api.spf.saleNews.eventHistoryInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.saleNews.eventHistoryInq.model.EventHistoryInqModel;


@Mapper
public interface EventHistoryInqMapper {

	EventHistoryInqModel selectEventHistoryInq(EventHistoryInqModel request);

	List<EventHistoryInqModel> selectEventHistoryInqList(EventHistoryInqModel request);

	

}