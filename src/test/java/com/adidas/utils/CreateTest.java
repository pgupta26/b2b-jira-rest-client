package com.adidas.utils;

import com.adidas.config.Configuration;
import com.adidas.json.paths.JiraPaths;
import com.adidas.json.payloads.JiraPayloads;
import com.adidas.serenity.steps.JiraSteps;

import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;


public class CreateTest {

  //  Launch url - https://allow-me-jira.tools.3stripes.net/ before running this class
  public static void main (String[] args) {

    JiraSteps jiraSteps = new JiraSteps();
    
    int totalTests = Integer.parseInt(args[0]);

    List<String> testKeys = new ArrayList<String>();

    for (int i = 1; i <= totalTests; i++) {

      Response response = jiraSteps.crateTestIssue(
          JiraPayloads.CREATE_TEST_ISSUE,
          Configuration.JIRA_PROJECT,
          Configuration.JIRA_TEST_PLAN
      );
      
      testKeys.add(response.jsonPath().getString(JiraPaths.TEST_KEY));

    }

    System.out.println(testKeys);
  }
}
