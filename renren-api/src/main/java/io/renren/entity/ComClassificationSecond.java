package io.renren.entity;
/** 
* @Description: 商品分类2信息 
* @Param:  
* @return:
* @Author: dinggc
* @Date: 2019/3/8 
*/ 
public class ComClassificationSecond extends BaseEntity{

	private String classificationSecond;
	private String classificationFirstId;

	public String getClassificationSecond() {
		return classificationSecond;
	}

	public void setClassificationSecond(String classificationSecond) {
		this.classificationSecond = classificationSecond;
	}

	public String getClassificationFirstId() {
		return classificationFirstId;
	}

	public void setClassificationFirstId(String classificationFirstId) {
		this.classificationFirstId = classificationFirstId;
	}
}
