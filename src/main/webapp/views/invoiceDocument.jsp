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
        <table class="table table-hover my-0" id="invoiceDocumentTable">
            <thead>
            <tr>
                <th>ID</th>
                <th>Yuk xati raqami</th>
                <th>Tashkilot nomi</th>
                <th>Yuk xati sanasi</th>
                <th>Amallar</th>
            </tr>
            </thead>
            <tbody>
            <% int count=1;%>
            <% for (InvoiceDocumentDTO invoiceDocumentDTO : invoiceDocumentDTOList) {%>
            <tr>
                <td><%=count++%></td>
                <td><%=invoiceDocumentDTO.getDocumentNumber()%></td>
                <td><%=invoiceDocumentDTO.getOrganization().getName()%></td>
                <td><%=invoiceDocumentDTO.getTimestamp()%></td>
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
                                        <input type="datetime-local" step="2" name="date" class="form-control datetimeInput" id="exampleDate" required>
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
                        <input type="text" name="docNum" class="form-control" id="exampleDocNumber2" required>
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
                        <input type="datetime-local" step="2" name="date" class="form-control" id="exampleDate2" required>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger btn-sm" data-bs-dismiss="modal">Bekor qilish</button>
                        <button type="submit" class="btn btn-success btn-sm">Saqlash</button>
                    </div>
            </form>
        </div>
    </div>
</div>
<script>
    // Get all elements with the specified class
    var inputElements = document.getElementsByClassName("datetimeInput");

    // Get the current date and time
    var now = new Date();

    // Format the date to be in the required format for datetime-local input
    var formattedDate = now.toISOString().slice(0, 16);

    // Set the value of all elements with the specified class to the current date and time
    for (var i = 0; i < inputElements.length; i++) {
        inputElements[i].value = formattedDate;
    }
</script>
<script>
    $(document).ready( function () {
        $("#invoiceDocumentTable").DataTable({
            "oLanguage": {
                "sSearch": "Qidiruv:",
                "sInfo": "_TOTAL_ ta ma'lumotdan (_START_ dan _END_) tagachasi ko'rsatildi.",
                "sLengthMenu": "_MENU_ ta natijani ko'rsatish rejimi",
                "sZeroRecords": "Bunday ma'lumot topilmadi!",
                "sInfoFiltered": "_MAX_ ta ma'lumotdan saralandi.",
                "sInfoEmpty": "Bironta ham ma'lumot topilmadi! ",
                "sEmptyTable": "Jadvalda ma'lumotlar mavjud emas!",
                "oPaginate": {
                    "sPrevious": "Oldingi sahifa",
                    "sNext": "Keyingi sahifa"
                }
            }
        });
    } );
</script>
<%@ include file="footer.jsp"%>