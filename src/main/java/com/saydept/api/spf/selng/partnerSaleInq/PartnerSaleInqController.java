package com.saydept.api.spf.selng.partnerSaleInq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saydept.api.spf.selng.partnerSaleInq.model.PartnerSaleInqModel;

@CrossOrigin(origins = "*")
@RestController
public class PartnerSaleInqController {

	@Autowired
	private PartnerSaleInqService partnerSaleInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/partnerSaleInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	
	//협력업체리스트
		@RequestMapping(value = "api/partnerSaleInq/selectPartnerList", method = RequestMethod.POST)
		public List<PartnerSaleInqModel> selectPartnerList(@RequestBody PartnerSaleInqModel request)throws Exception {
	
			List<PartnerSaleInqModel> result = partnerSaleInqService.selectPartnerList(request);
			return result;
		}

	//클래스리스트
		@RequestMapping(value = "api/partnerSaleInq/selectClsList", method = RequestMethod.POST)
		public List<PartnerSaleInqModel> selectClsList(@RequestBody PartnerSaleInqModel request)throws Exception {

			List<PartnerSaleInqModel> result = partnerSaleInqService.selectClsList(request);
			return result;
		}
		//품목리스트
		@RequestMapping(value = "api/partnerSaleInq/selectGlsList", method = RequestMethod.POST)
		public List<PartnerSaleInqModel> selectGlsList(@RequestBody PartnerSaleInqModel request)throws Exception {

			List<PartnerSaleInqModel> result = partnerSaleInqService.selectGlsList(request);
			return result;
			}
	//조회리스트
		@RequestMapping(value = "api/partnerSaleInq/selectPartnerSaleInqList", method = RequestMethod.POST)
		public List<PartnerSaleInqModel> selectPartnerSaleInqList(@RequestBody PartnerSaleInqModel request)throws Exception {
	
			List<PartnerSaleInqModel> result = partnerSaleInqService.selectPartnerSaleInqList(request);
			return result;
		}
	
	
}