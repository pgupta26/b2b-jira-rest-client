package com.adidas.config;


import com.adidas.config.model.YamlJiraModel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
public class Configuration {

  public static final String JIRA_BASE_URI;

  public static final String JIRA_AUTH;

  public static final String JIRA_PROJECT;

  public static final String JIRA_TEST_PLAN;

  public static final String JIRA_TEST_EXECUTION_SUMMARY;


  static {

    YamlJiraModel configurations = loadConfigFile();

    JIRA_BASE_URI = configurations.getUri();

    JIRA_AUTH = configurations.getAuth();

    JIRA_PROJECT = configurations.getProject();

    JIRA_TEST_PLAN = configurations.getTestPlan();

    JIRA_TEST_EXECUTION_SUMMARY=configurations.getTestExecutionSummary();

  }

  @SneakyThrows
  private static YamlJiraModel loadConfigFile () {

    InputStream inputStream = Files.newInputStream(Paths.get(
        "src",
        "main",
        "resources",
        "configuration.yaml"
    ));
    return new Yaml().loadAs(inputStream, YamlJiraModel.class);
  }


  private Configuration () {

  }
}
