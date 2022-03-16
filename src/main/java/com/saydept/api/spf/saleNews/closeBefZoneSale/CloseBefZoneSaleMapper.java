package com.saydept.api.spf.saleNews.closeBefZoneSale;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.saleNews.closeBefZoneSale.model.CloseBefZoneSaleModel;

@Mapper
public interface CloseBefZoneSaleMapper {

	CloseBefZoneSaleModel selectCloseBefZoneSale(CloseBefZoneSaleModel request);

	List<CloseBefZoneSaleModel> selectCloseBefZoneSaleList(CloseBefZoneSaleModel request);

	int updateCloseBefZoneSale(CloseBefZoneSaleModel request);

	int insertCloseBefZoneSale(CloseBefZoneSaleModel request);

	int saveCloseBefZoneSale(CloseBefZoneSaleModel request);

	int deleteCloseBefZoneSale(CloseBefZoneSaleModel request);

}