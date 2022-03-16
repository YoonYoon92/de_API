package com.saydept.api.spf.org.pcManagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.saydept.api.comm.notice.NoticeMapper;
import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Message;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.AS400ZonedDecimal;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.ProgramParameter;

//import com.saydept.api.comm.notice.model.NoticeModel;
//import com.saydept.api.comm.notice.model.NoticeSaveModel;
//import com.saydept.api.spf.goods.clsInq.model.ClsInqModel;
//import com.saydept.api.comm.notice.model.NoticeSaveModel;
import com.saydept.api.spf.org.pcManagement.model.PcManagementModel;
import com.saydept.api.spf.org.pcManagement.model.PcManagementSaveModel;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqModel;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqParamModel;
import com.saydept.api.spf.puchas.buyReqFormInq.model.BuyReqFormInqModel;


	@Service
	public class PcManagementService {

	@Autowired
	private PcManagementMapper pcManagementMapper;
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public int updatePcManagement(PcManagementSaveModel request) {
		int result = 0;
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		pcManagementMapper.updatePcManagement(request);
		return result;
	}
	
	public int insertPcManagement(PcManagementSaveModel request) {
		int result = 0;
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		pcManagementMapper.insertPcManagement(request);
		return result;
	}
	
	public PcManagementSaveModel selectPcManagement(PcManagementSaveModel request)throws Exception {
		PcManagementSaveModel result = pcManagementMapper.selectPcManagement(request);
	return result;
	}
	
	public List<PcManagementModel> selectBuList(PcManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<PcManagementModel> result = pcManagementMapper.selectBuList(request);
		return result;
	}
	
	public List<PcManagementModel> selectTimList(PcManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<PcManagementModel> result = pcManagementMapper.selectTimList(request);
		return result;
	}
	
	public List<PcManagementModel> selectPcList(PcManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<PcManagementModel> result = pcManagementMapper.selectPcList(request);
		return result;
	}
	
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception	
	 */
	
	public int savePcManagement(PcManagementSaveModel request) {
	System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
	System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
//	JumManagementModel SignUpCheck = new JumManagementModel(); 
	int result = 0;

	String message="";
	
				AS400 as400System = new AS400("128.131.0.1","SUBUL","SUBUL");
				ProgramCall program = new ProgramCall(as400System);

				try
				{
					// Initialize the name of the program to run.
					String programName = "/QSYS.LIB/SPFOBJ.LIB/SPFM04JT.PGM";
					// Set up the 3 parameters.
					ProgramParameter[] parameterList = new ProgramParameter[23];
					// Parameter 1 is the First Name
					AS400Text textData = new AS400Text(20, as400System);
					parameterList[0] = new ProgramParameter(new AS400Text(1, as400System).toBytes(request.getMs04Mod  ()));
					parameterList[1] = new ProgramParameter(new AS400Text(6, as400System).toBytes(request.getMs04Sabun()));
					parameterList[2] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs04Jum()));
					parameterList[3] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs04Bu ()));
					parameterList[4] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs04Tim ()));
					parameterList[5] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs04Pc ()));
					parameterList[6] = new ProgramParameter(new AS400Text(34, as400System).toBytes(request.getMs04JumNm()));
					parameterList[7] = new ProgramParameter(new AS400Text(30, as400System).toBytes(request.getMs04BuNm()));
					parameterList[8] = new ProgramParameter(new AS400Text(30, as400System).toBytes(request.getMs04TimNm()));
					parameterList[9] = new ProgramParameter(new AS400Text(30, as400System).toBytes(request.getMs04PcNm()));
					// Parameter Double
					AS400ZonedDecimal as400ZonedDecimal = new AS400ZonedDecimal(5,0) ;
					if(request.getMs0409() == null) {
					double Ms0409 = 0.0;
					parameterList[10] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0409));
					}
					else {
					double Ms0409 = Double.valueOf(request.getMs0409());
					parameterList[10] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0409));
					}
					
					if(request.getMs0410() == null) {
					double Ms0410 = 0.0;
					parameterList[11] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0410));
					}
					else {
					double Ms0410 = Double.valueOf(request.getMs0410());
					parameterList[11] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0410));
					}

					parameterList[12] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs0411 ()));
					
					if(request.getMs0412() == null) {
					double Ms0412 = 0.0;	
					parameterList[13] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0412));
					}
					else {
					double Ms0412 = Double.valueOf(request.getMs0412());
					parameterList[13] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0412));
					}
					
					if(request.getMs0413() == null) {
					double Ms0413 = 0.0;	
					parameterList[14] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0413));
					}
					else {
					double Ms0413 = Double.valueOf(request.getMs0413());
					parameterList[14] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0413));
					}
					
					if(request.getMs0414() == null) {
					double Ms0414 = 0.0;	
					parameterList[15] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0414));
					}
					else {
					double Ms0414 = Double.valueOf(request.getMs0414());
					parameterList[15] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms0414));
					}
					
					parameterList[16] = new ProgramParameter(new AS400Text(26, as400System).toBytes(request.getMs0415 ()));
					parameterList[17] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0416 ()));
					parameterList[18] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0417 ()));
					parameterList[19] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0418 ()));
					parameterList[20] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0419 ()));
					parameterList[21] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs0420 ()));
					
					parameterList[22] = new ProgramParameter(100);
					
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
						message = (String) textData.toObject(parameterList[22].getOutputData());
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