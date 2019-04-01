package id.co.roxas.efim.dao.stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import id.co.roxas.efim.entity.stream.TblUserPictureProfile;
import id.co.roxas.efim.entity.stream.pk.TblUserPictureProfilePk;


public interface TblUserPictureProfileDao extends JpaRepository<TblUserPictureProfile,TblUserPictureProfilePk>{
	    
	     @Query(" select a.picProfilePath from TblUserPictureProfile a where a.picProfileNo =:picProfileNo and a.projectCode=:projectCode")
	    public byte[] getUserPicture(@Param("picProfileNo") String picProfileNo,
	    		@Param("projectCode") String projectCode);
}
