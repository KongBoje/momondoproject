/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module("myApp", ["ngRoute"]);

app.factory("loginContainer", function() {
   var factory = {};
   
   var resultType = 0;
   var username = null;
   var id = null;
   var email = null;
   var realname = null;
   var phone = null;
   
   factory.setResultType = function(data) {
       resultType = data;
   };
   
   factory.setUsername = function(data) {
       username = data;
   };
   
   factory.setId = function(data) {
       id = data;
   };
   
   factory.setEmail = function(data) {
       email = data;
   },
   
   factory.setRealname = function(data) {
       realname = data;
   };
   
   factory.setPhone = function(data) {
       phone = data;
   };
   
   factory.getResultType = function() {
       return resultType;
   };
   
   factory.getUsername = function() {
       return username;
   };
   
   factory.getId = function() {
       return id;
   };
   
   factory.getEmail = function() {
       return email;
   };
   
   factory.getRealname = function() {
       return realname;
   };
   
   factory.getPhone = function() {
       return phone;
   };
   
   return factory;
});

app.factory("dataContainer", function () {
    var factory = {};

    var myresults = null;
    var flightnum = null;
    var flightid = null;
    var passengerQty = null;

    factory.setQty = function (data) {
        passengerQty = data;
    };

    factory.getQty = function () {
        return passengerQty;
    };

    factory.set = function (data) {
        myresults = data;
    };

    factory.setfn = function (data) {
        flightnum = data;
    };

    factory.getfn = function () {
        return flightnum;
    };

    factory.getfid = function () {
        return flightid;
    };

    factory.setfid = function (data) {
        flightid = data;
    };

    factory.get = function () {
        return myresults;
    };

    return factory;
});

app.config(function ($routeProvider) {
    $routeProvider.
            when("/search", {
                templateUrl: "search_refactor.html",
                controller: "searchCtrl"
            }).when("/results", {
        templateUrl: "results_refactor.html",
        controller: "searchCtrl"
    }).when("/reserve", {
        templateUrl: "reserveflight.html",
        controller: "searchCtrl"
    }).when("/login", {
        templateUrl: "login.html",
        controller: "loginCtrl"
    }).when("/userpage", {
        templateUrl: "userpage.html",
        controller: "searchCtrl"
    }).otherwise({
        redirectTo: "/search"
    });
});

