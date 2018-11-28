package com.cyssxt.ltemplate.core;

import com.cyssxt.ltemplate.expression.Expression;
import com.cyssxt.ltemplate.response.Result;
import com.cyssxt.ltemplate.rule.Rule;

import java.util.List;
import java.util.Map;

public class StringTemplate implements Template {
  @Override
  public String render(Map<String, Object> paramsMap) {
    return null;
  }

  @Override
  public void If(Expression expression) {

  }

  @Override
  public List<Expression> list(List<Rule> rules) {
    return null;
  }

  public String render(List<Result> results) {
    return null;
  }

  @Override
  public Map<String, Object> getParams() {
    return null;
  }

  @Override
  public Template replace(String old, String id) {
    return null;
  }
}
