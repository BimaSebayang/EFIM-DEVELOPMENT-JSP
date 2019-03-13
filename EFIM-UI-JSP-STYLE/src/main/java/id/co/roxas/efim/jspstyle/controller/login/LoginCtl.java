package id.co.roxas.efim.jspstyle.controller.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import Share.WsResponse;
import Share.Dto.UserPrivilegeCustom;
import Share.Dto.HeadUser.TblDataUserDto;
import id.co.roxas.efim.jspstyle.configuration.AppConfig;
import id.co.roxas.efim.jspstyle.lib.BaseCtl;
import id.co.roxas.efim.jspstyle.model.Forgot;
import id.co.roxas.efim.jspstyle.model.Login;
import id.co.roxas.efim.jspstyle.model.Register;

@Controller
public class LoginCtl extends BaseCtl{

	
	@Autowired
	private AppConfig appConfig;
	
    private Map<String, Object> modelMap = new HashMap<>();
    
    public void callModelMapper(Object... objectMap) {
    	modelMap.put("login", objectMap[0]);
		modelMap.put("forgot", objectMap[1]);
		modelMap.put("register", objectMap[2]);
    }
	
	//@GetMapping(name = "enter")
	@RequestMapping("/enter")
    public ModelAndView login() {	
		System.out.println(appConfig.getCoreMapper());
		ModelAndView mv = new ModelAndView("login/login");
		callModelMapper(new Login(),new Forgot(),new Register());
		mv.addAllObjects(modelMap);
		return  mv;
	}
	
	
	//@PostMapping(name = "event")
	@RequestMapping(name = "/event", method = RequestMethod.POST)
	public ModelAndView toLogin(@ModelAttribute("login") Login login,@ModelAttribute("forgot") Forgot forgot,
			@ModelAttribute("register") Register register, HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(!Strings.isEmpty(request.getParameter("login"))) {
			modelAndView = clickLogin(login);
		}
		else if(!Strings.isEmpty(request.getParameter("forgot"))) {
			modelAndView = clickForgot(forgot);
		}
		else if(!Strings.isEmpty(request.getParameter("register"))) {
			modelAndView = clickRegister(register);
		}
		
		callModelMapper(new Login(),new Forgot(),new Register());
		modelAndView.addAllObjects(modelMap);
		return  modelAndView;
	}
	
