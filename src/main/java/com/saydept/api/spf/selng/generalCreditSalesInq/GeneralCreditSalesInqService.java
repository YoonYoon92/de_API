package com.saydept.api.spf.selng.generalCreditSalesInq;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.selng.generalCreditSalesInq.model.GeneralCreditSalesInqModel;
import com.saydept.api.spf.selng.generalCreditSalesInq.model.GeneralCreditSalesInqPDataModel;
import com.saydept.api.spf.selng.generalCreditSalesInq.model.GeneralCreditSalesInqParamModel;
import com.saydept.api.spf.selng.generalCreditSalesInq.model.GeneralCreditSalesInqTrModel;
import com.saydept.utils.SayUtils;

	@Service
	public class GeneralCreditSalesInqService {

	@Autowired
	private GeneralCreditSalesInqMapper generalCreditSalesInqMapper;
	

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<GeneralCreditSalesInqModel> selectGeneralCreditSalesInqList(GeneralCreditSalesInqParamModel request)throws Exception {

		List<GeneralCreditSalesInqModel> result = generalCreditSalesInqMapper.selectGeneralCreditSalesInqList(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<GeneralCreditSalesInqModel> selectGeneralCreditSalesInqListTr(GeneralCreditSalesInqParamModel request)throws Exception {

		final String PDATA = "P01DATA";
		int ngtv; 
		
		List<GeneralCreditSalesInqModel> result  = new ArrayList<GeneralCreditSalesInqModel>();
		List<GeneralCreditSalesInqTrModel> trModel = new ArrayList<GeneralCreditSalesInqTrModel>();
		GeneralCreditSalesInqParamModel classModel = new GeneralCreditSalesInqParamModel();
		
		trModel = generalCreditSalesInqMapper.selectGeneralCreditSalesInqListTr(request);
		
		for(GeneralCreditSalesInqTrModel tr: trModel) {
			if(tr.getP01HSGU().equals("1") || tr.getP01HSGU().equals("2")) {
				ngtv = -1;
			} else {
				ngtv = 1; 
			}
			
			for(Field field : tr.getClass().getDeclaredFields()) {
				
				field.setAccessible(true);
				Object value = field.get(tr);
				
				String str = field.getName().substring(0,7).toString();
				System.out.println(str);
				if(str.equals(PDATA)) {
					if(value.toString().substring(0, 1).equals("1")) {
						
						
						GeneralCreditSalesInqModel resultRecord = new GeneralCreditSalesInqModel();
						
						if(request.getSaleCls().equals("3")) {
							resultRecord.setClassfication("특판");
						} else {
							resultRecord.setClassfication("COD");
						}
						
						resultRecord.setSaledate(tr.getP01HSYY()+tr.getP01HSMM()+tr.getP01HSDD());
						resultRecord.setRegi(tr.getP01HRNO());
						resultRecord.setReceipt(tr.getP01HTNO());
						resultRecord.setSlpno(tr.getP01CODN());
			
						GeneralCreditSalesInqPDataModel pData = salesData(ngtv, value.toString());
						
						if(pData.getCHK().equals("C") || pData.getCHK().equals("D") ) {
							resultRecord.setClassNo(pData.getCLASS1());
							
							if(!pData.getCLASS1().isBlank()) {
								request.setClassCd(pData.getCLASS1());
								classModel = generalCreditSalesInqMapper.selectGeneralCreditSalesInqListM06(request);
							}
							
							resultRecord.setClassNm(classModel.getClassNm());
							resultRecord.setOrgCd(classModel.getOrgCd());							
						} else if(pData.getCHK().equals("I")) {
							resultRecord.setSingleItemNo(pData.getDATA());
							
							if(!pData.getDATA().isBlank()) {
								request.setBuCd(tr.getP01HRNO().substring(0, 2));
								request.setSingleItemCd(pData.getDATA());							
								classModel = generalCreditSalesInqMapper.selectGeneralCreditSalesInqListM07(request);
							}
							
							resultRecord.setClassNm(classModel.getClassNm());
							resultRecord.setSingleItemNm(classModel.getSingleItemNm());
							resultRecord.setOrgCd(classModel.getOrgCd());
						}
						
						resultRecord.setUnitPrice(pData.getTG());
						resultRecord.setQuantity(pData.getNO());
						resultRecord.setNetAmount(pData.getNO()*pData.getTG()-pData.getHAL());
						resultRecord.setTotalAmount(pData.getNO()*pData.getTG());
						resultRecord.setSaleAmount(pData.getHAL());
						
						System.out.println("Pc: "+ request.getPc() + " |Tim: " + request.getTim() + " |Bu: " + request.getBu() + " |Jum: " + request.getJum());
						System.out.println("orgCd: "+ resultRecord.getOrgCd());
						
						if(request.getPc() != null && request.getPc().length()!=0) {	
							if(resultRecord.getOrgCd().equals(request.getPc())) {
								result.add(resultRecord);
							}
						} else if (request.getTim() != null && request.getTim().length()!=0){
							if(resultRecord.getOrgCd().substring(0, 6).equals(request.getTim())) {
								result.add(resultRecord);
							}
						} else if (request.getBu() != null && request.getBu().length()!=0) {
							if(resultRecord.getOrgCd().substring(0, 4).equals(request.getBu())) {
								result.add(resultRecord);
							}
						} else if (request.getJum() != null && request.getJum().length()!=0) {
							if(resultRecord.getOrgCd().substring(0, 2).equals(request.getJum())) {
								result.add(resultRecord);
							}
						}
						
					}
				}				
			}
		}
		System.out.println("result: " + result);
		return result;

	}
	
	public GeneralCreditSalesInqPDataModel salesData(int ngtv, String pData) throws Exception {
		GeneralCreditSalesInqPDataModel result = new GeneralCreditSalesInqPDataModel();
		
		result.setSJB(pData.substring(0, 1));
		System.out.println("SJB : " + result.getSJB());
		
		result.setCHK(pData.substring(1, 2));
		System.out.println("CHK : " + result.getCHK());
		
		result.setDATA(pData.substring(3, 16));
		System.out.println("DATA : " + result.getDATA());
		
		result.setCDTYPE(pData.substring(5, 6));
		System.out.println("CDTYPE : " + result.getCDTYPE());
		
		result.setCDNO(pData.substring(6,22));
		System.out.println("CDNO : " + result.getCDNO());
		
		result.setGIFNO(pData.substring(6, 17));
		System.out.println("GIFNO : " + result.getGIFNO());
		
		result.setGIFNO_PTNR(pData.substring(6, 19));
		System.out.println("GIFNO_PTNR : " + result.getGIFNO_PTNR());
		
		result.setPOINTER(pData.substring(1, 17));
		System.out.println("POINTER : " + result.getPOINTER());
		
		result.setBACOD(pData.substring(16, 23));
		System.out.println("BACOD : " + result.getBACOD());
		
		result.setCLASS1(pData.substring(16, 23));
		System.out.println("CLASS1 : " + result.getCLASS1());
		
		result.setTG(Double.parseDouble(pData.substring(23, 31))*ngtv);
		System.out.println("TG : " + result.getTG());
		
		result.setCLSSJB(pData.substring(26, 33));
		System.out.println("CLSSJB : " + result.getCLSSJB());
		
		result.setNO(Double.parseDouble(pData.substring(31, 34))*ngtv);
		System.out.println("NO : " + result.getNO());
		
		result.setGIFCD(pData.substring(33, 41));
		System.out.println("GIFCD : " + result.getGIFCD());
		
		result.setHAL(Double.parseDouble(pData.substring(37, 44))*ngtv);
		System.out.println("HAL : " + result.getHAL());
		
		result.setHANGUM(pData.substring(44, 52));
		System.out.println("HANGUM : " + result.getHANGUM());
		
		result.setGIFCLASS(pData.substring(48, 55));
		System.out.println("GIFCLASS : " + result.getGIFCLASS());
		
		result.setCDHK(pData.substring(65, 74));
		System.out.println("GIFNO : " + result.getGIFNO());
		
		return result;
	}


}