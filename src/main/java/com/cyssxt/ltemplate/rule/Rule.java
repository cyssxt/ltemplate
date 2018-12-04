package com.cyssxt.ltemplate.rule;

import com.cyssxt.ltemplate.expression.handler.Handler;
import com.cyssxt.ltemplate.template.Template;
import com.cyssxt.ltemplate.expression.Expression;

import java.util.List;
import java.util.regex.Pattern;

public interface Rule {

//  private final static  Pattern REG = Pattern.compile("\\{if ([a-z0-9]+)\\}([^{}]+)\\{/if\\}");
//
//  public static void main(String[] args) {

//    String template = "{if aaa} a aaaa {/if}";
//    Matcher matcher = REG.matcher(template);
//    System.out.println(matcher.groupCount());
//  }

  Pattern getReg();

  List<Expression> calc(Template template);

  Handler getHandler();
}
