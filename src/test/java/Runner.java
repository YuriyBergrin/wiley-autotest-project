import apitests.ApiTestWiley;
import apitests.HttpbinImageTest;
import apitests.HttpbinTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import uitests.UiTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ApiTestWiley.class, HttpbinTest.class, HttpbinImageTest.class, UiTest.class} )
public class Runner {
/**
 * just run runner
 */
}//add something in master