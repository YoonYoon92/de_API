package com.saydept.api.comm.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "env")
public class EnvSetModel {

	private String dbType;
	private String desc;

}
