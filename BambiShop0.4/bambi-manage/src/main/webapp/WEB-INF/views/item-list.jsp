<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="itemList" title="商品列表" 
       data-options="singleSelect:false,fitColumns:true,collapsible:true,pagination:true,url:'/item/query',method:'get',pageSize:20,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',width:60">商品ID</th>
            <th data-options="field:'title',width:200">商品标题</th>
            <th data-options="field:'cid',width:100,align:'center',formatter:KindEditorUtil.findItemCatName">叶子类目</th>
            <th data-options="field:'sellPoint',width:100">卖点</th>
            <th data-options="field:'price',width:70,align:'right',formatter:KindEditorUtil.formatPrice">价格</th>
            <th data-options="field:'num',width:70,align:'right'">库存数量</th>
            <th data-options="field:'barcode',width:100">条形码</th>
            <th data-options="field:'status',width:60,align:'center',formatter:KindEditorUtil.formatItemStatus">状态</th>
            <th data-options="field:'created',width:130,align:'center',formatter:KindEditorUtil.formatDateTime">创建日期</th>
            <th data-options="field:'updated',width:130,align:'center',formatter:KindEditorUtil.formatDateTime">更新日期</th>
        </tr>
    </thead>
</table>
<!--定义了修改页面的弹出框的位置  -->
<div id="itemEditWindow" class="easyui-window" title="编辑商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/page/item-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

	//动态获取用户的选中的页面数据
    function getSelectionsIds(){
        //利用id选择器动态选中所有表格数据.
    	var itemList = $("#itemList");
    	//利用easyUI的表格数据的方法获取用户选中的元素
    	//[{item1},{item2},{item3}]
    	var sels = itemList.datagrid("getSelections");
    	var ids = [];	//准备一个js数组  [101,102,103]
    	for(var i in sels){	//js中的for循环  sels遍历的数据  i遍历的下标
    		ids.push(sels[i].id); //将id添加到数组中.
    	}
    	//将数组拼接成串 1,2,3,4,5
    	ids = ids.join(",");
    	return ids;
    }

    //工具栏JS数据 toolbar
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        //点击操作事件
        handler:function(){
            //.类型选择器.
        	$(".tree-title:contains('新增商品')").parent().click();
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){		//点击之后执行的动作.
        	//获取用户选中的数据  id的字符串信息 100,101,102
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个商品才能编辑!');
        		return ;
        	}
        	//判断用户选中的是一个数据.
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个商品!');
        		return ;
        	}

        	//在指定的位置展现弹出框.
        	$("#itemEditWindow").window({
            	//当窗口打开之后执行该操作.
        		onLoad :function(){
        			//获取用户选中的一行信息 item对象
        			var data = $("#itemList").datagrid("getSelections")[0];
        			//将数据库中的价格除以100转化为小数.
        			data.priceView = KindEditorUtil.formatPrice(data.price);
        			//将数据在修改的表单中进行数据的回显.
        			//根据对象的名称与页面中的name属性一致时实现数据的回显.
        			$("#itemeEditForm").form("load",data);

					//让页面加载完成之后,执行取值操作.
					var cid = $("#itemeEditForm input[name='cid']").val();
        			//alert("获取分类id信息:"+cid);
        			$.get("/item/cat/queryItemName",{"itemCatId":cid},function(itemName){
						//alert(itemName);
						//获取span思路.1先获取cid的input标签,之后找到兄弟 span标签
						//val() 获取的是value的值   val(1000) 给value属性赋值
						//text() 获取的是文本的值   text(1000)给本文赋值
							$("#itemeEditForm input[name='cid']").siblings("span").text(itemName);
            			})
        			
        			// 加载商品描述
        			//_data = SysResult.ok(itemDesc)
        			$.getJSON('/item/query/item/desc/'+data.id,function(_data){
        				if(_data.status == 200){	//
        					//UM.getEditor('itemeEditDescEditor').setContent(_data.data.itemDesc, false);
        					itemEditEditor.html(_data.data.itemDesc);
        				}
        			});
        			
        			//加载商品规格 业务中暂时没有 跳过.
        			$.getJSON('/item/param/item/query/'+data.id,function(_data){
        				if(_data && _data.status == 200 && _data.data && _data.data.paramData){
        					$("#itemeEditForm .params").show();
        					$("#itemeEditForm [name=itemParams]").val(_data.data.paramData);
        					$("#itemeEditForm [name=itemParamId]").val(_data.data.id);
        					
        					//回显商品规格
        					 var paramData = JSON.parse(_data.data.paramData);
        					
        					 var html = "<ul>";
        					 for(var i in paramData){
        						 var pd = paramData[i];
        						 html+="<li><table>";
        						 html+="<tr><td colspan=\"2\" class=\"group\">"+pd.group+"</td></tr>";
        						 
        						 for(var j in pd.params){
        							 var ps = pd.params[j];
        							 html+="<tr><td class=\"param\"><span>"+ps.k+"</span>: </td><td><input autocomplete=\"off\" type=\"text\" value='"+ps.v+"'/></td></tr>";
        						 }
        						 
        						 html+="</li></table>";
        					 }
        					 html+= "</ul>";
        					 $("#itemeEditForm .params td").eq(1).html(html);
        				}
        			});
        			
        			KindEditorUtil.init({
        				"pics" : data.image,
        				"cid" : data.cid,
        				fun:function(node){
        					KindEditorUtil.changeItemParam(node, "itemeEditForm");
        				} 
        			});
        		}
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
            //动态获取商品ids
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}

        	//消息确认框架 
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/item/delete",params, function(data){
                    	//
            			if(data.status == 200){
            				$.messager.alert('提示','删除商品成功!',undefined,function(){
            					$("#itemList").datagrid("reload");
            				});
            			}else{
            				$.messager.alert("提示",data.msg);
            			}
            		});
        	    }
        	});
        }
    },'-',{
        text:'下架',
        iconCls:'icon-remove',
        handler:function(){
        	//获取选中的ID串中间使用","号分割
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定下架ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/item/instock",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','下架商品成功!',undefined,function(){
            					$("#itemList").datagrid("reload");
            				});
            			}else{
            				$.messager.alert('提示','下架商品失败!');
                		}
            		});
        	    }
        	});
        }
    },{
        text:'上架',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定上架ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/item/reshelf",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','上架商品成功!',undefined,function(){
            					$("#itemList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>