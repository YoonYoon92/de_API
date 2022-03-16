package com.saydept.api.spf.org.orgnztInq;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqModel;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqParamModel;
import com.saydept.api.spf.saleNews.corpSaleNews.model.CorpSaleNewsModel;

	@Service
	public class OrgnztInqService {

	@Autowired
	private OrgnztInqMapper orgnztInqMapper;


	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
//부서~코너조회
	public List<OrgnztInqModel> selectOrgnztInqList(OrgnztInqParamModel request)throws Exception {
		List<OrgnztInqModel> result = new ArrayList<OrgnztInqModel>();
		System.out.println(request);
		if (request.getJum()=="")
		{
		List<OrgnztInqModel> jumresult = orgnztInqMapper.selectOrgnztInqList(request);
		result = jumresult;
		}
		else if (request.getJum()!=""&&(request.getBu()==""||request.getBu()==null)
								&&(request.getTim()==""||request.getTim()==null)
								&&(request.getPc()==""||request.getPc()==null)
				){
		List<OrgnztInqModel> jumresult = orgnztInqMapper.jumselectOrgnztInqList(request);
		result = jumresult;
		}
		
		else if(request.getJum()!=""&&request.getBu()!=""
									&&(request.getTim()==""||request.getTim()==null)
									&&(request.getPc()==""||request.getPc()==null)) {
			List<OrgnztInqModel> buresult = orgnztInqMapper.buselectOrgnztInqList(request);
		result = buresult;
		}
		
		else if(request.getJum()!=""&&request.getBu()!=""
									&&(request.getTim()!="")
									&&(request.getPc()==""||request.getPc()==null)) {
			List<OrgnztInqModel> timresult = orgnztInqMapper.timselectOrgnztInqList(request);
		result = timresult;
		}
		else if(request.getJum()!=""&&request.getBu()!=""
				&&(request.getTim()!="")
				&&(request.getPc()!="")) {
			List<OrgnztInqModel> pcresult = orgnztInqMapper.pcselectOrgnztInqList(request);
		result = pcresult;
		}
		return result;
	}
//존리스트
	public List<OrgnztInqParamModel> selectzoneStoreList(OrgnztInqParamModel request)throws Exception {
		List<OrgnztInqParamModel> result = orgnztInqMapper.selectzoneStoreList(request);
		System.out.println(request);
		System.out.println(result);
		return result;
		}
//존코너별 리스트
	public List<OrgnztInqModel> zoneStoreList(OrgnztInqParamModel request)throws Exception {
		List<OrgnztInqModel> result = new ArrayList<OrgnztInqModel>();
		if (request.getZone()==""||request.getZone()==null) {
		List<OrgnztInqModel> Zoneresult = orgnztInqMapper.zoneStoreList(request);
		System.out.println(Zoneresult);
		result = Zoneresult;
		}
		else{
		List<OrgnztInqModel> ZoneConerresult=orgnztInqMapper.zoneselectOrgnztInqList(request);
		result = ZoneConerresult;
		}
		return result;
		}
//재사용가능코너
		public List<OrgnztInqModel> recycleStoreList(OrgnztInqParamModel request)throws Exception {
			List<OrgnztInqModel> result = orgnztInqMapper.recycleStoreList(request);
			System.out.println(request);
			System.out.println(result);
			return result;
			}
}