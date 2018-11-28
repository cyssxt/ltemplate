package com.cyssxt.ltemplate.expression;

import com.cyssxt.ltemplate.expression.handler.Handler;
import com.cyssxt.ltemplate.response.Result;

import java.util.Map;

public class Expression<T> {

  private Handler handler;
  private Map<String,Object> params;
  private T t;
  public Expression(T t,Handler<T> handler,Map<String,Object> params) {
    this.handler = handler;
    this.params = params;
    this.t = t;
  }

  public Result getResult() {
    return handler.render(t,params);
  }
}
