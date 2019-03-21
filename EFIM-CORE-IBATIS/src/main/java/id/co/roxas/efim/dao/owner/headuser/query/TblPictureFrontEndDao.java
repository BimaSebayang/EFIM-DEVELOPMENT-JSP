package id.co.roxas.efim.dao.owner.headuser.query;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import id.co.roxas.efim.entity.owner.stream.TblPictureFrontEnd;

@Mapper
public interface TblPictureFrontEndDao {

	// @Query("select a from TblPictureFrontEnd a where a.pictureName = :pictureName
	// and a.projectCode = :projectCode")
	@Results(value = { @Result(property = "pictureId", column = "PICTURE_ID"),
			@Result(property = "pictureName", column = "PICTURE_NAME", id = true),
			@Result(property = "picturePath", column = "PICTURE_PATH"),
			@Result(property = "projectCode", column = "PROJECT_CODE") })
	@Select(" select a.* from STREAM.TBL_PIC_FRONT_END a where a.picture_name = #{pictureName} "
			+ " and a.project_code = #{projectCode}")
	public TblPictureFrontEnd getImage(@Param("pictureName") String pictureName,
			@Param("projectCode") String projectCode);

}
