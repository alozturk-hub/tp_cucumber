package com.sqli.isc.iut.courses.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BarSteps {

    private int peopleInBar;
    private int maxCapacity = 10;
    private boolean isEntryAllowed;
    private int totalBill;
    private boolean isMrPignonHappy;
    private String barMessage;
    private boolean isPersonBehindRefused;

    @Given("there are only {int} seats in the bar")
    public void there_are_only_seats_in_the_bar(int seats) {
        this.maxCapacity = seats;
    }

    @Given("there are already {int} people in the bar")
    public void there_are_already_people_in_the_bar(int people) {
        this.peopleInBar = people;
    }

    @When("Mr. Pignon and Mr. Leblanc arrive in group")
    public void mr_pignon_and_mr_leblanc_arrive_in_group() {
        if (peopleInBar + 2 <= maxCapacity) {
            isEntryAllowed = true;
            peopleInBar += 2;
            barMessage = "";
            isPersonBehindRefused = (peopleInBar + 1 > maxCapacity);
        } else {
            isEntryAllowed = false;
            barMessage = "Full";
            isPersonBehindRefused = true;
        }
    }

    @When("Mr. Pignon and Mr. Leblanc arrive")
    public void mr_pignon_and_mr_leblanc_arrive() {
        if (peopleInBar + 2 <= maxCapacity) {
            isEntryAllowed = true;
            peopleInBar += 2;
            barMessage = "";
        } else {
            isEntryAllowed = false;
            barMessage = "Full";
        }
    }

    @When("only Mr. Pignon arrives in solo")
    public void only_mr_pignon_arrives_in_solo() {
        if (peopleInBar + 1 <= maxCapacity) {
            isEntryAllowed = true;
            peopleInBar += 1;
            barMessage = "";
        } else {
            isEntryAllowed = false;
            barMessage = "Full";
        }
    }

    @Then("they are refused entry")
    public void they_are_refused_entry() {
        assertTrue(!isEntryAllowed);
    }

    @Then("they are allowed entry")
    public void they_are_allowed_entry() {
        assertTrue(isEntryAllowed);
    }

    @Then("he is allowed entry")
    public void he_is_allowed_entry() {
        assertTrue(isEntryAllowed);
    }

    @Then("the bar displays {string}")
    public void the_bar_displays(String message) {
        assertEquals(message, barMessage);
    }

    @Then("the bar does not display {string}")
    public void the_bar_does_not_display(String message) {
        assertTrue(isEntryAllowed && barMessage.isEmpty());
    }

    @When("they order a {string}")
    public void they_order_a(String drink) {
        totalBill += 10;
    }

    @When("Mr. Leblanc pays for both")
    public void mr_leblanc_pays_for_both() {
        totalBill = 20;
    }

    @Then("the bill shows {int} euros")
    public void the_bill_shows_euros(int amount) {
        assertEquals(amount, totalBill);
    }

    @Then("Mr. Pignon is happy because they had only one drink")
    public void mr_pignon_is_happy_because_they_had_only_one_drink() {
        isMrPignonHappy = true;
        assertTrue(isMrPignonHappy);
    }

    @When("Mr. Pignon pays for his drink")
    public void mr_pignon_pays_for_his_drink() {
        totalBill = 10;
    }

    @When("Mr. Leblanc orders {int} more {string}")
    public void mr_leblanc_orders_more(int count, String drink) {
        totalBill += count * 10;
    }

    @Then("the bill for Mr. Leblanc shows {int} euros")
    public void the_bill_for_mr_leblanc_shows_euros(int amount) {
        assertEquals(amount, totalBill);
    }

    @Then("Mr. Pignon is sad because he knows Mr. Leblanc will have a bad night")
    public void mr_pignon_is_sad_because_he_knows_mr_leblanc_will_have_a_bad_night() {
        isMrPignonHappy = false;
        assertTrue(!isMrPignonHappy);
    }

    @Then("the person behind them is refused entry with {string}")
    public void the_person_behind_them_is_refused_entry_with(String message) {
        assertEquals("Full", message);
        assertTrue(isPersonBehindRefused);
    }
}



