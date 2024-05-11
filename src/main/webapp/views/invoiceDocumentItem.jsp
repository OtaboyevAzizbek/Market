<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page import="java.util.List" %>
<%@ page import="com.market.dto.invoiceDocumentItem.InvoiceDocumentItemDTO" %>
<%@ page import="com.market.dto.invoiceDocument.InvoiceDocumentDTO" %>
<%@ page import="com.market.dto.product.ProductDTO" %>
<%@ include file="header.jsp"%>
<%List<InvoiceDocumentItemDTO> invoiceDocumentItemDTOS = (List<InvoiceDocumentItemDTO>) request.getAttribute("invoiceDocumentItemList");%>
<%List<InvoiceDocumentDTO> invoiceDocumentDTOList = (List<InvoiceDocumentDTO>) request.getAttribute("invoiceDocumentList");%>
<%List<ProductDTO> productDTOList = (List<ProductDTO>) request.getAttribute("productList");%>
<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">
    <button class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>Mahsulot kirim qilish</button>
</div>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <div class="card-body">
        <table class="table table-hover my-0 dataTable">
            <thead>
            <tr>
                <th>ID</th>
                <th>Yuk xati raqami</th>
                <th>Tashkilot nomi</th>
                <th>Mahsulot nomi</th>
                <th>Mahsulot miqdori</th>
                <th>O'lchov birligi</th>
                <th>Mahsulot narxi</th>
            </tr>
            </thead>
            <tbody>
            <% int count=1;%>
            <% for (InvoiceDocumentItemDTO documentItemDTO : invoiceDocumentItemDTOS) {%>
            <tr>
                <td><%=count++%></td>
                <td><%=documentItemDTO.getInvoiceDocument().getDocumentNumber()%></td>
                <td><%=documentItemDTO.getInvoiceDocument().getOrganization().getName()%></td>
                <td><%=documentItemDTO.getProduct().getName()%></td>
                <td><%=documentItemDTO.getAmount()%></td>
                <td><%=documentItemDTO.getProduct().getUnitType().getName()%></td>
                <td><%=documentItemDTO.getProductPrice()%></td>
            </tr>
            <%}%>
            </tbody>
        </table>
        </div>
    </div>
</div>
<%--Modal for insert--%>
<div class="modal fade bd-example-modal-c" aria-labelledby="exampleModalInvoiceDocItem2" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalInvoiceDocItem2"><b>Mahsulot kirim qilish</b></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="create_invoice_document_item" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleInvoiceDocItem2" class="form-label">Yuk xati raqami</label>
                        <select name="invoiceDocId" id="exampleInvoiceDocItem2" class="form-control" required>
                            <option value="" selected>Yuk xatini tanlang</option>
                            <% for (InvoiceDocumentDTO invoiceDocumentDTO : invoiceDocumentDTOList) {%>
                            <option value="<%=invoiceDocumentDTO.getId()%>">№ <%=invoiceDocumentDTO.getDocumentNumber()%> || <%=invoiceDocumentDTO.getOrganization().getName()%> || <%=invoiceDocumentDTO.getDate()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInvoiceDocItemProduct2" class="form-label">Mahsulot nomi</label>
                        <select name="productId" id="exampleInvoiceDocItemProduct2" class="form-control" required>
                            <option value="" selected>Mahsulot tanlang</option>
                            <% for (ProductDTO productDTO : productDTOList) {%>
                            <option value="<%=productDTO.getId()%>"><%=productDTO.getName()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleProductAmount2" class="form-label">Mahsulot miqdori</label>
                        <input type="text" name="amount" class="form-control" id="exampleProductAmount2" required>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger btn-sm" data-bs-dismiss="modal">Bekor qilish</button>
                        <button type="submit" class="btn btn-success btn-sm">Saqlash</button>
                    </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>