app.service('cartService',function($http){
    this.submitOrder=function(order) {
        return $http.post('frontend/order/addOrder',order.paymentType)
    }
})