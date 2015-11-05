package com.jsu.ic.action.back;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Controller;

import com.jsu.ic.annotation.Log;
import com.jsu.ic.base.MyActionSupport;
import com.jsu.ic.po.Head;
import com.jsu.ic.po.User;
import com.jsu.ic.vo.PageBean;

@Controller
public class HeadAction extends MyActionSupport<Head> {

	private static final long serialVersionUID = -820967134923429377L;
	private String headIds;

	private PageBean headBean;

	@Log("系统头像首页")
	public String index() {
		User user = getCurrentUser();
		msg.put("powers", powerService.findByRole(user.getUserrole()));
		return "index";
	}

	@Log("加载头像列表")
	public String loadData() {
		headBean = headService.getPageBean(pageNum, pageSize, beginTime, endTime);
		json(headBean);
		return null;
	}

	@Log("根据一组标识删除头像")
	public String deleteByIds() {
		if (headIds.contains(",")) {
			String[] strids = headIds.split(",");
			Integer[] ids = new Integer[strids.length];
			for (int i = 0; i < strids.length; i++) {
				ids[i] = Integer.parseInt(strids[i]);
			}
			headService.deleteByIds(ids);
		} else {
			model = headService.findById(Integer.parseInt(headIds));
			model.setIsDelete(true);
			model.setUpdateTime(new Timestamp(new Date().getTime()));
			headService.update(model);
		}
		return null;
	}

	public void setHeadIds(String headIds) {
		this.headIds = headIds;
	}

}
