package com.cyssxt.ltemplate.rule;

import com.cyssxt.ltemplate.expression.handler.Handler;
import com.cyssxt.ltemplate.expression.handler.UrlParamHandler;

import java.util.regex.Pattern;

public class UrlParamRule extends ParamRule {

  @Override
  public Pattern getReg() {
    return Pattern.compile("\\#([0-9a-zA-z]+)\\#");
  }

  @Override
  public Handler getHandler() {
    return new UrlParamHandler();
  }
}
