package com.saydept.api.spf.saleNews.buRtnSaleNews;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.buRtnSaleNews.model.BuRtnSaleNewsModel;
import com.saydept.api.spf.saleNews.buRtnSaleNews.model.BuRtnSaleNewsParamModel;
import com.saydept.utils.SayUtils;

@Service
public class BuRtnSaleNewsService {

	@Autowired
	private BuRtnSaleNewsMapper buRtnSaleNewsMapper;
	
	@Autowired
	private SayUtils sayUtils;

	public List<BuRtnSaleNewsModel> buRtnSaleNewsList(BuRtnSaleNewsParamModel request) throws ParseException {
		// TODO Auto-generated method stub
		
		List<BuRtnSaleNewsModel> resultList = new ArrayList<BuRtnSaleNewsModel>();

//		String beforeDay = sayUtils.getCusomDay(request.getSearchDay(), -1 );
//		String beforeYear = sayUtils.getCusomYear(request.getSearchDay(), -1 );
//		System.out.println("before jum");
		if( request.getSerchLevel().equals(null)		//등급이 null일때
				) {	
			System.out.println("service.SerchLevel: null"); 					// 조회레벨 출력
			
			List<BuRtnSaleNewsModel> nullList = buRtnSaleNewsMapper.getNulllist(request);
			for( BuRtnSaleNewsModel data :  nullList) {
				BuRtnSaleNewsModel model = new BuRtnSaleNewsModel();
				model.setJum( data.getJum() );
				model.setJumNm( data.getJumNm() );
				model.setBu( data.getBu() );
				model.setBuNm( data.getBuNm() );
				model.setTim( data.getTim() );
				model.setTimNm( data.getTimNm() );
				model.setPc( data.getPc() );
				model.setPcNm( data.getPcNm() );
				model.setCls( data.getCls() );
				model.setClsNm( data.getClsNm() );
				model.setDdCnt( data.getDdCnt() );
				model.setDdCash( data.getDdCash() );
				model.setDdCard( data.getDdCard() );
				model.setDdOther( data.getDdOther() );
				model.setDdNetsale( data.getDdNetsale() );
				
				resultList.add( model );
			}
			System.out.println("services.null list end");
			
		} /* -- null end */
		if( request.getSerchLevel().equals("jum")		//등급이 점일때
				) {	
			System.out.println("service.SerchLevel: ".concat(request.getSerchLevel())); // 조회레벨 출력
			
			List<BuRtnSaleNewsModel> jumList = buRtnSaleNewsMapper.getJumlist(request);
			for( BuRtnSaleNewsModel data :  jumList) {
				BuRtnSaleNewsModel model = new BuRtnSaleNewsModel();
				model.setJum( data.getJum() );
				model.setJumNm( data.getJumNm() );
				model.setBu( data.getBu() );
				model.setBuNm( data.getBuNm() );
				model.setTim( data.getTim() );
				model.setTimNm( data.getTimNm() );
				model.setPc( data.getPc() );
				model.setPcNm( data.getPcNm() );
				model.setCls( data.getCls() );
				model.setClsNm( data.getClsNm() );
				model.setDdCnt( data.getDdCnt() );
				model.setDdCash( data.getDdCash() );
				model.setDdCard( data.getDdCard() );
				model.setDdOther( data.getDdOther() );
				model.setDdNetsale( data.getDdNetsale() );
				
				resultList.add( model );
			}
			System.out.println("service.jum list end");
			
		} /* -- jum end */

		
		if( request.getSerchLevel().equals("bu")		//등급이 부일때
				) {	
			System.out.println("service.SerchLevel: ".concat(request.getSerchLevel())); // 조회레벨 출력
			
			List<BuRtnSaleNewsModel> buList = buRtnSaleNewsMapper.getBulist(request);
			for( BuRtnSaleNewsModel data :  buList) {
				BuRtnSaleNewsModel model = new BuRtnSaleNewsModel();
				model.setJum( data.getJum() );
				model.setJumNm( data.getJumNm() );
				model.setBu( data.getBu() );
				model.setBuNm( data.getBuNm() );
				model.setTim( data.getTim() );
				model.setTimNm( data.getTimNm() );
				model.setPc( data.getPc() );
				model.setPcNm( data.getPcNm() );
				model.setCls( data.getCls() );
				model.setClsNm( data.getClsNm() );
				model.setDdCnt( data.getDdCnt() );
				model.setDdCash( data.getDdCash() );
				model.setDdCard( data.getDdCard() );
				model.setDdOther( data.getDdOther() );
				model.setDdNetsale( data.getDdNetsale() );
				
				resultList.add( model );
			}
			System.out.println("services.bu list end");
			
		} /* -- bu end */

		
		if( request.getSerchLevel().equals("tim")		//등급이 팀일때
				) {	
			System.out.println("service.SerchLevel: ".concat(request.getSerchLevel())); // 조회레벨 출력
			
			List<BuRtnSaleNewsModel> timList = buRtnSaleNewsMapper.getTimlist(request);
			for( BuRtnSaleNewsModel data :  timList) {
				BuRtnSaleNewsModel model = new BuRtnSaleNewsModel();
				model.setJum( data.getJum() );
				model.setJumNm( data.getJumNm() );
				model.setBu( data.getBu() );
				model.setBuNm( data.getBuNm() );
				model.setTim( data.getTim() );
				model.setTimNm( data.getTimNm() );
				model.setPc( data.getPc() );
				model.setPcNm( data.getPcNm() );
				model.setCls( data.getCls() );
				model.setClsNm( data.getClsNm() );
				model.setDdCnt( data.getDdCnt() );
				model.setDdCash( data.getDdCash() );
				model.setDdCard( data.getDdCard() );
				model.setDdOther( data.getDdOther() );
				model.setDdNetsale( data.getDdNetsale() );
				
				resultList.add( model );
			}
			System.out.println("services.tim list end");
			
		} /* -- tim end */

		return resultList;
	}
}
