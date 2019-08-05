package io.renren.modules.sys.service;

import io.renren.common.service.CrudService;
import io.renren.modules.sys.dao.UserMemberDao;
import io.renren.modules.sys.dto.UserMemberDTO;
import io.renren.modules.sys.entity.UserMemberEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-05
 */
public interface UserMemberService extends CrudService<UserMemberEntity, UserMemberDTO> {
    /**
     * 获取所有的会员等级
     * @return
     */
    List<UserMemberDTO> getMembers();
    /**
     * 保存商品的会员等级信息
     * @param id
     * @param commodityId
     * @param memberId
     * @param date
     */
    void saveMember(Long id,Long commodityId, Long memberId,Date date);
    /**
     * 根据id获取商品的会员信息
     * @param commodityId
     * @return
     */
    List<UserMemberDTO> getProductionMember(Long commodityId);
}