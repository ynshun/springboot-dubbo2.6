define([
    'layer',
	'module/common/tools'
], function (layer, tools) {
	
	var module = {
		ajaxOrgSaveUrl: '/system/organiz/ajax/save',
		
		init: function () {
			module._gatherEvent();
		},
		
		_gatherEvent: function () {
			
			$('#addForm').on('click', '#parent_name', function () {
				tools.openSingleSelectOrganiz('parent_name', 'parent_id');
			});
			
			
			$('#addForm').on('click', 'button[name=saveBtn]', function () {
				var data = tools.gatherFormData('addForm');
				var url = module.ajaxOrgSaveUrl;
				layer.msg('处理中，请稍后', { icon: 16 ,shade: 0.8 });
				$.post(url, data, function (resp) {
					layer.closeAll('loading');
					layer.msg(resp.result_message);
					if (resp.result_code === '200') {
						var index = parent.layer.index;
						setTimeout(function () {
							parent.layer.close(index);
						}, 2000);
					}
				});
			});
			
			$('#addForm').on('click', 'button[name=resetBtn]', function () {
				layer.confirm('重置后数据将丢失，确认要关闭吗？', { btn : [ '确定', '取消' ] }, function() {
					$('#addForm')[0].reset();
					layer.closeAll();
				});
			});
			
			
			$('#addForm').on('click', 'button[name=closeBtn]', function () {
				var index = parent.layer.index;
				layer.confirm('关闭后数据将丢失，确认要关闭吗？', { btn : [ '确定', '取消' ] }, function() {
					parent.layer.close(index);
				});
			});
		},
		
		
	};
	
	return module;
});