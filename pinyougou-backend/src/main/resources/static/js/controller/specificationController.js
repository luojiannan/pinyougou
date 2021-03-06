 //控制层 
app.controller('specificationController' ,function($scope,$controller   ,specificationService){	
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		specificationService.findAll().success(
			function(response){
				$scope.list=response.data;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		specificationService.findPage(page,rows).success(
			function(response){
				$scope.list=response.data;	
				$scope.paginationConf.totalItems=response.totalCount;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		specificationService.findOne(id).success(
			function(response){
				$scope.entity= response.result;					
			}
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.specification.id!=null){//如果有ID
			serviceObject=specificationService.update( $scope.entity ); //修改  
		}else{
			serviceObject=specificationService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.code == "00"){
					//重新查询 
		        	$scope.reloadList();//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.batchDelete=function(){
		var ids = $scope.selectedIds;
		console.log(ids);
		if (ids.length == 0) {
			alert("请选择要删除的规格")
			return;
		}
		//获取选中的复选框
		specificationService.delete(ids).success(
			function(response){
				if(response.code == "00"){
					$scope.reloadList();//刷新列表
					$scope.selectedIds=[];
				} else {
					alert(response.message)
				}
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){
		specificationService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.data;
				$scope.paginationConf.totalItems=response.totalCount;//更新总记录数
			}			
		);
	}

	// $scope.entity = {specificationOptionList:[]};
	$scope.addTableRow = function() {
		$scope.entity.specificationOptionList.push({})
	}

	$scope.deleteTableRow = function(index) {
		$scope.entity.specificationOptionList.splice(index, 1);
	}
    
});	
