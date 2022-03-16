package com.saydept.api.app.appSaySignUp;
import com.ibm.as400.access.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.app.appSaySignUp.model.AppSaySignUpModel;
import com.saydept.api.app.appSaySignUp.model.AppSaySignUpParamModel;

	@Service
	public class AppSaySignUpService {

	@Autowired
	private AppSaySignUpMapper appSaySignUpMapper;


	
	
//	----------------------------------------------------------------------
		public AppSaySignUpModel insertAppSaySignUp(AppSaySignUpParamModel request) {
			System.out.println(request);
			AppSaySignUpModel SignUpResult = new AppSaySignUpModel(); 
			AppSaySignUpModel SignUpCheck = new AppSaySignUpModel(); 
			int result = 0;
			//LOG기록
			int result1 = 0;
			String message="";
			
			request.setExtCarnum("");
			
			//가입체크
			SignUpCheck = appSaySignUpMapper.getAppSayPlusMemInfoCheck(request);
			if(SignUpCheck.getExtCarnum().equals(null)) {
				request.setExtCarnum("");
			
			}
			else {
			request.setExtCarnum(SignUpCheck.getExtCarnum());	
			System.out.println(request);
			}
			//로그기록
			result1 = appSaySignUpMapper.logAppSaySignUp(request);
			//카드가없을때 가입진행
			if(SignUpCheck.getCarnum().equals("")) {
				try {
					result = appSaySignUpMapper.insertAppSaySignUp(request);
				 
				//에러안났을경우만 프로그램실행
					if (result==0) {
					throw new Exception();
								}
				else {
						
						AS400 as400System = new AS400("128.131.0.1","SUBUL","SUBUL");
						//AS400 as400System = new AS400("128.129.0.11","SUBUL","SUBUL");
						//The ProgramCall class allows a user to call an iSeries server program, 
						//pass parameters to it (input and output), and access data returned in the 
						//output parameters after the program runs. Use ProgramCall to call programs.
						ProgramCall program = new ProgramCall(as400System);
	
						try
						{
							// Initialize the name of the program to run.
							String programName = "/QSYS.LIB/SCDOBJ.LIB/SCDP11IU.PGM";
							// Set up the 3 parameters.
							ProgramParameter[] parameterList = new ProgramParameter[7];
	
							// Parameter 1 is the First Name
							AS400Text textData = new AS400Text(20, as400System);
							parameterList[0] = new ProgramParameter(textData.toBytes(request.getName()));
	
							
							textData = new AS400Text(8, as400System);
							parameterList[1] = new ProgramParameter(textData.toBytes(request.getJoinDate()));
							textData = new AS400Text(8, as400System);
							parameterList[2] = new ProgramParameter(textData.toBytes(request.getJoinTime()));
							textData = new AS400Text(6, as400System);
							parameterList[3] = new ProgramParameter(textData.toBytes(request.getBirthday()));
							textData = new AS400Text(1, as400System);
							parameterList[4] = new ProgramParameter(textData.toBytes(request.getGender()));
							textData = new AS400Text(11, as400System);
							parameterList[5] = new ProgramParameter(textData.toBytes(request.getHptel()));
							
							parameterList[6] = new ProgramParameter(100);
							
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
								message = (String) textData.toObject(parameterList[6].getOutputData());
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
					}
				catch (Exception e )
					{
					System.out.println("--------------------------------------------");
					SignUpResult.setErrCode("1");
					SignUpResult.setCarnum("");		
					e.printStackTrace();
					}
				
				}
			else {
				SignUpResult.setErrCode("2");
				SignUpResult.setCarnum(SignUpCheck.getCarnum());			
			}
		
		return SignUpResult;

		
		}
}