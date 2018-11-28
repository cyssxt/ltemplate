package com.cyssxt.ltemplate.core;

import com.cyssxt.ltemplate.expression.Expression;
import com.cyssxt.ltemplate.response.Result;

import java.util.ArrayList;
import java.util.List;

public class TemplateExec {

  public String execute(Template template){
    List<Expression> expressionList = template.list(null);
    List<Result> results = new ArrayList<>();
    for(Expression expression:expressionList){
      Result result = expression.getResult();
      results.add(result);
    }
    return null;
  }
}
