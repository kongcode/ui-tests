angular.module("uiTests.testCase", ["ngRoute"])
  .config(function ($routeProvider) {
    $routeProvider.when("/", {
      templateUrl: "/app/testcase/browse.html",
      controller: "TestCaseBrowseController"
    })
  }).controller("TestCaseBrowseController", function ($scope) {
      $scope.headers = ["Name"];
      $scope.data = [];
  })
