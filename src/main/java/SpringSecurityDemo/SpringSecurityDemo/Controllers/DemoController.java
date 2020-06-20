package SpringSecurityDemo.SpringSecurityDemo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController
{
  @GetMapping("/student")
  public String getStudent()
  {
    return "Hello Student";
  }

  @GetMapping("/admin")
  public String getAdmin()
  {
    return "Hello Admin";
  }

  @GetMapping("/visitor")
  public String getVisitor()
  {
    return "Hello Visitor";
  }

}
