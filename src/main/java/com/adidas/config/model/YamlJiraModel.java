package com.adidas.config.model;


import lombok.Data;

@Data
public class YamlJiraModel {

  private String uri;

  private String auth;

  private String project;

  private String testPlan;

  private String testExecutionSummary;

}
