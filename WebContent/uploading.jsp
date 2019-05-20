<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="js/css/layui.css" media="all">
<script src="js/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
	layui.use('upload',function() {
						var $ = layui.jquery, upload = layui.upload;
						//普通图片上传
						var uploadInst = upload
								.render({
									elem : '#test1',
									url : 'up1.action',
									accept: 'file',
									auto: false,
						            bindAction: '#uploadPicBtn',
									before : function(obj) {
										//预读本地文件示例，不支持ie8
										obj.preview(function(index, file,result) {
											$('#demo1').attr('src', result); //图片链接（base64）
											layer.load();
										});
									},
									done : function(res) {
										//如果上传失败
										if (res.code > 0) {
											layer.msg(res.code);
											return layer.msg('上传失败');
										} 
										layer.closeAll();
										layer.msg("上传成功");
									}
								});
					});
</script>
</head>
<body>
	<div class="layui-upload">
		<button type="button" class="layui-btn" id="test1">上传图片</button>
		<div class="layui-upload-list">
			<p id="demoText"></p>
		</div>
		<button type="button" class="layui-btn layui-btn-warm" id="uploadPicBtn">开始上传</button>
	</div>
</body>
</html>