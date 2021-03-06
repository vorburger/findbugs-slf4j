package jp.skypencil.findbugs.slf4j;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

/**
 * A JUnit extension for SpotBugs plugin. It provides {@link SpotBugsRunner} instance as parameter
 * of test method.
 *
 * <p>Sample code:
 *
 * <pre>{@code
 * @ExtendWith(SpotBugsExtension.class)
 * public class GettingClassFromArrayTest {
 * @Test
 * public void test(SpotBugsRunner spotbugs) {
 * BugCollection bugs = spotbugs.performAnalysis(Paths.get("target/test-classes/pkg/GoodCase.class"));
 * ...
 * }
 * }
 * }</pre>
 */
public class SpotBugsExtension implements ParameterResolver {
  @Override
  public boolean supportsParameter(
      ParameterContext parameterContext, ExtensionContext extensionContext)
      throws ParameterResolutionException {
    return parameterContext.getParameter().getType().equals(SpotBugsRunner.class);
  }

  @Override
  public Object resolveParameter(
      ParameterContext parameterContext, ExtensionContext extensionContext)
      throws ParameterResolutionException {
    return new SpotBugsRunner();
  }
}
