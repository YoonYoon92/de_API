package com.saydept.api.app.appMemUpt;
import com.ibm.as400.access.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.app.appMemUpt.model.AppMemUptModel;
import com.saydept.api.app.appMemUpt.model.AppMemUptParamModel;

	@Service
	public class AppMemUptService {

	@Autowired
	private AppMemUptMapper appMemUptMapper;


	
	
//	----------------------------------------------------------------------
		public AppMemUptModel insertAppMemUpt(AppMemUptParamModel request) {
			System.out.println(request);
			AppMemUptModel SignUpResult = new AppMemUptModel(); 
			AppMemUptModel SignUpCheck = new AppMemUptModel(); 
			int result = 0;
			//LOG기록
			int result1 = 0;
			String message="";
			
			request.setExtCarnum("");
			result = appMemUptMapper.insertAppMemUpt(request);
			System.out.println(result);
			//가입체크
		
		
			if (result==1) {
						
						AS400 as400System = new AS400("128.131.0.1","SUBUL","SUBUL");
						
						ProgramCall program = new ProgramCall(as400System);
	
						try
						{
							// Initialize the name of the program to run.
							String programName = "/QSYS.LIB/SCDOBJ.LIB/SCDP11IU2.PGM";
							// Set up the 3 parameters.
							ProgramParameter[] parameterList = new ProgramParameter[5];
	
							// Parameter 1 is the First Name
							AS400Text textData = new AS400Text(20, as400System);
//							parameterList[0] = new ProgramParameter(textData.toBytes(request.getName()));
//	
//							
							System.out.println(request);
							textData = new AS400Text(8, as400System);
							parameterList[0] = new ProgramParameter(textData.toBytes(request.getUptDate()));
							textData = new AS400Text(6, as400System);
							parameterList[1] = new ProgramParameter(textData.toBytes(request.getUptTime()));
							textData = new AS400Text(6, as400System);
							parameterList[2] = new ProgramParameter(textData.toBytes(request.getCitizenNo1()));
							textData = new AS400Text(7, as400System);
							parameterList[3] = new ProgramParameter(textData.toBytes(request.getCitizenNo2()));
//							textData = new AS400Text(11, as400System);
//							parameterList[5] = new ProgramParameter(textData.toBytes(request.getHptel()));
							
							parameterList[4] = new ProgramParameter(100);
							
							// Set the program name and parameter list.
							program.setProgram(programName, parameterList);
							System.out.println(program);  
							// Run the program.
							if (program.run() != true)
							{
								// Report failure.
								System.out.println("Program failed!");
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
								message = (String) textData.toObject(parameterList[4].getOutputData());
							}
						}
						catch (Exception e)
						{
							System.out.println("Program " + program.getProgram() + " issued an exception!");
							e.printStackTrace();
						}
	
						// Done with the server.
						as400System.disconnectAllServices();
	
						//Print the output from the RPGLE called program 
						System.out.println("Message is: " + message);
						SignUpResult.setCarnum(message.trim());
						
						//결과값리턴
						if(SignUpResult.getCarnum().equals("")) {
							SignUpResult.setErrCode("1");	
						}
						else {
							SignUpResult.setErrCode("0");
						} 
							
						
					
					
			
			}
						return SignUpResult;

			
		}
}