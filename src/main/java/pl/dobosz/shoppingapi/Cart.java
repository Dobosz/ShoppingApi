package pl.dobosz.shoppingapi;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import pl.dobosz.shoppingapi.models.Foo;

@Api(
  name = "cart",
  version = "v1"
)
public class Cart {

  @ApiMethod(name = "foo", httpMethod = "GET")
  public Foo foo() {
    return new Foo();
  }

}
