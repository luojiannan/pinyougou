app.service('contentService',function($http){
    this.findByCategoryId=function(categoryId){
        return $http.get('frontend/goods/findByCategoryId?categoryId='+categoryId);
    }
})