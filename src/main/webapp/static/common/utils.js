'use strict';


/**
 * restful风格 异步请求
 * @param {Object} url 请求地址
 * @param {Object} type 请求类型
 * @param {Object} param 参数
 * @param {Object} successCallBack 成功回调
 * @param {Object} errorCallBack 失败回调
 */
jQuery.RestAjax = function (url, type, param, successCallBack, errorCallBack) {
    AjaxRequest(url, type, true, param, successCallBack, errorCallBack);
}

/**
 * restful风格  同步请求
 * @param {Object} url 请求地址
 * @param {Object} type 请求类型
 * @param {Object} param 参数
 * @param {Object} successCallBack 成功回调
 * @param {Object} errorCallBack 失败回调
 */
jQuery.RestSyncAjax = function (url, type, param, successCallBack, errorCallBack) {
    AjaxRequest(url, type, false, param, successCallBack, errorCallBack);
}
function AjaxRequest(url, type, async, param, successCallBack, errorCallBack) {
    // 查询时 处理过滤条件和排序
    if (type.toLowerCase() == 'get') {
        if (param) {
            var filters = param.filters;
            if (filters && filters.toString().indexOf('[object Object]') > -1) {
                filters = JSON.stringify(filters);
                param.filters = filters;
            }
            var sorts = param.sorts;
            if (sorts && sorts.toString().indexOf('[object Object]') > -1) {
                sorts = JSON.stringify(sorts);
                param.sorts = sorts;
            }
        }
    }
    $.ajax({
        type: type,
        dataType: 'json',
        headers: {
            "Content-Type": "application/json;charse=UTF-8",
            "If-Modified-Since": "0",
        },
        async: async,
        data: type.toLowerCase() == 'get' ? param : JSON.stringify(param),
        url:  url,
        success: function (data) {
            if (!data.success) {
                if (data.errorCode == 'E10001') {
                    $.showNotCloseMessage("系统内部异常！", 'error');
                } else {
                    $.showNotCloseMessage(data.errorMessage, 'error');
                }
            }
            successCallBack(data);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            if (errorCallBack) {
                errorCallBack(XMLHttpRequest.responseJSON);
            } else {
                console.error('******************请求失败：' + XMLHttpRequest.status + '**************************');
            }
        }
    });
}

/**
 * 从url上获取参数
 * @param {Object} name
 */
jQuery.getParamByUrl = function (name) {
    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
};

/**
 * 显示通知消息
 * @param {Object} message 消息内容
 * @param {Object} template 消息类型('info','warning','success','error')
 * @param {Object} clossCallBack 消息窗口关闭回调
 */
jQuery.showMessage = function (message, template, clossCallBack) {
    layer.msg(message, {time: 1000, icon: getIconType(template)}, function () {
        if (clossCallBack) {
            clossCallBack();
        }
    });
};

/**
 * 显示不自动关闭的通知消息
 * @param {Object} message 消息内容
 * @param {Object} template 消息类型('info','warning','success','error','mail','time')
 * @param {Object} clossCallBack 消息窗口关闭回调
 */
jQuery.showNotCloseMessage = function (message, template, clossCallBack) {
    layer.alert(message, {icon: getIconType(template)});
};
// 获取layer图标
function getIconType(template) {
    var icon = -1;
    if (template.toLowerCase() == 'error') {
        icon = 2
    } else if (template.toLowerCase() == 'success') {
        icon = 1
    } else if (template.toLowerCase() == 'warning') {
        icon = 0
    } else {
        icon = -1;
    }
    return icon;
}
/**
 * confrim窗口
 * @param {Object} message 显示的信息
 * @param {Object} okCallBack 确定回调
 * @param {Object} closeCallBack 取消回调
 */
jQuery.showConfirm = function (message, okCallBack, closeCallBack) {
    layer.msg("12312");
    layer.confirm(message, {
        btn: ['确定', '取消'],
        icon: 3
    }, function (layerIndex) {
        if (okCallBack) {
            okCallBack();
            layer.close(layerIndex);
        }
    }, function (layerIndex) {
        if (closeCallBack) {
            closeCallBack();
            layer.close(layerIndex);
        }
    });
}

/**
 * 常量枚举
 */
jQuery.getConstantEnum = function (type) {
    var result = {
        datatype: "json",
        datafields: [
            {name: 'value'},
            {name: 'text'}
        ],
        localdata: []
    };
    switch (type) {
        //性别
        case "gender":
            result.localdata = [
                {value: 'MALE', text: '男'},
                {value: 'FEMALE', text: '女'}
            ];
            break;
    }
    return result;
};