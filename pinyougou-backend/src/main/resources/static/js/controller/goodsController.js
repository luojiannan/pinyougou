 //控制层 
app.controller('goodsController' ,function($scope,$controller   ,goodsService, itemCatService, typeTemplateService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		goodsService.findAll().success(
			function(response){
				$scope.list=response.data;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		goodsService.findPage(page,rows).success(
			function(response){
				$scope.list=response.data;	
				$scope.paginationConf.totalItems=response.totalCount;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		goodsService.findOne(id).success(
			function(response){
				$scope.entity= response.result;					
			}
		);				
	}
	
	//增加商品
	$scope.add=function(){
		$scope.entity.goodsDesc.introduction = editor.html();

		goodsService.add( $scope.entity  ).success(
			function(response){
				if(response.code == "00"){
					alert("增加成功")
					$scope.entity={};
					//清空富文本编辑器
					editor.html("");
				}else {
					alert(response.message)
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		goodsService.dele( $scope.selectedIds ).success(
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
		goodsService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.data;	
				$scope.paginationConf.totalItems=response.totalCount;//更新总记录数
			}			
		);
	}

	$scope.selectItemCat1List=function() {
		itemCatService.findByParentId(0).success(
			function (response) {
				$scope.itemCat1List = response.data;
			}
		)
	}

	$scope.$watch('entity.goods.category1Id', function(newValue, oldValue){
		itemCatService.findByParentId(newValue).success(
			function (response) {
				$scope.itemCat2List = response.data;
			}
		)
	})

	$scope.$watch('entity.goods.category2Id', function(newValue, oldValue){
		itemCatService.findByParentId(newValue).success(
			function (response) {
				$scope.itemCat3List = response.data;
			}
		)
	})

	//读取模板id
	$scope.$watch('entity.goods.category3Id', function(newValue, oldValue){
		itemCatService.findOne(newValue).success(
			function(response){
				$scope.entity.goods.typeTemplateId = response.result.typeId;
			}
		)
	})

	//读取品牌列表
	$scope.$watch('entity.goods.typeTemplateId', function(newValue, oldValue){
		typeTemplateService.findOne(newValue).success(
			function(response){
				$scope.typeTemplate = response.result;
				//列表类型转换
				$scope.typeTemplate.brandIds = JSON.parse($scope.typeTemplate.brandIds)
				//扩展属性
				console.log($scope.entity)
				$scope.entity.goodsDesc.customAttributeItems = JSON.parse($scope.typeTemplate.customAttributeItems)
			}
		)
	})
    
});	
