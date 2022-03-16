package com.saydept.api.spf.selng.cardApprLogInq;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saydept.api.spf.selng.cardApprLogInq.model.CardApprLogInqModel;
import com.saydept.api.spf.selng.cardApprLogInq.model.CardApprLogInqParamModel;
import com.saydept.utils.SayUtils;

@CrossOrigin(origins = "*")
@RestController
public class CardApprLogInqController {

	@Autowired
	private CardApprLogInqService CardApprLogInqService;

	/**
	 * API 상태체크
	 * @return
	 */
	@RequestMapping(value = "api/spf/selng/selectCardApprLogInq", method = RequestMethod.GET)
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
	@RequestMapping(value = "api/spf/selng/selectCardApprLogInqList", method = RequestMethod.POST)
	public List<CardApprLogInqModel> selectCardApprLogInqList(@RequestBody CardApprLogInqParamModel request)throws Exception {

		ArrayList<CardApprLogInqModel> result = new ArrayList<CardApprLogInqModel>();
		String pattern = ".*[0-9].*"; //숫자만
		int numTxtPos;
		if(request.getSearchCardCoNm() != null) {
			request.setSearchCardCoNmUpper(request.getSearchCardCoNm().toUpperCase());
			request.setSearchCardCoNmLower(request.getSearchCardCoNm().toLowerCase());
			request.setSearchCardCoNmFullChar(SayUtils.toFullChar(request.getSearchCardCoNm()));
			request.setSearchCardCoNmFullCharUpper(SayUtils.toFullChar(request.getSearchCardCoNmUpper()));
			request.setSearchCardCoNmFullCharLower(SayUtils.toFullChar(request.getSearchCardCoNmLower()));
		}
		if(request.getSearchCardNo() != null) {
			request.setSearchCardNo(request.getSearchCardNo().trim());
		}
		List<CardApprLogInqModel> cardApprLogInqModel = CardApprLogInqService.selectCardApprLogInqList(request);
		
		for(CardApprLogInqModel cardApprLog: cardApprLogInqModel) {
			
			numTxtPos = 0;
			//승인 카드사코드/카드사명 분리, 매입사코드/매입사명 분리
			if(cardApprLog.getApprCardCo() != null && cardApprLog.getApprCardCo() != "") {
				cardApprLog.setApprCardCoCd(cardApprLog.getApprCardCo().substring(0, 2));			 
				for(int i = 2; i < cardApprLog.getApprCardCo().length(); i++) {
				    if(Pattern.matches(pattern, cardApprLog.getApprCardCo().substring(i, i+1))) {
				    	numTxtPos = i;
				    	i=cardApprLog.getApprCardCo().length();
				    }
				}
				if(numTxtPos != 0) {
					cardApprLog.setApprCardCoNm(cardApprLog.getApprCardCo().substring(2,numTxtPos));
					cardApprLog.setApprMaeipCoCd(cardApprLog.getApprCardCo().substring(numTxtPos,numTxtPos+2));
					cardApprLog.setApprMaeipCoNm(cardApprLog.getApprCardCo().substring(numTxtPos+2,cardApprLog.getApprCardCo().length()));
				}
			}
			
			
			//카드프리픽스마스터 search
//			request.setSearchCardNo(cardApprLog.getCardNoNonMask());
//			CardApprLogInqParamModel cardPrefixModel = CardApprLogInqMapper.selectCardPrefixInqList(request);
//			cardApprLog.setRepNo(cardPrefixModel.getRepNo());
//			cardApprLog.setCardCoNm(cardPrefixModel.getCardCoNm());		
			
			result.add(cardApprLog);
		}
	
		return result;
	}

}