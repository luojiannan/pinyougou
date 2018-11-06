var app=angular.module("myApp",[]);
app.controller("myCon",function ($scope,$http) {
    $http.get("/order/getUser").then(function (response) {

        $scope.list=response
    })
})
