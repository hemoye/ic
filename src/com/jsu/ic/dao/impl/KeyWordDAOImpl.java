package com.jsu.ic.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.commons.BeanTools;
import com.jsu.ic.commons.QueryHelper;
import com.jsu.ic.dao.KeyWordDAO;
import com.jsu.ic.po.Keyword;
import com.jsu.ic.vo.KeyWordVO;
import com.jsu.ic.vo.PageBean;

@SuppressWarnings("unchecked")
@Repository("keyWordDAO")
public class KeyWordDAOImpl extends DaoSupportImpl<Keyword> implements KeyWordDAO {

	@Override
	public PageBean getPageBean(int pageNum, int pageSize, Date beginTime, Date endTime, String word) {
		QueryHelper queryHelper = new QueryHelper(Keyword.class, "user");
		if (null != word && !"".equals(word)) {
			queryHelper.addCondition("word like '%" + word + "%'");
		}
		if (null != beginTime) {
			queryHelper.addCondition("addTime >= ?", beginTime);
		}
		if (null != endTime) {
			queryHelper.addCondition("addTime <= ?", endTime);
		}
		queryHelper.addOrderProperty("wordId", true);
		PageBean keyBean = getPageBean(pageNum, pageSize, queryHelper);

		List<KeyWordVO> keyWordVOs = BeanTools.copyProperties(keyBean.getRecordList(), new KeyWordVO());
		keyBean.setRecordList(keyWordVOs);

		return keyBean;
	}

	@Override
	public void deleteByIds(Integer[] ids) {
		log.debug("delete KeyWord with ids: " + ids);
		try {
			if (null == ids || 0 == ids.length) {
				log.error("delete failed" + " the ids is null or the ids.length is zero");
			} else {
				getSession().createSQLQuery("update KeyWord set isDelete = 1, updateTime = ? where wordId in (:ids)")
						.setParameterList("ids", ids).setTimestamp(0, new Date()).executeUpdate();
			}
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

}
