<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
				
<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-3">
	
				<a href="voluntary_board.ymv">
				<div class="col-md-10">
						<img src="${initParam.root}img/main1.jpg" style="height: 180px;">
				</div>
				</a>
				<div class="col-md-10"><br><br></div>
				<!-- 왼쪽 2번째 칸 -->
			<a href="introduce_ymv.ymv">
				<div class="col-md-10">
					<img src="${initParam.root}img/main3.jpg" style="height: 180px;">
				</div>
				</a>
			</div>
			<div class="col-md-6">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
						<li data-target="#myCarousel" data-slide-to="3"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="${initParam.root}img/봉사1.jpg" >
						</div>

						<div class="item">
							<img src="${initParam.root}img/봉사2.jpg"
								style="width: 300px; height: 400px;">
						</div>

						<div class="item">
							<img src="${initParam.root}img/봉사3.jpg"
								style="width: 300px; height: 400px;">
						</div>

						<div class="item">
							<img src="${initParam.root}img/봉사4.jpg"
								style="width: 300px; height: 400px;">
						</div>
					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel" role="button"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel" role="button"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
		<div class="col-md-3">
					<a href="review_board.ymv">
				<div class="col-md-10">
					<img src="${initParam.root}img/main2.jpg" style="height: 180px;">
			
						</div>
						</a>
			<div class="col-md-10"><br><br></div>
				<!-- 왼쪽 2번째 칸 -->
			<a href="introduce_map.ymv">
				<div class="col-md-10">
					<img src="${initParam.root}img/main4.jpg" style="height: 180px;">
				</div>
				</a>
		</div>
			</div>
		</div>
	</div>
