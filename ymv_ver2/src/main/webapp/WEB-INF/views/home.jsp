<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="section">
      <div class="container">
        <div class="row">
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
        <img src="${initParam.root}img/test1.jpg" style="width:300px; height:400px;">
      </div>

      <div class="item">
        <img src="${initParam.root}img/test2.jpg" style="width:300px; height:400px;">
      </div>
    
      <div class="item">
        <img src="${initParam.root}img/test3.jpg" style="width:300px; height:400px;">
      </div>

      <div class="item">
        <img src="${initParam.root}img/test4.jpg" style="width:300px; height:400px;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
            
          </div>
            <div class="col-md-6">
              <div class="col-md-10">
              <div align="center" >후기게시판</div>
                <table class="table">
                  <thead>
                    <tr>
                      <th class="success">#</th>
                      <th class="info">First Name</th>
                      <th class="info">Last Name</th>
                      <th class="info">Username</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>Mark</td>
                      <td>Otto</td>
                      <td>@mdo</td>
                    </tr>
                    <tr>
                      <td>2</td>
                      <td>Jacob</td>
                      <td>Thornton</td>
                      <td>@fat</td>
                    </tr>
                    <tr>
                      <td>3</td>
                      <td>Larry</td>
                      <td>the Bird</td>
                      <td>@twitter</td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
            <div class="col-md-6">
            	<div class="col-md-10">
            	<br><br>
           	    </div>
            </div>
            <div class="col-md-6">
              <div class="col-md-10">
                <table class="table">
                  <thead>
                    <tr>
                      <th class="danger">#</th>
                      <th class="warning">First Name</th>
                      <th class="warning">Last Name</th>
                      <th class="warning">Username</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>Mark</td>
                      <td>Otto</td>
                      <td>@mdo</td>
                    </tr>
                    <tr>
                      <td>2</td>
                      <td>Jacob</td>
                      <td>Thornton</td>
                      <td>@fat</td>
                    </tr>
                    <tr>
                      <td>3</td>
                      <td>Larry</td>
                      <td>the Bird</td>
                      <td>@twitter</td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>