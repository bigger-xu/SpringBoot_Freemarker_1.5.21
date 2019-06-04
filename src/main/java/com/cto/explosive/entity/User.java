/*
 * @(#)  UserVo.java    2019-03-25 23:10:17
 * Project  :Spring boot 代码生产系统
 * Company  :http://www.594cto.com
 */
package com.cto.explosive.entity;

import com.cto.explosive.entity.base.BaseEntity;

import java.util.Date;

/**
 * 文件名User.java
 * @author 1
 * @date 2019-03-25 23:10:17
 *  
 */
public class User extends BaseEntity {
    
	/**
	 * 默认构造函数
	 * @author 1
	 * @date 2019-03-25 23:10:17
	 */
	public User() {

	}
	/**
	 * 属性Id(编码)
	 */
	private Long id;
	/**
	 * 属性UUId(编码)
	 */
	private String uuid;
	/**
	 * 属性UserName(登录名)
	 */
	private String userName;
	/**
	 * 属性NickName(用户昵称)
	 */
	private String nickName;
	/**
	 * 属性Password(密码)
	 */
	private String password;
	/**
	 * 属性CreateTime(添加时间)
	 */
	private Date createTime;
	/**
	 * 属性UpdateTime(更新时间)
	 */
	private Date updateTime;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 *  获取属性Id(编码)
	 * @return Long
	 * @author 1
	 * @date 2019-03-25 23:10:17
	*/
	public Long getId(){
		return id;
	}
	/**
	* 设置属性Id(编码)
	* @param id
	* @return void
	* @author 1
	* @date  2019-03-25 23:10:17
	*/
	public void setId(Long id ){
		this.id = id ;
	}
	/**
	 *  获取属性UserName(登录名)
	 * @return String
	 * @author 1
	 * @date 2019-03-25 23:10:17
	*/
	public String getUserName(){
		return userName;
	}
	/**
	* 设置属性UserName(登录名)
	* @param userName
	* @return void
	* @author 1
	* @date  2019-03-25 23:10:17
	*/
	public void setUserName(String userName ){
		this.userName = userName ;
	}
	/**
	 *  获取属性NickName(用户昵称)
	 * @return String
	 * @author 1
	 * @date 2019-03-25 23:10:17
	*/
	public String getNickName(){
		return nickName;
	}
	/**
	* 设置属性NickName(用户昵称)
	* @param nickName
	* @return void
	* @author 1
	* @date  2019-03-25 23:10:17
	*/
	public void setNickName(String nickName ){
		this.nickName = nickName ;
	}
	/**
	 *  获取属性Password(密码)
	 * @return String
	 * @author 1
	 * @date 2019-03-25 23:10:17
	*/
	public String getPassword(){
		return password;
	}
	/**
	* 设置属性Password(密码)
	* @param password
	* @return void
	* @author 1
	* @date  2019-03-25 23:10:17
	*/
	public void setPassword(String password ){
		this.password = password ;
	}
	/**
	 *  获取属性CreateTime(添加时间)
	 * @return Date
	 * @author 1
	 * @date 2019-03-25 23:10:17
	*/
	public Date getCreateTime(){
		return createTime;
	}
	/**
	* 设置属性CreateTime(添加时间)
	* @param createTime
	* @return void
	* @author 1
	* @date  2019-03-25 23:10:17
	*/
	public void setCreateTime(Date createTime ){
		this.createTime = createTime ;
	}
	/**
	 *  获取属性UpdateTime(更新时间)
	 * @return Date
	 * @author 1
	 * @date 2019-03-25 23:10:17
	*/
	public Date getUpdateTime(){
		return updateTime;
	}
	/**
	* 设置属性UpdateTime(更新时间)
	* @param updateTime
	* @return void
	* @author 1
	* @date  2019-03-25 23:10:17
	*/
	public void setUpdateTime(Date updateTime ){
		this.updateTime = updateTime ;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id(编码):").append(id).append(" ");
		sb.append("UserName(登录名):").append(userName).append(" ");
		sb.append("NickName(用户昵称):").append(nickName).append(" ");
		sb.append("Password(密码):").append(password).append(" ");
		sb.append("CreateTime(添加时间):").append(createTime).append(" ");
		sb.append("UpdateTime(更新时间):").append(updateTime).append(" ");
		return sb.toString();
	}
}
