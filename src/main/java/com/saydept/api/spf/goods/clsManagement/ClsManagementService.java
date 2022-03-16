package com.saydept.api.spf.goods.clsManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Message;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.AS400ZonedDecimal;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.ProgramParameter;
import com.saydept.api.spf.goods.clsManagement.model.ClsManagementModel;

	@Service
	public class ClsManagementService {

	@Autowired
	private ClsManagementMapper clsManagementMapper;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public ClsManagementModel selectClsManagement(ClsManagementModel request)throws Exception {
	System.out.println(request);
	ClsManagementModel result = clsManagementMapper.selectClsManagement(request);
	System.out.println(result);
	return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<ClsManagementModel> selectClsManagementList(ClsManagementModel request)throws Exception {

		List<ClsManagementModel> result = clsManagementMapper.selectClsManagementList(request);
		return result;

	}
	
	public List<ClsManagementModel> selectConerList(ClsManagementModel request)throws Exception {
		
		List<ClsManagementModel> result = clsManagementMapper.selectConerList(request);
		return result;

	}
	
	public List<ClsManagementModel> selectKeyList(ClsManagementModel request)throws Exception {
		System.out.println(request);
		List<ClsManagementModel> result = clsManagementMapper.selectKeyList(request);
		System.out.println(result);
		return result;

	}
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateClsManagement(ClsManagementModel request)throws Exception {

		int result = clsManagementMapper.updateClsManagement(request);
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int insertClsManagement(ClsManagementModel request) {

		int result = 0;
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int saveClsManagement(ClsManagementModel request) {

		if (request.getExpire()==null) {
			request.setExpire("");
		}
		if (request.getExpire()==null) {
			request.setExpire("");
		}
		if (request.getPayment()==null) {
			request.setPayment("");
		}
		if (request.getDelDt()==null) {
			request.setDelDt("");
		}
		
		int result = 0;
		String message="";
		
		AS400 as400System = new AS400("128.131.0.1","SUBUL","SUBUL");
		ProgramCall program = new ProgramCall(as400System);
		System.out.println(request);
		try
		{
			// Initialize the name of the program to run.
			
			String programName = "/QSYS.LIB/SPFOBJ.LIB/SPFM06JT.PGM";
			
			ProgramParameter[] parameterList = new ProgramParameter[15];
			
			AS400Text textData = new AS400Text(20, as400System);
			AS400ZonedDecimal as400ZonedDecimal = new AS400ZonedDecimal(5,2) ;
			double stockLoss = Double.valueOf(request.getStockLoss());
			double margin = Double.valueOf(request.getMargin());
			System.out.println(stockLoss);
			System.out.println(margin);
			parameterList[0] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getJum()));
			parameterList[1] = new ProgramParameter(new AS400Text(5, as400System).toBytes(request.getConer()));
			parameterList[2] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getKey()));
			parameterList[3] = new ProgramParameter(new AS400Text(24, as400System).toBytes(request.getClsNm()));
			parameterList[4] = new ProgramParameter(new AS400Text(1, as400System).toBytes(request.getFeatureCd()));
			parameterList[5] = new ProgramParameter(new AS400Text(6, as400System).toBytes(request.getPartner()));
			parameterList[6] = new ProgramParameter(as400ZonedDecimal.toBytes(stockLoss));
			parameterList[7] = new ProgramParameter(as400ZonedDecimal.toBytes(margin));
			parameterList[8] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getEventCd()));
			parameterList[9] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getTagCd()));
			parameterList[10] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getExpire()));
			parameterList[11] = new ProgramParameter(new AS400Text(10, as400System).toBytes(request.getPayment()));
			parameterList[12] = new ProgramParameter(new AS400Text(6, as400System).toBytes(request.getUserId()));
			parameterList[13] = new ProgramParameter(100);
			//폐기일경우
			parameterList[14] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getDelDt()));
			
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
				message = (String) textData.toObject(parameterList[13].getOutputData());
			}
		}
		catch (Exception e)
		{
			System.out.println((char)27+"[0;31m     "+"Program " + program.getProgram() + " issued an exception!"+(char)27+"[0;00m");
			e.printStackTrace();
		}
		System.out.println(message);
		// Done with the server.
		as400System.disconnectAllServices();
		return result;

	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public int deleteClsManagement(ClsManagementModel request) {

		int result = clsManagementMapper.deleteClsManagement(request);
		return result;

	}

}