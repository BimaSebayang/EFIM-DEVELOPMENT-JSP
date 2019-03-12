package id.co.roxas.efim.dao.owner.headuser.query;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import id.co.roxas.efim.configuration.AppConfig;
import id.co.roxas.efim.entity.owner.headuser.TblDataUser;


@Mapper
public interface TblDataUserDao {

	
     public final String PAGINGMAGICWORD1 = "select tbl.* from(";	
     public final String PAGINGMAGICWORD2 = ")tbl where tbl.row > (#{page}-1)*#{count} and tbl.row<= #{page}*#{count} ";	
	
	 @Results(value= {
			 @Result(property="userId", column="user_id", id=true),
			 @Result(property="userName", column="user_name"),
			 @Result(property="userPassword", column="user_password"),
			 @Result(property="userMail", column="user_mail"),
			 @Result(property="userPhone", column="user_phone"),
			 @Result(property="userSessionCode", column = "user_session_code"),
			 @Result(property="userMaxDbstorage", column="user_max_dbstorage"),
			 @Result(property="userPhoto", column="user_photo"),
			 @Result(property="createdDate", column="created_date"),
			 @Result(property="userStatus", column="user_status"),
			 @Result(property="projectCode", column="project_code"),
	 })
	 @Select("select a.* from headuser.tbl_data_user a where a.user_id = #{userId} "
	 		+ " and a.project_code = #{projectCode}")
	 public TblDataUser getUserInformation(@Param("userId") String userId, @Param("projectCode") String projectCode);
	 
	 @Results(value= {
			 @Result(property="userId", column="user_id", id=true),
			 @Result(property="userName", column="user_name"),
			 @Result(property="userPassword", column="user_password"),
			 @Result(property="userMail", column="user_mail"),
			 @Result(property="userPhone", column="user_phone"),
			 @Result(property="userSessionCode", column = "user_session_code"),
			 @Result(property="userMaxDbstorage", column="user_max_dbstorage"),
			 @Result(property="userPhoto", column="user_photo"),
			 @Result(property="createdDate", column="created_date"),
			 @Result(property="userStatus", column="user_status"),
			 @Result(property="projectCode", column="project_code"),
			 @Result(property="tblSessionUser.userSessionCode", column="user_session_code"),
			 @Result(property="tblSessionUser.sessionStatus", column="session_status"),
			 @Result(property="tblSessionUser.sessionTime", column="session_time"),
			 @Result(property="tblSessionUser.projectCode", column="project_code"),
			 @Result(property="tblSessionUser.invalidCount", column="invalid_count"),
			 @Result(property="tblSessionUser.sessionMess", column="session_mess"),
	 })
	 @Select( PAGINGMAGICWORD1
			 + " select  ROW_NUMBER() OVER(order by ${orderBy} ${direction}) as row, "
			 + " a.*,b.* from headuser.tbl_data_user a, headuser.tbl_session_user b"
			 + " where a.user_session_Code = b.user_session_code"
			 +PAGINGMAGICWORD2)
	 public Page<TblDataUser> selectAllWithPaging(@Param("page") int page,@Param("count") int count,
			 @Param("orderBy") String orderBy, @Param("direction") String directionsa);
}
