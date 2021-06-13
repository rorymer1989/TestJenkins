$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 2,
  "name": "User Management",
  "description": "As a user\r\nI want to login",
  "id": "user-management",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@feature-guru-01"
    },
    {
      "line": 1,
      "name": "@login"
    }
  ]
});
formatter.before({
  "duration": 9135705900,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Login with correct password only",
  "description": "",
  "id": "user-management;login-with-correct-password-only",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@mc-0101"
    },
    {
      "line": 6,
      "name": "@regression"
    },
    {
      "line": 6,
      "name": "@sanity"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "I access to Login Function",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I login",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.goToLoginPage()"
});
formatter.result({
  "duration": 1282423100,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.login()"
});
formatter.result({
  "duration": 29700,
  "status": "passed"
});
formatter.after({
  "duration": 886451600,
  "status": "passed"
});
});