//服务层
app.service('specificationService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('http://localhost:8080/backend/specification/findAll');		
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('http://localhost:8080/backend/specification/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('http://localhost:8080/backend/specification/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('http://localhost:8080/backend/specification/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('http://localhost:8080/backend/specification/update',entity );
	}
	//删除
	this.delete=function(ids){
		return $http.get('http://localhost:8080/backend/specification/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('http://localhost:8080/backend/specification/search?page='+page+"&rows="+rows, searchEntity);
	}

	this.selectOptionList=function(){
		return $http.get('http://localhost:8080/backend/specification/selectOptionList');
	}
});
