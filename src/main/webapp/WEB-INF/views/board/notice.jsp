<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../layout/header.jsp" />

<div class="container-md">

	<table class="table table-striped table-hover">
	  <thead>
		  	<tr>
		  		<th scope="col">#</th>
		  		<th scope="col">title</th>
		  		<th scope="col">writer</th>
		  		<th scope="col">regDate</th>
		  		<th scope="col">readCount</th>
		  	</tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${list }" var="bvo">
	  		<tr>
	  			<td>${bvo.bno }</td>
	  			<td>
	  				<a href="/board/detail?bno=${bvo.bno }">${bvo.title }</a>
		  			<c:if test="${bvo.cmtQty > 0}">
		  					[${bvo.cmtQty }]
		  			</c:if>
		  			<%-- <c:if test="${bvo.hasFile > 0 }">
			  			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-floppy-fill" viewBox="0 0 16 16">
						  <path d="M0 1.5A1.5 1.5 0 0 1 1.5 0H3v5.5A1.5 1.5 0 0 0 4.5 7h7A1.5 1.5 0 0 0 13 5.5V0h.086a1.5 1.5 0 0 1 1.06.44l1.415 1.414A1.5 1.5 0 0 1 16 2.914V14.5a1.5 1.5 0 0 1-1.5 1.5H14v-5.5A1.5 1.5 0 0 0 12.5 9h-9A1.5 1.5 0 0 0 2 10.5V16h-.5A1.5 1.5 0 0 1 0 14.5z"/>
						  <path d="M3 16h10v-5.5a.5.5 0 0 0-.5-.5h-9a.5.5 0 0 0-.5.5zm9-16H4v5.5a.5.5 0 0 0 .5.5h7a.5.5 0 0 0 .5-.5zM9 1h2v4H9z"/>
						</svg>
					(${bvo.hasFile })
		  			</c:if> --%>
	  			</td>
	  			<td>${bvo.writer }</td>
	  			<td>${bvo.regDate }</td>
	  			<td>${bvo.readCnt }</td>
	  		</tr>
  		</c:forEach>
	  </tbody>
	</table>
</div>

<!-- Pagination line -->
<nav aria-label="Page navigation example">
	<!-- 왼쪽 화살표 -->
	<!--  -->
  <ul class="pagination justify-content-center">
    <li class="page-item ${ph.prev eq false ? 'disabled':'' }">
      <a class="page-link" href="/board/free?pageNo=${ph.startPage-1 }&qty=${ph.pgvo.qty}&type=${ph.pgvo.type }&keyword=${ph.pgvo.qty}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    
    <!-- 반복되는 페이징 넘버-->
    <c:forEach begin="${ph.startPage }" end="${ph.endPage }" var="i">
    	<li class="page-item"><a class="page-link ${ph.pgvo.pageNo eq i? 'active':'' }" href="/board/free?pageNo=${i }&qty=${ph.pgvo.qty}&type=${ph.pgvo.type }&keyword=${ph.pgvo.qty}">${i }</a></li>
    </c:forEach>
    
    <!-- 오른쪽 화살표 -->
    <li class="page-item ${ph.next eq false ? 'disabled':'' }">
      <a class="page-link" href="/board/free?pageNo=${ph.endPage+1 }&qty=${ph.pgvo.qty}&type=${ph.pgvo.type }&keyword=${ph.pgvo.qty}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
<jsp:include page="../layout/footer.jsp" />	