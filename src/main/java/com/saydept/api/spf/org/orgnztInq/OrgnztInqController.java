package com.saydept.api.spf.org.orgnztInq;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqModel;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqParamModel;
import com.saydept.api.spf.saleNews.conerPlanCntstPerfomSts.model.ConerPlanCntstPerfomStsModel;
import com.saydept.utils.SayUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@CrossOrigin(origins = "*")
@RestController
public class OrgnztInqController {

	@Autowired
	private OrgnztInqService orgnztInqService;
	@Autowired
	private SayUtils sayUtils;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/orgnztInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 * 리스트조회
	 */
	@RequestMapping(value = "api/orgnztInq/selectOrgnztInqList", method = RequestMethod.POST)
	public List<OrgnztInqModel> selectOrgnztInqList(@RequestBody OrgnztInqParamModel request)throws Exception {

		List<OrgnztInqModel> result = orgnztInqService.selectOrgnztInqList(request);
		return result;
	}
	
	/**
	 * 존리스트조회
	 */
	@RequestMapping(value = "api/orgnztInq/selectzoneStoreList", method = RequestMethod.POST)
	public List<OrgnztInqParamModel> selectzoneStoreList(@RequestBody OrgnztInqParamModel request)throws Exception {

		List<OrgnztInqParamModel> result = orgnztInqService.selectzoneStoreList(request);
		return result;
	}
	
	/**
	 * 존리스트조회
	 */
	@RequestMapping(value = "api/orgnztInq/zoneStoreList", method = RequestMethod.POST)
	public List<OrgnztInqModel> zoneStoreList(@RequestBody OrgnztInqParamModel request)throws Exception {
		
		List<OrgnztInqModel> result = orgnztInqService.zoneStoreList(request);
		return result;
	}
	/**
	 * 존리스트조회
	 */
	@RequestMapping(value = "api/orgnztInq/recycleStoreList", method = RequestMethod.POST)
	public List<OrgnztInqModel> recycleStoreList(@RequestBody OrgnztInqParamModel request)throws Exception {
		
		List<OrgnztInqModel> result = orgnztInqService.recycleStoreList(request);
		return result;
	}
	
	
}