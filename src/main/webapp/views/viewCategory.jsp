<%@ page import="com.market.dto.category.CategoryDTO" %>
<%@ page import="com.market.entity.Product" %>
<%@ include file="header.jsp"%>
<%CategoryDTO categoryDTO = (CategoryDTO) request.getAttribute("category");%>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <div class="card-body">
        <table class="table table-hover my-0 dataTable">
            <thead>
            <tr>
                <th>ID</th>
                <th>Mahsulot nomi</th>
                <th>O'lchov birligi</th>
            </tr>
            </thead>
            <tbody>
            <% int count=1;%>
            <% for (Product product : categoryDTO.getProductList()) {%>
            <tr>
                <td><%=count++%></td>
                <td><%=product.getName()%></td>
                <td><%=product.getUnitType().getName()%></td>
            </tr>
            <%}%>
            </tbody>
        </table>
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>