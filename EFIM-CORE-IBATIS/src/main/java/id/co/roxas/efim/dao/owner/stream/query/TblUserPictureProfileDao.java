package id.co.roxas.efim.dao.owner.stream.query;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TblUserPictureProfileDao {
//	@Query(" select a.picProfilePath from TblUserPictureProfile a where a.picProfileNo =:picProfileNo and a.projectCode=:projectCode")
//    public byte[] getUserPicture(@Param("picProfileNo") String picProfileNo,
//    		@Param("projectCode") String projectCode);
	
	@Select("select a.pic_profile_path from stream.tbl_user_picture_profile a where a.pic_profile_no = #{picProfileNo}"
			+ " and a.project_code = #{projectCode} ")
	public byte[] getUserPicture(@Param("picProfileNo") String picProfileNo, @Param("projectCode") String projectCode);
}
