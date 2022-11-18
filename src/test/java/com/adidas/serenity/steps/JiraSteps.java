package com.adidas.serenity.steps;

import com.adidas.rest.endpoints.JiraEndPoints;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static com.adidas.rest.specs.JiraSpec.*;

@Slf4j
public class JiraSteps {

  public Response crateTestIssue (String payloadTemplate, Object... payloadValues) {

    String payload = String.format(payloadTemplate, payloadValues);
    Response response = jiraSpec()
        .log()
        .all()
        .body(payload)
        .post(JiraEndPoints.CREATE_ISSUE)
        .then()
        .log()
        .all()
        .and()
        .extract()
        .response();

    return response;
  }


  public Response crateTestExecutionIssue (String payloadTemplate, Object... payloadValues) {

    String payload = String.format(payloadTemplate, payloadValues);
    Response response = jiraSpec()
        .log()
        .all()
        .body(payload)
        .post(JiraEndPoints.CREATE_ISSUE)
        .then()
        .log()
        .all()
        .and()
        .extract()
        .response();

    return response;
  }


  public Response updateAndLinkTestWithUserStory (String testId, String payloadTemplate, Object... payloadValues) {

    String payload = String.format(payloadTemplate, payloadValues);
    Response response = jiraSpec()
        .log()
        .all()
        .body(payload)
        .put(JiraEndPoints.UPDATE_ISSUE, testId)
        .then()
        .log()
        .all()
        .and()
        .extract()
        .response();

    return response;
  }


  public Response ImportTestResults (String payloadTemplate, Object... payloadValues) {

    String payload = String.format(payloadTemplate, payloadValues);
    Response response = jiraSpec()
        .log()
        .all()
        .body(payload)
        .post(JiraEndPoints.IMPORT_TEST_RESULTS)
        .then()
        .log()
        .all()
        .and()
        .extract()
        .response();

    return response;
  }


}
