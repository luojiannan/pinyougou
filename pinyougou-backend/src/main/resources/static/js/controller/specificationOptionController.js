 //控制层 
app.controller('specificationOptionController' ,function($scope,$controller   ,specificationOptionService){	
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		specificationOptionService.findAll().success(
			function(response){
				$scope.list=response.data;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		specificationOptionService.findPage(page,rows).success(
			function(response){
				$scope.list=response.data;	
				$scope.paginationConf.totalItems=response.totalCount;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		specificationOptionService.findOne(id).success(
			function(response){
				$scope.entity= response.result;					
			}
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=specificationOptionService.update( $scope.entity ); //修改  
		}else{
			serviceObject=specificationOptionService.add( $scope.entity  );//增加 
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
	$scope.dele=function(){			
		//获取选中的复选框			
		specificationOptionService.dele( $scope.selectedIds ).success(
			function(response){
				if(response.code == "00"){
					$scope.reloadList();//刷新列表
					$scope.selectedIds=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		specificationOptionService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.data;	
				$scope.paginationConf.totalItems=response.totalCount;//更新总记录数
			}			
		);
	}
    
});	
