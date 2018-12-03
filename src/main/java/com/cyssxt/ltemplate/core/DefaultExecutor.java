package com.cyssxt.ltemplate.core;

import com.cyssxt.ltemplate.expression.Expression;
import com.cyssxt.ltemplate.response.Result;
import com.cyssxt.ltemplate.rule.Rule;
import com.cyssxt.ltemplate.template.Template;

import java.util.List;

public class DefaultExecutor implements Executor {
  @Override
  public String execute(Template template, List<Rule> rules) {

    List<Expression> expressions = template.list(rules);
    for(Expression expression:expressions){
      Result result = expression.getResult();
      String value = result.getValue();
      String id = result.getId();
      template.replace(id,value);
    }
    return template.toString();
  }
}
