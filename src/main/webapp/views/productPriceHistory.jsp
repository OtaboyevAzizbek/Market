<%@ page import="com.market.dto.product.ProductDTO" %>
<%@ page import="com.market.entity.ProductPurchasePrice" %>
<%@ page import="com.market.entity.ProductSellPrice" %>
<%@ include file="header.jsp"%>
<%ProductDTO productDTO = (ProductDTO) request.getAttribute("product");%>
<div class="row">
<div class="col-12 col-lg-6 col-xxl-9">
    <div class="card flex-fill">
        <table class="table table-hover my-0">
            <thead>
            <tr>
                <th>Xarid narxi ID</th>
                <th>Xarid narxi</th>
                <th>Narx o'zgarish vaqti</th>
            </tr>
            </thead>
            <tbody>
            <% int count=1;%>
            <% for (ProductPurchasePrice purchasePriceDTO : productDTO.getProductPurchasePriceList()) {%>
            <tr>
                <td><%=count++%></td>
                <td><%=purchasePriceDTO.getPrice()%></td>
                <td><%=purchasePriceDTO.getTimestamp()%></td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>
<div class="col-12 col-lg-6 col-xxl-9">
    <div class="card flex-fill">
        <table class="table table-hover my-0">
            <thead>
            <tr>
                <th>Sotuv narxi ID</th>
                <th>Sotuv narxi</th>
                <th>Narx o'zgarish vaqti</th>
            </tr>
            </thead>
            <tbody>
            <% int count1=1;%>
            <% for (ProductSellPrice productSellPrice : productDTO.getProductSellPriceList()) {%>
            <tr>
                <td><%=count1++%></td>
                <td><%=productSellPrice.getPrice()%></td>
                <td><%=productSellPrice.getTimestamp()%></td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>
</div>
<%@ include file="footer.jsp"%>