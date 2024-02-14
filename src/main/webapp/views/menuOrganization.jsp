<%@ page import="com.market.dto.organization.OrganizationDTO" %>
<%@ page import="java.util.List" %>
<%@ include file="header.jsp"%>
<%List<OrganizationDTO> organizationDTOList = (List<OrganizationDTO>) request.getAttribute("organizationList");%>
<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">
    <button class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>Tashkilot qo'shish</button>
</div>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <div class="card-body">
            <table class="table table-hover my-0 dataTable">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Tashkilot nomi</th>
<%--                    <th>Tashkilot manzili</th>--%>
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
<%--                    <td><%=organizationDTO.getAddress()%></td>--%>
                    <td><%=organizationDTO.getPhoneNumber()%></td>
                    <td><%=organizationDTO.getClientDebt()%></td>
                    <td><%=organizationDTO.getPayment()%></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/market/view_organization/<%=organizationDTO.getId()%>" class="btn btn-primary btn-sm"><i class="fa-solid fa-eye mx-sm-1"></i>Ko'rish</a>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>