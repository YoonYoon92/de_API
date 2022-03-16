package com.saydept.api.spf.org.jumManagement;

import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.as400.access.*;

//import com.saydept.api.comm.notice.NoticeMapper;
//import com.saydept.api.comm.notice.model.NoticeModel;
//import com.saydept.api.comm.notice.model.NoticeSaveModel;
//import com.saydept.api.spf.goods.clsInq.model.ClsInqModel;
//import com.saydept.api.spf.org.buManagement.model.BuManagementModel;
//import com.saydept.api.comm.notice.model.NoticeSaveModel;
import com.saydept.api.spf.org.jumManagement.model.JumManagementModel;
import com.saydept.api.spf.org.jumManagement.model.JumManagementSaveModel;


	@Service
	public class JumManagementService {

	@Autowired
	private JumManagementMapper jumManagementMapper;
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public int updateJumManagement(JumManagementSaveModel request) {
		int result = 0;
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		result = jumManagementMapper.updateJumManagement(request);
		if(result == 0) {System.out.println((char)27+"[0;36m     "+"update err"+(char)27+"[0;00m");}
				   else {System.out.println((char)27+"[0;36m     "+"update ok "+(char)27+"[0;00m");}
		return result;
	}
	
	public int insertJumManagement(JumManagementSaveModel request) {
		int result = 0;
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		result=jumManagementMapper.insertJumManagement(request);
		return result;
	}
	
	public JumManagementSaveModel selectJumManagement(JumManagementSaveModel request)throws Exception {
		JumManagementSaveModel result = jumManagementMapper.selectJumManagement(request);
	return result;

	}
	
	public List<JumManagementModel> selectJumList(JumManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<JumManagementModel> result = jumManagementMapper.selectJumList(request);
		return result;
	}
	

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception	
	 */

	
//	----------------------------------------------------------------------
//		public JumManagementModel saveJumManagement(JumManagementSaveModel request) {
			public int saveJumManagement(JumManagementSaveModel request) {
			System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
			System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
//			JumManagementModel SignUpResult = new JumManagementModel(); 
//			JumManagementModel SignUpCheck = new JumManagementModel(); 
			int result = 0;
			String message="";
				AS400 as400System = new AS400("아이피","아이디","비밀번호");
						ProgramCall program = new ProgramCall(as400System);
	
						try
						{
							// Initialize the name of the program to run.
							String programName = "/시스템.LIB/파일위치.LIB/프로그램.PGM";
							// Set up the 3 parameters.
							ProgramParameter[] parameterList = new ProgramParameter[18];
							// Parameter 1 is the First Name
							AS400Text textData = new AS400Text(20, as400System);
							parameterList[0] = new ProgramParameter(new AS400Text(1, as400System).toBytes(request.getMs01Mod()));
							parameterList[1] = new ProgramParameter(new AS400Text(6, as400System).toBytes(request.getMs01Sabun()));
							parameterList[2] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs01Jum()));
							parameterList[3] = new ProgramParameter(new AS400Text(24, as400System).toBytes(request.getMs01JumNm()));
							parameterList[4] = new ProgramParameter(new AS400Text(16, as400System).toBytes(request.getMs01Sano()));
							parameterList[5] = new ProgramParameter(new AS400Text(10, as400System).toBytes(request.getMs01Dname()));
							parameterList[6] = new ProgramParameter(new AS400Text(16, as400System).toBytes(request.getMs01Juno1()));
							parameterList[7] = new ProgramParameter(new AS400Text(9, as400System).toBytes(request.getMs01Post1()));
							parameterList[8] = new ProgramParameter(new AS400Text(16, as400System).toBytes(request.getMs01Phone1()));
							parameterList[9] = new ProgramParameter(new AS400Text(60, as400System).toBytes(request.getMs01Address()));
							parameterList[10] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs01Crdate()));
							parameterList[11] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs01Camonth()));
							parameterList[12] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs01Deldate()));
							parameterList[13] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs01Adddate()));
							parameterList[14] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs01Uptdate()));
							parameterList[15] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs01Adduser()));
							parameterList[16] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs01Uptuser()));
							parameterList[17] = new ProgramParameter(100);
							
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
								message = (String) textData.toObject(parameterList[17].getOutputData());
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