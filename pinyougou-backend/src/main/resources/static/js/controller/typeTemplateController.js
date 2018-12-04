 //控制层 
app.controller('typeTemplateController' ,function($scope,$controller   ,typeTemplateService, brandService, specificationService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		typeTemplateService.findAll().success(
			function(response){
				$scope.list=response.data;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		typeTemplateService.findPage(page,rows).success(
			function(response){
				$scope.list=response.data;	
				$scope.paginationConf.totalItems=response.totalCount;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		typeTemplateService.findOne(id).success(
			function(response){
				$scope.entity= response.result;
				$scope.entity.brandIds = JSON.parse($scope.entity.brandIds)
				$scope.entity.customAttributeItems = JSON.parse($scope.entity.customAttributeItems)
				$scope.entity.specIds = JSON.parse($scope.entity.specIds)
			}
		);				
	}
	
	//保存 
	$scope.save=function(){
		var serviceObject;//服务层对象
		$scope.entity.brandIds = JSON.stringify($scope.entity.brandIds)
		$scope.entity.customAttributeItems = JSON.stringify($scope.entity.customAttributeItems)
		$scope.entity.specIds = JSON.stringify($scope.entity.specIds)
		if($scope.entity.id!=null){//如果有ID
			serviceObject=typeTemplateService.update( $scope.entity ); //修改
		}else{
			serviceObject=typeTemplateService.add( $scope.entity  );//增加
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
		var ids = $scope.selectedIds;
		console.log(ids);
		if (ids.length == 0) {
			alert("请选择要删除的模板")
			return;
		}
		//获取选中的复选框			
		typeTemplateService.dele( ids ).success(
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
		typeTemplateService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.data;	
				$scope.paginationConf.totalItems=response.totalCount;//更新总记录数
			}			
		);
	}

	//品牌列表
	$scope.brandList = {data:[]}
	//读取品牌列表
	$scope.findOptionList=function() {
		brandService.selectOptionList().success(
			function (response) {
				$scope.brandList = {data:response.data}
			}
		)
	}

	$scope.specificationList = {data:[]}
	//读取规格列表
	$scope.findSpecificationList = function(){
		specificationService.selectOptionList().success(
			function(response) {
				$scope.specificationList = {data:response.data}
			}
		)
	}
	//增加扩展属性
	$scope.addTableRow=function() {
		$scope.entity.customAttributeItems.push({})
	}
	//删除扩展属性
	$scope.deleteTableRow=function(index) {
		$scope.entity.customAttributeItems.splice(index,1)
	}
    
});	
