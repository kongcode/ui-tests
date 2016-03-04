angular.module("uiTests", ["ngRoute", "uiTests.testCase"])
  .config(function ($routeProvider) {
    $routeProvider.otherwise({ redirectTo: "/"})
  });
