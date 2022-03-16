package com.saydept.api.comm.model;

import java.util.List;

import lombok.Data;

@Data
public class ProgModel extends SayEnvModel{

	
	private	String userId;				//User ID
	private String id;					//프로그램 ID
	private String name;				//프로그램 명
	private String text;				//화면에 출력할 프로그램명
	private String iconCls;				//프로그램 아이콘
	private Boolean leaf;				//자식 존재여부
	private Boolean checked;
	private List<ProgModel> children;	//자식메뉴
	
}
