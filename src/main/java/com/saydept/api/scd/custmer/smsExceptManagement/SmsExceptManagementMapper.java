package com.saydept.api.scd.custmer.smsExceptManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.scd.custmer.smsExceptManagement.model.SmsExceptManagementModel;

@Mapper
public interface SmsExceptManagementMapper {

	SmsExceptManagementModel selectSmsExceptManagement(SmsExceptManagementModel request);

	List<SmsExceptManagementModel> selectSmsExceptManagementList(SmsExceptManagementModel request);

	int updateSmsExceptManagement(SmsExceptManagementModel request);

	int insertSmsExceptManagement(SmsExceptManagementModel request);

	int saveSmsExceptManagement(SmsExceptManagementModel request);

	int deleteSmsExceptManagement(SmsExceptManagementModel request);

}