app.controller('brandController',function($scope,$controller,brandService) {

    $controller('baseController',{$scope:$scope});

    //查询品牌列表
    $scope.findAll=function(){
        brandService.findAll().success(
            function(response) {
                $scope.list = response.data;
            }
        )
    }


    

    //分页
    $scope.searchEntity={};
    $scope.search = function(page,size) {
        brandService.getBrandList(page,size,$scope.searchEntity).success(
            function(response) {
                $scope.list = response.data;//显示当前页的数据
                $scope.paginationConf.totalItems = response.totalCount;
            }
        )
    };

    //新增
    $scope.save = function() {
        var object = null;
        if ($scope.entity.id != null) {
            object = brandService.updateBrand($scope.entity);
        }else {
            object = brandService.createBrand($scope.entity);
        }
        object.success(
            function(response) {
                if (response.code == "00") {
                    $scope.reloadList();
                } else {
                    alert(response.message)
                }
            }
        )
    };
    

    //删除
    $scope.batchDelete = function() {
        var ids = $scope.selectedIds;
        if (ids.length == 0) {
            alert("请选择要删除的品牌")
            return;
        }
        brandService.deleteByIds(ids).success(
            function(response) {
                if (response.code == "00") {
                    $scope.reloadList();
                    $scope.selectedIds=[];
                }else {
                    alert(response.message)
                }
            }
        )
    }

    $scope.findById = function(id) {
        brandService.findById(id).success(
            function(response) {
                if (response.code == "00") {
                    $scope.entity = response.result;
                }else {
                    alert(response.message)
                }
            }
        )
    };

})