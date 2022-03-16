package com.saydept.api.spf.org.zoneManagement;

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

import com.saydept.api.spf.org.zoneManagement.model.ZoneManagementModel;
import com.saydept.api.spf.org.zoneManagement.model.ZoneManagementSaveModel;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqModel;
import com.saydept.api.spf.org.orgnztInq.model.OrgnztInqParamModel;
import com.saydept.api.spf.puchas.buyReqFormInq.model.BuyReqFormInqModel;


	@Service
	public class ZoneManagementService {

	@Autowired
	private ZoneManagementMapper zoneManagementMapper;
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public int updateZoneManagement(ZoneManagementSaveModel request) {
		int result = 0;
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		zoneManagementMapper.updateZoneManagement(request);
		return result;
	}
	
	public int insertZoneManagement(ZoneManagementSaveModel request) {
		int result = 0;
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		zoneManagementMapper.insertZoneManagement(request);
		return result;
	}
	
	public ZoneManagementSaveModel selectZoneManagement(ZoneManagementSaveModel request)throws Exception {
		ZoneManagementSaveModel result = zoneManagementMapper.selectZoneManagement(request);
	return result;
	}
	
	public List<ZoneManagementModel> selectBuList(ZoneManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<ZoneManagementModel> result = zoneManagementMapper.selectBuList(request);
		return result;
	}
	
	public List<ZoneManagementModel> selectTimList(ZoneManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<ZoneManagementModel> result = zoneManagementMapper.selectTimList(request);
		return result;
	}
	
	public List<ZoneManagementModel> selectPcList(ZoneManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<ZoneManagementModel> result = zoneManagementMapper.selectPcList(request);
		return result;
	}
	
	public List<ZoneManagementModel> selectZoneList(ZoneManagementModel request)throws Exception {
		System.out.println(new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd").format(new Date())+(char)27+"[0;32m"+"  PARM"		+(char)27+"[0;35m "		+Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "")				+"                           ".substring(Thread.currentThread().getStackTrace()[1].getFileName().replace(".java", "").length())				+(char)27+"[0;36m "		+Thread.currentThread().getStackTrace()[1].getMethodName()		+(char)27+"[0;00m");
		System.out.println((char)27+"[0;36m     "+request+(char)27+"[0;00m");
		List<ZoneManagementModel> result = zoneManagementMapper.selectZoneList(request);
		return result;
	}
	
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception	
	 */
	public int saveZoneManagement(ZoneManagementSaveModel request) {
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
					String programName = "/QSYS.LIB/SPFOBJ.LIB/SPFM21JT.PGM";
					// Set up the 3 parameters.
					ProgramParameter[] parameterList = new ProgramParameter[16];
					// Parameter 1 is the First Name
					AS400Text textData = new AS400Text(20, as400System);
					parameterList[0] = new ProgramParameter(new AS400Text(1, as400System).toBytes(request.getMs21Mod  ()));
					parameterList[1] = new ProgramParameter(new AS400Text(6, as400System).toBytes(request.getMs21Sabun()));
					parameterList[2] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs21Jum()));
					parameterList[3] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs21Bu ()));
					parameterList[4] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs21Tim ()));
					parameterList[5] = new ProgramParameter(new AS400Text(2, as400System).toBytes(request.getMs21Pc ()));
					parameterList[6] = new ProgramParameter(new AS400Text(3, as400System).toBytes(request.getMs21Zone ()));
					parameterList[7] = new ProgramParameter(new AS400Text(40, as400System).toBytes(request.getMs21ZoneNm()));
					// Parameter Double
					AS400ZonedDecimal as400ZonedDecimal = new AS400ZonedDecimal(5,0) ;
					if(request.getMs2107() == null) {
					double Ms2107 = 0.0;
					parameterList[8] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms2107));
					}
					else {
					double Ms2107 = Double.valueOf(request.getMs2107());
					parameterList[8] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms2107));
					}

					if(request.getMs2108() == null) {
					double Ms2108 = 0.0;	
					parameterList[9] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms2108));
					}
					else {
					double Ms2108 = Double.valueOf(request.getMs2108());
					parameterList[9] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms2108));
					}
					
					if(request.getMs2109() == null) {
					double Ms2109 = 0.0;
					parameterList[10] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms2109));
					}
					else {
					double Ms2109 = Double.valueOf(request.getMs2109());
					parameterList[10] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms2109));
					}
					
					if(request.getMs2110() == null) {
					double Ms2110 = 0.0;
					parameterList[11] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms2110));
					}
					else {
					double Ms2110 = Double.valueOf(request.getMs2110());
					parameterList[11] = new ProgramParameter(as400ZonedDecimal.toBytes(Ms2110));
					}
					
					parameterList[12] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs2111 ()));
					parameterList[13] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs2112 ()));
					parameterList[14] = new ProgramParameter(new AS400Text(8, as400System).toBytes(request.getMs2113 ()));
					
					parameterList[15] = new ProgramParameter(100);
					
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
						message = (String) textData.toObject(parameterList[15].getOutputData());
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