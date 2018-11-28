package com.cyssxt.ltemplate.expression.handler;

import com.cyssxt.ltemplate.response.Result;
import java.util.Map;

public interface Handler<T> {

  Result render(T t,Map<String,Object> params);

}
