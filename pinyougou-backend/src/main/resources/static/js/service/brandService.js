//品牌服务
app.service("brandService",function($http){
    this.findAll = function() {
        return $http.get('http://localhost:8080/backend/brand/getBrand');
    }

    this.getBrandList = function(page,size,searchEntity) {
        return $http.post('http://localhost:8080/backend/brand/getBrandList?page=' + page + "&size=" + size,searchEntity);
    }

    this.findById = function(id) {
        return $http.get('http://localhost:8080/backend/brand/findById?id=' + id);
    }

    this.createBrand = function(entity) {
        return $http.post('http://localhost:8080/backend/brand/createBrand', entity)
    }

    this.updateBrand = function(entity) {
        return $http.post('http://localhost:8080/backend/brand/updateBrand', entity)
    }

    this.deleteByIds = function(ids) {
        return $http.get('http://localhost:8080/backend/brand/batchDelete?ids=' + ids);
    }


});