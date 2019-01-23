//服务层
app.service('sellerService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('http://localhost:8080/backend/seller/findAll');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('http://localhost:8080/backend/seller/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('http://localhost:8080/backend/seller/findOne?sellerId='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('http://localhost:8080/backend/seller/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('http://localhost:8080/backend/seller/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('http://localhost:8080/backend/seller/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('http://localhost:8080/backend/seller/search?page='+page+"&rows="+rows, searchEntity);
	}
	//修改状态
	this.updateStatus=function(sellerId,status){
		return $http.post('http://localhost:8080/backend/seller/updateStatus?sellerId='+sellerId+"&status="+status);
	}
});
