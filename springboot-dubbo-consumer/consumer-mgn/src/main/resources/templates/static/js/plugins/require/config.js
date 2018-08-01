requirejs.config({

    baseUrl: '/static/js/',
    waitSeconds:0,
    paths: {
        'layer'                     : 'plugins/layer/2.4.0/layer',
    },

    shim : {
    	'layer': {
            deps: ['css!plugins/layer/2.4.0/skin/layer']
        },
        'laydate': {
            exports: 'laydate',
            deps:['css!component/laydate/1.1.0/need/laydate']
        },
    },

    map: {
      '*': {
        'css'       : 'plugins/require/plugin/css/0.1.8/css'
       }
    },

    /**
     * 此参数在正式上线时请修改为实际的版本号
     */
    urlArgs: (function(){
        var date = new Date();
        var Y = date.getFullYear(),
            M = date.getMonth()+1,
            D = date.getDate(),
            h = date.getHours(),
            m = date.getMinutes(),
            s = date.getSeconds();

        return "v=" + Y + M + D + h + m + s;
    })()
});