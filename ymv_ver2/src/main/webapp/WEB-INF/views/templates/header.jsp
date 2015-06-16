<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <h2><a href="${initParam.root}home.do">로고</a>     메뉴 메뉴 메뉴 메뉴 </h2> --%>

<!doctype html>
<html lang=''>
<head>
   <meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script type="text/javascript">
(function($) {

	  $.fn.menumaker = function(options) {
	      
	      var cssmenu = $(this), settings = $.extend({
	        title: "Menu",
	        format: "dropdown",
	        sticky: false
	      }, options);

	      return this.each(function() {
	        cssmenu.prepend('<div id="menu-button">' + settings.title + '</div>');
	        $(this).find("#menu-button").on('click', function(){
	          $(this).toggleClass('menu-opened');
	          var mainmenu = $(this).next('ul');
	          if (mainmenu.hasClass('open')) { 
	            mainmenu.hide().removeClass('open');
	          }
	          else {
	            mainmenu.show().addClass('open');
	            if (settings.format === "dropdown") {
	              mainmenu.find('ul').show();
	            }
	          }
	        });

	        cssmenu.find('li ul').parent().addClass('has-sub');

	        multiTg = function() {
	          cssmenu.find(".has-sub").prepend('<span class="submenu-button"></span>');
	          cssmenu.find('.submenu-button').on('click', function() {
	            $(this).toggleClass('submenu-opened');
	            if ($(this).siblings('ul').hasClass('open')) {
	              $(this).siblings('ul').removeClass('open').hide();
	            }
	            else {
	              $(this).siblings('ul').addClass('open').show();
	            }
	          });
	        };

	        if (settings.format === 'multitoggle') multiTg();
	        else cssmenu.addClass('dropdown');

	        if (settings.sticky === true) cssmenu.css('position', 'fixed');

	        resizeFix = function() {
	          if ($( window ).width() > 768) {
	            cssmenu.find('ul').show();
	          }

	          if ($(window).width() <= 768) {
	            cssmenu.find('ul').hide().removeClass('open');
	          }
	        };
	        resizeFix();
	        return $(window).on('resize', resizeFix);

	      });
	  };
	})(jQuery);

	(function($){
	$(document).ready(function(){

	$("#cssmenu").menumaker({
	   title: "Menu",
	   format: "multitoggle"
	});


	});
	})(jQuery);

</script>
   <title>CSS MenuMaker</title>
</head>
<body>
<br><br><br><br>
<div id='cssmenu' align="center">
<ul>
   <li><a href='testTiles.ymv'>Home</a></li>
   <li class='active'><a href='#'>너나봉이란?</a>
      <ul>
         <li><a href='#'>너나봉 소개</a>
<!--             <ul>
               <li><a href='#'>Sub Product</a></li>
               <li><a href='#'>Sub Product</a></li>
            </ul> -->
         </li>
         <li><a href='#'>찾아오시는 길</a>
<!--             <ul>
               <li><a href='#'>Sub Product</a></li>
               <li><a href='#'>Sub Product</a></li>
            </ul> -->
         </li>
      </ul>
   </li>
   <li class='active'><a href='#'>봉사</a>
      <ul>
         <li><a href='#'>통합검색</a></li>
         <li><a href='voluntary_board.ymv'>전체목록</a></li>
      	 <li><a href='#'>봉사신청내역확인</a></li>
      </ul>
   </li> 
 <li class='active'><a href='#'>기업</a>
      <ul>
         <li><a href='voluntary_register_view.ymv'>봉사등록</a></li>
         <li><a href='voluntary_board_company.ymv'>봉사등록확인</a>
         </li>
      </ul>
   </li>
 <li class='active'><a href='#'>커뮤니티</a>
      <ul>
      	<li><a href='review_board.ymv'>봉사후기</a></li>
         <li><a href='notice_board.ymv'>공지사항</a></li>
         <li><a href='${initParam.root }qna_board.ymv'>Q & A</a>
         </li>
      </ul>
   </li>
</ul>
</div>

</body>
