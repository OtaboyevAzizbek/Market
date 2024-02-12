<%@ page import="com.market.dto.organization.OrganizationDTO" %>
<%@ page import="com.market.entity.InvoiceDocument" %>
<%@ include file="header.jsp"%>
<%OrganizationDTO organizationDTO = (OrganizationDTO) request.getAttribute("organization");%>
    <div class="row">
    <div class="col-12 col-lg-4 col-xxl-9">
        <div class="card flex-fill">
            <div class="d-grid gap-2 d-md-flex justify-content-md-end p-3">
                <button class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>Yuk xati qo'shish</button>
            </div>
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
                        <a href="<%=request.getContextPath()%>/market/view_product/<%=invoiceDocument.getId()%>" class="btn btn-primary btn-sm"><i class="fa-solid fa-eye mx-sm-1"></i></a>
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
                <table class="table table-hover my-0 invoiceTable">
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
                    <tr>
                        <td>Project Apollo</td>
                        <td class="d-none d-xl-table-cell">01/01/2023</td>
                        <td class="d-none d-xl-table-cell">31/06/2023</td>
                        <td><span class="badge bg-success">Done</span></td>
                        <td class="d-none d-md-table-cell">Vanessa Tucker</td>
                    </tr>
                    <tr>
                        <td>Project Fireball</td>
                        <td class="d-none d-xl-table-cell">01/01/2023</td>
                        <td class="d-none d-xl-table-cell">31/06/2023</td>
                        <td><span class="badge bg-danger">Cancelled</span></td>
                        <td class="d-none d-md-table-cell">William Harris</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready( function () {
        $(".invoiceTable").DataTable({
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