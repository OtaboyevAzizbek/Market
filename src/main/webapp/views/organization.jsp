<%@ page import="com.market.dto.organization.OrganizationDTO" %>
<%@ page import="java.util.List" %>
<%@ include file="header.jsp" %>
<%List<OrganizationDTO> organizationDTOList = (List<OrganizationDTO>) request.getAttribute("organizationList");%>
<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">
    <button class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i
            class="fa-solid fa-plus mx-sm-1"></i>Tashkilot qo'shish
    </button>
</div>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <div class="card-body">
            <table class="table table-hover my-0 dataTable">
                <thead>
                <tr>
                    <th style="width:3%;">ID</th>
                    <th style="width:23%;">Tashkilot nomi</th>
                    <th style="width:15%;">INN (JShIR)</th>
                    <th style="width:15%;">Manzil</th>
                    <th style="width:12%;">Tel raqam</th>
                    <th style="width:32%;">Amallar</th>
                </tr>
                </thead>
                <tbody>
                <% int count = 1;%>
                <% for (OrganizationDTO organizationDTO : organizationDTOList) {%>
                <tr>
                    <td><%=count++%>
                    </td>
                    <td><%=organizationDTO.getName()%>
                    </td>
                    <td><%=organizationDTO.getInn()%>
                    </td>
                    <td><%=organizationDTO.getAddress()%>
                    </td>
                    <td><%=organizationDTO.getPhoneNumber()%>
                    </td>
                    <td>
                        <a href="<%=request.getContextPath()%>/market/view_organization/<%=organizationDTO.getId()%>"
                           class="btn btn-primary btn-sm"><i class="fa-solid fa-eye mx-sm-1"></i>Ko'rish</a>
                        <button type="button" data-bs-toggle="modal"
                                data-bs-target=".bd-example-modal-a<%=organizationDTO.getId()%>"
                                class="btn btn-warning btn-sm"><i class="fa-solid fa-pen-to-square mx-sm-1"></i>O'zgartirish
                        </button>
                        <button type="button" data-bs-toggle="modal"
                                data-bs-target=".bd-example-modal-b<%=organizationDTO.getId()%>"
                                class="btn btn-danger btn-sm"><i class="fa-solid fa-trash-can mx-sm-1"></i>O'chirish
                        </button>
                    </td>
                    <%--Modal for delete--%>
                    <div class="modal fade bd-example-modal-b<%=organizationDTO.getId()%>" tabindex="-1">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title"><b>Tashkilot o'chirish</b></h4>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <h4>Haqiqatan ham o'chirib tashlamoqchimisiz?</h4>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary btn-sm" data-bs-dismiss="modal">Bekor
                                        qilish
                                    </button>
                                    <a href="<%=request.getContextPath()%>/market/delete_organization/<%=organizationDTO.getId()%>"
                                       class="btn btn-danger btn-sm">O'chirish</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--Modal for update--%>
                    <div class="modal fade bd-example-modal-a<%=organizationDTO.getId()%>"
                         aria-labelledby="exampleModalEditOrganization" tabindex="-1">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title" id="exampleModalEditOrganization"><b>Tashkilot
                                        o'zgartirish</b></h4>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <form action="update_organization" method="post">
                                    <input type="hidden" name="id" value="<%=organizationDTO.getId()%>">
                                    <div class="modal-body">
                                        <div class="mb-3">
                                            <label for="exampleOrganizationName" class="form-label">Tashkilot
                                                nomi</label>
                                            <input type="text" name="name" class="form-control exampleOrganizationName2"
                                                   id="exampleOrganizationName" value="<%=organizationDTO.getName()%>"
                                                   required>
                                            <div id="validationServerFeedback2" class="invalid-feedback">
                                                Bu nomdagi tashkilot allaqachon mavjud!
                                            </div>
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleInn2" class="form-label">INN (JShIR)</label>
                                            <input type="text" name="inn" class="form-control exampleInn"
                                                   pattern=".{8}|.{14}" value="<%=organizationDTO.getInn()%>"
                                                   id="exampleInn2" required>
                                            <div id="validationServerFeedback4" class="invalid-feedback">
                                                Ushbu inn allaqachon mavjud!
                                            </div>
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleOrganizationAddress" class="form-label">Tashkilot
                                                manzili</label>
                                            <input type="text" name="address" class="form-control"
                                                   id="exampleOrganizationAddress"
                                                   value="<%=organizationDTO.getAddress()%>" required>
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleOrganizationPhoneNumber" class="form-label">Tashkilot tel
                                                raqami</label>
                                            <input type="text" name="phoneNumber" class="form-control"
                                                   id="exampleOrganizationPhoneNumber"
                                                   value="<%=organizationDTO.getPhoneNumber()%>" required>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger btn-sm" data-bs-dismiss="modal">
                                                Bekor qilish
                                            </button>
                                            <button type="submit" class="btn btn-success btn-sm saveButton">Saqlash
                                            </button>
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
                        <label for="exampleOrganizationName3" class="form-label">Tashkilot nomi</label>
                        <input type="text" name="name" class="form-control exampleOrganizationName"
                               id="exampleOrganizationName3" required>
                        <div id="validationServerFeedback" class="invalid-feedback">
                            Bu nomdagi tashkilot allaqachon mavjud!
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInn" class="form-label">INN (JShIR)</label>
                        <input type="text" name="inn" class="form-control exampleOrganizationInn" id="exampleInn"
                               pattern=".{8}|.{14}" required>
                        <div id="validationServerFeedback3" class="invalid-feedback">
                            Ushbu inn allaqachon mavjud!
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="exampleOrganizationAddress2" class="form-label">Tashkilot manzili</label>
                        <input type="text" name="address" class="form-control" id="exampleOrganizationAddress2"
                               required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleOrganizationPhoneNumber2" class="form-label">Tashkilot tel raqami</label>
                        <input type="text" name="phoneNumber" class="form-control" id="exampleOrganizationPhoneNumber2"
                               required>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger btn-sm" data-bs-dismiss="modal">Bekor qilish
                        </button>
                        <button type="submit" class="btn btn-success btn-sm saveButton2">Saqlash</button>
                    </div>
            </form>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        $(".exampleOrganizationName, .exampleOrganizationInn").on("change", function () {
            checkOrganizationNameAndInnAJAX();
        });
    });

    function checkOrganizationNameAndInnAJAX() {
        let organizationName = $(".exampleOrganizationName").val();
        let organizationInn = $(".exampleOrganizationInn").val();

        if (organizationName && organizationInn) {
            $.ajax({
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: '/market/check_organization',
                type: "POST",
                data: {
                    name: organizationName,
                    inn: organizationInn
                },
                dataType: "json",
                success: function (data) {
                    if (data === true) {
                            $(".exampleOrganizationName").addClass("is-invalid");
                            $(".saveButton2").prop('disabled', true);
                    } else {
                        $(".exampleOrganizationName").removeClass("is-invalid");
                        $(".saveButton2").prop('disabled', false);
                    }
                },
                error: function () {
                    alert("Xatolik yuz berdi");
                }
            });
        }
    }
</script>


<%--<script>--%>
<%--    function checkOrganizationNameAJAX(value, inn, value2) {--%>
<%--        if (value && inn) {--%>
<%--            $.ajax({--%>
<%--                contentType: "application/x-www-form-urlencoded;charset=UTF-8",--%>
<%--                url: '/market/check_organization',--%>
<%--                type: "POST",--%>
<%--                data: {--%>
<%--                    name: value,--%>
<%--                    id: value2,--%>
<%--                    inn: inn--%>
<%--                },--%>
<%--                dataType: "json",--%>
<%--                success: function (data) {--%>
<%--                    if (data === true) {--%>
<%--                        $(".exampleOrganizationName2").addClass("is-invalid");--%>
<%--                        $(".saveButton").prop('disabled', true);--%>
<%--                    } else {--%>
<%--                        $(".exampleOrganizationName2").removeClass("is-invalid");--%>
<%--                        $(".saveButton").prop('disabled', false);--%>
<%--                    }--%>
<%--                },--%>
<%--                error: function () {--%>
<%--                    alert("Xatolik yuz berdi");--%>
<%--                }--%>
<%--            })--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>
<%@ include file="footer.jsp" %>