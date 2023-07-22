import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.stream.Stream; 
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;
import static org.junit.jupiter.params.provider.Arguments.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {	testDemo = new TestDemo();	}

	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException)	{	assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);	}
		else					{	assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);	} }
	
	static Stream<Arguments> argumentsForAddPositive()	{
		// @ formatter:off
		return Stream.of(
				arguments(2,4,6,false),
				arguments(5,10,15,false),
				arguments(10,20,30,false),
				arguments(1,2,5,false),		//  detect a method fail
				arguments(1,3,6,false),		//  detect a method fail
				arguments(1,-3,-2,true)		//  detect an IllegalArgumentException
				);
		// @formatter:on
	}
	
	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForDivisibleBy")
	void assertThatOneNumberIsDivisibleByAnother(int a, int b, boolean divisibleTrueOrFalse)	{
		assertThat(testDemo.divisibleBy(a, b)).isEqualTo(divisibleTrueOrFalse);						}

	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly()	{
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);	}

	static Stream<Arguments> argumentsForDivisibleBy()	{
		return Stream.of(arguments(4,2,true), arguments(10,5,true), arguments(100,7,false));		}

	@Test
	void assertThatNumberSquaredIsCorrect()	{
		TestDemo testDemoMock = spy(testDemo);
		doReturn(5).when(testDemoMock).getRandomInt();
		int fiveSquared = testDemoMock.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}







}
