package com.saydept.api.spf.org.orgnztInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqModel;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqParamModel;

@Mapper
public interface OrgnztInqMapper {

	OrgnztInqModel selectOrgnztInq(OrgnztInqModel request);
	List<OrgnztInqModel> selectOrgnztInqList(OrgnztInqParamModel request);
	List<OrgnztInqModel> jumselectOrgnztInqList(OrgnztInqParamModel request);
	List<OrgnztInqModel> buselectOrgnztInqList(OrgnztInqParamModel request);
	List<OrgnztInqModel> timselectOrgnztInqList(OrgnztInqParamModel request);
	List<OrgnztInqModel> pcselectOrgnztInqList(OrgnztInqParamModel request);
	List<OrgnztInqParamModel> selectzoneStoreList(OrgnztInqParamModel request);
	List<OrgnztInqModel> zoneStoreList(OrgnztInqParamModel request);
	List<OrgnztInqModel> zoneselectOrgnztInqList(OrgnztInqParamModel request);
	List<OrgnztInqModel> recycleStoreList(OrgnztInqParamModel request);
	
}