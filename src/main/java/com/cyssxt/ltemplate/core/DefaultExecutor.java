package com.cyssxt.ltemplate.core;

import com.cyssxt.ltemplate.expression.Expression;
import com.cyssxt.ltemplate.rule.Rule;

import java.util.List;

public class DefaultExecutor implements Executor {
  @Override
  public String execute(Template template,List<Rule> rules) {

    List<Expression> expressions = template.list(rules);
    for(Expression expression:expressions){

    }
    return null;
  }
}
