package com.saydept.api.comm.model;

import java.util.List;

import lombok.Data;

@Data
public class GridModel extends SayEnvModel{
	
	
	private List<?> rows;
	private int totCnt;
}
