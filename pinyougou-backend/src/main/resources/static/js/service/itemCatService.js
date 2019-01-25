//服务层
app.service('itemCatService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('http://localhost:8080/backend/itemCat/findAll');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('http://localhost:8080/backend/itemCat/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('http://localhost:8080/backend/itemCat/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('http://localhost:8080/backend/itemCat/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('http://localhost:8080/backend/itemCat/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('http://localhost:8080/backend/itemCat/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('http://localhost:8080/backend/itemCat/search?page='+page+"&rows="+rows, searchEntity);
	}
	//根据上级分类id查询商品分类列表
	this.findByParentId=function(parentId){
		return $http.get('../../backend/itemCat/findByParentId?parentId='+parentId);
	}
});
