package com.jsu.ic.action.back;

import java.util.Date;

import org.springframework.stereotype.Controller;

import com.jsu.ic.annotation.Log;
import com.jsu.ic.base.MyActionSupport;
import com.jsu.ic.commons.Const;
import com.jsu.ic.po.User;

@Controller
public class IndexAction extends MyActionSupport<User> {

	private static final long serialVersionUID = 6745443051265125145L;

	@Log("后台首页")
	public String index() {
		model = getCurrentUser();

		Date endTime = Const.getDate();
		Date beginTime = new Date(endTime.getTime() - 1000 * 24 * 60 * 60);
		msg.put("onlineNumber", Const.loginUsers.size());
		msg.put("userNumber", userInfoService.findByDate(beginTime, endTime).size());
		msg.put("visitNumber", sysLogService.findByDate(beginTime, endTime).size());
		msg.put("schoolNumber", schoolService.findByDate(beginTime, endTime).size());
		msg.put("users", userService.findAll().size());
		msg.put("schools", schoolService.findAll().size());
		msg.put("posts", userPostService.findAll().size());
		msg.put("resources", postResourceService.findAll().size());
		msg.put("powers", powerService.findByRole(model.getUserrole()));

		return "index";
	}

}
