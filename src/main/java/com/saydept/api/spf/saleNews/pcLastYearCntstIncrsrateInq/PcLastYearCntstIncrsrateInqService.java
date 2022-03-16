package com.saydept.api.spf.saleNews.pcLastYearCntstIncrsrateInq;

import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.saleNews.pcLastYearCntstIncrsrateInq.model.PcLastYearCntstIncrsrateInqModel;
import com.saydept.api.spf.saleNews.pcLastYearCntstIncrsrateInq.model.PcLastYearCntstIncrsrateInqParamModel;

import com.saydept.utils.SayUtils;

	@Service
	public class PcLastYearCntstIncrsrateInqService {

	@Autowired
	private PcLastYearCntstIncrsrateInqMapper PCLastYearCntstIncrsrateInqMapper;
	@Autowired
	private SayUtils sayUtils;

	public List<PcLastYearCntstIncrsrateInqModel> PCLastYearCntstIncrsrateInqList(PcLastYearCntstIncrsrateInqParamModel request) throws ParseException {
		
		
		request.setLastyearstartDt(sayUtils.getCusomYear(request.getStartDt(), -1 ));
		request.setLastyearendDt(sayUtils.getCusomYear(request.getEndDt(), -1 ));
		System.out.println(request);
		List<PcLastYearCntstIncrsrateInqModel> CornerList = PCLastYearCntstIncrsrateInqMapper.getAll(request);
		
		return CornerList;

		
	}
	
public List<PcLastYearCntstIncrsrateInqParamModel> selectzoneStoreList(PcLastYearCntstIncrsrateInqParamModel request) throws ParseException {
		
		
		System.out.println(request);
		List<PcLastYearCntstIncrsrateInqParamModel> ZoneList = PCLastYearCntstIncrsrateInqMapper.selectzoneStoreList(request);
		System.out.println(ZoneList);
		return ZoneList;

		
	}
}