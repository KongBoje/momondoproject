/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module("myApp", ["ngRoute"]);

app.factory("dataContainer", function () {
    var factory = {};

    var myresults = null;

    factory.set = function (data) {
        myresults = data;
    }

    factory.get = function () {
        return myresults;
    }

    return factory;
})

app.config(function ($routeProvider) {
    $routeProvider.
            when("/search", {
                templateUrl: "search_refactor.html",
                controller: "searchCtrl"
            }).when("/results", {
        templateUrl: "results_refactor.html",
        controller: "searchCtrl"
    }).otherwise({
        redirectTo: "/search"
    });
});

app.controller("searchCtrl", ["$scope", "$http", "dataContainer", "$location", function ($scope, $http, dataContainer, $location) {
        $scope.results = dataContainer.get();
        $scope.searchFunc = function () {

            if ($scope.fromIATA === undefined) {
                alert("Fill in a from airpor");
                return;
            }
            if ($scope.onDate === undefined) {
                alert("Fill in a date");
                return;
            }
            if ($scope.passengerCount === undefined) {
                alert("Fill in passenger count");
                return;
            }
            var passengers = ($scope.passengerCount).substring(0, 1);
            if ($scope.toIATA === undefined) {
                //console.log("To was not set, so just get from");

                $http({
                    method: "GET",
                    url: "api/flights/" + $scope.fromIATA + "/" + $scope.onDate + "T00:00:00.000Z" + "/" + passengers
                }).then(function callback(response) {
                    dataContainer.set(response.data);
                    $scope.results = dataContainer.get();
                    $location.path("/results");
                });

            } else {
                //console.log("To: " + $scope.toIATA);
                $http({
                    method: "GET",
                    url: "api/flights/" + $scope.fromIATA + "/" + $scope.toIATA + "/" + $scope.onDate + "T00:00:00.000Z" + "/" + passengers
                }).then(function callback(response) {
                    dataContainer.set(response.data);
                    $scope.results = dataContainer.get();
                    $location.path("/results");
                });
            }


        };
    }]);