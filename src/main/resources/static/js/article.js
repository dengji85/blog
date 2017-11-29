layui.use(['laypage','jquery','form'], function(){
	 var form = layui.form;
	 
	var strFullPath = window.document.location.href;
	var strPath = window.document.location.pathname;
	var pos = strFullPath.indexOf(strPath);
	var prePath = strFullPath.substring(0, pos);
	var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
	var basePath = prePath;
	basePath = prePath + postPath;
	console.log(basePath);
	  var laypage = layui.laypage;
	  var $=layui.jquery;
	  
	  $("#wz").addClass("layui-this");
	   $("#s_wz").addClass("layui-this");
	  // 执行一个laypage实例
	  laypage.render({
		  limit:7,
		  curr:$("#page").val(),
		    elem: '_page' // 注意，这里的 test1 是 ID，不用加 # 号
		    ,count: $("#count").val() // 数据总数，从服务端得到
		   , jump: function(obj,first){// 点击页码出发的事件
                if(first!=true){// 是否首次进入页面
                    var currentPage = obj.curr;// 获取点击的页码
                    window.location.href =basePath+"/page?page="+currentPage+"&type="+$("#type").val()+"&keyWords="+$("#keyWords").val();  
                }  
    }  
		  });
	  
	  //一些事件监听
	  form.on('submit(formSearch)', function(data){
		  window.location.href =basePath+"/page?keyWords="+data.field.keyWords;
	  });
	});
