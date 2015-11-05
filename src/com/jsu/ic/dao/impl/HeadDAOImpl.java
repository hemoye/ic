package com.jsu.ic.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.commons.BeanTools;
import com.jsu.ic.commons.QueryHelper;
import com.jsu.ic.dao.HeadDAO;
import com.jsu.ic.po.Head;
import com.jsu.ic.vo.HeadVO;
import com.jsu.ic.vo.PageBean;

@SuppressWarnings("unchecked")
@Repository("headDAO")
public class HeadDAOImpl extends DaoSupportImpl<Head> implements HeadDAO {

	@Override
	public PageBean getPageBean(int pageNum, int pageSize, Date beginTime, Date endTime) {
		QueryHelper queryHelper = new QueryHelper(Head.class, "head");
		if (null != beginTime) {
			queryHelper.addCondition("userinfo.registTime >= ?", beginTime);
		}
		if (null != endTime) {
			queryHelper.addCondition("userinfo.registTime <= ?", endTime);
		}
		queryHelper.addCondition("isDelete = ?", false);
		queryHelper.addOrderProperty("headId", true);
		PageBean headBean = getPageBean(pageNum, pageSize, queryHelper);

		List<HeadVO> headVOs = BeanTools.copyProperties(headBean.getRecordList(), new HeadVO());
		headBean.setRecordList(headVOs);

		return headBean;
	}

	@Override
	public void deleteByIds(Integer[] ids) {
		log.debug("delete Head with ids: " + ids);
		try {
			if (null == ids || 0 == ids.length) {
				log.error("delete failed" + " the ids is null or the ids.length is zero");
			} else {
				getSession().createSQLQuery("update head set isDelete = 1 where headId in (:ids)").setParameterList("ids", ids)
						.executeUpdate();
			}
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

}
