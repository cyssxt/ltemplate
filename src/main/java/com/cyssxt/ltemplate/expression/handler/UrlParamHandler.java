package com.cyssxt.ltemplate.expression.handler;

public class UrlParamHandler extends ParamHandler {

  @Override
  public String onNull() {
    return null;
  }

  @Override
  public String parseValue(Object value) {
    return value+"";
  }
}
