<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>YMV Main</title>
<script type="text/javascript">
	$(document).ready(function(){
		$("#searchBtn").click(function(){
			if($("#search").val()=="" || $("#search").val()==null){
				alert("검색어를 입력하세요!");
				return false;
			}else{
				//alert($("#search").val());
				location.href="search_boards.ymv?search="+$("#search").val();
			}
		});
		
	});

</script>
<c:choose>
<c:when test="${sessionScope.mvo.memberType=='admin' }">

<div>
<a href="${initParam.root }testTiles.ymv"><img src="${initParam.root }/img/logo.jpg" style="position: relative;left: 40%;"></a>
<nav class="navbar navbar-default" >
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${initParam.root }testTiles.ymv">Home</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
                <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">너나봉이란 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="${initParam.root }introduce_ymv.ymv">너나봉 소개</a></li>
            <li><a href="${initParam.root }introduce_how_ymv.ymv">about 너나봉</a></li>
            <li><a href="${initParam.root }introduce_administrator.ymv">직원 소개</a></li>
            <li class="divider"></li>
            <li><a href="${initParam.root }introduce_map.ymv">찾아오는 길</a></li>
          </ul>
        </li>
                <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">봉사<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="${initParam.root }search_view.ymv">통합검색</a></li>
            <li><a href="${initParam.root }voluntary_board.ymv">봉사전체목록</a></li>
            <li><a href="${initParam.root }voluntary_board_normal.ymv">봉사 신청 내역 확인</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">커뮤니티<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="${initParam.root }review_board.ymv">봉사후기</a></li>
            <li><a href="${initParam.root }notice_board.ymv">공지사항</a></li>
            <li><a href="${initParam.root }qna_board.ymv">Q & A</a></li>
          </ul>
        </li>
        <%--기업 --%>
                <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">기업 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="${initParam.root }voluntary_register_view.ymv">봉사등록</a></li>
            <li><a href="${initParam.root }voluntary_board_company.ymv">봉사 등록 확인</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">통계<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="${initParam.root }voluntary_statistics.ymv">전체통계</a></li>
            <li><a href="${initParam.root }voluntary_statisticsByAge.ymv">나이별 선호 봉사</a></li>
          </ul>
        </li>
      </ul>
     
      <ul class="nav navbar-nav navbar-right">
       <form class="navbar-form navbar-right" role="search" id="searchForm">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="검색해주세요" id="search">
        </div>
        <button type="button" class="btn btn-default" id="searchBtn">검색</button>
      </form>
      </ul>
    </div>
  </div>
</nav>
</div>

</c:when>
<c:otherwise>

<div>
<a href="${initParam.root }testTiles.ymv"><img src="${initParam.root }/img/logo.jpg" style="position: relative;left: 40%;"></a>
<nav class="navbar navbar-default" >
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${initParam.root }testTiles.ymv">Home</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
                <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">너나봉이란 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="${initParam.root }introduce_ymv.ymv">너나봉 소개</a></li>
            <li><a href="${initParam.root }introduce_how_ymv.ymv">about 너나봉</a></li>
            <li><a href="${initParam.root }introduce_administrator.ymv">직원 소개</a></li>
            <li class="divider"></li>
            <li><a href="${initParam.root }introduce_map.ymv">찾아오는 길</a></li>
          </ul>
        </li>
                <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">봉사<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="${initParam.root }search_view.ymv">통합검색</a></li>
            <li><a href="${initParam.root }voluntary_board.ymv">봉사전체목록</a></li>
            <c:choose>
            <c:when test="${sessionScope.mvo.memberType=='normal' }">
            <li><a href="${initParam.root }voluntary_board_normal.ymv">봉사 신청 내역 확인</a></li>
            </c:when>
            <c:when test="${sessionScope.mvo.memberType=='admin' }">
            <li><a href="${initParam.root }voluntary_board_normal.ymv">봉사 신청 내역 확인</a></li>
            </c:when>
            <c:otherwise>
            <li class="disabled"><a>봉사 신청 내역 확인</a></li>
            </c:otherwise>
            </c:choose>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">커뮤니티<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="${initParam.root }review_board.ymv">봉사후기</a></li>
            <li><a href="${initParam.root }notice_board.ymv">공지사항</a></li>
            <li><a href="${initParam.root }qna_board.ymv">Q & A</a></li>
          </ul>
        </li>
        <%--기업 --%>
        <c:choose>
        <c:when test="${sessionScope.mvo.memberType=='company' }">
                <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">기업 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="${initParam.root }voluntary_register_view.ymv">봉사등록</a></li>
            <li><a href="${initParam.root }voluntary_board_company.ymv">봉사 등록 확인</a></li>
          </ul>
        </li>
        </c:when>
        </c:choose>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">통계<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="${initParam.root }voluntary_statistics.ymv">전체통계</a></li>
            <li><a href="${initParam.root }voluntary_statisticsByAge.ymv">나이별 선호 봉사</a></li>
          </ul>
        </li>
      </ul>
     
      <ul class="nav navbar-nav navbar-right">
       <form class="navbar-form navbar-right" role="search" id="searchForm">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="검색해주세요" id="search">
        </div>
        <button type="button" class="btn btn-default" id="searchBtn">검색</button>
      </form>
      </ul>
    </div>
  </div>
</nav>
</div>

</c:otherwise>
</c:choose>

<%--    
<a href="testTiles.ymv"><img src="${initParam.root }/img/logo.jpg"></a>
<div id='cssmenu' align="center">
<ul>
   <li><a href='testTiles.ymv'>Home</a></li>
   <li class='active'><a href='#'>너나봉이란?</a>
      <ul>
         <li><a href='introduce_ymv.ymv'>너나봉 소개</a>
                 <ul>
               <li><a href='introduce_ymv.ymv'>너나봉 소개</a></li>
               <li><a href='introduce_how_ymv.ymv'>About 너나봉 </a></li>
            </ul>  </li>
          <li><a href='introduce_administrator.ymv'>너나봉 직원 소개</a>   
         <li><a href='introduce_map.ymv'>찾아오시는 길</a>

         </li>
      </ul>
   </li>
   <li class='active'><a href='#'>봉사</a>
      <ul>
         <li><a href='search_view.ymv'>통합검색</a></li>
         <li><a href='voluntary_board.ymv'>전체목록</a></li>
      	 <li><a href='voluntary_board_normal.ymv'>봉사신청내역확인</a></li>
      </ul>
   </li> 
   <c:choose>
   <c:when test="${sessionScope.mvo.memberType=='company' }">
   <li class='active'><a href='#'>기업</a>
      <ul>
         <li><a href='voluntary_register_view.ymv'>봉사등록</a></li>
         <li><a href='voluntary_board_company.ymv'>봉사등록확인</a>
         </li>
      </ul>
   </li>
   </c:when>
   <c:otherwise>
   </c:otherwise>
   </c:choose>
 <li class='active'><a href='#'>커뮤니티</a>
      <ul>
      	<li><a href='review_board.ymv'>봉사후기</a></li>
         <li><a href='notice_board.ymv'>공지사항</a></li>
         <li><a href='${initParam.root }qna_board.ymv'>Q & A</a>
         </li>
      </ul>
   </li>
    <li class='active'><a href='#'>통계</a>
      <ul>
      <li><a href='voluntary_statistics.ymv'>전체 통계</a></li>
         <li><a href='voluntary_statisticsByAge.ymv'>나이별 선호 봉사활동</a></li>
      </ul>
   </li>
</ul>
</div> --%>

