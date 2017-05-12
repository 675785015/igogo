
/**
 * Created by Jack on 2016/11/18.
 */
(function () {
    //页面公共对象
    var common = {
        apiOrigin: "localhost:8082",
        //获取url参数
        getUrlParam: function (name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]);
            else return null;
        },
        //显示文本内容
        toText: function (obj) {
            if (obj == null) {
                return '';
            }
            return obj.toString();
        },
        //将json日期格式化显示 数字转日期
        formatJsonDate: function (str, format) {
            if (str == null || str.length == 0) {
                return '';
            }
            str = str.replace(/T/g, " ").replace(/-/g, "/").substr(0, 19);
            var d = new Date(str);
            format = format || 'yyyy-MM-dd';
            return d.toFormatString(format);
        }
    };

    window.common = common;
})(jQuery);

//jQuery扩展
(function ($) {

    $(document).ajaxSend(function (event, jqxhr, settings) {
        if (settings.url.indexOf("/api") === 0) {
            settings.url = common.apiOrigin + settings.url;
            settings.xhrFields = {
                withCredentials: true
            };
            settings.crossDomain = true;
        }
    });
})

