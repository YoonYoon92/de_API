package com.saydept.api.spf.org.timManagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.saydept.api.comm.notice.NoticeMapper;
//import com.saydept.api.comm.notice.model.NoticeModel;
//import com.saydept.api.comm.notice.model.NoticeSaveModel;
//import com.saydept.api.spf.goods.clsInq.model.ClsInqModel;
//import com.saydept.api.comm.notice.model.NoticeSaveModel;
import com.saydept.api.spf.org.timManagement.model.TimManagementModel;
import com.saydept.api.spf.org.timManagement.model.TimManagementSaveModel;
import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Message;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.AS400ZonedDecimal;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.ProgramParameter;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqModel;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqParamModel;
//import com.saydept.api.spf.puchas.buyReqFormInq.model.BuyReqFormInqModel;


	@Service
	public class TimManagementService {

	@Autowired
	private TimManagementMapper timManagementMapper;
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public int updateTimManagement(TimManagementSaveModel request) {
		int result = 0;
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		timManagementMapper.updateTimManagement(request);
		return result;
	}
	
	public int insertTimManagement(TimManagementSaveModel request) {
		int result = 0;
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		timManagementMapper.insertTimManagement(request);
		return result;
	}
	
	public TimManagementSaveModel selectTimManagement(TimManagementSaveModel request)throws Exception {
		TimManagementSaveModel result = timManagementMapper.selectTimManagement(request);
	return result;

	}
	
	public List<TimManagementModel> selectBuList(TimManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<TimManagementModel> result = timManagementMapper.selectBuList(request);
		return result;

	}
	
	public List<TimManagementModel> selectTimList(TimManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<TimManagementModel> result = timManagementMapper.selectTimList(request);
		return result;

	}
	
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception	
	 */

	public int saveTimManagement(TimManagementSaveModel request) {
	System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
	System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
//	JumManagementModel SignUpCheck = new JumManagementModel(); 
	int result = 0;

	String message="";
	
	AS400 as400System = new AS400("아이피","아이디","비밀번호");
				ProgramCall program = new ProgramCall(as400System);

				try
				{
					// Initialize the name of the program to run.
					String programName = "/시스템.LIB/파일위치.LIB/프로그램.PGM";
					// Set up the 3 parameters.
					ProgramParameter[] parameterList = new ProgramParameter[21];
					// Parameter 1 is the First Name
					AS400Text textData = new AS400Text(20, as400System);
					parameterList[0] = new ProgramParameter(new AS400Text(1, as400System).toBytes(request.getMs03Mod  ()));
					parameterList[1] = new ProgramParameter(new AS400Text(6, as400System).toBytes(request.getMs03Sabun()));
					parameterList[2] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs03Jum()));
					parameterList[3] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs03Bu ()));
					parameterList[4] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs03Tim ()));
					parameterList[5] = new ProgramParameter(new AS400Text(34, as400System).toBytes(request.getMs03JumNm()));
					parameterList[6] = new ProgramParameter(new AS400Text(30, as400System).toBytes(request.getMs03BuNm()));
					parameterList[7] = new ProgramParameter(new AS400Text(30, as400System).toBytes(request.getMs03TimNm()));
					// Parameter Double
					AS400ZonedDecimal as400ZonedDecimal = new AS400ZonedDecimal(5,0) ;
					if(request.getMs0307() == null) {
					double Ms0307 = 0.0;
					parameterList[8] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0307));
					}
					else {
					double Ms0307 = Double.valueOf(request.getMs0307());
					parameterList[8] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0307));
					}

					double Ms0308 = Double.valueOf(request.getMs0308());
					parameterList[9] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0308));
					
					double Ms0309 = Double.valueOf(request.getMs0309());
					parameterList[10] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0309));
					
					double Ms0310 = Double.valueOf(request.getMs0310());
					parameterList[11] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0310));
					
					if(request.getMs0311() == null) {
					double Ms0311 = 0.0;	
					parameterList[12] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0311));
					}
					else {
					double Ms0311 = Double.valueOf(request.getMs0311());
					parameterList[12] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0311));
					}
					
					parameterList[13] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs0312 ()));
					parameterList[14] = new ProgramParameter(new AS400Text(16, as400System).toBytes(request.getMs0313 ()));
					parameterList[15] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0314 ()));
					parameterList[16] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0315 ()));
					parameterList[17] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0316 ()));
					parameterList[18] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0317 ()));
					parameterList[19] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0318 ()));
					
					parameterList[20] = new ProgramParameter(100);
					
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
						message = (String) textData.toObject(parameterList[20].getOutputData());
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