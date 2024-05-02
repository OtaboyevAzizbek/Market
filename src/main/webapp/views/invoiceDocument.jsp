<%@ page import="com.market.dto.invoiceDocument.InvoiceDocumentDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.market.dto.organization.OrganizationDTO" %>
<%@ include file="header.jsp"%>
<%List<InvoiceDocumentDTO> invoiceDocumentDTOList = (List<InvoiceDocumentDTO>) request.getAttribute("invoiceDocumentList");%>
<%List<OrganizationDTO> organizationList = (List<OrganizationDTO>) request.getAttribute("organizationList");%>
<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">
    <button class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>Yuk xati qo'shish</button>
</div>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <div class="card-body">
        <table class="table table-hover my-0 dataTable">
            <thead>
            <tr>
                <th style="width:3%;">ID</th>
                <th style="width:10%;">Yuk xati raqami</th>
                <th style="width:32%;">Tashkilot nomi</th>
                <th style="width:15%;">Yuk xati summasi</th>
                <th style="width:10%;">Yuk xati sanasi</th>
                <th style="width:30%;">Amallar</th>
            </tr>
            </thead>
            <tbody>
            <% int count=1;%>
            <% for (InvoiceDocumentDTO invoiceDocumentDTO : invoiceDocumentDTOList) {%>
            <tr>
                <td><%=count++%></td>
                <td><%=invoiceDocumentDTO.getDocumentNumber()%></td>
                <td><%=invoiceDocumentDTO.getOrganization().getName()%></td>
                <td><%=invoiceDocumentDTO.getTotalSumma()%></td>
                <td><%=invoiceDocumentDTO.getDate()%></td>
                <td>
                    <a href="<%=request.getContextPath()%>/market/view_invoice_document_item/<%=invoiceDocumentDTO.getId()%>" class="btn btn-primary btn-sm"><i class="fa-solid fa-eye mx-sm-1"></i>Ko'rish</a>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-a<%=invoiceDocumentDTO.getId()%>" class="btn btn-warning btn-sm"><i class="fa-solid fa-pen-to-square mx-sm-1"></i>O'zgartirish</button>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-b<%=invoiceDocumentDTO.getId()%>" class="btn btn-danger btn-sm"><i class="fa-solid fa-trash-can mx-sm-1"></i>O'chirish</button>
                </td>
                <%--Modal for delete--%>
                <div class="modal fade bd-example-modal-b<%=invoiceDocumentDTO.getId()%>" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title"><b>Yuk xati o'chirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h4>Haqiqatan ham o'chirib tashlamoqchimisiz?</h4>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary btn-sm" data-bs-dismiss="modal">Bekor qilish</button>
                                <a href="<%=request.getContextPath()%>/market/delete_invoice_document/<%=invoiceDocumentDTO.getId()%>" class="btn btn-danger btn-sm">O'chirish</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%--Modal for update--%>
                <div class="modal fade bd-example-modal-a<%=invoiceDocumentDTO.getId()%>" aria-labelledby="exampleModalEditCategory" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="exampleModalEditCategory"><b>Yuk xati o'zgartirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form action="update_invoice_document" method="post">
                                <input type="hidden" name="id" value="<%=invoiceDocumentDTO.getId()%>">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="exampleDocNumber" class="form-label">Yuk xati raqami</label>
                                        <input type="text" name="docNum" class="form-control" id="exampleDocNumber" value="<%=invoiceDocumentDTO.getDocumentNumber()%>" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleOrganization2" class="form-label">Tashkilot nomi</label>
                                        <select name="organizationId" id="exampleOrganization2" class="form-control" required>
                                            <option value="" selected>Tashkilotni tanlang</option>
                                            <% for (OrganizationDTO organizationDTO : organizationList) {%>
                                            <option value="<%=organizationDTO.getId()%>" <%=organizationDTO.getId()==invoiceDocumentDTO.getOrganization().getId() ? "selected":"" %>><%=organizationDTO.getName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleDate" class="form-label">Yuk xati sanasi</label>
                                        <input type="datetime-local" step="2" name="date" class="form-control datetimeInput" id="exampleDate" value="<%=invoiceDocumentDTO.getTimestamp()%>" required>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-danger btn-sm" data-bs-dismiss="modal">Bekor qilish</button>
                                        <button type="submit" class="btn btn-success btn-sm">Saqlash</button>
                                    </div>
                            </form>
                        </div>
                    </div>
                </div>
            </tr>
            <%}%>
            </tbody>
        </table>
        </div>
    </div>
</div>
<%--Modal for insert--%>
<div class="modal fade bd-example-modal-c" aria-labelledby="exampleModalInvoiceDocument2" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalInvoiceDocument2"><b>Yangi yuk xati qo'shish</b></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="create_invoice_document" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleDocNumber2" class="form-label">Yuk xati raqami</label>
                        <input type="text" name="docNum" class="form-control exampleDocumentNumber2" id="exampleDocNumber2" required>
                        <div id="validationServerFeedback" class="invalid-feedback">
                            Bu raqamdagi yuk xati allaqachon mavjud!
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="exampleOrganization" class="form-label">Tashkilot nomi</label>
                        <select name="organizationId" id="exampleOrganization" class="form-control" required>
                            <option value="" selected>Tashkilotni tanlang</option>
                            <% for (OrganizationDTO organizationDTO : organizationList) {%>
                            <option value="<%=organizationDTO.getId()%>"><%=organizationDTO.getName()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleDate2" class="form-label">Yuk xati sanasi</label>
                        <input type="date" name="date" class="form-control" id="exampleDate2" required>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger btn-sm" data-bs-dismiss="modal">Bekor qilish</button>
                        <button type="submit" class="btn btn-success btn-sm saveButton">Saqlash</button>
                    </div>
            </form>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        $("#exampleOrganization, #exampleDocNumber2, #exampleDate2").on("change", function () {
            checkInvoiceDocumentNumberAJAX();
        });
    });
    function checkInvoiceDocumentNumberAJAX() {
        let organizationId = $("#exampleOrganization").val();
        let documentNumber = $("#exampleDocNumber2").val();
        let date = $("#exampleDate2").val();

        if (organizationId && documentNumber && date) {
            $.ajax({
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: '/market/check_invoice_document',
                type: "POST",
                data: {
                    organizationId: organizationId,
                    docNumber: documentNumber,
                    date: date
                },
                dataType: "json",
                success: function (data) {
                    if (data === true) {
                        $(".exampleDocumentNumber2").addClass("is-invalid");
                        $(".saveButton").prop('disabled', true);
                    } else {
                        $(".exampleDocumentNumber2").removeClass("is-invalid");
                        $(".saveButton").prop('disabled', false);
                    }
                },
                error: function () {
                    alert("Xatolik yuz berdi");
                }
            });
        }
    }
</script>
<%@ include file="footer.jsp"%>