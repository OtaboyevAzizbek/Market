<%@ page import="com.market.dto.organization.OrganizationDTO" %>
<%@ page import="com.market.entity.InvoiceDocument" %>
<%@ include file="header.jsp"%>
<%OrganizationDTO organizationDTO = (OrganizationDTO) request.getAttribute("organization");%>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <table class="table table-hover my-0">
            <thead>
            <tr>
                <th>ID</th>
                <th>Yuk xati raqami</th>
                <th>Yuk xati sanasi</th>
            </tr>
            </thead>
            <tbody>
            <% int count=1;%>
            <% for (InvoiceDocument invoiceDocument : organizationDTO.getInvoiceDocumentList()) {%>
            <tr>
                <td><%=count++%></td>
                <td><%=invoiceDocument.getDocumentNumber()%></td>
                <td><%=invoiceDocument.getTimestamp()%></td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>
<%@ include file="footer.jsp"%>