app.controller("searchCtrl", ["$scope", "$http", "dataContainer", "loginContainer", "$location", function ($scope, $http, dataContainer, loginContainer, $location) {
        $scope.results = dataContainer.get();
        $scope.GOTRESPONSE = false;
        
        $scope.isLoggedIn = function() {
            if(loginContainer.getId() == null) {
                return false;
            } else {
                return true;
            }
        }
        
        function getUndefined() {
            return;
        }
        
        clearFields = function() {
            $scope.fromIATA = getUndefined();
            $scope.toIATA = getUndefined();
            $scope.startDate = getUndefined();
            $scope.passengerCount = getUndefined();
        };

        $scope.gotoReserve = function (fid, fn) {
            dataContainer.setfid(fid);
            dataContainer.setfn(fn);
            // alert("something");
        };



        $scope.doReserve = function () {
            var req = {
                flightID: dataContainer.getfid(),
                numberOfSeats: parseInt(dataContainer.getQty()),
                reserveeName: loginContainer.getRealname(),
                reservePhone: loginContainer.getPhone(),
                reserveeEmail: loginContainer.getEmail(),
                passengers: []
            };

            for (var i = 0; i != dataContainer.getQty(); i++) {
                var tmp = {"firstName": $scope.passengers[i].firstName, "lastName": $scope.passengers[i].lastName};
                req.passengers.push(tmp);
            }

            //console.log(req);

            $http({
                method: "POST",
                url: "api/wrapreservation/" + $scope.fid,
                data: req
            }).then(function success(response) {
                $scope.gotResponse = true;
                
                $scope.responseDate = response.data.date;
                $scope.responseDestination = response.data.destination;
                $scope.responseFlightNumber = response.data.flightNumber;
                $scope.responseFlightTime = response.data.flightTime;
                $scope.responseNumberOfSeats = response.data.numberOfSeats;
                $scope.responseOrigin = response.data.origin;
                $scope.responsePassengers = response.data.passengers;
                $scope.responseReserveeName = response.data.reserveeName;
                console.log(response.data);
            });
        };

        $scope.fn = dataContainer.getfn();
        $scope.fid = dataContainer.getfid();
        $scope.maxPassengers = dataContainer.getQty();
        
        $scope.USERREALNAME = loginContainer.getRealname();
        
        $scope.searchFunc = function () {


            if ($scope.fromIATA === undefined) {
                alert("Fill in a from airport");
                clearFields();
                return;
            }
            
            if ($scope.startDate === undefined) {
                alert("Fill in a date");
                clearFields();
                return;
            }
            
            
            $scope.onDate = $scope.startDate;
            var month = ($scope.onDate).substring(0,2);
            var day = ($scope.onDate).substring(3,5);
            var year = ($scope.onDate).substring(6,10);
            
            $scope.onDate = year + "-" + month + "-" + day;
            
            if ($scope.passengerCount === undefined) {
                alert("Fill in passenger count");
                clearFields();
                return;
            }

            var passengers = ($scope.passengerCount).substring(0, 1);
            dataContainer.setQty(passengers);

            if ($scope.toIATA === undefined) {
                //console.log("To was not set, so just get from");

                $http({
                    method: "GET",
                    url: "api/allflights/" + $scope.fromIATA + "/" + $scope.onDate + "T00:00:00.000Z" + "/" + passengers
                }).then(function callback(response) {

                    dataContainer.set(response.data);
                    $scope.results = dataContainer.get();
                    $location.path("/results");

                });

            } else {
                //console.log("To: " + $scope.toIATA);
                $http({
                    method: "GET",
                    url: "api/allflights/" + $scope.fromIATA + "/" + $scope.toIATA + "/" + $scope.onDate + "T00:00:00.000Z" + "/" + passengers
                }).then(function callback(response) {

                    dataContainer.set(response.data);
                    $scope.results = dataContainer.get();
                    $location.path("/results");

                });
            }


        };
    }]);

app.controller("loginCtrl", ["$scope", "$http", "loginContainer", function($scope, $http, loginContainer) {
    $scope.resultType = loginContainer.getResultType();
    
     $scope.loginButtonFunc = function() {
      
     var req = {username: $scope.loginFieldUsername, password: $scope.loginFieldPassword};
        
        $http({
            method: "POST",
            url: "api/login",
            data: req
        }).success(function (data) {
            console.log("It worked!");
            
            loginContainer.setUsername(req.username);
            loginContainer.setId(data.id);
            loginContainer.setEmail(data.email);
            loginContainer.setRealname(data.realname);
            loginContainer.setPhone(data.phone);
            
            console.log(data);
            console.log(loginContainer.getId());
            console.log(loginContainer);
            
            $scope.resultMsg = "Success: You logged in as " + loginContainer.getUsername() + " (" + loginContainer.getRealname() + ")";
        }).error(function(error, status) {
            if(status == 500) {
                console.log("User " + req.username + " doesn't exist");
                $scope.resultMsg = "The user doesnt exist";
            };
            if(status == 400) {
                console.log("User" + req.username + " isnt " + req.password);
                $scope.resultMsg = "The password is wrong";
            };
        });
    };
}]);

app.directive('datepicker', function() {
  return {
    link: function(scope, el, attr) {
      $(el).datepicker({
        onSelect: function(dateText) {
          console.log(dateText);
          var expression = attr.ngModel + " = " + "'" + dateText + "'";
          scope.$apply(expression);
          console.log(scope.startDate);
        }
      });
    }
  };
});



app.filter("niceIATA", function() {
    return function(x) {
        var tmp = x.toLowerCase();
        // js has no hshmap ..
        if(tmp == "cph") return "København";
        if(tmp == "sxf") return "Berlin";
        if(tmp == "stn") return "London";
        if(tmp == "cdg") return "Paris";
        if(tmp == "bcn") return "Barcelona";
        return x;
    };
});