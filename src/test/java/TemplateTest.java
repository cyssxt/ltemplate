import com.cyssxt.ltemplate.core.DefaultExecutor;
import com.cyssxt.ltemplate.rule.IfRule;
import com.cyssxt.ltemplate.rule.Rule;
import com.cyssxt.ltemplate.template.DefaultTemplate;
import com.cyssxt.ltemplate.template.Template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemplateTest {

  public static void main(String[] args) {
    //
    Map<String,Object> params = new HashMap<>();
    params.put("bbb","1");
    Template template = new DefaultTemplate("select * from aaa where {if bbb} 1=1 {/if}",params);
    List<Rule> rules = new ArrayList<>();
    rules.add(new IfRule());
    new DefaultExecutor().execute(template,rules);
  }
}
