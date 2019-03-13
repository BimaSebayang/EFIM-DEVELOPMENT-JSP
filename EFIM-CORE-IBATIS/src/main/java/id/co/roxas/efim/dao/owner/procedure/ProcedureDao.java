package id.co.roxas.efim.dao.owner.procedure;

import java.math.BigInteger;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import id.co.roxas.efim.dao.owner.procedure.entityCustom.SpCheckValidUserEntity;


@Mapper
public interface ProcedureDao {

	@Select("declare @output nvarchar(max) " +
		    "exec [MASTER].[SP_CHECK_VALID_USER] " + 
			  " #{inputId},"
			+ "#{inputPass},"
			+ "#{projectCode},"
			+ "#{accessDate},"
			+ " @output output " 
			+ " select @output")
	public String spCheckValidUser(@Param("inputId") String inputId, @Param("inputPass") String inputPass,
			@Param("projectCode") String projectCode, 
			@Param("accessDate") String accessDate, @Param("result") String result);
	
    @Select("declare @output nvarchar(max) "
    		+ " exec SECURITY.SP_CHECK_EMAIL_IS_VALID #{emailNo},#{projectCode}, @output output"
    		+ " select @output")
	public String  spCheckEmailIsValid(@Param("emailNo") String emailNo, @Param("projectCode") String projectCode);
    
    @Select(" exec MASTER.SP_RESET_PASSWORD "
    		+ " #{userId}, #{password}, #{accessDate}, #{projectCode} ")
    public void spResetPassword(@Param("userId")String userId, @Param("password") String password, 
    		@Param("accessDate")String accessDate,@Param("projectCode") String projectCode);
    
    
    @Select(  " declare @output nvarchar(max) "
    		+ " exec MASTER.CREATE_EMAIL_EXECUTE #{recepientName}, #{recepientEmail}, #{recepientId}, #{message}, #{subject}, #{ccPerson}, #{ccPersonEmail}, "
    		+ " #{createdDate}, #{expiredTime}, #{projectCode}, @output output "
    		+ " select @output")
    public String spCreateEmailExecute(@Param("recepientName")String recepientName, @Param("recepientEmail")String recepientEmail,
    		@Param("recepientId")String recepientId, @Param("message")String message, @Param("subject")String subject ,
    		@Param("ccPerson")String ccPerson, @Param("ccPersonEmail")String ccPersonEmail,
    		@Param("createdDate")String createdDate ,@Param("expiredTime")BigInteger expiredTime, 
    		@Param("projectCode")String projectCode);

    @Select(" declare @output nvarchar(max) "
    		+ " exec MASTER.SP_CREATE_TEMPORARY_USER #{userName}, #{userId}, #{userPassword}, #{userMail}, #{userPhone}, "
    		+ " #{createdDate}, #{projectCode}, @output output "
    		+ " select @output ")
    public String spCreatedTemporaryUser(@Param("userName")String userName,@Param("userId")String userId,@Param("userPassword")String userPassword
    		,@Param("userMail")String userMail,@Param("userPhone")String userPhone,@Param("createdDate")String createdDate, 
    		@Param("projectCode")String projectCode);
    
    @Select(" declare @output nvarchar(max) "
    		+ " exec MASTER.SP_CREATE_USER_AND_SESSION #{regNo}, #{createdDate}, #{projectCode}, @output output "
    		+ " select @output ")
    public String spCreatedUserAndSession(@Param("regNo")String regNo,@Param("createdDate")String createdDate, 
    		@Param("projectCode")String projectCode);
}
