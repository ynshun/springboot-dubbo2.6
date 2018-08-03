define([

], function() {

	var module = {

		init : function(/**String or Node*/tableNode, /** String */ajaxDataUrl, /** Array */colums, /**Function*/searchFunction, opts) {
			if (typeof tableNode === 'string') {
				tableNode = $('#' + tableNode);
			}
			
			$.fn.dataTable.ext.errMode = 'none'; 
			
			var setting = module._config.mixin({
				'processing' : true,
				'serverSide' : true,
				'columns' : colums,
				'bFilter' : false,
				'oLanguage' : module._config.zh_language,
				'ajax' : {
					'url' : ajaxDataUrl,
					'type' : 'POST',
					'data': searchFunction || function (data) { }
				},
				"fnDrawCallback" : function() {
					var api = this.api();
					var startIndex = api.context[0]._iDisplayStart;
					api.column(0).nodes().each(function(cell, i) {
						cell.innerHTML = startIndex + i + 1;
					});
				},
				"dom": 'rt<"bottom"iflp>'
			}, opts);
			
			return $(tableNode).on( 'error.dt', function ( e, settings, techNote, message ) {
				alert('数据加载异常，请刷新页面后再试！');
		    } ).DataTable(setting);
		},
		
		
		initNoPage : function(/**String or Node*/tableNode, /** String */ajaxDataUrl, /** Array */colums, /**Function*/searchFunction, opts) {
			if (typeof tableNode === 'string') {
				tableNode = $('#' + tableNode);
			}
			
			$.fn.dataTable.ext.errMode = 'none'; 
			
			var setting = module._config.mixin({
				'processing' : true,
				"paging": false,
				'bFilter' : false,
				'columns' : colums,
				'oLanguage' : module._config.zh_language,
				'ajax' : {
					'url' : ajaxDataUrl,
					'type' : 'POST',
					'data': searchFunction || function (data) { }
				},
				"fnDrawCallback" : function() {
					var api = this.api();
					var startIndex = api.context[0]._iDisplayStart;
					api.column(0).nodes().each(function(cell, i) {
						cell.innerHTML = startIndex + i + 1;
					});
				},
			}, opts);
			return $(tableNode).on( 'error.dt', function ( e, settings, techNote, message ) {
				//console.log("error");
				window.location.href='/ucenter/login';
		    } ).DataTable(setting);
		},
		
		
		_config: {
			zh_language: {
				"sProcessing" : "正在获取数据，请稍后...",
				"sLengthMenu" : "显示 _MENU_ 条",
				"sZeroRecords" : '<div style="widht: 100%; text-align: center; color: red;">没有您要搜索的内容</div>',
				"sInfo" : "从 _START_ 到 _END_ / 共 _TOTAL_ 条数据",
				"sInfoEmpty" : "", // 记录数为0
				"sInfoFiltered" : "(全部记录数 _MAX_ 条)",
				"sInfoPostFix" : "",
				"sSearch" : "搜索",
				"sUrl" : "",
				"oPaginate" : {
					"sFirst" : "第一页",
					"sPrevious" : "上一页",
					"sNext" : "下一页",
					"sLast" : "最后一页"
				}
			},
			
			mixin: function (source, ext) {
				ext = ext || {};
				source  = source || {};
					
				for (var pro in ext) {
					source[pro] = ext[pro];
				}
				return source;
			}
		}
	};

	return module;
});