define([
	'module/common/table',
	'module/common/tools'
], function (table, tools) {
	
	var module = {
		grid: null,
		tableId: 'example',
		// 分页查询
		ajaxQueryListByPageUrl: '/system/employee/ajax/query',
		
		
		init: function () {
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
			                { 'data' : 'name', 'title': '姓名', 'orderable': false },
			                { 'data' : 'loginname', 'title': '登录账号', 'orderable': false },
			                { "data" : "role_name", 'title': '角色名称', 'orderable': false }, 
			                { "data" : "full_org_name", 'title': '所属组织架构', 'orderable': false },
			                { "data" : null, 'title': '操作', 'orderable': false, 'render': module.tableRender.operateRender }
			            ];
			
			module.grid = table.init(module.tableId, module.ajaxQueryListByPageUrl, columns, module.searchFunction);
		},

		
		_gatherEvent: function () {
			
			// 所属组织
			$('#searchForm').on('click', '#org_name', function () {
				tools.openSingleSelectOrganiz('org_name', 'org_id');
			});
			
			// 查询按钮
			$('#searchForm').on('click', 'button[name=searchBtn]', function () {
				module.grid.ajax.reload();
			});
			
			// 新增按钮
			$('#searchForm').on('click', 'button[name=addBtn]', function () {
				// tools.openSingleSelectOrganiz('parent_name', 'parent_id');
				alert('开发中，敬请期待！');
			});
			
			
			$('#' + module.tableId).on('click', '.edit', function () {
				alert('开发中，敬请期待！');
			});
			
			$('#' + module.tableId).on('click', '.auth', function () {
				alert('开发中，敬请期待！');
			});

			$('#' + module.tableId).on('click', '.del', function () {
				alert('开发中，敬请期待！');
			});
			 
		},
		
		// 列表刷新处理
		searchFunction: function (param) {
			tools.gatherFormData('searchForm', param);
		},
		
		
		tableRender: {
			// 操作栏
			operateRender: function (a, b, c, d) {
				var html = [];
				html.push('<button data-id="' + c.id + '" type="button" class="edit btn btn-info btn-xs" title="编辑/修改角色信息"><i class="glyphicon glyphicon-edit"></i></button> &nbsp;');
				html.push('<button data-id="' + c.id + '" type="button" class="auth btn btn-warning btn-xs" title="角色信息授权"><i class="glyphicon glyphicon-user"></i></button> &nbsp;');
				html.push('<button data-id="' + c.id + '" type="button" class="del btn btn-danger btn-xs" title="删除角色信息"><i class="glyphicon glyphicon-trash"></i></button> &nbsp;');
				return html.join('');
			}
		}
	};
	
	return module;
});