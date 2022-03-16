package com.saydept.api.spf.saleNews.yearCornerSaleNews;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.saleNews.yearCornerSaleNews.model.YearCornerSaleNewsParamModel;
import com.saydept.api.spf.saleNews.yearCornerSaleNews.model.YearCornerSaleNewsModel;

@CrossOrigin(origins = "*")
@RestController
public class YearCornerSaleNewsController {

	@Autowired
	private YearCornerSaleNewsService yearCornerSaleNewsService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/yearCornerSaleNews", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 단일 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'
	 * Ex) selectYearCornerSaleNews
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/yearCornerSaleNews/selectYearCornerSaleNews", method = RequestMethod.POST)
	public YearCornerSaleNewsModel selectYearCornerSaleNews(@RequestBody YearCornerSaleNewsParamModel request)throws Exception {

		YearCornerSaleNewsModel result = yearCornerSaleNewsService.selectYearCornerSaleNews(request);
		return result;
	}

	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectYearCornerSaleNewsList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/yearCornerSaleNews/selectYearCornerSaleNewsList", method = RequestMethod.POST)
	public List<YearCornerSaleNewsModel> selectYearCornerSaleNewsList(@RequestBody YearCornerSaleNewsParamModel request)throws Exception {

		List<YearCornerSaleNewsModel> result = yearCornerSaleNewsService.selectYearCornerSaleNewsList(request);
		return result;
	}

	/**
	 * 데이터 수정
	 * 작성방법은 update'업무를 구분할 명칭'
	 * Ex)updateYearCornerSaleNews
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/yearCornerSaleNews/updateYearCornerSaleNews", method = RequestMethod.POST   )
	public int updateYearCornerSaleNews(@RequestBody YearCornerSaleNewsParamModel request)throws Exception {

		int result = yearCornerSaleNewsService.updateYearCornerSaleNews(request);
		return result;
	}

	/**
	 * 데이터 등록
	 * 작성방법은 insert'업무를 구분할 명칭'
	 * Ex)insertYearCornerSaleNews
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/yearCornerSaleNews/insertYearCornerSaleNews", method = RequestMethod.POST)
	public int insertYearCornerSaleNews(@RequestBody YearCornerSaleNewsParamModel request)throws Exception {

		int result = yearCornerSaleNewsService.insertYearCornerSaleNews(request);
		return result;
	}

	/**
	 * 데이터 수정+등록 Ex) 데이터가 없으면 insert 없으면 update 작업을 동시 처리할때
	 * 작성방법은 save'업무를 구분할 명칭'
	 * Ex)saveYearCornerSaleNews
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/yearCornerSaleNews/saveYearCornerSaleNews", method = RequestMethod.POST)
	public int saveYearCornerSaleNews(@RequestBody YearCornerSaleNewsParamModel request)throws Exception {

		int result = yearCornerSaleNewsService.saveYearCornerSaleNews(request);
		return result;
	}

	/**
	 * 데이터 삭제
	 * 작성방법은 delete'업무를 구분할 명칭'
	 * Ex)deleteYearCornerSaleNews
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/yearCornerSaleNews/deleteYearCornerSaleNews", method = RequestMethod.POST)
	public int deleteYearCornerSaleNews(@RequestBody YearCornerSaleNewsParamModel request)throws Exception {

		int result = yearCornerSaleNewsService.deleteYearCornerSaleNews(request);
		return result;
	}

}