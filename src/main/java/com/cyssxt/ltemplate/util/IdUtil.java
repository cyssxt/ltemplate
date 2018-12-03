package com.cyssxt.ltemplate.util;

import java.util.UUID;

public class IdUtil {

  public static String getId(){
    String id = UUID.randomUUID().toString().replace("-","");
    String key = String.format("#%s#",id);
    return key;
  }
}
