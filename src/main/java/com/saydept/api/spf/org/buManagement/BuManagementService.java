package com.saydept.api.spf.org.buManagement;

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
import com.saydept.api.spf.org.buManagement.model.BuManagementModel;
import com.saydept.api.spf.org.buManagement.model.BuManagementSaveModel;
import com.saydept.api.spf.org.jumManagement.model.JumManagementSaveModel;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqModel;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqParamModel;
import com.saydept.api.spf.puchas.buyReqFormInq.model.BuyReqFormInqModel;


	@Service
	public class BuManagementService {

	@Autowired
	private BuManagementMapper buManagementMapper;
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public int updateBuManagement(BuManagementSaveModel request) {
		int result = 0;
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		buManagementMapper.updateBuManagement(request);
		return result;
	}
	
	public int insertBuManagement(BuManagementSaveModel request) {
		int result = 0;
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		buManagementMapper.insertBuManagement(request);
		return result;
	}
	
	public BuManagementSaveModel selectBuManagement(BuManagementSaveModel request)throws Exception {
		BuManagementSaveModel result = buManagementMapper.selectBuManagement(request);
	return result;

	}
	
	public List<BuManagementModel> selectBuList(BuManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<BuManagementModel> result = buManagementMapper.selectBuList(request);
		return result;

	}
	
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception	
	 */

//	----------------------------------------------------------------------
		public int saveBuManagement(BuManagementSaveModel request) {
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
						ProgramParameter[] parameterList = new ProgramParameter[19];
						// Parameter 1 is the First Name
						AS400Text textData = new AS400Text(20, as400System);
						parameterList[0] = new ProgramParameter(new AS400Text(1, as400System).toBytes(request .getMs02Mod  ()));
						parameterList[1] = new ProgramParameter(new AS400Text(6, as400System).toBytes(request .getMs02Sabun()));
						parameterList[2] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request .getMs02Jum()));
						parameterList[3] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs02Bu ()));
						parameterList[4] = new ProgramParameter(new AS400Text(34, as400System).toBytes(request.getMs02JumNm()));
						parameterList[5] = new ProgramParameter(new AS400Text(30, as400System).toBytes(request.getMs02BuNm()));
						parameterList[6] = new ProgramParameter(new AS400Text(1, as400System).toBytes(request.getMs0205 ()));
						// Parameter Double
						AS400ZonedDecimal as400ZonedDecimal = new AS400ZonedDecimal(5,0) ;
						if(request.getMs0206() == null) {
						double Ms0206 = 0.0;
						parameterList[7] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0206));
						}
						else {
						double Ms0206 = Double.valueOf(request.getMs0206());
						parameterList[7] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0206));
						}
						double Ms0207 = Double.valueOf(request.getMs0207());
						parameterList[8] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0207));
						double Ms0208 = Double.valueOf(request.getMs0208());
						parameterList[9] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0208));
						if(request.getMs0209() == null) {
						double Ms0209 = 0.0;	
						parameterList[10] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0209));
						}
						else {
						double Ms0209 = Double.valueOf(request.getMs0209());
						parameterList[10] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0209));
						}
						
						double Ms0210 = Double.valueOf(request.getMs0210());
						parameterList[11] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0210));
						parameterList[12] = new ProgramParameter(new AS400Text(26, as400System).toBytes(request.getMs0211 ()));
						parameterList[13] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0212 ()));
						parameterList[14] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0213 ()));
						parameterList[15] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0214 ()));
						parameterList[16] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0215 ()));
						parameterList[17] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0216 ()));
						
						parameterList[18] = new ProgramParameter(100);
						
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
							message = (String) textData.toObject(parameterList[18].getOutputData());
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