package com.adidas.json.payloads;


public class JiraPayloads {

  public static final String CREATE_TEST_ISSUE = "{\n" +
      "    \"fields\": {\n" +
      "        \"assignee\": {\n" +
      "            \"name\": \"Parshant.Gupta@adidas.com\"\n" +
      "        },\n" +
      "        \"project\": {\n" +
      "            \"key\": \"%s\"\n" +
      "        },\n" +
      "        \"summary\": \"Temp Summary\",\n" +
      "        \"issuetype\": {\n" +
      "            \"name\": \"Test\"\n" +
      "        },\n" +
      "        \"customfield_11602\": [\n" +
      "            \"%s\"\n" +
      "        ]\n" +
      "    }\n" +
      "}";

  public static final String CREATE_TEST_EXECUTION_ISSUE = "{\n" +
      "    \"fields\": {\n" +
      "        \"assignee\": {\n" +
      "            \"name\": \"Parshant.Gupta@adidas.com\"\n" +
      "        },\n" +
      "        \"project\": {\n" +
      "            \"key\": \"%s\"\n" +
      "        },\n" +
      "        \"summary\": \"%s\",\n" +
      "        \"issuetype\": {\n" +
      "            \"name\": \"Test Execution\"\n" +
      "        },\n" +
      "        \"customfield_11407\": [\n" +
      "            \"%s\"\n" +
      "        ]\n" +
      "    }\n" +
      "}";

  public static final String UPDATE_TEST_ISSUE = "{\n" +
      "    \"fields\": {\n" +
      "        \"summary\": \"%s\"\n" +
      "    },\n" +
      "    \"update\": {\n" +
      "        \"issuelinks\": [\n" +
      "            {\n" +
      "                \"add\": {\n" +
      "                    \"type\": {\n" +
      "                        \"name\": \"Tests\",\n" +
      "                        \"inward\": \"Tests\",\n" +
      "                        \"outward\": \"Tests\"\n" +
      "                    },\n" +
      "                    \"outwardIssue\": {\n" +
      "                        \"key\": \"%s\"\n" +
      "                    }\n" +
      "                }\n" +
      "            }\n" +
      "        ]\n" +
      "    }\n" +
      "}";

  public static final String LINK_TEST_TO_TEST_EXECUTION = "{\n" +
      "    \"add\": [\n" +
      "        \"%s\"\n" +
      "    ]\n" +
      "}";


  public static final String IMPORT_TEST_RESULTS = "{\n" +
      "    \"testExecutionKey\": \"%s\",\n" +
      "    \"tests\": [\n" +
      "        {\n" +
      "            \"testKey\": \"%s\",\n" +
      "            \"status\": \"%s\"\n" +
      "        }\n" +
      "    ]\n" +
      "}";

}
