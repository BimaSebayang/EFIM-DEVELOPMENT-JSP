package id.co.roxas.efim.dao.master;
import org.springframework.data.jpa.repository.JpaRepository;

import id.co.roxas.efim.entity.master.TblCode;
import id.co.roxas.efim.entity.master.pk.TblCodePk;

public interface TblCodeDao extends JpaRepository<TblCode, TblCodePk>{
	
}
