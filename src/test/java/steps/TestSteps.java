package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TestSteps {
    private String result;

    @When("I hit test function")
    public void iHitTestFunction() {
        result = "okay";
    }

    @Then("I should get {string}")
    public void iShouldGet(String arg) {
        Assert.assertEquals(arg, result);
    }
}
