<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <meta charset="UTF-8">
    <title>AdminLTE 2 | Flot Charts</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>

    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <%-- <link href="${initParam.root}chart/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" /> --%>
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
    <%-- <link href="${initParam.root}chart/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" /> --%>
      
      <div class = "col-sm-6 col-sm-offset-3">
        <div class="box box-primary">
                <div class="box-header with-border">
                  <h1 class="box-title"><p  class = "text-center">봉사 분야별 선호도</p></h1>
                  <i class="fa fa-bar-chart-o"></i>
                </div>
                <div class="box-body">
                  <div id="bar-chart" style="height: 300px;"></div>
                </div><!-- /.box-body-->
              </div><!-- /.box -->
              </div>
              <!-- FLOT CHARTS -->
    <script src="${initParam.root}chart/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
    <!-- FLOT RESIZE PLUGIN - allows the chart to redraw when the window is resized -->
    <script src="${initParam.root}chart/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
    <!-- FLOT PIE PLUGIN - also used to draw donut charts -->
    <script src="${initParam.root}chart/plugins/flot/jquery.flot.pie.min.js" type="text/javascript"></script>
    <!-- FLOT CATEGORIES PLUGIN - Used to draw bar charts -->
    <script src="${initParam.root}chart/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
              
        <script type="text/javascript">
        $(function () {
        	var environmentValue = "${requestScope.environmentValue }";
        	var oldValue = "${requestScope.oldValue }";
        	var newValue = "${requestScope.newValue }";
        	var animalValue = "${requestScope.animalValue }";
        	var disabilityValue = "${requestScope.disabilityValue }";

var bar_data = {
          data: [["노인", oldValue], ["환경", environmentValue], ["아동", newValue], ["동물", animalValue], ["장애", disabilityValue]],
          color: "#3c8dbc"
        };
        $.plot("#bar-chart", [bar_data], {
          grid: {
            borderWidth: 1,
            borderColor: "#f3f3f3",
            tickColor: "#f3f3f3"
          },
          series: {
            bars: {
              show: true,
              barWidth: 0.5,
              align: "center"
            }
          },
          xaxis: {
            mode: "categories",
            tickLength: 0
          }
        });
        });

        </script>
        
        
        
        
        
        
        
        
        <%-- 
<center>
	<div class="container">
		<h2>전체 선호도 순위</h2>
		<div class="row">
			<div class = "col-md-3">
			</div>
			<div class="col-md-6 col-sm-6">
				<table class="table table-striped table-hover">
					<tr>
						<th>순위</th>
						<th>분야</th>
						<th>신청수</th>
						<!-- 	<th>나이</th> -->
					</tr>
					<c:forEach items="${requestScope.list}" var="i">
						<tr>
							<th>${i.RANKING }</th>
							<td>${i.FIELD }</td>
							<td>${i.COUNT }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</center>

 --%>
























<%-- <br><br>
		<table border="1" cellpadding="5">
			<tr>
				<th>순위</th>
				<th>분야</th>
				<th>신청수</th>
				<th>나이</th>
			</tr>
			<c:forEach items="${requestScope.list}" var="i">
				<tr>
					<td>${i.RANKING }</td>
					<td>${i.FIELD }</td>
					<td>${i.APPLICATE_COUNT }</td>
					<td>${i.AGE }</td>
					<!-- {RANKING=1, FIELD=아동, AGE=20, APPLICATE_COUNT=18} -->
				</tr>
			</c:forEach>
		</table> --%>