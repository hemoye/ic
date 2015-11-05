package com.jsu.ic.action.back;

import org.springframework.stereotype.Controller;

import com.jsu.ic.annotation.Log;
import com.jsu.ic.base.MyActionSupport;
import com.jsu.ic.po.Syslog;
import com.jsu.ic.po.User;
import com.jsu.ic.vo.PageBean;

@Controller
public class SysLogAction extends MyActionSupport<Syslog> {

	private static final long serialVersionUID = 7398872233034052694L;
	private PageBean logBean;
	private String userName;
	private Integer userId;
	private Integer success;

	@Log("日志管理首页")
	public String index() {
		User user = getCurrentUser();
		msg.put("powers", powerService.findByRole(user.getUserrole()));
		return "index";
	}

	@Log("加载日志列表")
	public String loadData() {
		logBean = sysLogService.getPageBean(pageNum, pageSize, beginTime, endTime, userName, success);
		json(logBean);
		return null;
	}

	public String detail() {
		Syslog syslog = sysLogService.findById(userId);
		print("syslog", syslog);
		return "detail";
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setSuccess(Integer success) {
		this.success = success;
	}

}
