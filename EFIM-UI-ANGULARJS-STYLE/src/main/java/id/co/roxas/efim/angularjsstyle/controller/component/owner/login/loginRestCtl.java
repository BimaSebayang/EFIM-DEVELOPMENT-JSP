package id.co.roxas.efim.angularjsstyle.controller.component.owner.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import Share.WsResponse;
import Share.Dto.UserPrivilegeCustom;
import Share.Dto.HeadUser.TblDataUserDto;
import id.co.roxas.efim.angularjsstyle.controller.component.owner.BaseController;
import id.co.roxas.efim.angularjsstyle.model.Register;

@RestController
@RequestMapping("/rest/login")
public class loginRestCtl extends BaseController{

	private static final long serialVersionUID = 6800599608270079156L;

	@PostMapping(value="/requestRegister")
	public String registerRequest(@RequestBody Register register, HttpServletRequest request) {
		System.out.println(new Gson().toJson(register));
    	TblDataUserDto dto = new TblDataUserDto();
		dto.setUserName(register.getRegisterUserName());
		dto.setUserId(register.getRegisterUserId());
		dto.setUserPassword(register.getRegisterUserPassword());
		dto.setUserMail(register.getRegisterUserMail());
		dto.setUserPhone(register.getRegisterUserPhone());
		
		WsResponse wsResponse = restTemplateLib.getResultWs("/RegisterCtl/CreateUser", dto, "post",
				"projectCode=" + appConfig.getProjectCode());
		Map<String, Object> resultMap = new HashMap<>();
		String idNo = wsResponse.getWsContent();
		
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
		
		WsResponse wsResponse2 = restTemplateLib.getResultWs("/LoginCtl/CreateUserEmail", dto, "post", "projectCode=" + appConfig.getProjectCode());
		String responseFinal = null;
		try {
			responseFinal = restTemplateLib.mapperJsonToSingleDto(wsResponse2.getWsContent(), String.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
		return "pesan anda berhasil dikirim";
	}
	
	@PostMapping(value = "/validation")
	public String isValidToContinue(@RequestBody Map<String, Object> body, HttpServletRequest request) {
		System.out.println("masuk ke dalam rm validation");
		body.put("user", body.get("user"));
		body.put("pass", body.get("pass"));
		WsResponse response = restTemplateLib.getResultWs("/LoginCtl/ValidationUser", body, "post",
				"projectCode=" + appConfig.getProjectCode());
		Map<String, Object> resultMap = new HashMap<>();
		resultMap = restTemplateLib.mapperJsonToHashMap(response.getWsContent());
		boolean pass = (boolean) resultMap.get("pass");
		if(pass) {
			Map<String, Object> mapBody = new HashMap<>();
			mapBody.put("userId", body.get("user"));
			WsResponse resp01 = restTemplateLib.getResultWs("/UserInformationCompCtl/UserInf", mapBody, "post",
					"projectCode=" + appConfig.getProjectCode());
			UserPrivilegeCustom upc = null;
			try {
				upc = restTemplateLib.mapperJsonToSingleDto(resp01.getWsContent(), UserPrivilegeCustom.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
				return redirectToUri(request,  "/dashboard");
		 }
		
		return redirectToUri(request,"/login/enter");

	}
	
	@PostMapping(value="/requestForgot")
	public String resultRequest(@RequestBody Map<String, Object> body, HttpServletRequest request) {
		System.out.println("masuk ke dalam");
		String userId = (String) body.get("userId");
    	WsResponse wsResponse = restTemplateLib.getResultWs("/ForgotPassCtl/GetEmail", userId, "post",
				"projectCode=" + appConfig.getProjectCode());
		TblDataUserDto information = new TblDataUserDto();
		try {
			information = restTemplateLib.mapperJsonToSingleDto(wsResponse.getWsContent(), TblDataUserDto.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (information.getUserMail().equalsIgnoreCase("ERROR")) {
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
			      
		}
		
		return "Pesan Anda Telah Dikirim";
	}
	
}
