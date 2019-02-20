app.controller('cartController',function($scope, cartService){

    $scope.submitOrder=function() {
        cartService.submitOrder($scope.order).success(
            function(response) {
                if (response.code == '00'){
                    $scope.order = response.result;
                    //微信支付
                    if ($scope.order.payment = "1") {
                        location.href="pay.html";
                    }else if ($scope.order.payment = "2") {
                        //支付宝

                    }
                } else {
                    alert(response.message)
                }
            }
        )
    }

    $scope.order={paymentType:"1"}
    //选择支付类型
    $scope.selectPaymentType=function(type) {
        $scope.order.paymentType=type;
    }
})