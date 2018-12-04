package com.cyssxt.ltemplate.core;

import com.cyssxt.ltemplate.expression.Expression;
import com.cyssxt.ltemplate.response.Result;
import com.cyssxt.ltemplate.rule.IfRule;
import com.cyssxt.ltemplate.rule.ParamRule;
import com.cyssxt.ltemplate.rule.Rule;
import com.cyssxt.ltemplate.rule.UrlParamRule;
import com.cyssxt.ltemplate.template.DefaultTemplate;
import com.cyssxt.ltemplate.template.Template;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DefaultExecutor implements Executor {

  private static Executor executor = null;

  @Override
  public String execute(Template template, List<Rule> rules,List<Rule> paramRules) {

    List<Expression> expressions = template.list(rules);
    eval(template, expressions);
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

  public static List<Rule> getExpressionRules(){
    List<Rule> rules = new ArrayList<>();
    rules.add(new IfRule());
    return rules;
  }

  public static List<Rule> getParamRules(){
    return getParamRules(false);
  }

  public static List<Rule> getParamRules(boolean filter){
    List<Rule> rules = new ArrayList<>();
    rules.add(new UrlParamRule());
    if(!filter){
      rules.add(new ParamRule());
    }
    return rules;
  }

  public static String execute(String sql,Map<String,Object> paramMap){
    Template template = new DefaultTemplate(sql,paramMap);
    return DefaultExecutor.getInstance().execute(template,getExpressionRules(),getParamRules());
  }

  public static String execute(String sql,Map<String,Object> paramMap,boolean flag){
    Template template = new DefaultTemplate(sql,paramMap);
    return DefaultExecutor.getInstance().execute(template,getExpressionRules(),getParamRules(flag));
  }

}
