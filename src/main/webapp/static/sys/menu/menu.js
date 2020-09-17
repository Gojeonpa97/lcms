
layui.define(['layer','table','element','index', 'form','treetable'], function(exports){

  var treetable = layui.treetable,
  layer = layui.layer
      ,form = layui.form;
  form.render();
  //渲染表格
  var renderTable = function(){
    layer.load(2); //加载层
    treetable.render({
      id:'menu',
      treeColIndex: 1,	//树形图标显示在第几列
      treeSpid: '0',		//最上级的父级id
      treeIdName: 'id',	//id字段的名称
      treePidName: 'pid',	//父级节点字段
      treeDefaultClose: false,	//是否默认折叠
      treeLinkage: false,		//父级展开时是否自动展开所有子级
      elem: '#menu',	//表格id
      url: '/sys/menu/findAllMenu',
      toolbar: '#toolbarDemo',
      page: false,
      cols: [ [
        {type:'radio'},
        {field: 'name', title: '菜单名称'},
        {field: 'url' , title: '地址'},
        {field: 'icon' , hide : true, title: '图标'},
        {field: 'sort', title: '排序'},
          {title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-useradmin-webuser'}
      ] ],
      //数据渲染完的回调
      done: function () {
        //关闭加载
        layer.closeAll('loading');
      }

    });
  };
  renderTable();


  exports('menu', {}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});