package com.saydept.api.scd.custmer.dmEventHisInq;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.scd.custmer.dmEventHisInq.model.DmEventHisInqModel;
import com.saydept.api.scd.custmer.dmEventHisInq.model.DmEventHisInqParamModel;
import com.saydept.api.scd.custmer.dmEventHisInq.model.DmEventHisInqT03Model;
import com.saydept.api.scd.custmer.dmEventHisInq.model.DmEventHisInqT04Model;

@CrossOrigin(origins = "*")
@RestController
public class DmEventHisInqController {

	@Autowired
	private DmEventHisInqService dmEventHisInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/scd/custer/selectDmEventHisInq", method = RequestMethod.GET)
	public String condition() {
		return this.getClass().getName() + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}


	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectSalesByTypeInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/scd/custmer/selectDmEventHisInqList", method = RequestMethod.POST)
	public List<DmEventHisInqModel> selectDmEventHisInqList(@RequestBody DmEventHisInqParamModel request)throws Exception {

		List<DmEventHisInqModel> result = dmEventHisInqService.selectDmEventHisInqList(request);
		return result;
	}


	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectSalesByTypeInqList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/scd/custmer/selectDmEventHisInqDetailList", method = RequestMethod.POST)
	public List<DmEventHisInqT03Model> selectDmEventHisInqT03(@RequestBody DmEventHisInqParamModel request)throws Exception {
		List<DmEventHisInqT03Model> t03Model = new ArrayList<DmEventHisInqT03Model>();
		List<DmEventHisInqT03Model> result = new ArrayList<DmEventHisInqT03Model>();
		DmEventHisInqParamModel req = new DmEventHisInqParamModel();
		DmEventHisInqModel t02Event = new DmEventHisInqModel();
		DmEventHisInqModel commerDist = new DmEventHisInqModel();


		DecimalFormat df = new DecimalFormat("###,###");
		String sValue;
		t03Model = dmEventHisInqService.selectDmEventHisInqT04MaxMin(request);

		//선정대상자의 최대매출액, 최소매출액
		for(DmEventHisInqT03Model t03 : t03Model) {
			t03.setCondDtl(df.format(Double.parseDouble(t03.getCondDtl().trim()))  + " 원");
			result.add(t03);
		}

		t03Model = dmEventHisInqService.selectDmEventHisInqT03(request);
		for(DmEventHisInqT03Model t03 : t03Model) {
			sValue = "";
			//대상자 선정 조건
			switch(t03.getCond()) {
			case "01" :  //매출발생 기간
				t03.setCondDtl(t03.getCondDtl().substring(0, 4) + "년" + t03.getCondDtl().substring(4, 6) + "월" + t03.getCondDtl().substring(6, 8) + "일 ~ " + t03.getCondDtl().substring(8, 12) + "년" + t03.getCondDtl().substring(12, 14) + "월" + t03.getCondDtl().substring(14, 16) + "일");
				break;
			case "02" :  //선정 매출액 ~원 이상
				t03.setCondDtl(df.format(Double.parseDouble(t03.getCondDtl().trim()))  + " 원 이상");
				break;	
			case "03" :  //선정 매출건수 ~건 이상
				t03.setCondDtl(df.format(Double.parseDouble(t03.getCondDtl().trim()))  + " 건 이상");
				break;	
			case "04" :  //선정 회원구분
				if(!t03.getCondDtl().substring(0, 1).isBlank()) {
					sValue = sValue + "LG(" + t03.getCondDtl().substring(0, 1) + ") ";
				}
				if(!t03.getCondDtl().substring(1, 2).isBlank()) {
					sValue = sValue + "플러스(" + t03.getCondDtl().substring(1, 2) + ") ";
				}
				if(!t03.getCondDtl().substring(2, 3).isBlank()) {
					sValue = sValue + "SAY(" + t03.getCondDtl().substring(2, 3) + ") ";
				}
				if(!t03.getCondDtl().substring(3, 4).isBlank()) {
					sValue = sValue + "세이플러스원(" + t03.getCondDtl().substring(3, 4) + ") ";
				}
				if(!t03.getCondDtl().substring(4, 5).isBlank()) {
					sValue = sValue + "FAM(" + t03.getCondDtl().substring(4, 5) + ") ";
				}
				if(!t03.getCondDtl().substring(5, 6).isBlank()) {
					sValue = sValue + "프라임(" + t03.getCondDtl().substring(5, 6) + ") ";
				}
				if(!t03.getCondDtl().substring(6, 7).isBlank()) {
					sValue = sValue + "IBK(" + t03.getCondDtl().substring(6, 7) + ") ";
				}
				t03.setCondDtl(sValue);
				break;		
			case "05" :  //선정 제외조직
				if(!t03.getCondDtl().substring(0, 2).isBlank()) {
					sValue = sValue + " 점:" + t03.getCondDtl().substring(0, 2);
				}
				if(!t03.getCondDtl().substring(2, 4).isBlank()) {
					sValue = sValue + "     부:" + t03.getCondDtl().substring(2, 4);
				}
				if(!t03.getCondDtl().substring(4, 6).isBlank()) {
					sValue = sValue + "     PC:" + t03.getCondDtl().substring(4, 6);
				}
				if(!t03.getCondDtl().substring(6, 11).isBlank()) {
					sValue = sValue + "     코너:" + t03.getCondDtl().substring(6, 11);
				}
				t03.setCondDtl(sValue);
				break;	
			case "06" :  //선정 조직 (점,부,PC,코너, 성별, 연령)
				if(!t03.getCondDtl().substring(0, 2).isBlank()) {
					sValue = sValue + " 점:" + t03.getCondDtl().substring(0, 2);
				}
				if(!t03.getCondDtl().substring(2, 4).isBlank()) {
					sValue = sValue + "    부:" + t03.getCondDtl().substring(2, 4);
				}
				if(!t03.getCondDtl().substring(4, 6).isBlank()) {
					sValue = sValue + "    PC:" + t03.getCondDtl().substring(4, 6);
				}
				if(!t03.getCondDtl().substring(6, 11).isBlank()) {
					sValue = sValue + "    코너:" + t03.getCondDtl().substring(6, 11);
				}
				if(!t03.getCondDtl().substring(11, 12).isBlank()) {
					if(t03.getCondDtl().substring(11, 12)=="1") {
						sValue = sValue + "     성별: 남";
					} else { 
						sValue = sValue + "     성별: 여";
					}
				} else {
					sValue = sValue + "     성별: 남녀모두" ;
				}
				if(!t03.getCondDtl().substring(12, 15).isBlank() && Double.parseDouble(t03.getCondDtl().substring(12, 15))!=0) {
					sValue = sValue + "     연령: " + df.format(Double.parseDouble(t03.getCondDtl().substring(12, 15))) + "세 ~";
					if(!t03.getCondDtl().substring(15, 18).isBlank()) {
						sValue = sValue + df.format(Double.parseDouble(t03.getCondDtl().substring(15, 18))) + "세";
					}
				}
				t03.setCondDtl(sValue);
				break;				
			case "07" :  //선정조건(상권)
				req.setCommerDistCd(t03.getCondDtl().trim());
				commerDist = dmEventHisInqService.selectDmEventHisInqM12(req);
				t03.setCondDtl(t03.getCondDtl().trim() + "- "+ commerDist.getCommerDistNm().trim() + ", " +commerDist.getCommerDistArNm().trim());
				break;
			case "08" :  //선정조건(지역-구우편번호) --미사용
				break;
			case "09" :  //선정조건(아파트-구우편번호)  --미사용
				break;
			case "10" :  //선정조건(반응행사)
			case "11" :  //선정조건(제외행사)
				req.setJum(t03.getCondDtl().substring(0, 2));
				req.setEventStartDt(t03.getCondDtl().substring(2, 10));
				req.setEventNo(t03.getCondDtl().substring(10, 18));
				t02Event = dmEventHisInqService.selectDmEventHisInqT02(req);
				t03.setCondDtl("점: "+ t03.getCondDtl().substring(0, 2) + " 행사시작일:" + t03.getCondDtl().substring(2, 10) +" 행사번호:" + t03.getCondDtl().substring(10, 15)+"00" + t03.getCondDtl().substring(15, 18) + " 행사명: "+ t02Event.getEventNm().trim());
				break;	
			case "12" :  //선정조건(매출순위)
				t03.setCondDtl(df.format(Double.parseDouble(t03.getCondDtl().trim().substring(0, 6)))  + " 위  ~ " + df.format(Double.parseDouble(t03.getCondDtl().trim().substring(7, 12)))  + " 위");
				break;	
			case "13" :  //요청건수
				t03.setCondDtl(df.format(Double.parseDouble(t03.getCondDtl().trim()))  + " 건");
				break;
			case "14" :  //선정조건(직영/가족 포함유무)
				if(!t03.getCondDtl().substring(0, 1).isBlank()) {
					sValue = sValue + " 직영사원포함 ";
				}
				if(!t03.getCondDtl().substring(1, 2).isBlank()) {
					sValue = sValue + " 가족사원포함 ";
				}
				break;
			case "15" :  //선정조건(휴면기간, 건수, 금액)
				break;
			case "16" :  //선정조건(직원전용) --미사용
				break;
			case "18" :  //선정조건(아파트 동 코드) --미사용
				break;
			default:
				break;			
			}			
			result.add(t03);
		}
		return result;
	}


	/**
	 * 복수 대상 조회
	 * 작성방법은 select'업무를 구분할 명칭'List
	 * Ex)selectDmEventHisInqT04CrtPson
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "api/scd/custmer/selectDmEventHisInqT04List", method = RequestMethod.POST)
	public List<DmEventHisInqT04Model> selectDmEventHisInqT04CrtPson(@RequestBody DmEventHisInqParamModel request)throws Exception {

		List<DmEventHisInqT04Model> result = dmEventHisInqService.selectDmEventHisInqT04CrtPson(request);
		return result;
	}

}