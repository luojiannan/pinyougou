app.controller('baseController',function($scope){
    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 15,
        perPageOptions:[10, 20, 30, 40, 50],
        onChange:function(){
            $scope.reloadList();
        }
    };
    //刷新列表
    $scope.reloadList = function(){
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage)
    };

    //复选框
    $scope.selectedIds = [];
    $scope.updateSelection = function($event, id) {
        if ($event.target.checked) {
            $scope.selectedIds.push(id);
        } else {
            var index = $scope.selectedIds.indexOf(id);
            //index要移除的元素下表，1要移除的元素个数
            $scope.selectedIds.splice(index,1);
        }
    }
});