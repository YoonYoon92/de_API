package com.saydept.api.admin.userProgListManagement.model;

import java.util.List;

import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.ProgramParameter;
import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class UserProgListManagementSaveModel extends SayEnvModel{

	private String zd0201  	; 	//메뉴그룹id
	private String zd0202  	; 	//메뉴id
	private String zd0203   ;   //프로그램id            
	private String zd0204   ;   //프로그램명
	private String zd0205   ;   //아이콘명
	private String zd0206   ;   //정렬순서
	private String zd0207   ;   //PROGRAM OLD-ID
	private String zd0208   ;   //FILLER_01
	private String zd0209   ;   //FILLER_01
//	private String zd02Mod  ;   //A,U
	private String zd02Result;
}