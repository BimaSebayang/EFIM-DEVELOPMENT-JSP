package id.co.roxas.efim.service.owner.headuser;

import java.util.List;
import java.util.Map;

import Share.Dto.HeadUser.TblDataUserDto;
import id.co.roxas.efim.lib.Paging;

public interface TblDataUserSvc {

	public Map<String, Object> getTheResultEmailAddress(String userId, String projectId);

	public Map<String, Object> getTheResultAllExistingUser(String projectCode);
}
