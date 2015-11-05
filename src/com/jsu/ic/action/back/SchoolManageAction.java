package com.jsu.ic.action.back;

import org.springframework.stereotype.Controller;

import com.jsu.ic.base.MyActionSupport;
import com.jsu.ic.po.School;

@Controller
public class SchoolManageAction extends MyActionSupport<School> {

	private static final long serialVersionUID = -3852802185190423318L;

	public String index() {
		return "index";
	}
}
