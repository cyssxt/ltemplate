package com.cyssxt.ltemplate.bean;


public class ParamInfo {
  private String Id;
  private String paramName;

  public ParamInfo(String id, String paramName) {
    Id = id;
    this.paramName = paramName;
  }

  public String getId() {
    return Id;
  }

  public void setId(String id) {
    Id = id;
  }

  public String getParamName() {
    return paramName;
  }

  public void setParamName(String paramName) {
    this.paramName = paramName;
  }
}
