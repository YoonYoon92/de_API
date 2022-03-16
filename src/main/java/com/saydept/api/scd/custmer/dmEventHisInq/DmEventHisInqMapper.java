package com.saydept.api.scd.custmer.dmEventHisInq;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.scd.custmer.dmEventHisInq.model.DmEventHisInqModel;
import com.saydept.api.scd.custmer.dmEventHisInq.model.DmEventHisInqParamModel;
import com.saydept.api.scd.custmer.dmEventHisInq.model.DmEventHisInqT03Model;
import com.saydept.api.scd.custmer.dmEventHisInq.model.DmEventHisInqT04Model;

@Mapper
public interface DmEventHisInqMapper {


	List<DmEventHisInqModel> selectDmEventHisInqList(DmEventHisInqParamModel request);

	DmEventHisInqModel selectDmEventHisInqT04Count(DmEventHisInqParamModel request);

	int updateDmEventT02End(DmEventHisInqParamModel request);
	
	int updateDmEventT02ReWork(DmEventHisInqParamModel request);
	
	int updateDmEventT02XWork(DmEventHisInqParamModel request);
	
	int updateDmEventT02Init(DmEventHisInqParamModel request);
	
	int updateDmEventT02SendCnt(DmEventHisInqParamModel request);
	
	int deleteDmEventT04Init(DmEventHisInqParamModel request);
	
	int deleteDmEventT05Init(DmEventHisInqParamModel request);
	
	int deleteDmEventT04DelUp(DmEventHisInqParamModel request);
	
	int deleteDmEventT04DelDown(DmEventHisInqParamModel request);
	
	List<DmEventHisInqT03Model> selectDmEventHisInqT03(DmEventHisInqParamModel request);
	
	List<DmEventHisInqT03Model> selectDmEventHisInqT04MaxMin(DmEventHisInqParamModel request);
	
	List<DmEventHisInqT04Model> selectDmEventHisInqT04CrtPson(DmEventHisInqParamModel request);
	
	DmEventHisInqModel selectDmEventHisInqT02(DmEventHisInqParamModel request);
	
	DmEventHisInqModel selectDmEventHisInqM12(DmEventHisInqParamModel request);
	
}