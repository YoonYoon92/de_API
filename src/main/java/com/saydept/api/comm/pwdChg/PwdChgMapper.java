package com.saydept.api.comm.pwdChg;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.comm.pwdChg.model.PwdChgModel;

@Mapper
public interface PwdChgMapper {

	int selectPwdChg(PwdChgModel request);

	List<PwdChgModel> selectPwdChgList(PwdChgModel request);

	int updatePwdChg(PwdChgModel request);

	int insertPwdChg(PwdChgModel request);

	int savePwdChg(PwdChgModel request);

	int deletePwdChg(PwdChgModel request);

}