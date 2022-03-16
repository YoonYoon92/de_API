package com.saydept.api.spf.org.pcManagement.model;

import java.util.List;

import com.saydept.api.comm.model.SayEnvModel;

//import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class PcManagementSaveModel extends SayEnvModel {

	private String ms04Mod  	; 	//수정삭제	구분자
	private String ms04Sabun  	; 	//수정삭제 사용자
	
	private String ms04Jum;	//점코드        
	private String ms04Bu; 	//부코드        
	private String ms04Tim;	//팀코드
	private String ms04Pc;	//Pc코드

	private String ms04JumNm;       //점명
	private String ms04BuNm;        //부명
	private String ms04TimNm;        //팀명
	private String ms04PcNm;        //팀명
//	MS0401         2          COLHDG(' 점번호 ')  
//	MS0402         2          COLHDG(' 부서번호 ')
//	MS0403         2          COLHDG(' 팀번호 ')  
//	MS0404         2          COLHDG(' ＰＣ번호 ')
//	MS0405        24J         COLHDG(' 점명 ')    
//	MS0406        20J         COLHDG(' 부서명 ')  
//	MS0407        20J         COLHDG(' 팀명 ')    
//	MS0408        20J         COLHDG(' ＰＣ명 ')  
  	      
	private Double ms0409;	//         5P         COLHDG(' ＰＣ직영인원 ') 
	private Double ms0410;	//         5P         COLHDG(' ＰＣ총평수 ')   
	private String ms0411;	//         2          COLHDG(' 층수 ')         
	private Double ms0412;	//         5  0       COLHDG(' 판촉인원 ')     
	private Double ms0413;	//         5  0       COLHDG(' 전용면적 ')     
	private Double ms0414;	//         5  0       COLHDG(' 공유면적 ')     
	private String ms0415;	//        16J         COLHDG(' ＰＣ장명 ')     
	private String ms0416;	//         8          COLHDG(' 등록 USER-ID')  
	private String ms0417;	//         8          COLHDG(' 변경 USER-ID')  
	private String ms0418;	//         8          COLHDG(' 코드폐기일 ')   
	private String ms0419;	//         8          COLHDG(' 코드부여일 ')   
	private String ms0420;	//         8          COLHDG(' 코드수정일 ')   
}