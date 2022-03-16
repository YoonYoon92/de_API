package com.saydept.api.spf.org.conerHistoryInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.org.conerHistoryInq.model.ConerHistoryInqModel;
import com.saydept.api.spf.org.conerHistoryInq.model.ConerHistoryInqParamModel;

@Mapper
public interface ConerHistoryInqMapper {

	ConerHistoryInqModel selectConerHistoryInq(ConerHistoryInqModel request);

	List<ConerHistoryInqModel> selectConerHistoryInqList(ConerHistoryInqParamModel request);

	int updateConerHistoryInq(ConerHistoryInqModel request);

	int insertConerHistoryInq(ConerHistoryInqModel request);

	int saveConerHistoryInq(ConerHistoryInqModel request);

	int deleteConerHistoryInq(ConerHistoryInqModel request);

}