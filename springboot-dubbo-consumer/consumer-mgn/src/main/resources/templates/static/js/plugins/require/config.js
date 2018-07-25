requirejs.config({

    baseUrl: '/static/js/',
    waitSeconds:0,
    paths: {
        //基础库
        'jquery'                    : 'component/jquery/1.11.1/jquery',                                 //IE6+
        'jquery2'                   : 'component/jquery/2.1.1/jquery',                                  //IE9+

    },

    shim : {
        'iscroll': {
            exports: 'IScroll'
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