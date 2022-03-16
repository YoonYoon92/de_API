package com.saydept.api.comm;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.comm.model.ProgModel;
import com.saydept.api.comm.model.UserProgModel;

@Mapper
public interface ProgramMapper {

	//메뉴조회
	List<ProgModel> selectMenuList(ProgModel request);
	//환경설정메뉴조회
	List<ProgModel> selectEnvMenuList(ProgModel request);

	//프로그램 목록 조회
	List<ProgModel> selectProgList(ProgModel request);

	//메뉴조회 -- 관리자
	List<ProgModel> selectAdminMenuList(ProgModel request);

	//프로그램 목록 조회 -- 관리자
	List<ProgModel> selectAdminProgList(ProgModel request);

	//메뉴저장 -- 관리자
	int saveAdminProgList(UserProgModel request);
	//메뉴insert -- 관리자
	int insertAdminProgList(UserProgModel request);
	//메뉴update -- 관리자
	int updateAdminProgList(UserProgModel request);
	
	//메뉴조회 -- 사용자
	List<ProgModel> selectUserMenuList(ProgModel request);
	//최근메뉴조회 -- 사용자
	List<ProgModel> selectUserLastMenuList(ProgModel request);

	//프로그램 목록 조회 -- 사용자
	List<ProgModel> selectUserProgList(ProgModel request);
	
	//프로그램 힛팅카운트 update(최초사용기록있을시)
	int UpdateHitCount1(ProgModel request);	
	//프로그램 힛팅카운트 update(최초사용일없을시)
	int UpdateHitCount2(ProgModel request);	
}