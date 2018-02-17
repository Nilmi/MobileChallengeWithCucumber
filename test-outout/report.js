$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/com/straitstimes/mobiletest/features/Mobile.feature");
formatter.feature({
  "line": 1,
  "name": "Login and view latest article",
  "description": "",
  "id": "login-and-view-latest-article",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Login and view latest article",
  "description": "",
  "id": "login-and-view-latest-article;login-and-view-latest-article",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "user already launched straitstimes application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user open drawer menu",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "tap on LOGIN button",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "enter \"\u003cusername\u003e\" and \"\u003cpassword\u003e\" tap on continue button",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "verify user has logged in successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "tap on latest tab and tap on first article",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "verify that article loading sucessfully with image/video",
  "keyword": "Then "
});
formatter.examples({
  "comments": [
    {
      "line": 13,
      "value": "# username and password parameterized in Examples section"
    }
  ],
  "line": 14,
  "name": "",
  "description": "",
  "id": "login-and-view-latest-article;login-and-view-latest-article;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 15,
      "id": "login-and-view-latest-article;login-and-view-latest-article;;1"
    },
    {
      "cells": [
        "wijerathna.nilmi@gmail.com",
        "Test1234"
      ],
      "line": 16,
      "id": "login-and-view-latest-article;login-and-view-latest-article;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 13361013,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Login and view latest article",
  "description": "",
  "id": "login-and-view-latest-article;login-and-view-latest-article;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "user already launched straitstimes application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user open drawer menu",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "tap on LOGIN button",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "enter \"wijerathna.nilmi@gmail.com\" and \"Test1234\" tap on continue button",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "verify user has logged in successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "tap on latest tab and tap on first article",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "verify that article loading sucessfully with image/video",
  "keyword": "Then "
});
formatter.match({
  "location": "LatestArticleTest.user_already_launched_straitstimes_application()"
});
formatter.result({
  "duration": 9413904275,
  "status": "passed"
});
formatter.match({
  "location": "LatestArticleTest.user_open_drawer_menu()"
});
formatter.result({
  "duration": 14198291861,
  "status": "passed"
});
formatter.match({
  "location": "LatestArticleTest.tap_on_LOGIN_button()"
});
formatter.result({
  "duration": 1031673648,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "wijerathna.nilmi@gmail.com",
      "offset": 7
    },
    {
      "val": "Test1234",
      "offset": 40
    }
  ],
  "location": "LatestArticleTest.enter_and_tap_on_continue_button(String,String)"
});
formatter.result({
  "duration": 13084518935,
  "status": "passed"
});
formatter.match({
  "location": "LatestArticleTest.verify_user_has_logged_in_successfully()"
});
formatter.result({
  "duration": 5491113255,
  "status": "passed"
});
formatter.match({
  "location": "LatestArticleTest.tap_on_latest_tab_and_tap_on_first_article()"
});
formatter.result({
  "duration": 6271738322,
  "status": "passed"
});
formatter.match({
  "location": "LatestArticleTest.verify_that_article_loading_sucessfully_with_image_video()"
});
formatter.result({
  "duration": 4399297691,
  "status": "passed"
});
});