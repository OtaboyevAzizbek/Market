<%@ page import="com.market.dto.category.CategoryDTO" %>
<%@ page import="java.util.List" %>
<%@ include file="header.jsp"%>
<%List<CategoryDTO> categoryDTOList = (List<CategoryDTO>) request.getAttribute("categoryList");%>
<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">
    <button class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>Kategoriya qo'shish</button>
</div>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <div class="card-body">
        <table class="table table-hover my-0 dataTable">
            <thead>
            <tr>
                <th>ID</th>
                <th>Kategoriya nomi</th>
                <th>Amallar</th>
            </tr>
            </thead>
            <tbody>
            <% int count=1;%>
            <% for (CategoryDTO categoryDTO : categoryDTOList) {%>
            <tr>
                <td><%=count++%></td>
                <td><%=categoryDTO.getName()%></td>
                <td>
                    <a href="<%=request.getContextPath()%>/market/view_category/<%=categoryDTO.getId()%>" class="btn btn-primary btn-sm"><i class="fa-solid fa-eye mx-sm-1"></i>Ko'rish</a>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-a<%=categoryDTO.getId()%>" class="btn btn-warning btn-sm"><i class="fa-solid fa-pen-to-square mx-sm-1"></i>O'zgartirish</button>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-b<%=categoryDTO.getId()%>" class="btn btn-danger btn-sm"><i class="fa-solid fa-trash-can mx-sm-1"></i>O'chirish</button>
                </td>
                <%--Modal for delete--%>
                <div class="modal fade bd-example-modal-b<%=categoryDTO.getId()%>" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title"><b>Kategoriya o'chirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h4>Haqiqatan ham o'chirib tashlamoqchimisiz?</h4>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary btn-sm" data-bs-dismiss="modal">Bekor qilish</button>
                                <a href="<%=request.getContextPath()%>/market/delete_category/<%=categoryDTO.getId()%>" class="btn btn-danger btn-sm">O'chirish</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%--Modal for update--%>
                <div class="modal fade bd-example-modal-a<%=categoryDTO.getId()%>" aria-labelledby="exampleModalEditCategory" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="exampleModalEditCategory"><b>Kategoriya o'zgartirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form action="update_category" method="post">
                                <input type="hidden" name="id" value="<%=categoryDTO.getId()%>">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="exampleCategoryName" class="form-label">Kategoriya nomi</label>
                                        <input type="text" name="name" class="form-control exampleCategoryName2" onchange="checkCategoryNameAJAX(this.value,<%=categoryDTO.getId()%>)" id="exampleCategoryName" value="<%=categoryDTO.getName()%>" required>
                                        <div id="validationServerFeedback2" class="invalid-feedback">
                                            Bu nomdagi kategoriya allaqachon mavjud!
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-danger btn-sm" data-bs-dismiss="modal">Bekor qilish</button>
                                        <button type="submit" class="btn btn-success btn-sm saveButton">Saqlash</button>
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
<div class="modal fade bd-example-modal-c" aria-labelledby="exampleModalCategory2" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalCategory2"><b>Yangi kategoriya qo'shish</b></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="create_category" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleCategoryName3" class="form-label">Kategoriya nomi</label>
                        <input type="text" name="name" class="form-control exampleCategoryName2" onchange="checkCategoryNameAJAX(this.value)" id="exampleCategoryName3" required>
                        <div id="validationServerFeedback" class="invalid-feedback">
                            Bu nomdagi kategoriya allaqachon mavjud!
                        </div>
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
    function checkCategoryNameAJAX(value,value2){
        $.ajax({
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            url: '/market/check_category',
            type: "POST",
            data: {
                name:value,
                id:value2
            },
            dataType: "json",
            success: function (data) {
                if (data === true) {
                    $(".exampleCategoryName2").addClass("is-invalid");
                    $(".saveButton").prop('disabled', true);
                }else {
                    $(".exampleCategoryName2").removeClass("is-invalid");
                    $(".saveButton").prop('disabled', false);
                }
            },
            error: function () {
                alert("Xatolik yuz berdi");
            }
        })
    }
</script>
<%@ include file="footer.jsp"%>