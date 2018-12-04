package com.cyssxt.ltemplate.core;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.regex.Pattern;

public class JsExecutor {


  final static ScriptEngineManager manager = new ScriptEngineManager();
  final static ScriptEngine engine = manager.getEngineByName("javascript");
  public static Boolean evalBoolean(String path) throws ScriptException {
    return (Boolean) engine.eval(String.format("Boolean(%s)",path));
  }

  public static String getJsValue(Object value){

    if(value instanceof String){
      return String.format("'%s'",value);
    }
    return value+"";
  }
  public static void main(String[] args) throws ScriptException {
//    System.out.println(eval(""));
  }
}
