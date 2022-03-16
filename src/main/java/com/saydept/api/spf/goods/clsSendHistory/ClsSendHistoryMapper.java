package com.saydept.api.spf.goods.clsSendHistory;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.goods.clsSendHistory.model.ClsSendHistoryModel;

@Mapper
public interface ClsSendHistoryMapper {


	List<ClsSendHistoryModel> selectClsSendHistoryList(ClsSendHistoryModel request);
	List<ClsSendHistoryModel> selectClsList(ClsSendHistoryModel request);
	List<ClsSendHistoryModel> selectCls2List(ClsSendHistoryModel request);

}