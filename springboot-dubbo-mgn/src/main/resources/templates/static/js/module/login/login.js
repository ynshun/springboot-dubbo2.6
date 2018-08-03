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
				
				if (data.username === '' || data.password === '') {
					layer.msg('用户名或密码不能为空！');
					return;
				}
				
				
				var url = module.ajaxDologinUrl;
				layer.msg('登录中，请稍后...', { icon: 16, time: 99999999, shade: 0.8 });
				$.post(url, data, function (resp) {
					layer.msg(resp.result_message);
					if ('200' === resp.result_code) {
						setTimeout(function() { window.location.href = '/'; }, 1000);
					}
				});
			});
		}
	};
	
	
	return module;
});