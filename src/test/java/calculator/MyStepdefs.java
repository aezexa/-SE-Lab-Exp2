package calculator;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyStepdefs {

    private Calculator calculator;
    private int value1;
    private int value2;
    private String op;
    private int result;
    private String result2;

    @Before
    public void before() {
        calculator = new Calculator ( );
    }

    @Given ( "^Two input values, (-?\\d+) and (-?\\d+)$" )
    public void twoInputValuesAnd(int arg0, int arg1) {
        value1 = arg0;
        value2 = arg1;
    }

    @When ( "^I add the two values$" )
    public void iAddTheTwoValues() {
        result = calculator.add(value1, value2);
        System.out.print(result);

    }

    @Then ( "^I expect the result (-?\\d+)$" )
    public void iExpectTheResult(int arg0) {
        Assert.assertEquals(arg0, result);
    }

    @Given("^Two input values, (-?\\d+) and (rvs|sqr)$")
    public void twoInputValuesAndRvs ( int arg0, String operation ) {
        value1 = arg0;
        op = operation;
    }

    @When("^I calculate the given operation$")
    public void iCalculateTheGivenOperation () {
        try {
            if (op.matches ( "rvs" )) {
                result2 = String.valueOf ( calculator.rvs ( value1 ) );
            } else if (op.matches ( "sqr" )) {
                result2 = String.valueOf ( calculator.sqr ( value1 ) );
            }
        } catch (Exception e) {
            result2 = e.getMessage();
        }

        System.out.print ( result2 );
    }

    @Then("^I expect the new result (-?\\d+(?:\\.\\d+)?|Bad Input!)$")
    public void iExpectTheNewResult ( String arg0 ) {
        if (arg0.matches ( "Bad Input!" )) {
            Assert.assertEquals ( arg0, result2 );
        } else {
            Assert.assertEquals ( Double.parseDouble ( arg0 ) , Double.parseDouble ( result2 ), 0.0001 );
        }
    }

}
