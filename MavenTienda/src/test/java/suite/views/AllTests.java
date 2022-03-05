package suite.views;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import tests.views.*;

@Suite
@SelectClasses({Test_CestaView.class, Test_LoginView.class, Test_RegisterView.class, Test_TiendaView.class})
public class AllTests {

}
