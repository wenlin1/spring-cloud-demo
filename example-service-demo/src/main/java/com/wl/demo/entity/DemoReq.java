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
 * 测试demo 请求体
 * @author billy
 * @description TODO
 * @date 2018/2/24 11:23
 */
public class DemoReq implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7782922734469661711L;
	@ApiModelProperty(value = "测试查询demoCode", example = "code1" ,required = true)
	private String demoCode;

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

	@Override
	public String toString() {
		return "DemoReq [demoCode=" + demoCode + "]";
	}
	
	
}
