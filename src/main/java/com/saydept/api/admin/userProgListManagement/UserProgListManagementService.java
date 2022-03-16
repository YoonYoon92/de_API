package com.saydept.api.admin.userProgListManagement;

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
import com.saydept.api.admin.userProgListManagement.model.UserProgListManagementModel;
import com.saydept.api.admin.userProgListManagement.model.UserProgListManagementSaveModel;


	@Service
	public class UserProgListManagementService {

	@Autowired
	private UserProgListManagementMapper userProgListManagementMapper;
	
	/**
	 * 
	 * @param request
	 * @return
	 */
//	public int updateUserProgListManagement(UserProgListManagementSaveModel request) {
//		int result = 0;
//		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                              ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
//		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
//		result = userProgListManagementMapper.updateUserProgListManagement(request);
//		if(result == 0) {System.out.println((char)27+"[0;36m     "+"update err"+(char)27+"[0;00m");}
//				   else {System.out.println((char)27+"[0;36m     "+"update ok "+(char)27+"[0;00m");}
//		return result;
//	}
	
	public int insertUserProgListManagement(UserProgListManagementSaveModel request) {
		int result = 0;
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                              ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+"insert"+request+(char)27+"[0;00m");
		result=userProgListManagementMapper.insertUserProgListManagement(request);
		System.out.println((char)27+"[0;36m     "+"권한 4 -> "+result+(char)27+"[0;00m");
		return result;
	}
	
	public int insertUserProgListManagement1(UserProgListManagementSaveModel request) {
		int result = 0;
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                              ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+"insert1"+request+(char)27+"[0;00m");
		result=userProgListManagementMapper.insertUserProgListManagement1(request);
		System.out.println((char)27+"[0;36m     "+"메뉴 1 -> "+result+(char)27+"[0;00m");
		return result;
	}
	
//	public UserProgListManagementSaveModel selectUserProgListManagement(UserProgListManagementSaveModel request)throws Exception {
//		UserProgListManagementSaveModel result = userProgListManagementMapper.selectUserProgListManagement(request);
//	return result;
//
//	}
	
//	public List<UserProgListManagementModel> selectPgmList(UserProgListManagementModel request)throws Exception {
//	System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                              ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
//	System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
//	List<UserProgListManagementModel> result = userProgListManagementMapper.selectPgmList(request);
//	return result;
//}
	
	public List<UserProgListManagementModel> selectMenuGroupIdList(UserProgListManagementModel request)throws Exception {
	System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                              ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
	System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
	List<UserProgListManagementModel> result = userProgListManagementMapper.selectMenuGroupIdList(request);
	return result;
}
	
	public List<UserProgListManagementModel> selectMenuIdList(UserProgListManagementModel request)throws Exception {
	System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                              ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
	System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
	List<UserProgListManagementModel> result = userProgListManagementMapper.selectMenuIdList(request);
	return result;
}
		

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception	
	 */

	
//	----------------------------------------------------------------------
//		public UserProgListManagementModel saveUserProgListManagement(UserProgListManagementSaveModel request) {
			public int saveUserProgListManagement(UserProgListManagementSaveModel request) {
			System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                              ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
			System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
//			UserProgListManagementModel SignUpResult = new UserProgListManagementModel(); 
//			UserProgListManagementModel SignUpCheck = new UserProgListManagementModel(); 
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
							parameterList[0] = new ProgramParameter(new AS400Text(1,  as400System).toBytes(request.getZd0203()));
							parameterList[1] = new ProgramParameter(new AS400Text(6,  as400System).toBytes(request.getZd0203()));
							parameterList[2] = new ProgramParameter(new AS400Text(2,  as400System).toBytes(request.getZd0203()));
							parameterList[3] = new ProgramParameter(new AS400Text(24, as400System).toBytes(request.getZd0203()));
							parameterList[4] = new ProgramParameter(new AS400Text(16, as400System).toBytes(request.getZd0203()));
							parameterList[5] = new ProgramParameter(new AS400Text(10, as400System).toBytes(request.getZd0203()));
							parameterList[6] = new ProgramParameter(new AS400Text(16, as400System).toBytes(request.getZd0203()));
							parameterList[7] = new ProgramParameter(new AS400Text(9,  as400System).toBytes(request.getZd0203()));
							parameterList[8] = new ProgramParameter(new AS400Text(16, as400System).toBytes(request.getZd0203()));
							parameterList[9] = new ProgramParameter(new AS400Text(60, as400System).toBytes(request.getZd0203()));
							parameterList[10] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getZd0203()));
							parameterList[11] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getZd0203()));
							parameterList[12] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getZd0203()));
							parameterList[13] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getZd0203()));
							parameterList[14] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getZd0203()));
							parameterList[15] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getZd0203()));
							parameterList[16] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getZd0203()));
							parameterList[17] = new ProgramParameter(100);
							
							// Set the program name and parameter list.
							program.setProgram(programName, parameterList);
							System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                              ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
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