package com.saydept.api.spf.rtngud.rtnReqFormInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.rtngud.rtnReqFormInq.model.RtnReqFormInqModel;

@Mapper
public interface RtnReqFormInqMapper {

	RtnReqFormInqModel selectRtnReqFormInq(RtnReqFormInqModel request);

	List<RtnReqFormInqModel> selectRtnReqFormInqList(RtnReqFormInqModel request);
	
	List<RtnReqFormInqModel> selectDetailList(RtnReqFormInqModel request);

	
}