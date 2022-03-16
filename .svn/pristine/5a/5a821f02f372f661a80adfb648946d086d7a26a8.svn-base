package com.saydept.api.Template.tamplate1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.Template.tamplate1.model.Tamplate1Model;
import com.saydept.api.comm.model.GridModel;
import com.saydept.api.comm.model.SearchModel;

@CrossOrigin(origins = "*")
@RestController
public class Tamplate1Controller {

	@Autowired
	private Tamplate1Service tamplate1Service;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/tamplate1", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectTamplate1
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/tamplate1/selectTamplate1", method = RequestMethod.POST)
	public Tamplate1Model selectTamplate1(@RequestBody Tamplate1Model request)throws Exception {

		Tamplate1Model result = tamplate1Service.selectTamplate1(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectTamplate1List
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/tamplate1/selectTamplate1List")
	public GridModel selectTamplate1List(@ModelAttribute SearchModel request)throws Exception {
		
		System.out.println("&&&&&&&&&&&&&&&&&&&param");
		System.out.println(request.toString());
		System.out.println("&&&&&&&&&&&&&&&&&&&param");
		
		
		List<Tamplate1Model> result = tamplate1Service.selectTamplate1List(request);
		
		System.out.println("*************************");
		System.out.println(result.get(0).getTotCnt());
		System.out.println("*************************");
		
		GridModel gridModel = new GridModel();
		gridModel.setRows(result);
		gridModel.setTotCnt(result.get(0).getTotCnt());
		
		return gridModel;
	}
	
	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectTamplate1List
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/tamplate1/selectTamplate1List2", method = RequestMethod.POST)
	public List<Tamplate1Model> selectTamplate1List2(@RequestBody SearchModel request)throws Exception {

		System.out.println(request.toString());
		List<Tamplate1Model> result = tamplate1Service.selectTamplate1List2(request);
		
		System.out.println("*************************");
		System.out.println(result.size());
		System.out.println("*************************");
		
		return result;
	}

	/**
	 * 데이터 수정
	 * 작성방법은 update'업무를 구분할 명칭'
	 * Ex)updateTamplate1
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/tamplate1/updateTamplate1", method = RequestMethod.POST)
	public int updateTamplate1(@RequestBody Tamplate1Model request)throws Exception {

		int result = tamplate1Service.updateTamplate1(request);
		return result;
	}

	/**
	 * 데이터 등록
	 * 작성방법은 insert'업무를 구분할 명칭'
	 * Ex)insertTamplate1
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/tamplate1/insertTamplate1", method = RequestMethod.POST)
	public int insertTamplate1(@RequestBody Tamplate1Model request)throws Exception {

		int result = tamplate1Service.insertTamplate1(request);
		return result;
	}

	/**
	 * 데이터 수정+등록 Ex) 데이터가 없으면 insert 없으면 update 작업을 동시 처리할때
	 * 작성방법은 save'업무를 구분할 명칭'
	 * Ex)saveTamplate1
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/tamplate1/saveTamplate1", method = RequestMethod.POST)
	public int saveTamplate1(@RequestBody Tamplate1Model request)throws Exception {

		int result = tamplate1Service.saveTamplate1(request);
		return result;
	}

	/**
	 * 데이터 삭제
	 * 작성방법은 delete'업무를 구분할 명칭'
	 * Ex)deleteTamplate1
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/tamplate1/deleteTamplate1", method = RequestMethod.POST)
	public int deleteTamplate1(@RequestBody Tamplate1Model request)throws Exception {

		int result = tamplate1Service.deleteTamplate1(request);
		return result;
	}

}