package com.cyssxt.ltemplate.expression.handler;

import com.cyssxt.ltemplate.bean.ParamInfo;
import com.cyssxt.ltemplate.core.JsExecutor;
import com.cyssxt.ltemplate.response.Result;
import com.cyssxt.ltemplate.response.ResultConstant;
import java.util.Map;

public class ParamHandler extends DefaultHandler<ParamInfo> {
  @Override
  public Result render(ParamInfo paramInfo, Map<String, Object> params) {
    String paramName = paramInfo.getParamName();
    String id = paramInfo.getId();
    Object value = params.get(paramName);
    return new Result(id,getValue(value));
  }

  @Override
  public String parseValue(Object value) {
    return JsExecutor.getJsValue(value);
  }

  @Override
  public String onNull() {
    return ResultConstant.JS_EMPTY;
  }
}
