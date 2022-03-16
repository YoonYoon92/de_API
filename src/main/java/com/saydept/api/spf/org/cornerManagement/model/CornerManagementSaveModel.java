package com.saydept.api.spf.org.cornerManagement.model;

import java.util.List;

import com.saydept.api.comm.model.SayEnvModel;

//import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class CornerManagementSaveModel extends SayEnvModel {

	private String ms05Mod  	; 	//수정삭제	구분자
	private String ms05Sabun  	; 	//수정삭제 사용자

	private String ms05Jum      ;   //점코드            
	private String ms05JumNm    ;   //점명
	private String ms05Bu      ;   //부코드            
	private String ms05BuNm    ;   //부명
	private String ms05Tim      ;   //팀코드            
	private String ms05TimNm    ;   //팀명
	private String ms05Pc      ;   //pc코드            
	private String ms05PcNm    ;   //pc명
	private String ms05Corner ;		//코너
	private String ms05CornerNm ;	//코너명
	private String ms05CornerOn ;	//온라인코너
	private String ms0511;   //1          COLHDG(' 코너등급 ')    
	private Double ms0512;   //5P 2       COLHDG(' 코너직영인원 ')
	private Double ms0513;   //5P 2       COLHDG(' 코너판촉인원 ')
	private Double ms0514;   //5P 2       COLHDG(' 코너평수 ')             
	private String ms0515;   //8          COLHDG(' 코드폐기일 ')  
	private String ms0516;   //8          COLHDG(' 코드부여일 ')  
	private String ms0517;   //8          COLHDG(' 코드수정일 ')  
	private String ms0518;   //3          COLHDG(' ZONNING 구분 ')
	private String ms0519;   //8          COLHDG(' 등록 USER-ID') 
	private String ms0520;   //8          COLHDG(' 변경 USER-ID')   
	private String ms0521;   //3          COLHDG(' FILLER')
	
	private String ms05211;   //1          COLHDG('pda사용
	private String ms05212;   //1          COLHDG('관리유무
	private String ms05213;   //1          COLHDG('온라인사용
	
	private String ms05703;   //8          COLHDG(' FILLER')
	private String ms05704;   //8          COLHDG(' FILLER')
	private String ms05705;   //8          COLHDG(' FILLER')
	private String ms05103;   //8          COLHDG(' FILLER')
	private String ms05104;   //8          COLHDG(' FILLER')
	private String dgs0204;   //8          COLHDG(' FILLER')
	private String ms05107;   //8          COLHDG(' FILLER')
	private String egs0204;   //8          COLHDG(' FILLER')
	
}