package com.jsu.ic.test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 木木
 *
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class TestStrutsAction extends ActionSupport {

	/**
	 * 测试整合Struts
	 */
	public String execute() throws Exception {
		System.out.println("测试成功");
		return SUCCESS;
	}
}
