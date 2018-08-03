define([
	'module/common/table',
	'module/common/tools'
], function (table, tools) {
	
	var module = {
		grid: null,
		treeId: 'treeDemo',
		tableId: 'example',
		zTree: null,
		// 加载组织架构下级
		ajaxQueryChildrenUrl: '/system/organiz/ajax/children',
		// 分页查询组织架构
		ajaxQueryListByPageUrl: '/system/organiz/ajax/children/page',
		// 删除组织架构
		ajaxDeleteOrganizUrl: '/system/organiz/ajax/delete/{id}',
		
		
		init: function () {
			module.__rendTree();
			module.__initTable();
			module._gatherEvent();
		},
		
		
		__rendTree: function () {
			var setting = {
				async: {
					enable: true,
					url: module.ajaxQueryChildrenUrl,
					autoParam:["id", "name", "level"],
					dataFilter: module.filter
				},
				callback: {
					onClick: module.zTreeOnClick
				}
			};
			module.zTree = $.fn.zTree.init($('#' + module.treeId), setting);
		},
		
		
		__initTable: function () {
			var columns = [ { 'data' : null, 'title': '序号', 'orderable': false },
			                { "data" : "full_org_name", 'title': '全路径', 'orderable': false }, 
			                { "data" : "org_name", 'title': '组织名称', 'orderable': false },
			                { "data" : "parent_name", 'title': '上级组织', 'orderable': false }
			            ];
			
			module.grid = table.init(module.tableId, module.ajaxQueryListByPageUrl, columns, module.searchFunction);
		},

		
		_gatherEvent: function () {
			
			// 刷新按钮
			$('#orgTreeBtnGroup').on('click', 'button[name=refresh]', function () {
				module.__rendTree();
				
				$('body').data('parentid', '');
				module.grid.ajax.reload();
			});
			
			// 新增按钮
			$('#orgTreeBtnGroup').on('click', 'button[name=add]', function () {
				var url = '/topage/system/organiz/add.html';
				var index = layer.open({ title : '新增组织架构', type : 2, shade: 0.8, shadeClose : false, maxmin: true, area : [ '800px', '400px' ], content : url });
				// layer.full(index);
			});
			
			$('#orgTreeBtnGroup').on('click', 'button[name=edit]', function () {
				var nodes = module.zTree.getSelectedNodes();
				
				if (!nodes || nodes.length == 0) {
					layer.msg('请选择需要修改的组织架构！');
					return;
				}
				
				var node = nodes[0];
				
				if (node.id.indexOf('org_') != 0) {
					layer.msg('用户角色不能编辑！');
					return;
				}
				
				var orgId = node.id.substring(4)
				var parentNode = node.getParentNode();
				var parentOrgName = '';
				
				if (parentNode) {
					parentOrgName = parentNode.name;
				}
				
				
				var url = '/topage/system/organiz/edit.html?orgId=' + orgId + "&parentOrgName=" + parentOrgName;
				var index = layer.open({ title : '修改组织架构', type : 2, shade: 0.8, shadeClose : false, maxmin: true, area : [ '800px', '400px' ], content : url });
				// layer.full(index);
			});
			
			// 删除按钮
			$('#orgTreeBtnGroup').on('click', 'button[name=delete]', function () {
				var nodes = module.zTree.getSelectedNodes();
				var node = nodes[0];
				
				if (!nodes || nodes.length == 0) {
					layer.msg('请选择需要删除的组织架构！');
					return;
				}
				
				if (node.id.indexOf('org_') != 0) {
					layer.msg('用户角色不能删除！');
					return;
				}

				if (node.parentTId == null) {
					layer.msg('一级组织架构不能删除！');
					return;
				}
				
				layer.confirm('您确定要删除[' + node.name + ']吗？', { btn : [ '确定', '取消' ] }, function() {
					var id = node.id.substring(4);
					var url = tools.replace(module.ajaxDeleteOrganizUrl, {id: id});
					
					layer.msg('处理中，请稍后', { icon: 16 ,shade: 0.8 });
					$.post(url, {}, function (resp) {
						layer.closeAll('loading');
						layer.msg(resp.result_message);
						if (resp.result_code === '200') {
							module.zTree.removeNode(node);
						}
					});
				});
			});
		},
		
		// 列表刷新处理
		searchFunction: function (param) {
			param['id'] = $('body').data('parentid');
		},
		
		
		// 组织架构树单击
		zTreeOnClick: function (event, treeId, treeNode) {
			var id = treeNode.id;
			if (id && id.indexOf('org_') == 0) {
				$('body').data('parentid', id.substring(4));
				module.grid.ajax.reload();
			}
		},
		
		filter: function (treeId, parentNode, childNodes) {
			if (!childNodes) return null;
			for (var i = 0, l = childNodes.length; i < l; i++) {
				childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
			}
			return childNodes;
		}
	};
	
	return module;
});