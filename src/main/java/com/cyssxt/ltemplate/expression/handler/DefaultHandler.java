package com.cyssxt.ltemplate.expression.handler;

import com.cyssxt.ltemplate.core.JsExecutor;
import com.cyssxt.ltemplate.response.ResultConstant;

public abstract class DefaultHandler<T> implements Handler<T> {

  @Override
  public String parseValue(Object value) {
    return JsExecutor.getJsValue(value);
  }

  @Override
  public String onNull() {
    return ResultConstant.JS_EMPTY;
  }

  public String getValue(Object value){
    return value==null?onNull():parseValue(value);
  }
}
