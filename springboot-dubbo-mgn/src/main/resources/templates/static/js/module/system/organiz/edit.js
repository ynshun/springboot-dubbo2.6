define([
    'layer',
	'module/common/tools'
], function (layer, tools) {
	
	var module = {
		ajaxOrgSaveUrl: '/system/organiz/ajax/save',
		ajaxOrgDetailUrl: '/system/organiz/ajax/detail/{id}',
		
		init: function () {
			module._gatherEvent();
			module._initControl();
		},
		
		_initControl: function () {
			var orgId = $('input[name=orgId]').val();
			var parentOrgName = $('input[name=parentOrgName]').val();
			var url = tools.replace(module.ajaxOrgDetailUrl, {id: orgId});
			
			var index = layer.msg('加载中，请稍后', { icon: 16, shade: 0.8 });
			$.post(url, {}, function (resp) {
				layer.close(index);
				if (resp.result_code != '200') {
					layer.msg(resp.result_message);
					return;
				}
				
				var data = resp.result_data;
				data['parent_name'] = parentOrgName;
				
				tools.publishFormData('editForm', data);
			});
		},
		
		_gatherEvent: function () {
			
			$('#editForm').on('click', '#parent_name', function () {
				tools.openSingleSelectOrganiz('parent_name', 'parent_id');
			});
			
			$('#editForm').on('click', 'button[name=saveBtn]', function () {
				var data = tools.gatherFormData('editForm');
				var url = module.ajaxOrgSaveUrl;
				
				layer.msg('处理中，请稍后', { icon: 16, shade: 0.8 });
				$.post(url, data, function (resp) {
					layer.closeAll('loading');
					layer.msg(resp.result_message);
					if (resp.result_code === '200') {
						var index = parent.layer.index;
						setTimeout(function () { parent.layer.close(index); }, 2000);
					}
				});
			});
			
			$('#editForm').on('click', 'button[name=resetBtn]', function () {
				layer.confirm('重置后数据将丢失，确认要关闭吗？', { btn : [ '确定', '取消' ] }, function() {
					$('#editForm')[0].reset();
					layer.closeAll();
				});
			});
			
			
			$('#editForm').on('click', 'button[name=closeBtn]', function () {
				var index = parent.layer.index;
				layer.confirm('关闭后数据将丢失，确认要关闭吗？', { btn : [ '确定', '取消' ] }, function() {
					parent.layer.close(index);
				});
			});
		},
		
		
	};
	
	return module;
});