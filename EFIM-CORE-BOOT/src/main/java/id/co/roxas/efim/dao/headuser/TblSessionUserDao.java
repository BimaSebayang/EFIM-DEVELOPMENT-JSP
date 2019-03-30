package id.co.roxas.efim.dao.headuser;

import org.springframework.data.jpa.repository.JpaRepository;

import id.co.roxas.efim.entity.headuser.TblSessionUser;
import id.co.roxas.efim.entity.headuser.pk.TblSessionUserPk;

public interface TblSessionUserDao extends JpaRepository<TblSessionUser, TblSessionUserPk>{

}
