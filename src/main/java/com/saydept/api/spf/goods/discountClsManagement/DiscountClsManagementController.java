package com.saydept.api.spf.goods.discountClsManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.goods.discountClsManagement.model.DiscountClsManagementModel;

@CrossOrigin(origins = "*")
@RestController
public class DiscountClsManagementController {

	@Autowired
	private DiscountClsManagementService discountClsManagementService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/discountClsManagement", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectDiscountClsManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/discountClsManagement/selectDiscountClsManagement", method = RequestMethod.POST)
	public DiscountClsManagementModel selectDiscountClsManagement(@RequestBody DiscountClsManagementModel request)throws Exception {

		DiscountClsManagementModel result = discountClsManagementService.selectDiscountClsManagement(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectDiscountClsManagementList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/discountClsManagement/selectDiscountClsManagementList", method = RequestMethod.POST)
	public List<DiscountClsManagementModel> selectDiscountClsManagementList(@RequestBody DiscountClsManagementModel request)throws Exception {

		List<DiscountClsManagementModel> result = discountClsManagementService.selectDiscountClsManagementList(request);
		return result;
	}

	/**
	 * 데이터 수정
	 * 작성방법은 update'업무를 구분할 명칭'
	 * Ex)updateDiscountClsManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/discountClsManagement/updateDiscountClsManagement", method = RequestMethod.POST)
	public int updateDiscountClsManagement(@RequestBody DiscountClsManagementModel request)throws Exception {

		int result = discountClsManagementService.updateDiscountClsManagement(request);
		return result;
	}

	/**
	 * 데이터 등록
	 * 작성방법은 insert'업무를 구분할 명칭'
	 * Ex)insertDiscountClsManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/discountClsManagement/insertDiscountClsManagement", method = RequestMethod.POST)
	public int insertDiscountClsManagement(@RequestBody DiscountClsManagementModel request)throws Exception {

		int result = discountClsManagementService.insertDiscountClsManagement(request);
		return result;
	}

	/**
	 * 데이터 수정+등록 Ex) 데이터가 없으면 insert 없으면 update 작업을 동시 처리할때
	 * 작성방법은 save'업무를 구분할 명칭'
	 * Ex)saveDiscountClsManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/discountClsManagement/saveDiscountClsManagement", method = RequestMethod.POST)
	public int saveDiscountClsManagement(@RequestBody DiscountClsManagementModel request)throws Exception {

		int result = discountClsManagementService.saveDiscountClsManagement(request);
		return result;
	}

	/**
	 * 데이터 삭제
	 * 작성방법은 delete'업무를 구분할 명칭'
	 * Ex)deleteDiscountClsManagement
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/discountClsManagement/deleteDiscountClsManagement", method = RequestMethod.POST)
	public int deleteDiscountClsManagement(@RequestBody DiscountClsManagementModel request)throws Exception {

		int result = discountClsManagementService.deleteDiscountClsManagement(request);
		return result;
	}

}