//粘贴图片上传
//延时加载uploadImage方法，否则被默认方法覆盖
$(function(){setTimeout(uplaodImage,400);});
 
//使用FormData形式，将base64图片转换成formData再提交(图片不限制大小)
function uplaodImage(){
    CKEDITOR.instances.CKEditor.on('change',function(e){//content为textarea的id
              var a = e.editor.document ;
              var b = a.find("img");
              var count = b.count();
              for(var i=0;i<count;i++){
                       var src =b.getItem(i).$.src;//获取img的src
                       if(src.substring(0,10)=='data:image'){ //判断是否是二进制图像，是才处理
                           var img1=src.split(',')[1]; 
                          var img2=window.atob(img1); 
                          alert('img2 size='+img2.length);
                           var ia = new Uint8Array(img2.length); 
                           for (var x = 0; x < img2.length; x++) { 
                             ia[x] = img2.charCodeAt(x); 
                           };
                          //获得图片的类型
                          var w1=src.indexOf(":");//获得指定字符的第一个下标值
                            var w2=src.indexOf(";");
                            var imgType= src.substring(w1+1, w2);//返回一个包含从 start 到最后（不包含 end ）的子字符串的字符串
                             
                           var blob=new Blob([ia], {type:imgType}); 
                           var formdata=new FormData(); 
                           formdata.append('croppedImage',blob);
                            
                                $.ajax({
                                        type:"POST",
                                        url:"${baseurl}article/uploadImage.action",//服务器url
                                        async:false,//同步，因为修改编辑器内容的时候会多次调用change方法，所以要同步，否则会多次调用后台
                                        data:formdata,
                                        processData: false,
                                        contentType: false,
                                        success:function(json){
                                             var imgurl=json.resultInfo.sysdata.url; //获取回传的图片url
                                           //alert('返回的url='+imgurl);
                                             
                                             //获取并更改到现有的图片标签src的值
                                              b.getItem(i).$.src=imgurl;
                                            var a = CKEDITOR.instances.content.document.$.getElementsByTagName("img")[i]; //content为textarea的id
                                            a.setAttribute('data-cke-saved-src',imgurl);
                                                  }
                                });
                       }
              }
    });
}