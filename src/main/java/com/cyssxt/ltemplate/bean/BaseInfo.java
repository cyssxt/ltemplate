package com.cyssxt.ltemplate.bean;

public class BaseInfo {

  private String id;
  private String value;
  private String old;

  public BaseInfo(String id,String old,String value) {
    this.id = id;
    this.value = value;
    this.old = old;
  }


  public String getOld() {
    return old;
  }

  public void setOld(String old) {
    this.old = old;
  }
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
