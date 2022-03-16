package com.saydept.api.spf.saleNews.clsSaleNews;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.clsSaleNews.model.ClsSaleNewsModel;
import com.saydept.api.spf.saleNews.clsSaleNews.model.ClsSaleNewsParamModel;
import com.saydept.utils.SayUtils;

@Service
public class ClsSaleNewsService {

	@Autowired
	private ClsSaleNewsMapper clsSaleNewsMapper;
	
	@Autowired
	private SayUtils sayUtils;

	public List<ClsSaleNewsModel> clsSaleNewsList(ClsSaleNewsParamModel request) throws ParseException {
		// TODO Auto-generated method stub

		if(request.getJum() == null) {
			request.setJum("01");
		}
		if(request.getBu() == null) {
			request.setBu("");
		}
		if(request.getTim() == null) {
			request.setTim("");
		}
		if(request.getOnlineChk() == null) {
			request.setOnlineChk("A");
		}
//		request.setOnlineChk("");
		
	
		List<ClsSaleNewsModel> resultList = new ArrayList<ClsSaleNewsModel>();

//		request.setOnlineChkN("N");
		System.out.println("Service1");
		System.out.println(request); 					//로그 찍기
			/**
			 * 1. 해당 부 리스트 조회
			 */
			List<ClsSaleNewsModel> ClsSaleNewsList = clsSaleNewsMapper.getClsSaleNewslist(request);
			for( ClsSaleNewsModel data :  ClsSaleNewsList) {
				ClsSaleNewsModel model = new ClsSaleNewsModel();
				model.setBu( data.getBu() );
				model.setBuNm( data.getBuNm() );
				model.setCls( data.getCls() );
				model.setClsNm( data.getClsNm() );
				model.setDdTotsale( data.getDdTotsale() );
				model.setDdDsicount( data.getDdDsicount() );
				model.setDdNetsale( data.getDdNetsale() );
				model.setMmNetsale( data.getMmNetsale() );
				model.setYyNetsale( data.getYyNetsale() );
				
				resultList.add( model );
			}
		
		return resultList;
	}
	
	/**/
	public List<ClsSaleNewsModel> clsSaleNewsListA(ClsSaleNewsParamModel request) throws ParseException {
		// TODO Auto-generated method stub

		if(request.getJum() == null) {
			request.setJum("01");
		}
		if(request.getBu() == null) {
			request.setBu("");
		}
		if(request.getTim() == null) {
			request.setTim("");
		}
		if(request.getOnlineChk() == null) {
			request.setOnlineChk("A");
		}
	
//		request.setOnlineChk("");
		
	
		List<ClsSaleNewsModel> resultList = new ArrayList<ClsSaleNewsModel>();

//		request.setOnlineChkN("N");
		System.out.println("Service1");
		System.out.println(request); 					//로그 찍기
			/**
			 * 1. 해당 부 리스트 조회
			 */
			List<ClsSaleNewsModel> ClsSaleNewsList = clsSaleNewsMapper.getClsSaleNewslistA(request);
			for( ClsSaleNewsModel data :  ClsSaleNewsList) {
				ClsSaleNewsModel model = new ClsSaleNewsModel();
				model.setBu( data.getBu() );
				model.setBuNm( data.getBuNm() );
				model.setCls( data.getCls() );
				model.setClsNm( data.getClsNm() );
				model.setDdTotsale( data.getDdTotsale() );
				model.setDdDsicount( data.getDdDsicount() );
				model.setDdNetsale( data.getDdNetsale() );
				model.setMmNetsale( data.getMmNetsale() );
				model.setYyNetsale( data.getYyNetsale() );
				
				resultList.add( model );
			}
		
		return resultList;
	}
	/**/
}
