package com.saydept.api.spf.org.cornerManagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Message;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.AS400ZonedDecimal;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.ProgramParameter;
//import com.saydept.api.comm.notice.NoticeMapper;
//import com.saydept.api.comm.notice.model.NoticeModel;
//import com.saydept.api.comm.notice.model.NoticeSaveModel;
//import com.saydept.api.spf.goods.clsInq.model.ClsInqModel;
//import com.saydept.api.comm.notice.model.NoticeSaveModel;
import com.saydept.api.spf.org.cornerManagement.model.CornerManagementModel;
import com.saydept.api.spf.org.cornerManagement.model.CornerManagementSaveModel;
import com.saydept.api.spf.org.jumManagement.model.JumManagementSaveModel;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqModel;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqParamModel;
import com.saydept.api.spf.puchas.buyReqFormInq.model.BuyReqFormInqModel;


	@Service
	public class CornerManagementService {

	@Autowired
	private CornerManagementMapper cornerManagementMapper;
	
	/**
	 * 
	 * @param request
	 * @return
	 */
//	public int updateCornerManagement(CornerManagementSaveModel request) {
//		int result = 0;
//		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
//		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
//		cornerManagementMapper.updateCornerManagement(request);
//		return result;
//	}
	
//	public int insertCornerManagement(CornerManagementSaveModel request) {
//		int result = 0;
//		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
//		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
//		cornerManagementMapper.insertCornerManagement(request);
//		return result;
//	}
	
	public CornerManagementSaveModel selectCornerManagement(CornerManagementSaveModel request)throws Exception {
		CornerManagementSaveModel result = cornerManagementMapper.selectCornerManagement(request);
	return result;

	}
	
	public List<CornerManagementModel> selectCornerList(CornerManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<CornerManagementModel> result = cornerManagementMapper.selectCornerList(request);
		return result;

	}
	
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception	
	 */

//	----------------------------------------------------------------------
		public int saveCornerManagement(CornerManagementSaveModel request) {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
//		JumManagementModel SignUpCheck = new JumManagementModel(); 
		int result = 0;

		String message="";
		
		AS400 as400System = new AS400("아이피","아이디","비밀번호");

					ProgramCall program = new ProgramCall(as400System);

					try
					{
						// Initialize the name of the program to run.
						String programName = "/시스템.LIB/파일위치.LIB/프로그램.PGM";
						// Set up the 3 parameters.
						ProgramParameter[] parameterList = new ProgramParameter[28];
						// Parameter 1 is the First Name
						AS400Text textData = new AS400Text(20, as400System);
						parameterList[0] = new ProgramParameter(new AS400Text(1, as400System).toBytes(request.getMs05Mod  ()));
						parameterList[1] = new ProgramParameter(new AS400Text(6, as400System).toBytes(request.getMs05Sabun()));
						parameterList[2] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs05Jum()));
						parameterList[3] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs05Bu ()));
						parameterList[4] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs05Tim ()));
						parameterList[5] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs05Pc ()));
						parameterList[6] = new ProgramParameter(new AS400Text(5, as400System).toBytes(request.getMs05Corner ()));
						if(request.getMs05CornerOn() == null) {
							request.setMs05CornerOn("");
						}
						parameterList[7] = new ProgramParameter(new AS400Text(5, as400System).toBytes(request.getMs05CornerOn()));
						parameterList[8] = new ProgramParameter(new AS400Text(34, as400System).toBytes(request.getMs05JumNm()));
						parameterList[9] = new ProgramParameter(new AS400Text(30, as400System).toBytes(request.getMs05BuNm()));
						parameterList[10] = new ProgramParameter(new AS400Text(30, as400System).toBytes(request.getMs05TimNm()));
						parameterList[11] = new ProgramParameter(new AS400Text(30, as400System).toBytes(request.getMs05PcNm()));
						parameterList[12] = new ProgramParameter(new AS400Text(30, as400System).toBytes(request.getMs05CornerNm()));
						parameterList[13] = new ProgramParameter(new AS400Text(1, as400System).toBytes(request.getMs0511()));
						// Parameter Double
						AS400ZonedDecimal as400ZonedDecimal = new AS400ZonedDecimal(5,0) ;
						if(request.getMs0512() == null) {
						double Ms0512 = 0.0;
						parameterList[14] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0512));
						}
						else {
						double Ms0512 = Double.valueOf(request.getMs0512());
						parameterList[14] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0512));
						}
						
						if(request.getMs0513() == null) {
						double Ms0513 = 0.0;	
						parameterList[15] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0513));
						}
						else {
						double Ms0513 = Double.valueOf(request.getMs0513());
						parameterList[15] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0513));
						}
						
						if(request.getMs0514() == null) {
						double Ms0514 = 0.0;	
						parameterList[16] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0514));
						}
						else {
						double Ms0514 = Double.valueOf(request.getMs0514());
						parameterList[16] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0514));
						}
						if(request.getMs0515() == null) {
							request.setMs0515("");
						}
						parameterList[17] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0515()));
						parameterList[18] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0516()));
						parameterList[19] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0517()));
						parameterList[20] = new ProgramParameter(new AS400Text(3, as400System).toBytes(request.getMs0518()));
						parameterList[21] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0519()));
						parameterList[22] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0520()));
						parameterList[23] = new ProgramParameter(new AS400Text(3, as400System).toBytes(""));
						parameterList[24] = new ProgramParameter(new AS400Text(1, as400System).toBytes(request.getMs05211()));
						parameterList[25] = new ProgramParameter(new AS400Text(1, as400System).toBytes(request.getMs05212()));
						parameterList[26] = new ProgramParameter(new AS400Text(1, as400System).toBytes(request.getMs05213()));
						
						parameterList[27] = new ProgramParameter(100);
						
						// Set the program name and parameter list.
						program.setProgram(programName, parameterList);
						System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
						System.out.println((char)27+"[0;36m     "+parameterList+(char)27+"[0;00m");
						System.out.println((char)27+"[0;36m     "+program+(char)27+"[0;00m");
						// Run the program.
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
							message = (String) textData.toObject(parameterList[27].getOutputData());
						}
					}
					catch (Exception e)
					{
						System.out.println((char)27+"[0;31m     "+"Program " + program.getProgram() + " issued an exception!"+(char)27+"[0;00m");
						e.printStackTrace();
					}
					// Done with the server.
					as400System.disconnectAllServices();

					//Print the output from the RPGLE called program 
					System.out.println((char)27+"[0;32m     "+"MSG "+(char)27+"[0;35m"+message+(char)27+"[0;00m");
	
	return result;
	
	}
	

}