    public ModelAndView clickLogin(Login login) {
    	
    	ModelAndView mv = new ModelAndView();
        
    	Map<String, Object> body = new HashMap<>();
		body.put("user", login.getInputUserId());
		body.put("pass", login.getInputPassword());
		WsResponse response = restTemplateLib.getResultWs("/LoginCtl/ValidationUser", body, "post",
				"projectCode=" + appConfig.getProjectCode());
		Map<String, Object> resultMap = new HashMap<>();
		resultMap = restTemplateLib.mapperJsonToHashMap(response.getWsContent());
		boolean pass = (boolean) resultMap.get("pass");
		System.out.println("pass : " + pass);
		if(pass) {
			Map<String, Object> mapBody = new HashMap<>();
			mapBody.put("userId", login.getInputUserId());
			WsResponse resp01 = restTemplateLib.getResultWs("/UserInformationCompCtl/UserInf", mapBody, "post",
					"projectCode=" + appConfig.getProjectCode());
			UserPrivilegeCustom upc = null;
			try {
				upc = restTemplateLib.mapperJsonToSingleDto(resp01.getWsContent(), UserPrivilegeCustom.class);
				System.err.println("apakah upc ada " + upc.getUserName());
				mv.setViewName("login/login");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(upc!=null) {
				mv.setViewName("login/login");
			}	
		 }
           return mv;
    }
    
    public ModelAndView clickRegister(Register register) {
    	
    	ModelAndView mv = new ModelAndView();
    	
    	TblDataUserDto dto = new TblDataUserDto();
		dto.setUserName(register.getRegisterUserName());
		dto.setUserId(register.getRegisterUserId());
		dto.setUserPassword(register.getRegisterUserPassword());
		dto.setUserMail(register.getRegisterUserMail());
		dto.setUserPhone(register.getRegisterUserPhone());


		String html = " <p> Dear " + register.getRegisterUserName() + ", <br>"
				+ " Terima kasih telah menggunakan EFIM sebagai layanan penyimpanan data anda."
				+ " Kami Konfirmasi kembali data yang telah anda input . </p>" + " <p>Nama    : "
				+ register.getRegisterUserName() + "<br>" + "    User Id : " + register.getRegisterUserId()+ "<br>" + "    No Telp : "
				+ register.getRegisterUserPhone() + "<br></p>"
				+ " <p>Anda dapat mengklik button dibawah ini untuk dapat langsung mengaktifkan akun anda </p>"
				+ " <a href='http://localhost:28080/EFIM-UI/registeration/successPr.zul?id=" 
				+ "'><button>Activate your Account</button></a>"
				+ " <p>Anda dapat mengabaikan pesan ini jika tidak ingin melanjutkan <br>" + "    Best Regard,</p>"
				+ "<br>" + "<p> <b>Notes : Pesan ini akan kadaluarsa dalam 3 hari</b> </p>";
		
		String subject = "New Register Efim";
		
		dto.setSubjecEmail(subject);
		dto.setMessageEmail(html);
		
	
		String html2 = " <p> Dear " + register.getRegisterUserName() + ", <br>"
				+ " Terima kasih telah menggunakan EFIM sebagai layanan penyimpanan data anda."
				+ " Kami Konfirmasi kembali data yang telah anda input . </p>" + " <p>Nama    : "
				+ register.getRegisterUserName() + "<br>" + "    User Id : " + register.getRegisterUserId()+ "<br>" + "    No Telp : "
				+ register.getRegisterUserPhone() + "<br></p>"
				+ " <p>Anda dapat mengklik button dibawah ini untuk dapat langsung mengaktifkan akun anda </p>"
				+ " <a href='http://localhost:28080/EFIM-UI/registeration/successPr.zul?id=" 
				+ "'><button>Activate your Account</button></a>"
				+ " <p>Anda dapat mengabaikan pesan ini jika tidak ingin melanjutkan <br>" + "    Best Regard,</p>"
				+ "<br>" + "<p> <b>Notes : Pesan ini akan kadaluarsa dalam 3 hari</b> </p>";
	
		String email = sendMail(register.getRegisterUserMail(), html2, subject,
				"Mohon Buka email anda untuk aktivasi akun anda.");
		  System.out.println("email response : " + email);
		 mv.setViewName("login/login");
		return mv;
    }
    
    public ModelAndView clickForgot(Forgot forgot) {
    	ModelAndView mv = new ModelAndView();
    	System.out.println("user id : " + forgot.getForgotUserId());
    	WsResponse wsResponse = restTemplateLib.getResultWs("/ForgotPassCtl/GetEmail", forgot.getForgotUserId(), "post",
				"projectCode=" + appConfig.getProjectCode());
		TblDataUserDto information = new TblDataUserDto();
		try {
			information = restTemplateLib.mapperJsonToSingleDto(wsResponse.getWsContent(), TblDataUserDto.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (information.getUserMail().equalsIgnoreCase("ERROR")) {
			mv.setViewName("login/login");
		} else {

			TblDataUserDto dto = new TblDataUserDto();
			dto.setUserName(information.getUserName());
			dto.setUserId(information.getUserId());
			dto.setUserMail(information.getUserMail());
			String html = " <p> Dear " + information.getUserName() + ", <br>"
					+ " Kami mendengar bahwa anda baru saja kehilangan password anda. Kami kirimkan link untuk "
					+ " dapat mereset password yang anda punya sekarang </p>"
					+ " <p>Anda dapat mengklik button dibawah ini untuk dapat langsung mereset password anda </p>"
					+ " <a href='http://localhost:28080/EFIM-UI/forgot/forgotPr.zul?id=" 
					+ "'><button>Reset Your Password</button></a>"
					+ " <p>Anda dapat mengabaikan pesan ini jika tidak ingin melanjutkan <br>" + "    Best Regard,</p>"
					+ " <br>" + " <p> <b>Notes : Pesan ini akan kadaluarsa dalam 3 hari</b> </p>";
			
			String subject = "Reset Password Akun EFIM";
			
			dto.setSubjecEmail(subject);
			dto.setMessageEmail(html);
			
			WsResponse wsResponse2 = restTemplateLib.getResultWs("/LoginCtl/CreateUserEmail", dto, "post", "projectCode=" + appConfig.getProjectCode());
			String responseFinal = null;
			try {
				responseFinal = restTemplateLib.mapperJsonToSingleDto(wsResponse2.getWsContent(), String.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			String html2 = " <p> Dear " + information.getUserName() + ", <br>"
					+ " Kami mendengar bahwa anda baru saja kehilangan password anda. Kami kirimkan link untuk "
					+ " dapat mereset password yang anda punya sekarang </p>"
					+ " <p>Anda dapat mengklik button dibawah ini untuk dapat langsung mereset password anda </p>"
					+ " <a href='http://localhost:28080/EFIM-UI/forgot/forgotPr.zul?id=" + responseFinal
					+ "'><button>Reset Your Password</button></a>"
					+ " <p>Anda dapat mengabaikan pesan ini jika tidak ingin melanjutkan <br>" + "    Best Regard,</p>"
					+ " <br>" + " <p> <b>Notes : Pesan ini akan kadaluarsa dalam 3 hari</b> </p>";
			      String email =  sendMail(information.getUserMail(), html2,
					"Reset Password Akun EFIM", "Mohon Buka email anda untuk dapat mereset password anda.");
			      System.out.println("email response : " + email);
			      
			      mv.setViewName("login/login");
		}
		
		return mv;
    }

}
