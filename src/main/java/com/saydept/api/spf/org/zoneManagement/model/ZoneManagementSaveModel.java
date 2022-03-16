package com.saydept.api.spf.org.zoneManagement.model;

import java.util.List;

import com.saydept.api.comm.model.SayEnvModel;

//import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ZoneManagementSaveModel extends SayEnvModel  {
	
	private String ms21Mod  	; 	//수정삭제	구분자
	private String ms21Sabun  	; 	//수정삭제 사용자

	private String ms21Jum;	//점코드        
	private String ms21Bu; 	//부코드        
	private String ms21Tim;	//팀코드
	private String ms21Pc;	//Pc코드
	private String ms04PcNm;	//Pc명
	private String ms21Zone;//존코드
	private String ms21ZoneNm;        //존명
//	MS2101         2A         COLHDG(' 점　번호 ')
//	MS2102         2A         COLHDG(' 부서번호 ')
//	MS2103         2A         COLHDG(' 팀　번호 ')
//	MS2104         2A         COLHDG(' ＰＣ번호 ')
//	MS2105         3A         COLHDG(' 존　번호 ')
//	MS2106        30J         COLHDG(' 존　　명 ')
  	      
	private Double ms2107;	//         5  0       COLHDG(' 전용면적 ')     
	private Double ms2108;	//         5  0       COLHDG(' 공유면적 ')     
	private Double ms2109;	//         5P         COLHDG(' 직영인원 ') 
	private Double ms2110;	//         5  0       COLHDG(' 판촉인원 ')     
	private String ms2111;	//         8          COLHDG(' 코드부여일 ')   
	private String ms2112;	//         8          COLHDG(' 코드수정일 ')   
	private String ms2113;	//         8          COLHDG(' 코드폐기일 ')   
}