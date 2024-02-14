<%@ page import="com.market.dto.organization.OrganizationDTO" %>
<%@ page import="com.market.entity.InvoiceDocument" %>
<%@ page import="com.market.dto.invoiceDocument.InvoiceDocumentDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.market.entity.InvoiceDocumentItem" %>
<%@ include file="header.jsp"%>
<%OrganizationDTO organizationDTO = (OrganizationDTO) request.getAttribute("organization");%>
<%List<InvoiceDocumentDTO> invoiceDocumentDTOList = (List<InvoiceDocumentDTO>) request.getAttribute("invoiceDocumentList");%>
<div class="row">
    <div class="col-12 col-lg-4 col-xxl-9">
    <div class="d-flex justify-content-end mb-2">
        <button class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>Yuk xati qo'shish</button>
    </div>
    </div>
    <div class="col-12 col-lg-8 col-xxl-9">
        <div class="d-flex justify-content-end mb-2">
                    <div class="col-md-4">
                        <input type="date" class="form-control">
                    </div>
                    <div class="col-md-4">
                        <input type="date" class="form-control">
                    </div>
                    <div class="col-md-4">
                        <button class="btn btn-primary">Search</button>
                    </div>
        </div>
</div>
<div class="row">
    <div class="col-12 col-lg-4 col-xxl-9">
        <div class="card flex-fill">
            <table class="table table-hover my-0">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Yuk xati raqami</th>
                    <th>Yuk xati sanasi</th>
                    <th>Amallar</th>
                </tr>
                </thead>
                <tbody>
                <% int count=1;%>
                <% for (InvoiceDocument invoiceDocument : organizationDTO.getInvoiceDocumentList()) {%>
                <tr>
                    <td><%=count++%></td>
                    <td><%=invoiceDocument.getDocumentNumber()%></td>
                    <td><%=invoiceDocument.getTimestamp()%></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/market/view_invoice_document_item/<%=invoiceDocument.getId()%>" class="btn btn-primary btn-sm"><i class="fa-solid fa-eye mx-sm-1"></i></a>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-12 col-lg-8 col-xxl-9">
        <div class="card flex-fill">
            <div class="card-body">
                <table class="table table-hover my-0 dataTable">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th class="d-none d-xl-table-cell">Mahsulot nomi</th>
                        <th class="d-none d-xl-table-cell">Mahsulot miqdori</th>
                        <th>O'lchov birligi</th>
                        <th class="d-none d-md-table-cell">Mahsulot narxi</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% int count2=1;%>
                    <% for (InvoiceDocumentDTO invoiceDocumentDTO : invoiceDocumentDTOList) {%>
                    <% for (InvoiceDocumentItem invoiceDocumentItem : invoiceDocumentDTO.getInvoiceDocumentItemList()) {%>
                    <tr>
                        <td><%=count2++%></td>
                        <td><%=invoiceDocumentItem.getProduct().getName()%></td>
                        <td><%=invoiceDocumentItem.getAmount()%></td>
                        <td><%=invoiceDocumentItem.getProduct().getUnitType().getName()%></td>
                        <td><%=invoiceDocumentItem.getPurchasePrice()%></td>
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