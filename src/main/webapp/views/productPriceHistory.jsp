<%@ page import="com.market.dto.product.ProductDTO" %>
<%@ page import="com.market.entity.ProductPriceHistory" %>
<%@ page import="com.market.status.ProductPriceType" %>
<%@ include file="header.jsp"%>
<%ProductDTO productDTO = (ProductDTO) request.getAttribute("product");%>
<div class="row">
    <div class="d-flex justify-content-center mb-3">
        <h1 style="font-family: Georgia,serif"><b><%=productDTO.getName()%></b> narxining o'zgarishlar tarixi</h1>
    </div>
<div class="col-12 col-lg-6 col-xxl-9">
    <div class="card flex-fill">
        <div class="card-body">
        <table class="table table-hover my-0 dataTable">
            <thead>
            <tr>
                <th>Xarid narxi ID</th>
                <th>Xarid narxi</th>
                <th>Narx o'zgarish vaqti</th>
            </tr>
            </thead>
            <tbody>
            <% int count=1;%>
            <% for (ProductPriceHistory productPriceHistory : productDTO.getProductPriceHistoryList()) {%>
            <%if (productPriceHistory.getProductPriceType().equals(ProductPriceType.BUY)){%>
            <tr>
                <td><%=count++%></td>
                <td><%=productPriceHistory.getPrice()%></td>
                <td><%=productPriceHistory.getTimestamp()%></td>
            </tr>
            <%}%>
            <%}%>
            </tbody>
        </table>
        </div>
    </div>
</div>
<div class="col-12 col-lg-6 col-xxl-9">
    <div class="card flex-fill">
        <div class="card-body">
        <table class="table table-hover my-0 dataTable">
            <thead>
            <tr>
                <th>Sotuv narxi ID</th>
                <th>Sotuv narxi</th>
                <th>Narx o'zgarish vaqti</th>
            </tr>
            </thead>
            <tbody>
            <% int count1=1;%>
            <% for (ProductPriceHistory productPriceHistory : productDTO.getProductPriceHistoryList()) {%>
            <%if (productPriceHistory.getProductPriceType().equals(ProductPriceType.SELL)){%>
            <tr>
                <td><%=count1++%></td>
                <td><%=productPriceHistory.getPrice()%></td>
                <td><%=productPriceHistory.getTimestamp()%></td>
            </tr>
            <%}%>
            <%}%>
            </tbody>
        </table>
        </div>
    </div>
</div>
</div>
<%@ include file="footer.jsp"%>