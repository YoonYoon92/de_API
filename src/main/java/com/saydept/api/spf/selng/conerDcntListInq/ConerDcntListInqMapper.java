package com.saydept.api.spf.selng.conerDcntListInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.selng.conerDcntListInq.model.ConerDcntListInqModel;

@Mapper
public interface ConerDcntListInqMapper {

	
	List<ConerDcntListInqModel> selectConerDcntListInqList(ConerDcntListInqModel request);
	
	List<ConerDcntListInqModel> selectConerList(ConerDcntListInqModel request);
	
}