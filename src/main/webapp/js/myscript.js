/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var app = angular.module("myApp", ["ngRoute"]);

app.config(function ($routeProvider) {
    $routeProvider.
            when("/search", {
                templateUrl: "search_refactor.html"
            }).when("/results", {
        templateUrl: "results_refactor.html"
    }).otherwise({
        redirectTo: "/search"
    });
});