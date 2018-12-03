package com.cyssxt.ltemplate.core;

import com.cyssxt.ltemplate.rule.Rule;
import com.cyssxt.ltemplate.template.Template;

import java.util.List;

public interface Executor {

  String execute(Template template, List<Rule> rules);

}
