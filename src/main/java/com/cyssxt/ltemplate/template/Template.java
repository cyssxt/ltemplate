package com.cyssxt.ltemplate.template;

import com.cyssxt.ltemplate.expression.Expression;
import com.cyssxt.ltemplate.rule.Rule;

import java.util.List;
import java.util.Map;

public interface Template {

  //计算模版中存在表达式
  List<Expression> list(List<Rule> rules);

  //获取模版参数
  Map<String,Object> getParams();

  //替换字符串
  void replace(String old,String id);

  //id生成规则
  String getId();

  String render(Map<String,Object> params);

  void calcItem(String paramName,String paramValue);

  String getKeyValue(Object value);

  String getContent();

}
