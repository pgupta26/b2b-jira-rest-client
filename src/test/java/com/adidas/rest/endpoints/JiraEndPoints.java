package com.adidas.rest.endpoints;


public final class JiraEndPoints {

  public static final String CREATE_ISSUE = "/rest/api/2/issue";

  public static final String UPDATE_ISSUE = "/rest/api/2/issue/{issueId}";

  public static final String IMPORT_TEST_RESULTS = "/rest/raven/1.0/import/execution";

  public static final String LINK_TEST_TO_TEST_EXECUTION = "/rest/raven/1.0/api/testexec/{executionId}/test";

  public static final String GET_TEST_RUN_ID = "/rest/raven/1.0/api/testrun?testExecIssueKey={executionId}&testIssueKey={testId}";

  public static final String UPDATE_TEST_STATUS = "/rest/raven/1.0/api/testrun/{testRunId}/status?status={testStatus}";

  private JiraEndPoints () {

  }
}
