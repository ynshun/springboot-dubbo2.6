define([
	'module/common/tools'
], function (tools) {
	
	var module = {
		ajaxDologinUrl: '/ajax/doLogin',
		init: function () {
			
			module.__gatherEvent();
		}, 
		
		
		__gatherEvent: function () {
			
			$('#loginBtn').click(function () {
				var data = tools.gatherFormData('loginForm');
				var url = module.ajaxDologinUrl;
				
				$.post(url, data, function (resp) {
					alert(JSON.stringify(resp));
				});
			});
		}
	};
	
	
	return module;
});