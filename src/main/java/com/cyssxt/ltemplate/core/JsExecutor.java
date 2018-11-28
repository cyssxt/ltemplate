package com.cyssxt.ltemplate.core;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JsExecutor {
  final static ScriptEngineManager manager = new ScriptEngineManager();
  final static ScriptEngine engine = manager.getEngineByName("javascript");
  public static Boolean evalBoolean(String path) throws ScriptException {
    return (Boolean) engine.eval(path);
  }

  public static String getJsValue(Object value){
    return String.format("'%s'",value);
  }

  public static void main(String[] args) throws ScriptException {
//    System.out.println(eval(""));
  }
}
