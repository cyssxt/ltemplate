package com.cyssxt.ltemplate.rule;

import com.cyssxt.ltemplate.bean.IfInfo;
import com.cyssxt.ltemplate.core.Template;
import com.cyssxt.ltemplate.expression.Expression;
import com.cyssxt.ltemplate.expression.handler.IfHandler;
import com.cyssxt.ltemplate.util.IdUtil;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IfRule implements Rule{

  @Override
  public Pattern getReg() {
    return Pattern.compile("\\{if ([a-z0-9]+)\\}([^{}]+)\\{/if\\}");
  }

  @Override
  public Expression calc(Template template) {
    Matcher matcher = getReg().matcher(template.toString());
    if(matcher.find()){
      String old = matcher.group(0);
      String eval = matcher.group(1);
      String temp = matcher.group(2);
      String id = IdUtil.getId();
      IfInfo ifInfo = new IfInfo(id,eval,temp,old);
      Map<String,Object> params = template.getParams();
      template.replace(old,String.format("#%s#",id));
      Expression expression = new Expression(ifInfo, new IfHandler(), params);
      return expression;
    }
    return null;
  }

  public static void main(String[] args) {
    //
    Matcher matcher = Pattern.compile("\\{if ([a-z0-9]+)\\}([^{}]+)\\{/if\\}").matcher("{if aa}111{/if}");
    if(matcher.find()) {
      System.out.println(matcher.group(2));
    }
  }

}
