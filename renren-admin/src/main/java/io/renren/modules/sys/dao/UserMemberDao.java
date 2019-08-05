package io.renren.modules.sys.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.sys.dto.UserMemberDTO;
import io.renren.modules.sys.entity.UserMemberEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-05
 */
@Mapper
public interface UserMemberDao extends BaseDao<UserMemberEntity> {
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
    void saveMember(@Param("id") Long id, @Param("commodityId") Long commodityId,
                    @Param("memberId") Long memberId, @Param("date") Date date);

    /**
     * 根据id获取商品的会员信息
     * @param commodityId
     * @return
     */
    List<UserMemberDTO> getProductionMember(@Param("commodityId") Long commodityId);


}