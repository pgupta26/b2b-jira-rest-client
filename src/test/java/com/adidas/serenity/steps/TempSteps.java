package com.adidas.serenity.steps;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import cucumber.api.java.en.Given;


@Slf4j
public class TempSteps {


  @Given("^Username is (.*)$")
  public void setUserName (String userName) {

    System.out.println("Current User Name Is: "+userName);
  }

  @Given("^Test is failed$")
  public void setSalesOrgConfigs () {

    Assert.assertTrue(false);
  }

}



