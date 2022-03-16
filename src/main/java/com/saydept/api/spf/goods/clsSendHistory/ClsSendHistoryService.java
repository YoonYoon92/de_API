package com.saydept.api.spf.goods.clsSendHistory;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.goods.clsSendHistory.model.ClsSendHistoryModel;


	@Service
	public class ClsSendHistoryService {

	@Autowired
	private ClsSendHistoryMapper clsSendHistoryMapper;

	

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception	
	 */
	public List<ClsSendHistoryModel> selectClsSendHistoryList(ClsSendHistoryModel request)throws Exception {

		List<ClsSendHistoryModel> resultList = new ArrayList<ClsSendHistoryModel>();
		List<ClsSendHistoryModel> result = clsSendHistoryMapper.selectClsSendHistoryList(request);
		for( ClsSendHistoryModel data :  result) {
			
			ClsSendHistoryModel model = data;
			if(data.getProc().equals("U")) {
				model.setProc( "행사" );
			}
			else if(data.getProc().equals("I")) {
				model.setProc( "신규" );
			}
			else if(data.getProc().equals("D")) {
				model.setProc( "폐기" );
			}
			if(data.getDisol().equals("Y")) {
				model.setDisol( "전체" );
			}
			else if(data.getDisol().equals("N")) {
				model.setDisol( "매장" );
			}
			
			resultList.add( model );
		}
		
//		System.out.println(resultList);
		return resultList;

	}

	public List<ClsSendHistoryModel> selectClsList(ClsSendHistoryModel request)throws Exception {
		List<ClsSendHistoryModel> result = clsSendHistoryMapper.selectClsList(request);
		return result;
	}
	public List<ClsSendHistoryModel> selectCls2List(ClsSendHistoryModel request)throws Exception {
		List<ClsSendHistoryModel> result = clsSendHistoryMapper.selectCls2List(request);
		return result;
	}
	

}