package com.cyssxt.ltemplate.expression.handler;

import com.cyssxt.ltemplate.bean.ParamInfo;
import com.cyssxt.ltemplate.response.Result;

import java.util.Map;

public class ParamHandler implements Handler<ParamInfo> {
  @Override
  public Result render(ParamInfo paramInfo, Map<String, Object> params) {
    String paramName = paramInfo.getParamName();
    String id = paramInfo.getId();
    Object value = params.get(paramName);
    return new Result(id,value==null?"":value+"");
  }
}
