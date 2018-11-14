//服务层
app.service('userService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('http://localhost:8080/backend/user/findAll');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('http://localhost:8080/backend/user/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('http://localhost:8080/backend/user/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('http://localhost:8080/backend/user/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('http://localhost:8080/backend/user/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('http://localhost:8080/backend/user/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('http://localhost:8080/backend/user/search?page='+page+"&rows="+rows, searchEntity);
	}    	
});
