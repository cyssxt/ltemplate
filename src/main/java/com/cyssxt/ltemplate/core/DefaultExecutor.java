package com.cyssxt.ltemplate.core;

import com.cyssxt.ltemplate.expression.Expression;
import com.cyssxt.ltemplate.response.Result;
import com.cyssxt.ltemplate.rule.IfRule;
import com.cyssxt.ltemplate.rule.ParamRule;
import com.cyssxt.ltemplate.rule.Rule;
import com.cyssxt.ltemplate.template.DefaultTemplate;
import com.cyssxt.ltemplate.template.Template;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DefaultExecutor implements Executor {

  private static Executor executor = null;

  @Override
  public String execute(Template template, List<Rule> rules) {

    List<Expression> expressions = template.list(rules);
    eval(template, expressions);
    List<Rule> paramRules=  new ArrayList<>();
    paramRules.add(new ParamRule());
    List<Expression> paramExpressions = template.list(paramRules);
    eval(template, paramExpressions);
    return template.getContent();
  }

  private void eval(Template template, List<Expression> paramExpressions) {
    for(Expression expression:paramExpressions) {
      if (expression == null) {
        continue;
      }
      Result result = expression.getResult();
      String value = result.getValue();
      String id = result.getId();
      template.replace(id,value);
    }
  }

  public synchronized static Executor getInstance(){
    if(executor==null){
      executor = new DefaultExecutor();
    }
    return executor;
  }

  public static String execute(String sql,Map<String,Object> paramMap){
    Template template = new DefaultTemplate(sql,paramMap);
    List<Rule> rules = new ArrayList<>();
    rules.add(new IfRule());
    return DefaultExecutor.getInstance().execute(template,rules);
  }

}
