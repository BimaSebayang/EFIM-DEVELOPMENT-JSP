package id.co.roxas.efim.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import id.co.roxas.efim.entity.owner.headuser.TblDataUser;


@Mapper
public interface TblDataUserDao {

	@Results(value = { @Result(property = "userId", column = "user_id", id = true),
			@Result(property = "userName", column = "user_name") })
	@Select("select tbl.* from "
			+ "(select  ROW_NUMBER() OVER(order by a.user_session_code desc) as row ,a.* from HEADUSER.TBL_DATA_USER a "
			+ ")tbl " + "where " + "tbl.row > (#{page}-1)*2 " + "and tbl.row<= #{page}*2 ")
	List<TblDataUser> findAll(@Param("page") int page);

	@Results(value = { @Result(property = "userId", column = "user_id", id = true),
			@Result(property = "userName", column = "user_name") })
	@Select("select tbl.* from "
			+ "(select  ROW_NUMBER() OVER(order by ${orderBy} ${direction}) as row ,a.* from HEADUSER.TBL_DATA_USER a) "
			+ "tbl " + "where " + "tbl.row > (#{page}-1)*2 " + "and tbl.row<= #{page}*2 ")
	List<TblDataUser> findAllWithOrderByParam(@Param("orderBy") String orderBy, @Param("direction") String direction, @Param("page") int page);

	@Select("select count(a.user_id) from headuser.tbl_data_user a")
	Integer countUser();

	@Select("select a.user_Id from headuser.tbl_data_user a")
	List<String> getAllUser();
}
