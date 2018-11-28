package com.cyssxt.ltemplate.core;

import com.cyssxt.ltemplate.expression.Expression;
import com.cyssxt.ltemplate.rule.Rule;

import java.util.List;
import java.util.Map;

public interface Template {

  String render(Map<String,Object> paramsMap);

  void If(Expression expression);

  List<Expression> list(List<Rule> rules);

  Map<String,Object> getParams();

  Template replace(String old,String id);
}
