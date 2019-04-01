package id.co.roxas.efim.dao.headuser;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import id.co.roxas.efim.entity.headuser.TblDataUser;
import id.co.roxas.efim.entity.headuser.pk.TblDataUserPk;


public interface TblDataUserDao extends JpaRepository<TblDataUser, TblDataUserPk> {

	@Query("select a from TblDataUser a where a.userSessionCode.userSessionCode = 'GBOLAAHQWCCDAHKLCCLV'")
	public TblDataUser selectByTblSessionUser();

	@Query("SELECT a FROM TblDataUser a " + " where a.userId = :userId and a.projectCode = :projectCode")
	public TblDataUser getUserInformation(@Param("userId") String userId, @Param("projectCode") String projectCode);

	@Query(" select a.userId from TblDataUser a where a.projectCode = :projectCode ")
	public List<String> getAllUser(@Param("projectCode") String projectCode);

	@Query(" select b.userId from TempTblRegistration b where b.projectCode = :projectCode")
	public List<String> getAllUSerFromTemp(@Param("projectCode") String projectCode);
	

	// @Query("Select a,b from TblDataUser a, TblSessionUser b where
	// a.userSessionCode = b.userSessionCode")
	// public List<Object[]> selectAll();

	// @Query("Select a,b from TblDataUser a, TblSessionUser b where
	// a.userSessionCode = b.userSessionCode")
	// public Page<Object[]> selectAllWithPaging(Pageable pageable);

}
