layui.define(['laytpl', 'layer'], function(exports){
  var $ = layui.jquery
      ,layer = layui.layer

  //弹窗
  view.popup = function(options){
    var success = options.success
        ,skin = options.skin;

    delete options.success;
    delete options.skin;

    return layer.open($.extend({
      type: 1
      ,title: '提示'
      ,content: ''
      ,id: 'LAY-system-view-popup'
      ,skin: 'layui-layer-admin' + (skin ? ' ' + skin : '')
      ,shadeClose: true
      ,closeBtn: false
      ,success: function(layero, index){
        var elemClose = $('<i class="layui-icon" close>&#x1006;</i>');
        layero.append(elemClose);
        elemClose.on('click', function(){
          layer.close(index);
        });
        typeof success === 'function' && success.apply(this, arguments);
      }
    }, options))
  };
})