package com.saydept.api.comm.model;

import java.util.List;

import lombok.Data;

@Data
public class StoreModel extends SayEnvModel{

	private String id;					//조직코드
	private String name;				//조직명
	private String text;				//화면에 출력할 조직명
//	private String iconCls;				//조직 아이콘
	private Boolean leaf;				//자식 존재여부
	private List<StoreModel> children;	//자식 조직
	
}
