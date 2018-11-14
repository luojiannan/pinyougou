//服务层
app.service('payLogService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('http://localhost:8080/backend/payLog/findAll');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('http://localhost:8080/backend/payLog/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('http://localhost:8080/backend/payLog/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('http://localhost:8080/backend/payLog/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('http://localhost:8080/backend/payLog/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('http://localhost:8080/backend/payLog/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('http://localhost:8080/backend/payLog/search?page='+page+"&rows="+rows, searchEntity);
	}    	
});
