package tdd.stringcaltest;

import org.junit.Test;

import junit.framework.Assert;
import tdd.stringcal.StringCalculator;

public class StringCalculatorTest {

//    @Test(expected = RuntimeException.class)
//    public final void ifMoreThan2NumbersThenThrowException() {
//        StringCalculator.add("3,4,5");
//    }
	@Test
	public final void ifTwoNumbersUsedThenNoException() {
		StringCalculator.add("2,4");
		Assert.assertTrue(true);
	}

	@Test(expected = RuntimeException.class)
	public final void ifNonNumericIsUsedThenThrowException() {
		StringCalculator.add("5,X");
	}

	@Test
	public final void ifEmptyStringThenReturn_0() {
		Assert.assertEquals(0, StringCalculator.add(""));
	}

	@Test
	public final void ifOnlyOneNumberThenReturnSameNumberValue() {
		Assert.assertEquals(5, StringCalculator.add("5"));
	}

	@Test
	public final void ifTwoNumbersReturnTheirSum() {
		Assert.assertEquals(5 + 10, StringCalculator.add("5,10"));
	}

	@Test
	public final void ifnAnyNumberOfNumbersThenReturnTheirSums() {
		Assert.assertEquals(4 + 6 + 16 + 20 + 28 + 47, StringCalculator.add("4,6,16,20,28,47"));
	}

	@Test
	public final void ifNewLineIsUsedBetweenNumbersThenReturnTheirSums() {
		Assert.assertEquals(5 + 10 + 15, StringCalculator.add("5,10n15"));
	}

	@Test
	public final void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
		Assert.assertEquals(5 + 10 + 15, StringCalculator.add("//;n5;10;15"));
	}

	@Test(expected = RuntimeException.class)
	public final void ifNegativeNumberThenThrowRuntimeException() {
		StringCalculator.add("5,-16,7,22,65,13");
	}

	@Test
	public final void ifNegativeNumbersThenThrowRuntimeException() {
		RuntimeException exception = null;
		try {
			StringCalculator.add("5,-16,7,-22,65,13");
		} catch (RuntimeException e) {
			exception = e;
		}
		Assert.assertNotNull(exception);
		Assert.assertEquals("Negative Numbers are not allowed: [-16, -22]", exception.getMessage());
	}

	@Test
	public final void ifNumbersAreGreaterThan1000ThenIgnoreInSum() {
		Assert.assertEquals(17 + 6 + 1000, StringCalculator.add("17,1024,1001,6,1165,1000"));
	}

	@Test
	public final void ifDelimiterLengthIsAnyLength() {
		Assert.assertEquals(5 + 10 + 15, StringCalculator.add("//;;;n5;;;10;;;15"));
	}

	@Test
	public final void whenMultipleDelimiterOfAnyLength() {
		Assert.assertEquals(5 + 10 + 15, StringCalculator.add("//;#:#,n5;10,15"));
	}

}
