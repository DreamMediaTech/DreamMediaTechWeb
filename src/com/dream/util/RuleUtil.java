package com.dream.util;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class RuleUtil {
	private static  ScriptEngineManager manager;
	private static  ScriptEngine se;
	public static void init(){
		//加载JavaScript引擎
		manager = new ScriptEngineManager();
		se    = manager.getEngineByName("js");
	}
	
	public static Object runRule(Rule rule,String... params){
		init();
		double result = 0.0;
		String str = "";
		//根据规则参数个数进行公式和参数的拼接
		switch (rule.getParamsCount()) {
		case 1 :
			str = String.format(rule.getRuleContent(), params[0]);
			break;
		case 2 :
			str = String.format(rule.getRuleContent(), params[0],params[1]);
			break;
		case 3 :
			str = String.format(rule.getRuleContent(), params[0],params[1],params[2]);
			break;
		case 4 :
			str = String.format(rule.getRuleContent(), params[0],params[1],params[2],params[3]);
			break;
		case 5 :
			str = String.format(rule.getRuleContent(), params[0],params[1],params[2],params[3],params[4]);
			break;
		default:
			break;
		}
		//执行计算
		try {
			result = (double) se.eval(str);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//测试工具
	public static void main(String[] args) {
		//创建测试规则
		Rule rule = new Rule();
		rule.setParamsCount(2);//测试参数个数
		rule.setRuleContent("%s*%s");//测试用公式x*y
		double result = (double) RuleUtil.runRule(rule,"5","0.5");
		System.out.println(result);//控制台输出测试结果
	}
}
