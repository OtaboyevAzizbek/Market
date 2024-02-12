<%@ page import="com.market.dto.organization.OrganizationDTO" %>
<%@ page import="java.util.List" %>
<%@ include file="header.jsp"%>
<%List<OrganizationDTO> organizationDTOList = (List<OrganizationDTO>) request.getAttribute("organizationList");%>
<% if ((Integer) request.getAttribute("status")==0){%>
<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">
    <button class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>Tashkilot qo'shish</button>
</div>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <div class="card-body">
            <table class="table table-hover my-0 organizationTable">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Tashkilot nomi</th>
                    <th>Tashkilot manzili</th>
                    <th>Tashkilot tel raqami</th>
                    <th>Amallar</th>
                </tr>
                </thead>
                <tbody>
                <% int count=1;%>
                <% for (OrganizationDTO organizationDTO : organizationDTOList) {%>
                <tr>
                    <td><%=count++%></td>
                    <td><%=organizationDTO.getName()%></td>
                    <td><%=organizationDTO.getAddress()%></td>
                    <td><%=organizationDTO.getPhoneNumber()%></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/market/view_organization/<%=organizationDTO.getId()%>" class="btn btn-primary btn-sm"><i class="fa-solid fa-eye mx-sm-1"></i>Ko'rish</a>
                        <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-a<%=organizationDTO.getId()%>" class="btn btn-warning btn-sm"><i class="fa-solid fa-pen-to-square mx-sm-1"></i>O'zgartirish</button>
                        <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-b<%=organizationDTO.getId()%>" class="btn btn-danger btn-sm"><i class="fa-solid fa-trash-can mx-sm-1"></i>O'chirish</button>
                    </td>
                    <%--Modal for delete--%>
                    <div class="modal fade bd-example-modal-b<%=organizationDTO.getId()%>" tabindex="-1">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title"><b>Tashkilot o'chirish</b></h4>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <h4>Haqiqatan ham o'chirib tashlamoqchimisiz?</h4>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary btn-sm" data-bs-dismiss="modal">Bekor qilish</button>
                                    <a href="<%=request.getContextPath()%>/market/delete_organization/<%=organizationDTO.getId()%>" class="btn btn-danger btn-sm">O'chirish</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--Modal for update--%>
                    <div class="modal fade bd-example-modal-a<%=organizationDTO.getId()%>" aria-labelledby="exampleModalEditOrganization" tabindex="-1">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title" id="exampleModalEditOrganization"><b>Tashkilot o'zgartirish</b></h4>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <form action="update_organization" method="post">
                                    <input type="hidden" name="id" value="<%=organizationDTO.getId()%>">
                                    <div class="modal-body">
                                        <div class="mb-3">
                                            <label for="exampleOrganizationName" class="form-label">Tashkilot nomi</label>
                                            <input type="text" name="name" class="form-control" id="exampleOrganizationName" value="<%=organizationDTO.getName()%>" required>
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleOrganizationAddress" class="form-label">Tashkilot manzili</label>
                                            <input type="text" name="address" class="form-control" id="exampleOrganizationAddress" value="<%=organizationDTO.getAddress()%>" required>
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleOrganizationPhoneNumber" class="form-label">Tashkilot tel raqami</label>
                                            <input type="text" name="phoneNumber" class="form-control" id="exampleOrganizationPhoneNumber" value="<%=organizationDTO.getPhoneNumber()%>" required>
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
<div class="modal fade bd-example-modal-c" aria-labelledby="exampleModalOrganization2" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalOrganization2"><b>Yangi tashkilot qo'shish</b></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="create_organization" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleOrganizationName2" class="form-label">Tashkilot nomi</label>
                        <input type="text" name="name" class="form-control" id="exampleOrganizationName2" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleOrganizationAddress2" class="form-label">Tashkilot manzili</label>
                        <input type="text" name="address" class="form-control" id="exampleOrganizationAddress2" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleOrganizationPhoneNumber2" class="form-label">Tashkilot tel raqami</label>
                        <input type="text" name="phoneNumber" class="form-control" id="exampleOrganizationPhoneNumber2" required>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger btn-sm" data-bs-dismiss="modal">Bekor qilish</button>
                        <button type="submit" class="btn btn-success btn-sm">Saqlash</button>
                    </div>
            </form>
        </div>
    </div>
</div>
<%}%>
<% if ((Integer) request.getAttribute("status")==1){%>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <div class="card-body">
            <table class="table table-hover my-0 organizationTable">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Tashkilot nomi</th>
                    <th>Tashkilot manzili</th>
                    <th>Tashkilot tel raqami</th>
                    <th>Tashkilotga qarzdorlik</th>
                    <th>Tashkilotga to'lov</th>
                    <th>Amallar</th>
                </tr>
                </thead>
                <tbody>
                <% int count=1;%>
                <% for (OrganizationDTO organizationDTO : organizationDTOList) {%>
                <tr>
                    <td><%=count++%></td>
                    <td><%=organizationDTO.getName()%></td>
                    <td><%=organizationDTO.getAddress()%></td>
                    <td><%=organizationDTO.getPhoneNumber()%></td>
                    <td><%=organizationDTO.getClientDebt()%></td>
                    <td><%=organizationDTO.getPayment()%></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/market/view_organization/<%=organizationDTO.getId()%>" class="btn btn-primary btn-sm"><i class="fa-solid fa-warehouse mx-sm-1"></i>Kirim</a>
<%--                        <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-a<%=organizationDTO.getId()%>" class="btn btn-warning btn-sm"><i class="fa-solid fa-pen-to-square mx-sm-1"></i>O'zgartirish</button>--%>
<%--                        <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-b<%=organizationDTO.getId()%>" class="btn btn-danger btn-sm"><i class="fa-solid fa-trash-can mx-sm-1"></i>O'chirish</button>--%>
                    </td>
                    <%--Modal for delete--%>
                    <div class="modal fade bd-example-modal-b<%=organizationDTO.getId()%>" tabindex="-1">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title"><b>Tashkilot o'chirish</b></h4>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <h4>Haqiqatan ham o'chirib tashlamoqchimisiz?</h4>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary btn-sm" data-bs-dismiss="modal">Bekor qilish</button>
                                    <a href="<%=request.getContextPath()%>/market/delete_organization/<%=organizationDTO.getId()%>" class="btn btn-danger btn-sm">O'chirish</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--Modal for update--%>
<%--                    <div class="modal fade bd-example-modal-a<%=organizationDTO.getId()%>" aria-labelledby="exampleModalEditOrganization" tabindex="-1">--%>
<%--                        <div class="modal-dialog">--%>
<%--                            <div class="modal-content">--%>
<%--                                <div class="modal-header">--%>
<%--                                    <h4 class="modal-title" id="exampleModalEditOrganization"><b>Tashkilot o'zgartirish</b></h4>--%>
<%--                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
<%--                                </div>--%>
<%--                                <form action="update_organization" method="post">--%>
<%--                                    <input type="hidden" name="id" value="<%=organizationDTO.getId()%>">--%>
<%--                                    <div class="modal-body">--%>
<%--                                        <div class="mb-3">--%>
<%--                                            <label for="exampleOrganizationName" class="form-label">Tashkilot nomi</label>--%>
<%--                                            <input type="text" name="name" class="form-control" id="exampleOrganizationName" value="<%=organizationDTO.getName()%>" required>--%>
<%--                                        </div>--%>
<%--                                        <div class="mb-3">--%>
<%--                                            <label for="exampleOrganizationAddress" class="form-label">Tashkilot manzili</label>--%>
<%--                                            <input type="text" name="address" class="form-control" id="exampleOrganizationAddress" value="<%=organizationDTO.getAddress()%>" required>--%>
<%--                                        </div>--%>
<%--                                        <div class="mb-3">--%>
<%--                                            <label for="exampleOrganizationPhoneNumber" class="form-label">Tashkilot tel raqami</label>--%>
<%--                                            <input type="text" name="phoneNumber" class="form-control" id="exampleOrganizationPhoneNumber" value="<%=organizationDTO.getPhoneNumber()%>" required>--%>
<%--                                        </div>--%>
<%--                                        <div class="modal-footer">--%>
<%--                                            <button type="button" class="btn btn-danger btn-sm" data-bs-dismiss="modal">Bekor qilish</button>--%>
<%--                                            <button type="submit" class="btn btn-success btn-sm">Saqlash</button>--%>
<%--                                        </div>--%>
<%--                                </form>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%}%>
<script>
    $(document).ready( function () {
        $(".organizationTable").DataTable({
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