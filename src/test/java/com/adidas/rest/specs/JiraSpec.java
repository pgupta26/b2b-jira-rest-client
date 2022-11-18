package com.adidas.rest.specs;


import com.adidas.config.Configuration;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static net.serenitybdd.rest.SerenityRest.rest;


public final class JiraSpec {

  private JiraSpec () {

  }

  public static RequestSpecification jiraSpec () {

    return rest()
        .baseUri(Configuration.JIRA_BASE_URI)
        .given()
        .header("Authorization", "Basic " + Configuration.JIRA_AUTH)
        .contentType(ContentType.JSON)
        .when();

  }
}
