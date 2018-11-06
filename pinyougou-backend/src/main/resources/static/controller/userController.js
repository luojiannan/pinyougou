//建立模块
var app=angular.module("myApp",[]);
//创建控制器 $scope就是控制层与视图层之间交换数据的桥梁
app.controller("myCon",function ($scope,$http) {
    $http.get("/order/getUser").then(function (response) {

        $scope.list=response.data
    })
})
