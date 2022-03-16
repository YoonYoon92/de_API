package com.saydept.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 2020.04.16 최용권
 * Exception Handler 공통 처리
 * @author dydrn
 *
 */
@RestControllerAdvice(annotations = RestController.class)
public class SayExceptionHandler {

	@Autowired
	private SayUtils sayUtils;
	
	@ExceptionHandler(Exception.class)
	public void sayExceptionHandler(Exception e, HttpServletResponse respones) {
		sayUtils.errorLogger(e, respones,"99", "Server Error!!.");
	}
	
	@ExceptionHandler(BadSqlGrammarException.class)
	public void sayBadSqlGrammarExceptionHandler(Exception e, HttpServletResponse respones) {
		sayUtils.errorLogger(e, respones, "01", "SQL 처리중 문제가 발생했습니다.");
	}
	
	@ExceptionHandler(UncategorizedSQLException.class)
	public void sayUncategorizedSQLExceptionHandler(Exception e, HttpServletResponse respones) {
		sayUtils.errorLogger(e, respones, "01", "SQL 처리중 문제가 발생했습니다.");
	}
	
	@ExceptionHandler(MyBatisSystemException.class)
	public void sayMyBatisSystemExceptionHandler(Exception e, HttpServletResponse respones) {
		sayUtils.errorLogger(e, respones, "01", "SQL 처리중 문제가 발생했습니다.");
	}
	
	@ExceptionHandler(NullPointerException.class)
	public void sayNullPointExceptionHandler(Exception e, HttpServletResponse respones) {
		sayUtils.errorLogger(e, respones, "02", "데이터 처리중 문제가 발생했습니다.");
	}

	@ExceptionHandler(IOException.class)
	public void sayIoExceptionHandler(Exception e, HttpServletResponse respones){
		sayUtils.errorLogger(e, respones, "03", "데이터 송수신중 문제가 발생했습니다.");
	}
	
	@ExceptionHandler(JSONException.class)
	public void sayJSONExceptionHandler(Exception e, HttpServletResponse respones){
		sayUtils.errorLogger(e, respones, "04", "수신 전문 처리중 문제가 발생했습니다.");
	}
	
}
