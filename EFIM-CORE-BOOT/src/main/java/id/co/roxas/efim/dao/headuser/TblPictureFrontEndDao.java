package id.co.roxas.efim.dao.headuser;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import id.co.roxas.efim.entity.stream.TblPictureFrontEnd;
import id.co.roxas.efim.entity.stream.pk.TblPictureFrontEndPk;


public interface TblPictureFrontEndDao extends JpaRepository<TblPictureFrontEnd, TblPictureFrontEndPk>{
   
	@Query("select a from TblPictureFrontEnd a where a.pictureName = :pictureName and a.projectCode = :projectCode")
	public TblPictureFrontEnd getImage(@Param("pictureName") String pictureName, @Param("projectCode") String projectCode);
	
	
	
}
