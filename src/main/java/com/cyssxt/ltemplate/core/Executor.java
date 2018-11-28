package com.cyssxt.ltemplate.core;

import com.cyssxt.ltemplate.rule.Rule;

import java.util.List;

public interface Executor {

  String execute(Template template,List<Rule> rules);
}
