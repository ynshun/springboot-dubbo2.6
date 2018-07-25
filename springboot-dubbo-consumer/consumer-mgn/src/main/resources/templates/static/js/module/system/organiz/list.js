define([
        
], function () {
	
	var module = {
		treeId: 'treeDemo',
		tableId: 'example',
		zTree: null,
		// 加载组织架构下级
		ajaxOrganizChildrenUrl: '/system/organiz/children',
		// 分页查询组织架构
		ajaxOrganizListUrl: '/static/datas/datatable.json',
		
		
		init: function () {
			module.__initTree();
			module.__initTable();
			module._gatherEvent();
		},
		
		
		__initTree: function () {
			var setting = {
				async: {
					enable: true,
					url: module.ajaxOrganizChildrenUrl,
					autoParam:["id", "name", "level"],
					dataFilter: module.filter
				}
			};
			module.zTree = $.fn.zTree.init($('#' + module.treeId), setting);
		},
		
		
		__initTable: function () {
			
			$('#' + module.tableId).dataTable( {
		        "ajax": module.ajaxOrganizListUrl,
		        "columns": [
		            { "data": "name" },
		            { "data": "position" },
		            { "data": "office" },
		            { "data": "extn" }
		        ]
		    } );
			
		},

		
		_gatherEvent: function () {
			$('#orgTreeBtnGroup').on('click', 'button[name=refresh]', function () {
				zTree = $.fn.zTree.init($("#treeDemo"), setting);
			});
			
			$('#orgTreeBtnGroup').on('click', 'button[name=add]', function () {
				alert('add');
			});
			
			$('#orgTreeBtnGroup').on('click', 'button[name=edit]', function () {
				alert('edit');
			});
			
			$('#orgTreeBtnGroup').on('click', 'button[name=delete]', function () {
				var nodes = module.zTree.getSelectedNodes();
				for (var i = 0, l = nodes.length; i < l; i++) {
					module.zTree.removeNode(nodes[i]);
				}
			});
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