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
<%--            <div class="row">--%>
<%--                <div class="col-sm-12 col-md-6">--%>
<%--                    <div class="dataTables_length" id="DataTables_Table_0_length">--%>
<%--                        <label>--%>
<%--                            <select name="DataTables_Table_0_length" aria-controls="DataTables_Table_0" class="form-select form-select-sm">--%>
<%--                                <option value="10">10</option>--%>
<%--                                <option value="25">25</option>--%>
<%--                                <option value="50">50</option>--%>
<%--                                <option value="100">100</option>--%>
<%--                            </select>--%>
<%--                        </label> ta natijani ko'rish rejimi--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-sm-12 col-md-6">--%>
<%--                    <div id="DataTables_Table_0_filter" class="d-flex justify-content-end">--%>
<%--                        <span class="d-flex align-items-center me-1">Qidiruv:</span>--%>
<%--                        <label>--%>
<%--                            <input type="search" class="form-control form-control-sm" placeholder="" aria-controls="DataTables_Table_0">--%>
<%--                        </label>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
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
                                        <input type="text" name="name" class="form-control" id="exampleCategoryName" value="<%=categoryDTO.getName()%>" required>
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
<%--            <div class="row">--%>
<%--                <div class="col-sm-12 col-md-5">--%>
<%--                    <div class="" id="categoryTable_info" role="status" aria-live="polite">--%>
<%--                        <span >3 ta ma'lumotdan (1 dan 3) tagachasi ko'rsatildi.</span>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-sm-12 col-md-7">--%>
<%--                    <div class="d-flex justify-content-end" id="categoryTable_paginate">--%>
<%--                        <ul class="pagination">--%>
<%--                            <li class="paginate_button page-item previous disabled" id="categoryTable_previous">--%>
<%--                                <a aria-controls="categoryTable" aria-disabled="true" role="link" data-dt-idx="previous" tabindex="-1" class="page-link">--%>
<%--                                    Oldingi sahifa--%>
<%--                                </a>--%>
<%--                            </li>--%>
<%--                            <li class="paginate_button page-item active">--%>
<%--                                <a href="#" aria-controls="categoryTable" role="link" aria-current="page" data-dt-idx="0" tabindex="0" class="page-link">--%>
<%--                                    1--%>
<%--                                </a>--%>
<%--                            </li>--%>
<%--                            <li class="paginate_button page-item next disabled" id="categoryTable_next">--%>
<%--                                <a aria-controls="categoryTable" aria-disabled="true" role="link" data-dt-idx="next" tabindex="-1" class="page-link">--%>
<%--                                    Keyingi sahifa--%>
<%--                                </a>--%>
<%--                            </li>--%>
<%--                        </ul>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
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
                        <label for="exampleCategoryName2" class="form-label">Kategoriya nomi</label>
                        <input type="text" name="name" class="form-control" id="exampleCategoryName2" required>
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