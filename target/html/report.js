$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Google Search.feature");
formatter.feature({
  "name": "Google Search feature",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.scenarioOutline({
  "name": "To test google search functionality",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User is on \u003csearchEngine\u003e home page",
  "keyword": "Given "
});
formatter.step({
  "name": "User perform search with \u003csearchKey\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "User see all the valid search results",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "searchKey",
        "searchEngine"
      ]
    },
    {
      "cells": [
        "\"java\"",
        "\"bing\""
      ]
    },
    {
      "cells": [
        "\"java\"",
        "\"google\""
      ]
    }
  ]
});
formatter.scenario({
  "name": "To test google search functionality",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on \"bing\" home page",
  "keyword": "Given "
});
formatter.match({
  "location": "GoogleSearchStepDef.user_is_on_home_page(String)"
});
formatter.write("User is on Google home page");
formatter.write("User is on bing page");
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User perform search with \"java\"",
  "keyword": "When "
});
formatter.match({
  "location": "GoogleSearchStepDef.user_perform_search_with(String)"
});
formatter.write("User click search button");
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User see all the valid search results",
  "keyword": "Then "
});
formatter.match({
  "location": "GoogleSearchStepDef.user_see_all_the_valid_search_results()"
});
formatter.write("User is on google search results page");
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "To test google search functionality",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on \"google\" home page",
  "keyword": "Given "
});
formatter.match({
  "location": "GoogleSearchStepDef.user_is_on_home_page(String)"
});
formatter.write("User is on Google home page");
formatter.write("User is on google page");
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User perform search with \"java\"",
  "keyword": "When "
});
formatter.match({
  "location": "GoogleSearchStepDef.user_perform_search_with(String)"
});
formatter.write("User click search button");
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User see all the valid search results",
  "keyword": "Then "
});
formatter.match({
  "location": "GoogleSearchStepDef.user_see_all_the_valid_search_results()"
});
formatter.write("User is on google search results page");
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});