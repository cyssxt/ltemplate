package com.cyssxt.ltemplate.rule;

import com.cyssxt.ltemplate.expression.Expression;
import com.cyssxt.ltemplate.expression.handler.ParamHandler;
import com.cyssxt.ltemplate.template.Template;
import com.cyssxt.ltemplate.util.IdUtil;
import com.cyssxt.ltemplate.bean.ParamInfo;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParamRule implements Rule {
  @Override
  public Pattern getReg() {
    return Pattern.compile("\\:([0-9a-zA-Z]+)");
  }

  @Override
  public Expression calc(Template template) {
    String content = template.getContent();
    Matcher matcher = getReg().matcher(content);
    while (matcher.find()){
      String old = matcher.group(0);
      String paramName = matcher.group(1);
      String id = IdUtil.getId();
      ParamInfo paramInfo = new ParamInfo(id,paramName);
      Map<String,Object> params = template.getParams();
      template.replace(old,id);
      Expression expression = new Expression(paramInfo, new ParamHandler(), params);
      return expression;
    }
    return null;
  }
}
