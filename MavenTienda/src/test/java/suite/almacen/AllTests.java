package suite.almacen;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import tests.almacen.*;

@Suite
@SelectClasses({ Test_Personas.class, Test_Productos.class })
public class AllTests {

}
