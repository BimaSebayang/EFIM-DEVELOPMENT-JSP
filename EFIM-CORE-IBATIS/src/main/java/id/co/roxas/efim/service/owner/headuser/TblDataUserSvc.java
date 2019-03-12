package id.co.roxas.efim.service.owner.headuser;

import java.util.List;
import java.util.Map;

import Share.Dto.HeadUser.TblDataUserDto;
import id.co.roxas.efim.lib.Paging;

public interface TblDataUserSvc {

	public List<TblDataUserDto> selectAllUserWithParamPaging(Paging paging);
	
}
