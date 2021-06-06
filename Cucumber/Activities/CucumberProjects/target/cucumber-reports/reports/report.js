$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Activity1_5.feature");
formatter.feature({
  "line": 2,
  "name": "Data driven test with Example",
  "description": "",
  "id": "data-driven-test-with-example",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@activity1_5"
    }
  ]
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Testing with Data from Scenario",
  "description": "",
  "id": "data-driven-test-with-example;testing-with-data-from-scenario",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "User is on Login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User enters \"\u003cUsernames\u003e\" and \"\u003cPasswords\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Read the page title and confirmation message",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Close the Browser",
  "keyword": "And "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "data-driven-test-with-example;testing-with-data-from-scenario;",
  "rows": [
    {
      "cells": [
        "Usernames",
        "Passwords"
      ],
      "line": 11,
      "id": "data-driven-test-with-example;testing-with-data-from-scenario;;1"
    },
    {
      "cells": [
        "admin",
        "password"
      ],
      "line": 12,
      "id": "data-driven-test-with-example;testing-with-data-from-scenario;;2"
    },
    {
      "cells": [
        "adminUser",
        "Password"
      ],
      "line": 13,
      "id": "data-driven-test-with-example;testing-with-data-from-scenario;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 12,
  "name": "Testing with Data from Scenario",
  "description": "",
  "id": "data-driven-test-with-example;testing-with-data-from-scenario;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@activity1_5"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User is on Login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User enters \"admin\" and \"password\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Read the page title and confirmation message",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Close the Browser",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTestSteps.userIsOnLoginPage()"
});
formatter.result({
  "duration": 19394937400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "admin",
      "offset": 13
    },
    {
      "val": "password",
      "offset": 25
    }
  ],
  "location": "LoginTestSteps.user_enters_and(String,String)"
});
formatter.result({
  "duration": 631041500,
  "status": "passed"
});
formatter.match({
  "location": "LoginTestSteps.readTitleAndHeading()"
});
formatter.result({
  "duration": 210510400,
  "status": "passed"
});
formatter.match({
  "location": "LoginTestSteps.closeBrowser()"
});
formatter.result({
  "duration": 2417482100,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Testing with Data from Scenario",
  "description": "",
  "id": "data-driven-test-with-example;testing-with-data-from-scenario;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@activity1_5"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User is on Login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User enters \"adminUser\" and \"Password\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Read the page title and confirmation message",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Close the Browser",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTestSteps.userIsOnLoginPage()"
});
formatter.result({
  "duration": 18856877800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "adminUser",
      "offset": 13
    },
    {
      "val": "Password",
      "offset": 29
    }
  ],
  "location": "LoginTestSteps.user_enters_and(String,String)"
});
formatter.result({
  "duration": 503224200,
  "status": "passed"
});
formatter.match({
  "location": "LoginTestSteps.readTitleAndHeading()"
});
formatter.result({
  "duration": 199443300,
  "error_message": "org.junit.ComparisonFailure: expected:\u003c[Invalid Credentials]\u003e but was:\u003c[Welcome Back, admin]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat stepDefinitions.LoginTestSteps.readTitleAndHeading(LoginTestSteps.java:62)\r\n\tat ✽.Then Read the page title and confirmation message(Activity1_5.feature:7)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "LoginTestSteps.closeBrowser()"
});
formatter.result({
  "status": "skipped"
});
});