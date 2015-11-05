package com.jsu.ic.base;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.jsu.ic.commons.Const;
import com.jsu.ic.commons.JSONSupport;
import com.jsu.ic.po.User;
import com.jsu.ic.service.ApplyFriendService;
import com.jsu.ic.service.CityService;
import com.jsu.ic.service.ClazzService;
import com.jsu.ic.service.CountyService;
import com.jsu.ic.service.DepartService;
import com.jsu.ic.service.HeadService;
import com.jsu.ic.service.KeyWordService;
import com.jsu.ic.service.MessageService;
import com.jsu.ic.service.PostResourceService;
import com.jsu.ic.service.PostTypeService;
import com.jsu.ic.service.PowerService;
import com.jsu.ic.service.ProvinceService;
import com.jsu.ic.service.RealInfoService;
import com.jsu.ic.service.ReplyService;
import com.jsu.ic.service.ResourceTypeService;
import com.jsu.ic.service.SchoolService;
import com.jsu.ic.service.SysLogService;
import com.jsu.ic.service.UserInfoService;
import com.jsu.ic.service.UserOfficeService;
import com.jsu.ic.service.UserPostService;
import com.jsu.ic.service.UserRelationService;
import com.jsu.ic.service.UserRoleService;
import com.jsu.ic.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author 木木
 * 
 */

@SuppressWarnings("serial")
public abstract class MyActionSupport<T> extends ActionSupport implements ModelDriven<T> {

	// =============== ModelDriven的支持 ==================
	protected T model;
	protected Map<String, Object> msg = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	public MyActionSupport() {
		try {
			// 通过反射获取model的真实类型
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			// 通过反射创建model的实例
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}

	// =============== Service实例的声明 ==================
	@Resource
	protected ApplyFriendService applyFriendService;
	@Resource
	protected CityService cityService;
	@Resource
	protected ClazzService clazzService;
	@Resource
	protected CountyService countyService;
	@Resource
	protected DepartService departService;
	@Resource
	protected HeadService headService;
	@Resource
	protected KeyWordService keyWordService;
	@Resource
	protected MessageService messageService;
	@Resource
	protected PostResourceService postResourceService;
	@Resource
	protected PostTypeService postTypeService;
	@Resource
	protected PowerService powerService;
	@Resource
	protected ProvinceService provinceService;
	@Resource
	protected RealInfoService realInfoService;
	@Resource
	protected ReplyService replyService;
	@Resource
	protected ResourceTypeService resourceTypeService;
	@Resource
	protected SchoolService schoolService;
	@Resource
	protected SysLogService sysLogService;
	@Resource
	protected UserInfoService userInfoService;
	@Resource
	protected UserOfficeService userOfficeService;
	@Resource
	protected UserPostService userPostService;
	@Resource
	protected UserRelationService userRelationService;
	@Resource
	protected UserRoleService userRoleService;
	@Resource
	protected UserService userService;

	/**
	 * 获取当前登录的用户
	 * 
	 * @return 当前登录的用户实体
	 */
	protected User getCurrentUser() {
		User user = (User) ActionContext.getContext().getSession().get(Const.LOGIN_USER_SESSION_KEY);
		return user;
	}

	/**
	 * 将key的值value放入session
	 * 
	 * @param key
	 *            标识
	 * @param value
	 *            值
	 */
	protected void print(String key, Object value) {
		msg.put(key, value);
		ServletActionContext.getContext().put(key, msg);
	}

	/**
	 * AJAX异步传输、json方式写出数据
	 * 
	 * @param value
	 *            数据
	 */
	protected void json(Object value) {
		try {
			ServletActionContext.getResponse().getWriter().print(JSONSupport.json(value));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * AJAX方式异步写出字符串数据
	 * 
	 * @param value
	 */
	protected void json(String value) {
		try {
			ServletActionContext.getResponse().getWriter().print(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String outView(String template) {
		ActionContext.getContext().put("outViewTemplate", template);
		return "VIEW";
	}

	// ============== 分页用的参数 =============

	protected int pageNum = 1; // 当前页
	protected int pageSize = 10; // 每页显示多少条记录
	protected Date beginTime;
	protected Date endTime;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Map<String, Object> getMsg() {
		return msg;
	}
}
