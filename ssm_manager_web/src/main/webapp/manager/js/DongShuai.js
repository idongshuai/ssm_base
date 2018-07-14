layui.config({
  base:'js/'
}).use(['jquery','element','layer','navtab'],function(){
    window.jQuery = window.$ = layui.jquery;
	  window.layer = layui.layer;
    var element = layui.element(),
         navtab = layui.navtab({
               elem: '.DongShuai-tab-box'
         });

  
   //iframe自适应
  $(window).on('resize', function() {
    var $content = $('#DongShuai-tab .layui-tab-content');
    $content.height($(this).height() - 96);
    $content.find('iframe').each(function() {
      $(this).height($content.height());
    });
    tab_W = $('#DongShuai-tab').width();
    // DongShuai-footer：p-admin宽度设定
    var DongShuaiFoot = $('#DongShuai-footer').width();
    $('#DongShuai-footer p.p-admin').width(DongShuaiFoot - 300);
  }).resize();
  
  // 左侧菜单导航-->tab
$(function(){
    // 注入菜单
    // var $menu = $('.DongShuai-tab-menu');
    // console.log($menu);
    // $('#DongShuai-tab .layui-tab-title').append($menu);
    $('#DongShuai-nav-side').click(function(){
        if($(this).attr('lay-filter')!== undefined){
            $(this).children('ul').find('li').each(function(){
                var $this = $(this);
                if($this.find('dl').length > 0){
                   var $dd = $this.find('dd').each(function(){
                       $(this).click(function(){
                           var $a = $(this).children('a');
                           var href = $a.data('url');
                           var icon = $a.children('i:first').data('icon');
                           var title = $a.children('span').text();
                           var data = {
                                 href: href,
                                 icon: icon,
                                 title: title
                           }
                           navtab.tabAdd(data);
                       });
                   });
                }else{
                    $this.click(function(){
                           var $a = $(this).children('a');
                           var href = $a.data('url');
                           var icon = $a.children('i:first').data('icon');
                           var title = $a.children('span').text();
                           var data = {
                                 href: href,
                                 icon: icon,
                                 title: title
                           }
                           navtab.tabAdd(data);
                    });
                }
            });
        }
    })
})


});