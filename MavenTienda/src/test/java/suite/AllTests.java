package suite;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({suite.almacen.AllTests.class, suite.views.AllTests.class})
public class AllTests {

}
