<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="/css/jt.css" />
<script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
</head>
<body class="easyui-layout">

  <div data-options="region:'west',title:'菜单',split:true" style="width:10%;">
   		<ul class="easyui-tree">
   			<li>
   			<span>商品管理</span>
   			<ul>
   			<li><a onclick="addTab('商品新增','/item-add')">商品新增</a></li>
   			<li><a onclick="addTab('商品查询','/item-list')">商品查询</a></li>
   			<li><a onclick="addTab('商品更新','/item-update')">商品更新</a></li>
   			</ul>
			</li>
			
			<li>
   			<span>网站内容管理</span>
   			<ul>
   			<li>内容新增</li>
   			<li>内容修改</li>
   			</ul>
			</li>
   		
   		</ul>
   </div>
   <div id="tt" class="easyui-tabs" data-options="region:'center',title:'首页'"></div>


</body>
<script type="text/javascript">
//addTab('商品新增','/item-add')
function addTab(title, url){  
	//$('#tt')id选择器 .tabs选项卡相关函数,   exists判断是否存在
    if ($('#tt').tabs('exists', title)){  	
        //如果当前标题信息商品新增已经存在了,则选中该选项卡.
        $('#tt').tabs('select', title);  
    } 
    else {  //当前选项卡不存在  iframe 画中画
        var content = '<iframe scrolling="auto" frameborder="0"  src="https://map.baidu.com/@12959238.56,4825347.47,12z" style="width:100%;height:100%;"></iframe>';  
        $('#tt').tabs('add',{  
            title:title,  
            content:content,  	//选项卡的内容
            closable:true  
        });  
    }  
} 

</script>

</html>