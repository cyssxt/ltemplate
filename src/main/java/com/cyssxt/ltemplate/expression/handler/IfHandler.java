package com.cyssxt.ltemplate.expression.handler;

import com.cyssxt.ltemplate.bean.IfInfo;
import com.cyssxt.ltemplate.core.JsExecutor;
import com.cyssxt.ltemplate.response.Result;
import com.cyssxt.ltemplate.response.ResultConstant;
import javax.script.ScriptException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IfHandler extends DefaultHandler<IfInfo>{

  private final static Pattern REG = Pattern.compile("([a-zA-z_0-9]+)");

  @Override
  public String onNull() {
    return null;
  }

  @Override
  public Result render(IfInfo o, Map params) {
    String condition = o.getCondition();
    condition = calcCondition(condition,params);
    try {
      Boolean flag = JsExecutor.evalBoolean(condition);
      if(flag){
        return new Result(o.getId(),o.getValue());
      }
    } catch (ScriptException e) {
      e.printStackTrace();
    }
    return new Result(o.getId(),"");
  }


  public String calcCondition(String condition,Map<String,Object> params){
    Matcher matcher = REG.matcher(condition);
    List<String> paramNames = new ArrayList<>();
    while (matcher.find()){
      String paramName = matcher.group(1);
      if(paramName!=null && paramName.length()>0){
        paramNames.add(paramName);
      }
    }
    Collections.sort(paramNames, (o1, o2) -> o2.length()-o1.length());
    for(String paramName:paramNames){
      String value = params.get(paramName)==null?
          ResultConstant.JS_EMPTY:JsExecutor.getJsValue(params.get(paramName));
      condition = condition.replace(paramName,value);
    }
    return condition;
  }


  public static void main(String[] args) {
    IfHandler ifHandler = new IfHandler();
    Map<String,Object> params = new HashMap<>();
    params.put("aaa","1");
    params.put("bbbc","2");
    IfInfo ifInfo = new IfInfo("1","cccc","aaa==bbbc","");
    System.out.println(ifHandler.render(ifInfo,params).getValue());
  }
}
