/**
 * FileName: Address
 * Author:   dinggc
 * Date:     2019/7/31 21:32
 * Description: 收货地址实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package io.renren.entity;

/**
 * 〈一句话功能简述〉<br> 
 * 〈收货地址实体类〉
 *
 * @author dinggc
 * @create 2019/7/31
 * @since 1.0.0
 */
public class Address extends BaseEntity{
    /**
     * 用户地址
     */
    private String userAddress;
    /**
     * 详细门牌号
     */
    private String detailAddress;
    /**
     * 地址默认状态
     */
    private int addressStatus;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 收货人
     */
    private String name;
    /**
     * 收货手机号
     */
    private String tel;

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public int getAddressStatus() {
        return addressStatus;
    }

    public void setAddressStatus(int addressStatus) {
        this.addressStatus = addressStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}