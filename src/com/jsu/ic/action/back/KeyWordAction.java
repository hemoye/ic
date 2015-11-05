package com.jsu.ic.action.back;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Controller;

import com.jsu.ic.annotation.Log;
import com.jsu.ic.base.MyActionSupport;
import com.jsu.ic.commons.BeanTools;
import com.jsu.ic.commons.Const;
import com.jsu.ic.po.Keyword;
import com.jsu.ic.po.User;
import com.jsu.ic.vo.KeyWordVO;
import com.jsu.ic.vo.PageBean;

@Controller
public class KeyWordAction extends MyActionSupport<Keyword> {

	private static final long serialVersionUID = -4545183056813096500L;

	private PageBean keyBean;
	private String wordIds;
	private Integer userId;

	@Log("敏感词首页")
	public String index() {
		User user = getCurrentUser();
		msg.put("powers", powerService.findByRole(user.getUserrole()));
		return "index";
	}

	@Log("加载敏感词列表")
	public String loadData() {
		keyBean = keyWordService.getPageBean(pageNum, pageSize, beginTime, endTime, model.getWord());
		json(keyBean);
		return null;
	}
	
	@Log("添加敏感词")
	public String add() {
		Keyword keyword = keyWordService.findByProperty("word", model.getWord());
		if (keyword != null) {
			json(Const.getMessage("module.5"));
		}
		else {
			model.setAddTime(new Timestamp(new Date().getTime()));
			model.setUpdateTime(new Timestamp(new Date().getTime()));
			model.setIsDelete(false);
			keyWordService.save(model);
			json(Const.getMessage("module.6"));
		}
		return null;
	}

	public String detail() {
		if (userId != null) {
			model = keyWordService.findById(userId);
			KeyWordVO keyWordVO = new KeyWordVO();
			BeanTools.copyProperties(model, keyWordVO);
			json(keyWordVO);
		}
		return null;
	}

	@Log("修改敏感词")
	public String update() {
		Keyword keyword = keyWordService.findById(model.getWordId());
		keyword.setSortNumber(model.getSortNumber());
		keyword.setWord(model.getWord());
		keyword.setUpdateTime(new Timestamp(new Date().getTime()));
		keyWordService.update(keyword);
		json(Const.getMessage("module.1"));
		return null;
	}

	@Log("删除敏感词")
	public String deleteByIds() {
		if (wordIds.contains(",")) {
			String[] strids = wordIds.split(",");
			Integer[] ids = new Integer[strids.length];
			for (int i = 0; i < strids.length; i++) {
				ids[i] = Integer.parseInt(strids[i]);
			}
			keyWordService.deleteByIds(ids);
		} else {
			model = keyWordService.findById(Integer.parseInt(wordIds));
			model.setUpdateTime(new Timestamp(new Date().getTime()));
			model.setIsDelete(true);
			keyWordService.update(model);
		}
		json(Const.getMessage("module.3"));
		return null;
	}

	public void setWordIds(String wordIds) {
		this.wordIds = wordIds;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
