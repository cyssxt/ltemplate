package com.cyssxt.ltemplate.bean;


public class IfInfo extends BaseInfo {

  private String condition;

  public IfInfo(String id,String condition,String value,  String old) {
    super(id,old,value);
    this.condition = condition;
  }


  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }
}
