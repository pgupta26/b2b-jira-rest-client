package com.adidas.serenity.steps;


import com.adidas.config.Configuration;
import com.adidas.json.paths.JiraPaths;
import com.adidas.json.payloads.JiraPayloads;
import com.adidas.runner.World;
import com.adidas.serenity.steps.JiraSteps;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Hooks {

  @Steps
  JiraSteps jiraSteps;

  private static int lineNumber = 0;

  private static List<String> statuses = new ArrayList<>();

  private String finalTestStatus;

  private static String previousTestId;

  private String testExecutionId;

  private String storyId;

  private String testId;

  private String testName;

  private List<Integer> lineNumbers = new ArrayList<>();


  @Before(order = 0)
  public void createTestExecutionAndLinkTestWithUserStory (Scenario scenario) {

    if (World.getFlag()) {

      Response response = jiraSteps.crateTestExecutionIssue(
          JiraPayloads.CREATE_TEST_EXECUTION_ISSUE,
          Configuration.JIRA_PROJECT,
          Configuration.JIRA_TEST_EXECUTION_SUMMARY,
          Configuration.JIRA_TEST_PLAN
      );

      testExecutionId = response.jsonPath().getString(JiraPaths.TEST_KEY);

      World.setFlag(false);
    }


    this.extractStoryIDTestIDAndTestName(scenario);
    jiraSteps.updateAndLinkTestWithUserStory(testId, JiraPayloads.UPDATE_TEST_ISSUE,
                                             testName,
                                             storyId
    );

  }


  private void extractStoryIDTestIDAndTestName (Scenario sc) {

    Collection<String> tags = sc.getSourceTagNames();

    storyId = tags.stream().filter(x -> x.contains("@story")).findFirst().orElse(null);
    storyId = storyId.split(":")[1];


    testId = tags.stream().filter(x -> x.contains("@test")).findFirst().orElse(null);
    testId = testId.split(":")[1];

    testName = sc.getName().trim();

  }


  public void importTestResults (String testId, String status) {

    Response response = jiraSteps.ImportTestResults(
        JiraPayloads.IMPORT_TEST_RESULTS,
        testExecutionId,
        testId,
        status
    );
  }

  public void importPreviousTestResultsAndSetCurrentLineNumber(int currentLineNumber) {

    if (statuses.size() > 0) {
      finalTestStatus = statuses.stream().anyMatch(x -> x.contains("FAILED"))
          ? "FAIL"
          : "PASS";
      this.importTestResults(previousTestId, finalTestStatus);
    }

    statuses.clear();
    lineNumber = lineNumbers.get(currentLineNumber);
    previousTestId = testId;

  }



  @After(order = 0)
  public void updateTestStatus (Scenario scenario) {

    lineNumbers = scenario.getLines();

    if (lineNumbers.size() == 2) {

      if (World.getFlag()) {
        previousTestId = testId;
        lineNumber = lineNumbers.get(1);
        World.setFlag(false);
      }

      if (lineNumbers.get(1) == lineNumber) {

        statuses.add(scenario.getStatus().toString());
      } else {

        /*if (statuses.size() > 0) {
          finalTestStatus = statuses.stream().anyMatch(x -> x.contains("FAILED"))
              ? "FAIL"
              : "PASS";
          this.importTestResults(previousTestId, finalTestStatus);
        }

        statuses.clear();
        lineNumber = lineNumbers.get(1);
        previousTestId = testId;*/

        importPreviousTestResultsAndSetCurrentLineNumber(lineNumbers.get(1));
        statuses.add(scenario.getStatus().toString());
      }
    } else {

     /* if (statuses.size() > 0) {
        finalTestStatus = statuses.stream().anyMatch(x -> x.contains("FAILED"))
            ? "FAIL"
            : "PASS";
        this.importTestResults(previousTestId, finalTestStatus);
      }

      statuses.clear();
      lineNumber = lineNumbers.get(0);
      previousTestId = testId;*/

      importPreviousTestResultsAndSetCurrentLineNumber(lineNumbers.get(0));
      finalTestStatus = scenario.isFailed() ? "FAIL" : "PASS";

      this.importTestResults(testId, finalTestStatus);
    }

    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run () {

        importPreviousTestResultsAndSetCurrentLineNumber(lineNumbers.get(0));

        /*if (statuses.size() > 0) {

          finalTestStatus = statuses.stream().anyMatch(x -> x.contains("FAILED"))
              ? "FAIL"
              : "PASS";

          Response response = jiraSteps.ImportTestResults(
              JiraPayloads.IMPORT_TEST_RESULTS,
              testExecutionId,
              previousTestId,
              finalTestStatus
          );
        }*/
      }
    });

  }
}