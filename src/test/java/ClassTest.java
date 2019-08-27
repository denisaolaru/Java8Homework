import org.junit.AfterClass;
import org.junit.BeforeClass;

public class ClassTest {
    @BeforeClass
    public static void beforeClass () {
        System.out.println ( "Before Class" );
    }

    @AfterClass
    public static void afterClass () {
        System.out.println ( "after class" );
    }

}
