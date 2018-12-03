package com.cyssxt.ltemplate.template;

import com.cyssxt.ltemplate.expression.Expression;
import com.cyssxt.ltemplate.rule.Rule;
import com.cyssxt.ltemplate.util.IdUtil;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultTemplate implements Template {

  private final static Pattern KEY_REG = Pattern.compile("\\{([a-zA-Z_]+[a-zA-Z_0-9]+)\\}");

  private String content;
  private Map<String,Object> params;

  public DefaultTemplate(String content, Map<String,Object> params) {
    this.content = content;
    this.params = params;
  }

  @Override
  public List<Expression> list(List<Rule> rules) {
    List<Expression> expressions = new ArrayList<>();
    for(Rule rule:rules){
      Expression expression = rule.calc(this);
      if(expression==null){
        continue;
      }
      expressions.add(expression);
    }
    return expressions;
  }

  @Override
  public Map<String, Object> getParams() {
    return this.params;
  }

  @Override
  public void replace(String old, String id) {
    this.content = this.content.replace(old,id);
  }

  @Override
  public String getId() {
    return IdUtil.getId();
  }

  @Override
  public String render(Map<String, Object> paramMap) {
    String temp = this.content;
    Matcher matcher = KEY_REG.matcher(temp);
    List<String> params = new ArrayList<>();
    while (matcher.find()){
      params.add(matcher.group(1));
    }
    Collections.sort(params, (o1, o2) -> o2.length()-o1.length());
    for(String param:params){
      this.content = this.content.replace(param,getKeyValue(paramMap.get(param)));
    }
    return null;
  }

  @Override
  public void calcItem(String paramName, String paramValue) {
    this.content = this.content.replace(paramName,paramName);
  }

  @Override
  public String getKeyValue(Object value) {
    return String.format("''",value);
  }

  @Override
  public String getContent() {
    return this.content;
  }

  public static void main(String[] args) {
    //
    String a = "1";
    String b = a;
    b="123";
    System.out.println(a);
  }
}
