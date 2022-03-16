package com.saydept.api.spf.goods.partnerManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Message;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.AS400ZonedDecimal;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.ProgramParameter;
import com.saydept.api.spf.goods.partnerManagement.model.PartnerManagementModel;

	@Service
	public class PartnerManagementService {

	@Autowired
	private PartnerManagementMapper partnerManagementMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public PartnerManagementModel selectPartnerManagement(PartnerManagementModel request)throws Exception {
	System.out.println(request);
	PartnerManagementModel result = partnerManagementMapper.selectPartnerManagement(request);
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PartnerManagementModel> selectPartnerManagementList(PartnerManagementModel request)throws Exception {

		List<PartnerManagementModel> result = partnerManagementMapper.selectPartnerManagementList(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updatePartnerManagement(PartnerManagementModel request)throws Exception {

		int result = partnerManagementMapper.updatePartnerManagement(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int insertPartnerManagement(PartnerManagementModel request) {

		int result = partnerManagementMapper.insertPartnerManagement(request);
		return result;
		
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int savePartnerManagement(PartnerManagementModel request) {
		System.out.println(request);
		
		String data1="";
		String data2="";
		String data3="";
		String data4="";
		String data5="";
		String data6="";
		
		
		AS400 as400System = new AS400("아이피","아이디","비밀번호");
		ProgramCall program = new ProgramCall(as400System);
		System.out.println(request);
		try
		{
			// Initialize the name of the program to run.
			
	
		String programName = "/시스템.LIB/파일위치.LIB/프로그램.PGM";
			
			ProgramParameter[] parameterList = new ProgramParameter[10];
			
			AS400Text textData = new AS400Text(100, as400System);
			System.out.println(request.getBusiNm());
			System.out.println(request.getOwner());
			System.out.println(request.getAddressNm());
			System.out.println(request.getServiceSect());
			System.out.println(request.getService());
			
		
			
			//상호
			parameterList[0] = new ProgramParameter(new AS400Text(30, as400System).toBytes(request.getBusiNm().trim()));
			//대표자명
			parameterList[1] = new ProgramParameter(new AS400Text(10, as400System).toBytes(request.getOwner().trim()));
//			//주소
			parameterList[2] = new ProgramParameter(new AS400Text(62, as400System).toBytes(request.getAddressNm().trim()));
//			//업태
			parameterList[3] = new ProgramParameter(new AS400Text(16, as400System).toBytes(request.getServiceSect().trim()));
//			//업종
			parameterList[4] = new ProgramParameter(new AS400Text(24, as400System).toBytes(request.getService().trim()));
//			
			parameterList[5] = new ProgramParameter(100);
			parameterList[6] = new ProgramParameter(100);
			parameterList[7] = new ProgramParameter(100);
			parameterList[8] = new ProgramParameter(100);
			parameterList[9] = new ProgramParameter(100);
//			
			
			// Set the program name and parameter list.
			program.setProgram(programName, parameterList);
		
			if (program.run() != true)
			{
				// Report failure.
				System.out.println((char)27+"[0;31m     "+"Program failed!"+(char)27+"[0;00m");
				// Show the messages.
				AS400Message[] messageList = program.getMessageList();
				for (int i = 0; i < messageList.length; ++i)
				{
					// Show each message.
					System.out.println(messageList[i].getText());
					// Load additional message information.
					messageList[i].load();
					//Show help text.
					System.out.println(messageList[i].getHelp());
				}
			}
			// Else no error, get output data.
			else
			{
				textData = new AS400Text(100, as400System);
				
				data1 = (String) textData.toObject(parameterList[5].getOutputData());
				data2 = (String) textData.toObject(parameterList[6].getOutputData());
				data3 = (String) textData.toObject(parameterList[7].getOutputData());
				data4 = (String) textData.toObject(parameterList[8].getOutputData());
				data5 = (String) textData.toObject(parameterList[9].getOutputData());
				
			}
		}
		catch (Exception e)
		{
			System.out.println((char)27+"[0;31m     "+"Program " + program.getProgram() + " issued an exception!"+(char)27+"[0;00m");
			e.printStackTrace();
		}
		System.out.println(data1.substring(0,29));
		System.out.println(data2.substring(0,9));
		System.out.println(data3.substring(0,61));
		System.out.println(data4.substring(0,23));
		System.out.println(data5.substring(0,16));
		
		request.setBusiNm(data1.substring(0,29));
		request.setOwner(data2.substring(0,9));
		request.setAddressNm(data3.substring(0,61));
		request.setServiceSect(data4.substring(0,16));
		request.setService(data5.substring(0,23));
		request.setJumin1(request.getJumin().substring(0,6));
		request.setJumin2(request.getJumin().substring(6,13));
		request.setTel1(request.getTel().substring(0,3));
		request.setTel2(request.getTel().substring(3,6));
		request.setTel3(request.getTel().substring(6,10));
		if(request.getFax().length()==8) {
		request.setFax1(request.getFax().substring(0,4));
		request.setFax2(request.getFax().substring(4,8));
		}else {
			request.setFax1("");
			request.setFax2("");
		}
		request.setAddress1(request.getAddress().substring(0,3));
		request.setAddress2(request.getAddress().substring(3,6));
			
		System.out.println(request);
		// Done with the server.
		as400System.disconnectAllServices();
		int result = 0;
		
		try {
			result = partnerManagementMapper.insertPartnerManagement(request);
			if (result==0) {
							throw new Exception();
							}
			}
		
		catch (Exception e )
			{
			System.out.println("--------------------------------------------");
			result = partnerManagementMapper.updatePartnerManagement(request);
			result = result+1;
			}
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deletePartnerManagement(PartnerManagementModel request) {

		int result = partnerManagementMapper.deletePartnerManagement(request);
		return result;

	}

}