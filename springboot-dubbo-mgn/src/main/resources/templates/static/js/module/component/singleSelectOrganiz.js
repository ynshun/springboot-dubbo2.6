define([
	'module/common/table',
	'module/common/tools'
], function (table, tools) {
	
	var module = {
		grid: null,
		tableId: 'example',
		// 分页查询组织架构
		ajaxOrganizListUrl: '/component/ajax/organiz/pagelist',
		
		init: function () {
			module.__initTable();
			module._gatherEvent();
		},
		
		__initTable: function () {
			var columns = [ { 'data' : null, 'title': '序号', 'orderable': false },
			                { "data" : "full_org_name", 'title': '组织名称', 'orderable': false },
			                { "data" : null, 'title': '选择', 'orderable': false, 'render': module.selectRender }];
			
			module.grid = table.init(module.tableId, module.ajaxOrganizListUrl, columns, module.searchFunction);
		},

		
		_gatherEvent: function () {
			$('#' + module.tableId).on('click', '.select', function () {
				var valNode = ['INPUT', 'TEXTAREA', 'DIV'];
				
				var json = JSON.parse(unescape($(this).data('json')));
				var index = parent.layer.index;
				var showNode = tools.getUrlParam('showNode');
				var valueNode = tools.getUrlParam('valueNode');
				
				var showNodeType = parent.$('#' + showNode).prop("tagName");
				
				// 处理值
				parent.$('#' + valueNode).val(json.id);
				
				// 处理显示
				if (valNode.indexOf(showNodeType) > -1) {
					parent.$('#' + showNode).val(json.full_org_name);
				} else {
					parent.$('#' + showNode).html(json.full_org_name);
				}
				
				parent.layer.close(index);
			});
			
			$('body').on('click', 'button[name=searchBtn]', function () {
				module.grid.ajax.reload();
			});
		},
		
		selectRender: function (a, b, c, d) {
			var json = escape(JSON.stringify(c));
			return '<button data-json="' + json + '" class="btn btn-success btn-xs select"><i class="glyphicon glyphicon-ok"></i></button>';
		},
		
		searchFunction: function (param) {
			tools.gatherFormData('searchForm', param);
		}
		
	};
	
	return module;
});