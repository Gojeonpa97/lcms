layui.define('view', function(exports) {
  var $ = layui.jquery
      ,view = layui.view
      ,admin = {
    //弹出面板
    popup: view.popup

    //右侧面板
    ,popupRight: function(options){
      return admin.popup.index = layer.open($.extend({
        type: 1
        ,id: 'LAY_adminPopupR'
        ,anim: -1
        ,title: false
        ,closeBtn: false
        ,offset: 'r'
        ,shade: 0.1
        ,shadeClose: true
        ,skin: 'layui-anim layui-anim-rl layui-layer-adminRight'
        ,area: '300px'
      }, options));
    }

  }
})
