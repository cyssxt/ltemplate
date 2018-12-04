import com.cyssxt.ltemplate.core.DefaultExecutor;
import java.util.HashMap;
import java.util.Map;

public class TemplateTest {

  public static void main(String[] args) {
    //
    Map<String,Object> params = new HashMap<>();
    params.put("host","127.0.0.1");
    String value  = DefaultExecutor.execute("select host from connection  where 1=1 {if host} and host=:host{/if}",params);
    System.out.println(value);
  }
}
