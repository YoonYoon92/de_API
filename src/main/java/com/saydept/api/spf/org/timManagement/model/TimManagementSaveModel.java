package com.saydept.api.spf.org.timManagement.model;

import java.util.List;

import com.saydept.api.comm.model.SayEnvModel;

//import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class TimManagementSaveModel  extends SayEnvModel{

	private String ms03Mod  	; 	//수정삭제	구분자
	private String ms03Sabun  	; 	//수정삭제 사용자

	private String ms03Jum;	//점코드        
	private String ms03Bu; 	//부코드        
	private String ms03Tim;	//팀코드        

	private String ms03JumNm;       //점명
	private String ms03BuNm;        //부명
	private String ms03TimNm;        //팀명
	   // MS0301         2A         COLHDG(' 점번호 ')  
	   // MS0302         2A         COLHDG(' 부서번호 ')
	   // MS0303         2A         COLHDG(' 팀번호 ')  
	   // MS0304        24J         COLHDG(' 점명 ')    
	   // MS0305        20J         COLHDG(' 부서명 ')  
	   // MS0306        20J         COLHDG(' 팀명 ')    
	      
//	private String ms0306;       //        20J         COLHDG(' 팀명 ')        
	private Double ms0307;       //         5  0       COLHDG(' 직영인원 ')    
	private Double ms0308;       //         5  0       COLHDG(' 팀판촉인원 ')  
	private Double ms0309;       //         5  0       COLHDG(' 팀총평수 ')    
	private Double ms0310;       //         5  0       COLHDG(' 팀전용면적 ')  
	private Double ms0311;       //         5  0       COLHDG(' 팀공유면적 ')  
	private String ms0312;       //         2A         COLHDG(' 내부부서코드 ')
	private String ms0313;       //        16J         COLHDG(' 팀장명 ')      
	private String ms0314;       //         8A         COLHDG(' 등록 USER-ID') 
	private String ms0315;       //         8A         COLHDG(' 변경 USER-ID') 
	private String ms0316;       //         8A         COLHDG(' 코드부여일 ')  
	private String ms0317;       //         8A         COLHDG(' 코드수정일 ')  
	private String ms0318;       //         8A         COLHDG(' 코드폐기일 ')  
}