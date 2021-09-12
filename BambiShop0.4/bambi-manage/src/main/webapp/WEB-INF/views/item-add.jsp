<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemAddForm" class="itemForm" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>商品类目:</td>
	            <td>
	            	<a href="javascript:void(0)" class="easyui-linkbutton selectItemCat">选择类目</a>
	            	<input type="hidden" name="cid" style="width: 280px;"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>商品标题:</td>
	            <td><input class="easyui-textbox" type="text" name="title" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>商品卖点:</td>
	            <td><input class="easyui-textbox" name="sellPoint" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>商品价格:</td>
	            <td><input class="easyui-numberbox" type="text" name="priceView" data-options="min:1,max:99999999,precision:2,required:true" />
	            	<input type="hidden" name="price"/>
	            </td>
	        </tr>
	        <tr>
	            <td>库存数量:</td>
	            <td><input class="easyui-numberbox" type="text" name="num" data-options="min:1,max:99999999,precision:0,required:true" /></td>
	        </tr>
	        <tr>
	            <td>条形码:</td>
	            <td>
	                <input class="easyui-textbox" type="text" name="barcode" data-options="validType:'length[1,30]'" />
	            </td>
	        </tr>
	        <tr>
	            <td>商品图片:</td>
	            <td>
	            	 <a href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
	                 <input type="hidden" name="image"/>
	            </td>
	        </tr>
	        <tr>
	            <td>商品描述:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="itemDesc"></textarea>
	            </td>
	        </tr>
	        <tr class="params hide">
	        	<td>商品规格:</td>
	        	<td>
	        		
	        	</td>
	        </tr>
	    </table>
	    <input type="hidden" name="itemParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var itemAddEditor ;
	$(function(){
		//和form下的itemDesc组件绑定
		itemAddEditor = KindEditorUtil.createEditor("#itemAddForm [name=itemDesc]");
		KindEditorUtil.init({fun:function(node){
			KindEditorUtil.changeItemParam(node, "itemAddForm");
		}});
	});

	//定义js提交函数
	function submitForm(){
		//表单校验
		//$('#itemAddForm') id选择器   
		//.form EasyUI中表单提交的函数   
		//validate 校验 检查页面JS是否满足规范
		if(!$('#itemAddForm').form('validate')){
			//有校验没有完成
			$.messager.alert('提示','表单还未填写完成!');
			return ;	//return 表示业务结束
		}
		//转化价格单位，将元转化为分
		//$("id选择器 子元素选择器  属性选择器")
		//$("xxx").val(100);  赋值操作
		//$("xxxx").val();	   取值操作
		//eval()	是专门完成算术运算的函数 转化为数字
		$("#itemAddForm [name=price]").val(eval($("#itemAddForm [name=priceView]").val()) * 100);
		itemAddEditor.sync();//将输入的内容同步到多行文本中
		
		var paramJson = [];
		$("#itemAddForm .params li").each(function(i,e){
			var trs = $(e).find("tr");
			var group = trs.eq(0).text();
			var ps = [];
			for(var i = 1;i<trs.length;i++){
				var tr = trs.eq(i);
				ps.push({
					"k" : $.trim(tr.find("td").eq(0).find("span").text()),
					"v" : $.trim(tr.find("input").val())
				});
			}
			paramJson.push({
				"group" : group,
				"params": ps
			});
		});
		paramJson = JSON.stringify(paramJson);//将对象转化为json字符串
		
		$("#itemAddForm [name=itemParams]").val(paramJson);
		

		//参数1:
				//请求路径: /item/save
		//参数2: 
				//请求参数: 1. {key1:value1,key2:value2}  json格式
				//		    2. id=1&name=tomcat&age=18	  参数拼接
				//可以将整个表单序列号,作用:将所有的参数进行拼接
				//alert($("#itemAddForm").serialize());
		
		//参数3:回调函数 当发起ajax请求之后,服务器给页面的响应(正确/失败,返回业务数据)
		$.post("/item/save",$("#itemAddForm").serialize(), function(data){
			//data SysResult VO对象{status:200/201,msg:"xxxxx",data:xxxx}
			//封装一个返回值 要求有status属性 200表示操作成功 
			if(data.status == 200){
				$.messager.alert('提示','新增商品成功!');
			}else{
				$.messager.alert("提示","新增商品失败!");
			}
		});
	}
	
	function clearForm(){
		$('#itemAddForm').form('reset');
		itemAddEditor.html('');
	}
</script>
