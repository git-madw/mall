package io.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.sys.dao.UserMemberDao;
import io.renren.modules.sys.dto.UserMemberDTO;
import io.renren.modules.sys.entity.UserMemberEntity;
import io.renren.modules.sys.service.UserMemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-05
 */
@Service
public class UserMemberServiceImpl extends CrudServiceImpl<UserMemberDao, UserMemberEntity, UserMemberDTO> implements UserMemberService {

    @Autowired
    UserMemberDao dao;

    @Override
    public QueryWrapper<UserMemberEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<UserMemberEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


    @Override
    public List<UserMemberDTO> getMembers() {
        return dao.getMembers();
    }

    @Override
    public void saveMember(Long id, Long commodityId, Long memberId, Date date) {
        dao.saveMember(id,commodityId,memberId,date);
    }

    @Override
    public List<UserMemberDTO> getProductionMember(Long commodityId) {
        return dao.getProductionMember(commodityId);
    }
}