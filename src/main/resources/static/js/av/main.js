/*
 * 主JS文件
 * 日期: 2017-09-1
 * By Endfish
 * 
*/

$(document).ready(function(){
	
	initPage();
	
});

function initPage() {
	
	//导航
	layui.use('element', function(){
		var top_nav = layui.element;
	});
	
	$('#top_nav li').addClass('layui-nav-item');
	$('#top_nav .current_page_item, #top_nav .current-menu-item').addClass('layui-this');
	
	//幻灯
	layui.use('carousel', function(){
		//首页主播幻灯
		var index_banner = layui.carousel;
		index_banner.render({
			elem: '#index_banner'
			,width: '100%'
			,height: '100%'
			,interval: 3000
			,arrow: 'always'
	  	});
	  	
	  	//首页新闻幻灯
	  	var index_news_banner = layui.carousel;
		index_news_banner.render({
			elem: '#index_news_banner'
			,width: '100%'
			,height: '100%'
			,interval: 3000
			,arrow: 'always'
	  	});
	  	
	  	//新闻首页幻灯
		var news_banner = layui.carousel;
		news_banner.render({
			elem: '#news_banner'
			,width: '100%'
			,height: '100%'
			,interval: 3000
			,arrow: 'always'
			,indicator: 'none'
	  	});
	  	
	  	//主播图片
		var auchor_img = layui.carousel;
		auchor_img.render({
			elem: '#auchor_img'
			,width: '100%'
			,height: '100%'
			,autoplay: false
			,interval: 3000
			,arrow: 'none'
			,indicator: 'inside'
	  	});
	  	
	});
	
	//表单
	layui.use('form', function(){
		var form = layui.form;
		
		//开关
		form.on('switch(switchAuchor)', function(data){
			if(data.elem.checked){
				$('.add-dis').addClass('show');
			}else{
				$('.add-dis').removeClass('show');
			}
		});
		
		//主播搜索
		form.on('submit(search_anchor)', function(data){
			if( data.field.s == '' ){
				$('#search').attr("name","");
				$('#search_hide').attr("name","s").val('直播');
			}
		});
		
		//公会搜索
		form.on('submit(search_guild)', function(data){
			if( data.field.s == '' ){
				$('#search').attr("name","");
				$('#search_hide').attr("name","s").val('公会');
			}
		});
		
		
	});
	
	
	//主播生日
	layui.use('laydate', function(){
		var laydate = layui.laydate;
  
  		laydate.render({
    		elem: '#auchor_birthday'
    		,theme: '#60bac7'
    		,format: 'yyyy年MM月dd日'
  		});
	});
	
	//主播简介编辑器
	layui.use('layedit', function(){
		var layedit = layui.layedit;
  
  		var anchor_con = layedit.build('auchor_editor',{
  			height: 300
  			,tool: [
  				'strong'
  				, 'italic'
  				, 'underline'
  				, 'del'
  				, '|'
  				, 'left'
  				, 'center'
  				, 'right'
  			]
  		});
  		
  		$('#add_anchor').on('click',function() {
			layedit.sync(anchor_con);
		});
	});
	
	
	
	//点赞
	$('.live-btn-like').on("click",function() {
		
		
		if($(this).hasClass('live-btn-like-ok')){
			//console.log('已赞');
			
		}else{
			var post_id = $(this).data("id");
			anchor_like(post_id);
			
			$(this).removeClass('live-btn-like-girl,live-btn-like-boy');
			$(this).addClass('live-btn-like-ok');
			
			$(this).text('已赞');
		}
		
	});
	
	//TOP按钮
	layui.use('util', function(){
		var util = layui.util;
  
		util.fixbar({
			css: {right: 10, bottom: 100}
    			,bgcolor: '#393939'
    			,click: function(){
    				
    			}
		});
	});
	
	//自媒体
	layui.use('layer', function(){
		var layer = layui.layer;
		var w_code = $('.weixin-code').html();
		var w_name = $('.weixin-code img').attr('alt');

		$('ul.author-link .weixin').on('click',function() {
			layer.open({
				content:		w_code
				,title:			w_name + '的微信公众号'
				,skin:			'w-code'
				,shadeClose:	true
				,btn:			''
			});
		});
		
		//外链跳转
		$('div.page-nav .web-link').on('click',function() {
			var url_link = $(this).data("link");
			var url_name = $(this).find('.name').html();
			
			layer.open({
				title:	'前往' + url_name
				,content: '传送门开启中...'
				,shadeClose:	true
				,skin: 'web-link-url'
				,btn:	['立即前往']
				,btnAlign: 'c'
				,success: function(layero, index){
					console.log(layero);
					layero.find('.layui-layer-btn0').attr({
						'href' : url_link
						,'target' : "_blank"
					});
				}
				
			});
		});
		
	}); 
	
}

function anchor_like (post_id) {

	var ajax_data = {
		action: "zhubo_anchor_like",
		um_id: post_id
	};
	
	$.post("/wp-admin/admin-ajax.php", ajax_data, function(data) {
		$('.anchor-num .like-num').html(data);
	});
	
}