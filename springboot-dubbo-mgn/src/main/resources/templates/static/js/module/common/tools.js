define([
	'layer'
], function (layer) {
	
	var module = {
			
		guid: function () {
		    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
		        var r = Math.random()*16|0, v = c == 'x' ? r : (r&0x3|0x8);
		        return v.toString(16);
		    });
		},
			
		replace: function (/**String*/content, /**Object*/data) {
			for (var pro in data) {
				content = content.replace('{' + pro + '}', data[pro]);
			}
			return content;
		},
			
		dateFormat: function (/**Date*/date, /**String*/fmt) {
		    var o = {
		        "M+": date.getMonth() + 1, //月份 
		        "d+": date.getDate(), //日 
		        "h+": date.getHours(), //小时 
		        "m+": date.getMinutes(), //分 
		        "s+": date.getSeconds(), //秒 
		        "q+": Math.floor((date.getMonth() + 3) / 3), //季度 
		        "S": date.getMilliseconds() //毫秒 
		    };
		    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
		    for (var k in o)
		    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		    return fmt;
		},
		
		/**格式化输出货币金额*/
		moneyFormat: function (/**float*/s, /**int*/n) {
			n = n > 0 && n <= 20 ? n : 2; 
			s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + ""; 
			var l = s.split(".")[0].split("").reverse(), 
			r = s.split(".")[1]; 
			t = ""; 
			for(i = 0; i < l.length; i ++ ) 
			{ 
			t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : ""); 
			} 
			return t.split("").reverse().join("") + "." + r; 
		},
		
		/**
		 * 收集表单数据
		 * @param form
		 * @param data
		 */
		gatherFormData: function (/**Node Or String*/form, /**Object*/data) {
			if (typeof form === 'string') {
				form = $('#' + form);
			}
			
			data = data || {};
			
			var gatherData = function (/**Node Or Array of Node*/nodes) {
				
				$.each(nodes, function (i, n) {
					var key = $(n).prop('id') || $(n).prop('name');
					var value = $(n).val();
					if (typeof(key) != 'undefined' && key != '') {
						data[key] = value;
					}
				});
			};
			
			var inputs = $(form).find('input');
			var selects = $(form).find('select');
			var textareas = $(form).find('textarea');
			
			gatherData(inputs);
			gatherData(selects);
			gatherData(textareas);
			return data;
		},
		
		
		publishFormData: function (/**Node Or String*/form, /**Object*/data) {
			if (typeof form === 'string') form = $('#' + form);
			
			data = data || {};
			
			for (var pro in data) {
				var node = node = $(form).find('[name=' + pro + ']');
				if (!node || node.length == 0) {
					node = $(form).find('[id=' + pro + ']');
				}
				$(node).val(data[pro]);
			}
		},
			
		
		
		/**
		 * 获取当前ServletRequestUrl
		 */
		getUrlRelativePath: function () {
			var url = document.location.toString();
			var arrUrl = url.split("//");
			var start = arrUrl[1].indexOf("/");
			var relUrl = arrUrl[1].substring(start);

			if(relUrl.indexOf("?") != -1) {
				relUrl = relUrl.split("?")[0];
			}
			return relUrl;
		},
		
		/**
         * json转url参数
         */
        jsonParseString: function(param, key) {
            var paramStr="";
            if (param instanceof String || param instanceof Number || param instanceof Boolean) {
                paramStr += "&" + key + "=" + encodeURIComponent(param);
            } else {
                $.each(param, function(i) {
                	try {
                		var k = key == null ? i : key + (param instanceof Array ? "[" + i + "]" : "." + i);
                		var value = param[k];
                		if (value && value != null) {
                			paramStr += '&' + k + '=' + value;
                		}
                	} catch (e) {
                		console.log('帅不起来了~~~~~');
                	}
                });
            }
            return paramStr.substr(1);
        },
        
        
        /**
         * 获取当前请求URL中的参数值
         */
        getUrlParam: function (/** String */name) {   
    		var url = location.search;
    		var theRequest = new Object();
    		if (url.indexOf("?") != -1) {
    	    	var str = url.substr(1);
    	    	strs = str.split("&");
    	    	for(var i = 0; i < strs.length; i ++) {
    	        	theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
    	    	}
    		}
    		return theRequest[name];
    	},
        
        
        /**
         * 打开组织架构单选控件
         */
        openSingleSelectOrganiz: function (/**String*/showNode, /**String*/valueNode) {
        	var url = '/topage/component/singleSelectOrganiz?showNode=' + showNode + '&valueNode=' + valueNode;
        	layer.open({ title : '组织架构选择', type : 2, shade: 0.8, shadeClose : false, area : [ '800px', '600px' ], content : url });
        }
	};
	
	return module;
});