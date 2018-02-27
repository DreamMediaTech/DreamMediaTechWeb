package com.dream.util;

import com.google.gson.Gson;

public class Rule {
	private String ruleContent; //规则公式字符串
	private int paramsCount; //规则参数个数

	public String getRuleContent() {
		return ruleContent;
	}

	public void setRuleContent(String ruleContent) {
		this.ruleContent = ruleContent;
	}

	public int getParamsCount() {
		return paramsCount;
	}

	public void setParamsCount(int paramsCount) {
		this.paramsCount = paramsCount;
	}
	
	
}
