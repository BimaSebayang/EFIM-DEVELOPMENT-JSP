package id.co.roxas.efim.dao.headuser;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import id.co.roxas.efim.entity.headuser.TblEfimDb;
import id.co.roxas.efim.entity.headuser.pk.TblEfimDbPk;


public interface TblEfimDbDao extends JpaRepository<TblEfimDb, TblEfimDbPk>{

	@Query("select a from TblEfimDb a where a.fileOwner = :fileOwner and a.projectCode = :projectCode "
			+ " and a.fileIdReff not in :listIdReff")
	public List<TblEfimDb> getAllDataAndFileOwner
	(@Param("fileOwner") String fileOwner, @Param("projectCode") String projectCode,
			@Param("listIdReff") List<String> listIdReff );
	
}
