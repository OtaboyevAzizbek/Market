<%@ page import="com.market.dto.product.ProductDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.market.dto.category.CategoryDTO" %>
<%@ page import="com.market.dto.unitType.UnitTypeDTO" %>
<%@ page import="com.market.status.ProductPriceType" %>
<%@ page import="com.market.status.ProductPriceStatus" %>
<%@ include file="header.jsp"%>
<%List<ProductDTO> productDTOList = (List<ProductDTO>) request.getAttribute("productList");%>
<%List<CategoryDTO> categoryDTOList = (List<CategoryDTO>) request.getAttribute("categoryList");%>
<%List<UnitTypeDTO> unitTypeDTOList = (List<UnitTypeDTO>) request.getAttribute("unitTypeList");%>
<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">
    <button class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>Mahsulot qo'shish</button>
</div>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <div class="card-body">
            <div id="datatable-buttons_wrapper">

            </div>
        <table class="table table-hover my-0 dataTable">
            <thead>
            <tr>
                <th style="width:3%;">ID</th>
                <th style="width:25%;">Mahsulot nomi</th>
                <th style="width:10%;">Magazine qoldig'i</th>
                <th style="width:10%;">Omborxona qoldig'i</th>
                <th style="width:10%;">O'lchov birligi</th>
                <th style="width:10%;">Kategoriya nomi</th>
                <th style="width:32%;">Amallar</th>
            </tr>
            </thead>
            <tbody>
            <% int count=1;%>
            <% for (ProductDTO productDTO : productDTOList) {%>
            <tr>
                <td><%=count++%></td>
                <td><%=productDTO.getName()%></td>
                <td><%=productDTO.getStoreAmount()%></td>
                <td><%=productDTO.getWarehouseAmount()%></td>
                <td><%=productDTO.getUnitType().getName()%></td>
                <td><%=productDTO.getCategory().getName()%></td>
                <td>
                    <a href="<%=request.getContextPath()%>/market/view_product/<%=productDTO.getId()%>" class="btn btn-primary btn-sm"><i class="fa-solid fa-eye mx-sm-1"></i>Ko'rish</a>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-a<%=productDTO.getId()%>" class="btn btn-warning btn-sm"><i class="fa-solid fa-pen-to-square mx-sm-1"></i>O'zgartirish</button>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-b<%=productDTO.getId()%>" class="btn btn-danger btn-sm"><i class="fa-solid fa-trash-can mx-sm-1"></i>O'chirish</button>
                </td>
                <%--Modal for delete--%>
                <div class="modal fade bd-example-modal-b<%=productDTO.getId()%>" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title"><b>Mahsulot o'chirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h4>Haqiqatan ham o'chirib tashlamoqchimisiz?</h4>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary btn-sm" data-bs-dismiss="modal">Bekor qilish</button>
                                <a href="<%=request.getContextPath()%>/market/delete_product/<%=productDTO.getId()%>" class="btn btn-danger btn-sm">O'chirish</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%--Modal for update--%>
                <div class="modal fade bd-example-modal-a<%=productDTO.getId()%>" aria-labelledby="exampleModalEditCategory" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="exampleModalEditCategory"><b>Mahsulot o'zgartirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form action="update_product" method="post">
                                <input type="hidden" name="id" value="<%=productDTO.getId()%>">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="exampleProductName" class="form-label">Mahsulot nomi</label>
                                        <input type="text" name="name" class="form-control" id="exampleProductName" value="<%=productDTO.getName()%>" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleCategory" class="form-label">Mahsulot kategoriyasi</label>
                                        <select name="categoryId" id="exampleCategory" class="form-control" required>
                                            <option value="" selected>Kategoriya tanlang</option>
                                            <% for (CategoryDTO categoryDTO : categoryDTOList) {%>
                                            <option value="<%=categoryDTO.getId()%>" <%=categoryDTO.getId()==productDTO.getCategory().getId() ? "selected":"" %>><%=categoryDTO.getName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleUnitType" class="form-label">O'lchov birligi</label>
                                        <select name="unitTypeId" id="exampleUnitType" class="form-control" required>
                                            <option value="" selected>O'lchov birlik tanlang</option>
                                            <% for (UnitTypeDTO unitTypeDTO : unitTypeDTOList) {%>
                                            <option value="<%=unitTypeDTO.getId()%>" <%=unitTypeDTO.getId()==productDTO.getUnitType().getId() ? "selected":"" %>><%=unitTypeDTO.getName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleBuyPrice" class="form-label">Xarid narxi</label>
                                        <input type="text" name="purchasePrice"  value="<%=productDTO.getBuyPrice()%>" class="form-control" id="exampleBuyPrice" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleSellPrice" class="form-label">Sotuv narxi</label>
                                        <input type="text" name="sellPrice" value="<%=productDTO.getSellPrice()%>" class="form-control" id="exampleSellPrice" required>
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
<div class="modal fade bd-example-modal-c" aria-labelledby="exampleModalCategory2" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalCategory2"><b>Yangi mahsulot qo'shish</b></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="create_product" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleProductName2" class="form-label">Mahsulot nomi</label>
                        <input type="text" name="name" class="form-control" onchange="checkProductNameAJAX(this.value)" id="exampleProductName2" required>
                        <div id="validationServerFeedback" class="invalid-feedback">
                            Bu nomdagi mahsulot allaqachon mavjud!
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="exampleCategory2" class="form-label">Mahsulot kategoriyasi</label>
                        <select name="categoryId" id="exampleCategory2" class="form-control" required>
                            <option value="" selected>Kategoriya tanlang</option>
                            <% for (CategoryDTO categoryDTO : categoryDTOList) {%>
                            <option value="<%=categoryDTO.getId()%>"><%=categoryDTO.getName()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleUnitType2" class="form-label">O'lchov birligi</label>
                        <select name="unitTypeId" id="exampleUnitType2" class="form-control" required>
                            <option value="" selected>O'lchov birlik tanlang</option>
                            <% for (UnitTypeDTO unitTypeDTO : unitTypeDTOList) {%>
                            <option value="<%=unitTypeDTO.getId()%>"><%=unitTypeDTO.getName()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleBuyPrice2" class="form-label">Xarid narxi</label>
                        <input type="text" name="purchasePrice" class="form-control" id="exampleBuyPrice2" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleSellPrice2" class="form-label">Sotuv narxi</label>
                        <input type="text" name="sellPrice" class="form-control" id="exampleSellPrice2" required>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger btn-sm" data-bs-dismiss="modal">Bekor qilish</button>
                        <button type="submit" id="saveButton" class="btn btn-success btn-sm">Saqlash</button>
                    </div>
            </form>
        </div>
    </div>
</div>
<script>
    function checkProductNameAJAX(value){
            $.ajax({
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: '/market/check_product',
                type: "POST",
                data: {
                    name:value
                },
                dataType: "json",
                success: function (data) {
                    if (data===true) {
                        $("#exampleProductName2").addClass("is-invalid");
                        $("#saveButton").prop('disabled', true);
                    }else {
                        $("#exampleProductName2").removeClass("is-invalid");
                        $("#saveButton").prop('disabled', false);
                    }
                },
                error: function () {
                    alert("Xatolik yuz berdi");
                }
            })
    }
</script>
<%@ include file="footer.jsp"%>