/**
 *                    _ooOoo_
 *                   o8888888o
 *                   88" . "88
 *                   (| -_- |)
 *                    O\ = /O
 *                ____/`---'\____
 *              .   ' \\| |// `.
 *               / \\||| : |||// \
 *             / _||||| -:- |||||- \
 *               | | \\\ - /// | |
 *             | \_| ''\---/'' | |
 *              \ .-\__ `-` ___/-. /
 *           ___`. .' /--.--\ `. . __
 *        ."" '< `.___\_<|>_/___.' >'"".
 *       | | : `- \`.;`\ _ /`;.`/ - ` : | |
 *         \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 *                    `=---='
 *
 * .............................................
 *                佛祖保佑             永无BUG
 */
package com.wl.demo.entity;


import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 测试demo 响应体
 * @author billy
 * @description TODO
 * @date 2018/2/24 11:23com.wl
 */
public class DemoRes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7976448076472764045L;
	@ApiModelProperty(value = "测试查询demo主键ID", required = true)
	private Integer id;
	@ApiModelProperty(value = "测试查询demoCode", required = true)
	private String demoCode;
	@ApiModelProperty(value = "测试查询demo描述")
	private String demoDesc;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the demoCode
	 */
	public String getDemoCode() {
		return demoCode;
	}

	/**
	 * @param demoCode the demoCode to set
	 */
	public void setDemoCode(String demoCode) {
		this.demoCode = demoCode;
	}

	/**
	 * @return the demoDesc
	 */
	public String getDemoDesc() {
		return demoDesc;
	}

	/**
	 * @param demoDesc the demoDesc to set
	 */
	public void setDemoDesc(String demoDesc) {
		this.demoDesc = demoDesc;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DemoRes [id=" + id + ", demoCode=" + demoCode + ", demoDesc=" + demoDesc + "]";
	}
	
}
