<%@ page import="com.market.dto.unitType.UnitTypeDTO" %>
<%@ page import="java.util.List" %>
<%@ include file="header.jsp"%>
<%List<UnitTypeDTO> unitTypeDTOList = (List<UnitTypeDTO>) request.getAttribute("unitTypeList");%>
<%--<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">--%>
<%--    <button class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>O'lchov birligi qo'shish</button>--%>
<%--</div>--%>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <div class="card-body">
        <table class="table table-hover my-0" id="unitTypeTable">
            <thead>
            <tr>
                <th>ID</th>
                <th>O'chov birligi nomi</th>
<%--                <th>Amallar</th>--%>
            </tr>
            </thead>
            <tbody>
            <% int count=1;%>
            <% for (UnitTypeDTO unitTypeDTO : unitTypeDTOList) {%>
            <tr>
                <td><%=count++%></td>
                <td><%=unitTypeDTO.getName()%></td>
<%--                <td>--%>
<%--                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-a<%=unitTypeDTO.getId()%>" class="btn btn-warning btn-sm"><i class="fa-solid fa-pen-to-square mx-sm-1"></i>O'zgartirish</button>--%>
<%--                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-b<%=unitTypeDTO.getId()%>" class="btn btn-danger btn-sm"><i class="fa-solid fa-trash-can mx-sm-1"></i>O'chirish</button>--%>
<%--                </td>--%>
                <%--Modal for delete--%>
                <div class="modal fade bd-example-modal-b<%=unitTypeDTO.getId()%>" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title"><b>O'chov birligi o'chirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h4>Haqiqatan ham o'chirib tashlamoqchimisiz?</h4>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary btn-sm" data-bs-dismiss="modal">Bekor qilish</button>
                                <a href="<%=request.getContextPath()%>/market/delete_unit_type/<%=unitTypeDTO.getId()%>" class="btn btn-danger btn-sm">O'chirish</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%--Modal for update--%>
                <div class="modal fade bd-example-modal-a<%=unitTypeDTO.getId()%>" aria-labelledby="exampleModalEditUnitType" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="exampleModalEditUnitType"><b>O'lchov birligi o'zgartirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form action="update_unit_type" method="post">
                                <input type="hidden" name="id" value="<%=unitTypeDTO.getId()%>">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="exampleUnitTypeName" class="form-label">O'lchov birligi nomi</label>
                                        <input type="text" name="name" class="form-control" id="exampleUnitTypeName" value="<%=unitTypeDTO.getName()%>" required>
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
<div class="modal fade bd-example-modal-c" aria-labelledby="exampleModalUnitType2" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalUnitType2"><b>Yangi o'lchov qo'shish</b></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="create_unit_type" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleUnitTypeName2" class="form-label">O'lchov birlik nomi</label>
                        <input type="text" name="name" class="form-control" id="exampleUnitTypeName2" required>
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
    $(document).ready( function () {
        $("#unitTypeTable").DataTable({
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