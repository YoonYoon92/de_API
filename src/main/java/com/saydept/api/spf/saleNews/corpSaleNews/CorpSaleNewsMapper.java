package com.saydept.api.spf.saleNews.corpSaleNews;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.saleNews.corpSaleNews.model.CorpSaleNewsModel;
import com.saydept.api.spf.saleNews.corpSaleNews.model.CorpSaleNewsParamModel;

@Mapper
public interface CorpSaleNewsMapper {
	
	//부 목록 조회
	List<CorpSaleNewsModel> getBulistCorp(CorpSaleNewsParamModel data);
	//팀 목록 조회
	List<CorpSaleNewsModel> getTimlistCorp(CorpSaleNewsParamModel data);
	//PC 목록 조회
	List<CorpSaleNewsModel> getPclistCorp(CorpSaleNewsParamModel data);
	//코너 목록 조회
	List<CorpSaleNewsModel> getConerlistCorp(CorpSaleNewsParamModel data);

	//일 목표 조회
	CorpSaleNewsModel getDaySaleGoal(CorpSaleNewsParamModel data);

	//월 목표 조회
	CorpSaleNewsModel getMonthSaleGoal(CorpSaleNewsParamModel data);
	CorpSaleNewsModel getMonthSaleGoalMax(CorpSaleNewsParamModel data);	
	
	//년 목표 조회
	CorpSaleNewsModel getYearSaleGoal(CorpSaleNewsParamModel data);
	CorpSaleNewsModel getYearSaleGoalMax(CorpSaleNewsParamModel data);	

	//일 실적 조회
	CorpSaleNewsModel getDaySalePer(CorpSaleNewsParamModel data);

	//당월 실적 조회
	CorpSaleNewsModel getMonthSalePer(CorpSaleNewsParamModel data);
	
	//코너 실적 조회
	List<CorpSaleNewsModel> getConerlistTotal(CorpSaleNewsParamModel data);
	

}
