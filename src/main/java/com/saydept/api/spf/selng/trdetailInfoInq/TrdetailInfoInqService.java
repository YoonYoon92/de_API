package com.saydept.api.spf.selng.trdetailInfoInq;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.corpSaleNews.model.CorpSaleNewsModel;
import com.saydept.api.spf.selng.trdetailInfoInq.model.TrdetailInfoInqModel;
import com.saydept.api.spf.selng.trdetailInfoInq.model.TrdetailInfoInqParamModel;


	@Service
	public class TrdetailInfoInqService {

	@Autowired
	private TrdetailInfoInqMapper trdetailInfoInqMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public TrdetailInfoInqModel selectTrdetailInfoInq(TrdetailInfoInqParamModel request)throws Exception {

	TrdetailInfoInqModel result = trdetailInfoInqMapper.selectTrdetailInfoInq(request);
	TrdetailInfoInqParamModel cardparam =  new TrdetailInfoInqParamModel();
	TrdetailInfoInqParamModel cardresult =  new TrdetailInfoInqParamModel();
	
	TrdetailInfoInqModel lastResult = new TrdetailInfoInqModel();
	lastResult.setStartDt(result.getStartDt());
	lastResult.setSaleDiv(result.getSaleDiv());
	lastResult.setPayDiv1(result.getPayDiv1());
	lastResult.setPayDiv2(result.getPayDiv2());
	lastResult.setPayDiv3(result.getPayDiv3());
	lastResult.setPayDiv4(result.getPayDiv4());
	lastResult.setPayDiv5(result.getPayDiv5());
	lastResult.setPayAmt1(result.getPayAmt1());
	lastResult.setPayAmt2(result.getPayAmt2());
	lastResult.setPayAmt3(result.getPayAmt3());
	lastResult.setPayAmt4(result.getPayAmt4());
	lastResult.setPayAmt5(result.getPayAmt5());
	
	if (lastResult.getPayDiv1().equals("카드")) {
	
	if (result.getData1().substring(0).equals("3")) {
		int amt =Integer.parseInt(result.getData1().substring(64,73));
		
		if (Integer.parseInt(result.getData1().substring(64,73))==result.getPayAmt1()) {
			lastResult.setCardNum1(result.getData1().substring(6,24));
			lastResult.setAppNum1(result.getData1().substring(54,62));
			lastResult.setChitNum1(result.getData1().substring(1,5));
			
			cardparam.setCardNum(result.getData1().substring(6,24).trim());
			cardparam.setAppNum(result.getData1().substring(54,62).trim());
			cardparam.setChitNum(result.getData1().substring(1,5).trim());
			cardparam.setStartDt(request.getStartDt());

			cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
			lastResult.setVan1(cardresult.getVan());
			
			}
	}
	else if (result.getData2().substring(0,1).equals("3") ) {
	
		int amt =Integer.parseInt(result.getData2().substring(64,73));
		
		if (Integer.parseInt(result.getData2().substring(64,73))==result.getPayAmt1()) {
			lastResult.setCardNum1(result.getData2().substring(6,24));
			lastResult.setAppNum1(result.getData2().substring(54,62));
			lastResult.setChitNum1(result.getData2().substring(1,5));
			
			cardparam.setCardNum(result.getData2().substring(6,24).trim());
			cardparam.setAppNum(result.getData2().substring(54,62).trim());
			cardparam.setChitNum(result.getData2().substring(1,5).trim());
			cardparam.setStartDt(request.getStartDt());

			cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
			lastResult.setVan1(cardresult.getVan());
		
			}
	}
	else if (result.getData3().substring(0,1).equals("3")) {
		int amt =Integer.parseInt(result.getData3().substring(64,73));
				
		if (Integer.parseInt(result.getData3().substring(64,73))==result.getPayAmt1()) {
			lastResult.setCardNum1(result.getData3().substring(6,24));
			lastResult.setAppNum1(result.getData3().substring(54,62));
			lastResult.setChitNum1(result.getData3().substring(1,5));
			
			cardparam.setCardNum(result.getData3().substring(6,24).trim());
			cardparam.setAppNum(result.getData3().substring(54,62).trim());
			cardparam.setChitNum(result.getData3().substring(1,5).trim());
			cardparam.setStartDt(request.getStartDt());

			cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
			lastResult.setVan1(cardresult.getVan());
			}
	}
	else if (result.getData4().substring(0,1).equals("3")) {
		int amt =Integer.parseInt(result.getData4().substring(64,73));
		
		if (Integer.parseInt(result.getData4().substring(64,73))==result.getPayAmt1()) {
			lastResult.setCardNum1(result.getData4().substring(6,24));
			lastResult.setAppNum1(result.getData4().substring(54,62));
			lastResult.setChitNum1(result.getData4().substring(1,5));
			
			cardparam.setCardNum(result.getData4().substring(6,24).trim());
			cardparam.setAppNum(result.getData4().substring(54,62).trim());
			cardparam.setChitNum(result.getData4().substring(1,5).trim());
			cardparam.setStartDt(request.getStartDt());

			cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
			lastResult.setVan1(cardresult.getVan());
			}
	}
	else if (result.getData5().substring(0,1).equals("3")) {
		int amt =Integer.parseInt(result.getData5().substring(64,73));
		
		if (Integer.parseInt(result.getData5().substring(64,73))==result.getPayAmt1()) {
			lastResult.setCardNum1(result.getData5().substring(6,24));
			lastResult.setAppNum1(result.getData5().substring(54,62));
			lastResult.setChitNum1(result.getData5().substring(1,5));
			
			cardparam.setCardNum(result.getData5().substring(6,24).trim());
			cardparam.setAppNum(result.getData5().substring(54,62).trim());
			cardparam.setChitNum(result.getData5().substring(1,5).trim());
			cardparam.setStartDt(request.getStartDt());

			cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
			lastResult.setVan1(cardresult.getVan());
			}
	}
	else if (result.getData6().substring(0,1).equals("3")) {
		int amt =Integer.parseInt(result.getData6().substring(64,73));
		
		if (Integer.parseInt(result.getData6().substring(64,73))==result.getPayAmt1()) {
			lastResult.setCardNum1(result.getData6().substring(6,24));
			lastResult.setAppNum1(result.getData6().substring(54,62));
			lastResult.setChitNum1(result.getData6().substring(1,5));
			
			cardparam.setCardNum(result.getData6().substring(6,24).trim());
			cardparam.setAppNum(result.getData6().substring(54,62).trim());
			cardparam.setChitNum(result.getData6().substring(1,5).trim());
			cardparam.setStartDt(request.getStartDt());

			cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
			lastResult.setVan1(cardresult.getVan());
			}
	}
	else if (result.getData7().substring(0,1).equals("3")) {
		int amt =Integer.parseInt(result.getData7().substring(64,73));
		
		if (Integer.parseInt(result.getData7().substring(64,73))==result.getPayAmt1()) {
			lastResult.setCardNum1(result.getData7().substring(6,24));
			lastResult.setAppNum1(result.getData7().substring(54,62));
			lastResult.setChitNum1(result.getData7().substring(1,5));
			
			cardparam.setCardNum(result.getData7().substring(6,24).trim());
			cardparam.setAppNum(result.getData7().substring(54,62).trim());
			cardparam.setChitNum(result.getData7().substring(1,5).trim());
			cardparam.setStartDt(request.getStartDt());

			cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
			lastResult.setVan1(cardresult.getVan());
			}
	}
	else if (result.getData8().substring(0,1).equals("3")) {
		int amt =Integer.parseInt(result.getData8().substring(64,73));
		
		if (Integer.parseInt(result.getData8().substring(64,73))==result.getPayAmt1()) {
			lastResult.setCardNum1(result.getData8().substring(6,24));
			lastResult.setAppNum1(result.getData8().substring(54,62));
			lastResult.setChitNum1(result.getData8().substring(1,5));
			
			cardparam.setCardNum(result.getData8().substring(6,24).trim());
			cardparam.setAppNum(result.getData8().substring(54,62).trim());
			cardparam.setChitNum(result.getData8().substring(1,5).trim());
			cardparam.setStartDt(request.getStartDt());

			cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
			lastResult.setVan1(cardresult.getVan());
			}
	}
	else if (result.getData9().substring(0,1).equals("3")) {
		int amt =Integer.parseInt(result.getData9().substring(64,73));
		
		if (Integer.parseInt(result.getData9().substring(64,73))==result.getPayAmt1()) {
			lastResult.setCardNum1(result.getData9().substring(6,24));
			lastResult.setAppNum1(result.getData9().substring(54,62));
			lastResult.setChitNum1(result.getData9().substring(1,5));
			
			cardparam.setCardNum(result.getData9().substring(6,24).trim());
			cardparam.setAppNum(result.getData9().substring(54,62).trim());
			cardparam.setChitNum(result.getData9().substring(1,5).trim());
			cardparam.setStartDt(request.getStartDt());

			cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
			lastResult.setVan1(cardresult.getVan());
			}
	}
	
	if (lastResult.getPayDiv2().equals("카드")) {
		
		if (result.getData1().substring(0).equals("3")) {
			int amt =Integer.parseInt(result.getData1().substring(64,73));
			
			if (Integer.parseInt(result.getData1().substring(64,73))==result.getPayAmt2()) {
				lastResult.setCardNum2(result.getData1().substring(6,24));
				lastResult.setAppNum2(result.getData1().substring(54,62));
				lastResult.setChitNum2(result.getData1().substring(1,5));
				
				cardparam.setCardNum(result.getData1().substring(6,24).trim());
				cardparam.setAppNum(result.getData1().substring(54,62).trim());
				cardparam.setChitNum(result.getData1().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan2(cardresult.getVan());
				}
		}
		else if (result.getData2().substring(0,1).equals("3") ) {
		
			int amt =Integer.parseInt(result.getData2().substring(64,73));
			
			if (Integer.parseInt(result.getData2().substring(64,73))==result.getPayAmt2()) {
				lastResult.setCardNum2(result.getData2().substring(6,24));
				lastResult.setAppNum2(result.getData2().substring(54,62));
				lastResult.setChitNum2(result.getData2().substring(1,5));
				
				cardparam.setCardNum(result.getData2().substring(6,24).trim());
				cardparam.setAppNum(result.getData2().substring(54,62).trim());
				cardparam.setChitNum(result.getData2().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan2(cardresult.getVan());
				
				}
			
		
		}
		else if (result.getData3().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData3().substring(64,73));
					
			if (Integer.parseInt(result.getData3().substring(64,73))==result.getPayAmt2()) {
				lastResult.setCardNum2(result.getData3().substring(6,24));
				lastResult.setAppNum2(result.getData3().substring(54,62));
				lastResult.setChitNum2(result.getData3().substring(1,5));
				
				cardparam.setCardNum(result.getData3().substring(6,24).trim());
				cardparam.setAppNum(result.getData3().substring(54,62).trim());
				cardparam.setChitNum(result.getData3().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan2(cardresult.getVan());
				}
		}
		else if (result.getData4().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData4().substring(64,73));
			
			if (Integer.parseInt(result.getData4().substring(64,73))==result.getPayAmt2()) {
				lastResult.setCardNum2(result.getData4().substring(6,24));
				lastResult.setAppNum2(result.getData4().substring(54,62));
				lastResult.setChitNum2(result.getData4().substring(1,5));
				
				cardparam.setCardNum(result.getData4().substring(6,24).trim());
				cardparam.setAppNum(result.getData4().substring(54,62).trim());
				cardparam.setChitNum(result.getData4().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan2(cardresult.getVan());
				}
		}
		else if (result.getData5().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData5().substring(64,73));
			
			if (Integer.parseInt(result.getData5().substring(64,73))==result.getPayAmt2()) {
				lastResult.setCardNum2(result.getData5().substring(6,24));
				lastResult.setAppNum2(result.getData5().substring(54,62));
				lastResult.setChitNum2(result.getData5().substring(1,5));
				cardparam.setCardNum(result.getData5().substring(6,24).trim());
				cardparam.setAppNum(result.getData5().substring(54,62).trim());
				cardparam.setChitNum(result.getData5().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan2(cardresult.getVan());
				}
		}
		else if (result.getData6().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData6().substring(64,73));
			
			if (Integer.parseInt(result.getData6().substring(64,73))==result.getPayAmt2()) {
				lastResult.setCardNum2(result.getData6().substring(6,24));
				lastResult.setAppNum2(result.getData6().substring(54,62));
				lastResult.setChitNum2(result.getData6().substring(1,5));
				cardparam.setCardNum(result.getData6().substring(6,24).trim());
				cardparam.setAppNum(result.getData6().substring(54,62).trim());
				cardparam.setChitNum(result.getData6().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan2(cardresult.getVan());
				}
		}
		else if (result.getData7().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData7().substring(64,73));
			
			if (Integer.parseInt(result.getData7().substring(64,73))==result.getPayAmt2()) {
				lastResult.setCardNum2(result.getData7().substring(6,24));
				lastResult.setAppNum2(result.getData7().substring(54,62));
				lastResult.setChitNum2(result.getData7().substring(1,5));
				cardparam.setCardNum(result.getData7().substring(6,24).trim());
				cardparam.setAppNum(result.getData7().substring(54,62).trim());
				cardparam.setChitNum(result.getData7().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan2(cardresult.getVan());
				}
		}
		else if (result.getData8().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData8().substring(64,73));
			
			if (Integer.parseInt(result.getData8().substring(64,73))==result.getPayAmt2()) {
				lastResult.setCardNum2(result.getData8().substring(6,24));
				lastResult.setAppNum2(result.getData8().substring(54,62));
				lastResult.setChitNum2(result.getData8().substring(1,5));
				
				cardparam.setCardNum(result.getData8().substring(6,24).trim());
				cardparam.setAppNum(result.getData8().substring(54,62).trim());
				cardparam.setChitNum(result.getData8().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan2(cardresult.getVan());
				}
		}
		else if (result.getData9().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData9().substring(64,73));
			
			if (Integer.parseInt(result.getData9().substring(64,73))==result.getPayAmt2()) {
				lastResult.setCardNum2(result.getData9().substring(6,24));
				lastResult.setAppNum2(result.getData9().substring(54,62));
				lastResult.setChitNum2(result.getData9().substring(1,5));
				
				cardparam.setCardNum(result.getData9().substring(6,24).trim());
				cardparam.setAppNum(result.getData9().substring(54,62).trim());
				cardparam.setChitNum(result.getData9().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan2(cardresult.getVan());
				}
		}
		}
	
	if (lastResult.getPayDiv3().equals("카드")) {
		
		if (result.getData1().substring(0).equals("3")) {
			int amt =Integer.parseInt(result.getData1().substring(64,73));
			
			if (Integer.parseInt(result.getData1().substring(64,73))==result.getPayAmt3()) {
				lastResult.setCardNum3(result.getData1().substring(6,24));
				lastResult.setAppNum3(result.getData1().substring(54,62));
				lastResult.setChitNum3(result.getData1().substring(1,5));
				cardparam.setCardNum(result.getData1().substring(6,24).trim());
				cardparam.setAppNum(result.getData1().substring(54,62).trim());
				cardparam.setChitNum(result.getData1().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan3(cardresult.getVan());
				}
		}
		else if (result.getData2().substring(0,1).equals("3") ) {
		
			int amt =Integer.parseInt(result.getData2().substring(64,73));
			
			if (Integer.parseInt(result.getData2().substring(64,73))==result.getPayAmt3()) {
				lastResult.setCardNum3(result.getData2().substring(6,24));
				lastResult.setAppNum3(result.getData2().substring(54,62));
				lastResult.setChitNum3(result.getData2().substring(1,5));
				cardparam.setCardNum(result.getData2().substring(6,24).trim());
				cardparam.setAppNum(result.getData2().substring(54,62).trim());
				cardparam.setChitNum(result.getData2().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan3(cardresult.getVan());
				}
		}
		else if (result.getData3().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData3().substring(64,73));
					
			if (Integer.parseInt(result.getData3().substring(64,73))==result.getPayAmt3()) {
				lastResult.setCardNum3(result.getData3().substring(6,24));
				lastResult.setAppNum3(result.getData3().substring(54,62));
				lastResult.setChitNum3(result.getData3().substring(1,5));
				cardparam.setCardNum(result.getData3().substring(6,24).trim());
				cardparam.setAppNum(result.getData3().substring(54,62).trim());
				cardparam.setChitNum(result.getData3().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan3(cardresult.getVan());
				}
		}
		else if (result.getData4().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData4().substring(64,73));
			
			if (Integer.parseInt(result.getData4().substring(64,73))==result.getPayAmt3()) {
				lastResult.setCardNum3(result.getData4().substring(6,24));
				lastResult.setAppNum3(result.getData4().substring(54,62));
				lastResult.setChitNum3(result.getData4().substring(1,5));
				cardparam.setCardNum(result.getData4().substring(6,24).trim());
				cardparam.setAppNum(result.getData4().substring(54,62).trim());
				cardparam.setChitNum(result.getData4().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan3(cardresult.getVan());
				}
		}
		else if (result.getData5().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData5().substring(64,73));
			
			if (Integer.parseInt(result.getData5().substring(64,73))==result.getPayAmt3()) {
				lastResult.setCardNum3(result.getData5().substring(6,24));
				lastResult.setAppNum3(result.getData5().substring(54,62));
				lastResult.setChitNum3(result.getData5().substring(1,5));
				cardparam.setCardNum(result.getData5().substring(6,24).trim());
				cardparam.setAppNum(result.getData5().substring(54,62).trim());
				cardparam.setChitNum(result.getData5().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan3(cardresult.getVan());
				}
		}
		else if (result.getData6().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData6().substring(64,73));
			
			if (Integer.parseInt(result.getData6().substring(64,73))==result.getPayAmt3()) {
				lastResult.setCardNum3(result.getData6().substring(6,24));
				lastResult.setAppNum3(result.getData6().substring(54,62));
				lastResult.setChitNum3(result.getData6().substring(1,5));
				cardparam.setCardNum(result.getData6().substring(6,24).trim());
				cardparam.setAppNum(result.getData6().substring(54,62).trim());
				cardparam.setChitNum(result.getData6().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan3(cardresult.getVan());
				}
		}
		else if (result.getData7().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData7().substring(64,73));
			
			if (Integer.parseInt(result.getData7().substring(64,73))==result.getPayAmt3()) {
				lastResult.setCardNum3(result.getData7().substring(6,24));
				lastResult.setAppNum3(result.getData7().substring(54,62));
				lastResult.setChitNum3(result.getData7().substring(1,5));
				cardparam.setCardNum(result.getData7().substring(6,24).trim());
				cardparam.setAppNum(result.getData7().substring(54,62).trim());
				cardparam.setChitNum(result.getData7().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan3(cardresult.getVan());
				}
		}
		else if (result.getData8().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData8().substring(64,73));
			
			if (Integer.parseInt(result.getData8().substring(64,73))==result.getPayAmt3()) {
				lastResult.setCardNum3(result.getData8().substring(6,24));
				lastResult.setAppNum3(result.getData8().substring(54,62));
				lastResult.setChitNum3(result.getData8().substring(1,5));
				cardparam.setCardNum(result.getData8().substring(6,24).trim());
				cardparam.setAppNum(result.getData8().substring(54,62).trim());
				cardparam.setChitNum(result.getData8().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan3(cardresult.getVan());
				}
		}
		else if (result.getData9().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData9().substring(64,73));
			
			if (Integer.parseInt(result.getData9().substring(64,73))==result.getPayAmt3()) {
				lastResult.setCardNum3(result.getData9().substring(6,24));
				lastResult.setAppNum3(result.getData9().substring(54,62));
				lastResult.setChitNum3(result.getData9().substring(1,5));
				cardparam.setCardNum(result.getData9().substring(6,24).trim());
				cardparam.setAppNum(result.getData9().substring(54,62).trim());
				cardparam.setChitNum(result.getData9().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan3(cardresult.getVan());
				}
		}
		}
	if (lastResult.getPayDiv4().equals("카드")) {
		
		if (result.getData1().substring(0).equals("3")) {
			int amt =Integer.parseInt(result.getData1().substring(64,73));
			
			if (Integer.parseInt(result.getData1().substring(64,73))==result.getPayAmt4()) {
				lastResult.setCardNum4(result.getData1().substring(6,24));
				lastResult.setAppNum4(result.getData1().substring(54,62));
				lastResult.setChitNum4(result.getData1().substring(1,5));
				cardparam.setCardNum(result.getData1().substring(6,24).trim());
				cardparam.setAppNum(result.getData1().substring(54,62).trim());
				cardparam.setChitNum(result.getData1().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan4(cardresult.getVan());
				}
		}
		else if (result.getData2().substring(0,1).equals("3") ) {
		
			int amt =Integer.parseInt(result.getData2().substring(64,73));
			
			if (Integer.parseInt(result.getData2().substring(64,73))==result.getPayAmt4()) {
				lastResult.setCardNum4(result.getData2().substring(6,24));
				lastResult.setAppNum4(result.getData2().substring(54,62));
				lastResult.setChitNum4(result.getData2().substring(1,5));
				cardparam.setCardNum(result.getData2().substring(6,24).trim());
				cardparam.setAppNum(result.getData2().substring(54,62).trim());
				cardparam.setChitNum(result.getData2().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan4(cardresult.getVan());
				}
		}
		else if (result.getData3().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData3().substring(64,73));
					
			if (Integer.parseInt(result.getData3().substring(64,73))==result.getPayAmt4()) {
				lastResult.setCardNum4(result.getData3().substring(6,24));
				lastResult.setAppNum4(result.getData3().substring(54,62));
				lastResult.setChitNum4(result.getData3().substring(1,5));
				cardparam.setCardNum(result.getData3().substring(6,24).trim());
				cardparam.setAppNum(result.getData3().substring(54,62).trim());
				cardparam.setChitNum(result.getData3().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan4(cardresult.getVan());
				}
		}
		else if (result.getData4().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData4().substring(64,73));
			
			if (Integer.parseInt(result.getData4().substring(64,73))==result.getPayAmt4()) {
				lastResult.setCardNum4(result.getData4().substring(6,24));
				lastResult.setAppNum4(result.getData4().substring(54,62));
				lastResult.setChitNum4(result.getData4().substring(1,5));
				cardparam.setCardNum(result.getData4().substring(6,24).trim());
				cardparam.setAppNum(result.getData4().substring(54,62).trim());
				cardparam.setChitNum(result.getData4().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan4(cardresult.getVan());
				}
		}
		else if (result.getData5().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData5().substring(64,73));
			
			if (Integer.parseInt(result.getData5().substring(64,73))==result.getPayAmt4()) {
				lastResult.setCardNum4(result.getData5().substring(6,24));
				lastResult.setAppNum4(result.getData5().substring(54,62));
				lastResult.setChitNum4(result.getData5().substring(1,5));
				cardparam.setCardNum(result.getData5().substring(6,24).trim());
				cardparam.setAppNum(result.getData5().substring(54,62).trim());
				cardparam.setChitNum(result.getData5().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan4(cardresult.getVan());
				}
		}
		else if (result.getData6().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData6().substring(64,73));
			
			if (Integer.parseInt(result.getData6().substring(64,73))==result.getPayAmt4()) {
				lastResult.setCardNum4(result.getData6().substring(6,24));
				lastResult.setAppNum4(result.getData6().substring(54,62));
				lastResult.setChitNum4(result.getData6().substring(1,5));
				cardparam.setCardNum(result.getData6().substring(6,24).trim());
				cardparam.setAppNum(result.getData6().substring(54,62).trim());
				cardparam.setChitNum(result.getData6().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan4(cardresult.getVan());
				}
		}
		else if (result.getData7().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData7().substring(64,73));
			
			if (Integer.parseInt(result.getData7().substring(64,73))==result.getPayAmt4()) {
				lastResult.setCardNum4(result.getData7().substring(6,24));
				lastResult.setAppNum4(result.getData7().substring(54,62));
				lastResult.setChitNum4(result.getData7().substring(1,5));
				cardparam.setCardNum(result.getData7().substring(6,24).trim());
				cardparam.setAppNum(result.getData7().substring(54,62).trim());
				cardparam.setChitNum(result.getData7().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan4(cardresult.getVan());
				}
		}
		else if (result.getData8().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData8().substring(64,73));
			
			if (Integer.parseInt(result.getData8().substring(64,73))==result.getPayAmt4()) {
				lastResult.setCardNum4(result.getData8().substring(6,24));
				lastResult.setAppNum4(result.getData8().substring(54,62));
				lastResult.setChitNum4(result.getData8().substring(1,5));
				cardparam.setCardNum(result.getData8().substring(6,24).trim());
				cardparam.setAppNum(result.getData8().substring(54,62).trim());
				cardparam.setChitNum(result.getData8().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan4(cardresult.getVan());
				}
		}
		else if (result.getData9().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData9().substring(64,73));
			
			if (Integer.parseInt(result.getData9().substring(64,73))==result.getPayAmt4()) {
				lastResult.setCardNum4(result.getData9().substring(6,24));
				lastResult.setAppNum4(result.getData9().substring(54,62));
				lastResult.setChitNum4(result.getData9().substring(1,5));
				cardparam.setCardNum(result.getData9().substring(6,24).trim());
				cardparam.setAppNum(result.getData9().substring(54,62).trim());
				cardparam.setChitNum(result.getData9().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan4(cardresult.getVan());
				}
		}
		}
if (lastResult.getPayDiv5().equals("카드")) {
		
		if (result.getData1().substring(0).equals("3")) {
			int amt =Integer.parseInt(result.getData1().substring(64,73));
			
			if (Integer.parseInt(result.getData1().substring(64,73))==result.getPayAmt5()) {
				lastResult.setCardNum5(result.getData1().substring(6,24));
				lastResult.setAppNum5(result.getData1().substring(54,62));
				lastResult.setChitNum5(result.getData1().substring(1,5));
				cardparam.setCardNum(result.getData1().substring(6,24).trim());
				cardparam.setAppNum(result.getData1().substring(54,62).trim());
				cardparam.setChitNum(result.getData1().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan5(cardresult.getVan());
				}
		}
		else if (result.getData2().substring(0,1).equals("3") ) {
		
			int amt =Integer.parseInt(result.getData2().substring(64,73));
			
			if (Integer.parseInt(result.getData2().substring(64,73))==result.getPayAmt5()) {
				lastResult.setCardNum5(result.getData2().substring(6,24));
				lastResult.setAppNum5(result.getData2().substring(54,62));
				lastResult.setChitNum5(result.getData2().substring(1,5));
				cardparam.setCardNum(result.getData2().substring(6,24).trim());
				cardparam.setAppNum(result.getData2().substring(54,62).trim());
				cardparam.setChitNum(result.getData2().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan5(cardresult.getVan());
				}
		}
		else if (result.getData3().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData3().substring(64,73));
					
			if (Integer.parseInt(result.getData3().substring(64,73))==result.getPayAmt5()) {
				lastResult.setCardNum5(result.getData3().substring(6,24));
				lastResult.setAppNum5(result.getData3().substring(54,62));
				lastResult.setChitNum5(result.getData3().substring(1,5));
				cardparam.setCardNum(result.getData3().substring(6,24).trim());
				cardparam.setAppNum(result.getData3().substring(54,62).trim());
				cardparam.setChitNum(result.getData3().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan5(cardresult.getVan());
				}
		}
		else if (result.getData4().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData4().substring(64,73));
			
			if (Integer.parseInt(result.getData4().substring(64,73))==result.getPayAmt5()) {
				lastResult.setCardNum5(result.getData4().substring(6,24));
				lastResult.setAppNum5(result.getData4().substring(54,62));
				lastResult.setChitNum5(result.getData4().substring(1,5));
				cardparam.setCardNum(result.getData4().substring(6,24).trim());
				cardparam.setAppNum(result.getData4().substring(54,62).trim());
				cardparam.setChitNum(result.getData4().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan5(cardresult.getVan());
				}
		}
		else if (result.getData5().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData5().substring(64,73));
			
			if (Integer.parseInt(result.getData5().substring(64,73))==result.getPayAmt5()) {
				lastResult.setCardNum5(result.getData5().substring(6,24));
				lastResult.setAppNum5(result.getData5().substring(54,62));
				lastResult.setChitNum5(result.getData5().substring(1,5));
				cardparam.setCardNum(result.getData5().substring(6,24).trim());
				cardparam.setAppNum(result.getData5().substring(54,62).trim());
				cardparam.setChitNum(result.getData5().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan5(cardresult.getVan());
				}
		}
		else if (result.getData6().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData6().substring(64,73));
			
			if (Integer.parseInt(result.getData6().substring(64,73))==result.getPayAmt5()) {
				lastResult.setCardNum5(result.getData6().substring(6,24));
				lastResult.setAppNum5(result.getData6().substring(54,62));
				lastResult.setChitNum5(result.getData6().substring(1,5));
				cardparam.setCardNum(result.getData6().substring(6,24).trim());
				cardparam.setAppNum(result.getData6().substring(54,62).trim());
				cardparam.setChitNum(result.getData6().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan5(cardresult.getVan());
				}
		}
		else if (result.getData7().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData7().substring(64,73));
			
			if (Integer.parseInt(result.getData7().substring(64,73))==result.getPayAmt5()) {
				lastResult.setCardNum5(result.getData7().substring(6,24));
				lastResult.setAppNum5(result.getData7().substring(54,62));
				lastResult.setChitNum5(result.getData7().substring(1,5));
				cardparam.setCardNum(result.getData7().substring(6,24).trim());
				cardparam.setAppNum(result.getData7().substring(54,62).trim());
				cardparam.setChitNum(result.getData7().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan5(cardresult.getVan());
				}
		}
		else if (result.getData8().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData8().substring(64,73));
			
			if (Integer.parseInt(result.getData8().substring(64,73))==result.getPayAmt5()) {
				lastResult.setCardNum5(result.getData8().substring(6,24));
				lastResult.setAppNum5(result.getData8().substring(54,62));
				lastResult.setChitNum5(result.getData8().substring(1,5));
				cardparam.setCardNum(result.getData8().substring(6,24).trim());
				cardparam.setAppNum(result.getData8().substring(54,62).trim());
				cardparam.setChitNum(result.getData8().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan5(cardresult.getVan());
				}
		}
		else if (result.getData9().substring(0,1).equals("3")) {
			int amt =Integer.parseInt(result.getData9().substring(64,73));
			
			if (Integer.parseInt(result.getData9().substring(64,73))==result.getPayAmt5()) {
				lastResult.setCardNum5(result.getData9().substring(6,24));
				lastResult.setAppNum5(result.getData9().substring(54,62));
				lastResult.setChitNum5(result.getData9().substring(1,5));
				cardparam.setCardNum(result.getData9().substring(6,24).trim());
				cardparam.setAppNum(result.getData9().substring(54,62).trim());
				cardparam.setChitNum(result.getData9().substring(1,5).trim());
				cardparam.setStartDt(request.getStartDt());

				cardresult=trdetailInfoInqMapper.selectVanChk(cardparam);
				lastResult.setVan5(cardresult.getVan());
				}
		}
		}
	}
	
	System.out.println(request);
	System.out.println(lastResult);
	return lastResult;
	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<TrdetailInfoInqParamModel> dataList(TrdetailInfoInqParamModel request)throws Exception {

		List<TrdetailInfoInqParamModel> result = trdetailInfoInqMapper.dataList(request);
		ArrayList<TrdetailInfoInqParamModel> resultList =  new ArrayList<TrdetailInfoInqParamModel>();
		for( TrdetailInfoInqParamModel data :  result) {
			//resultList.setData(result.getData1());
			
		}
		
		return resultList;

	}


}