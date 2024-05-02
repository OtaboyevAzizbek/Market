<%@ page import="com.market.dto.organization.OrganizationDTO" %>
<%@ page import="java.util.List" %>
<%@ include file="header.jsp"%>
<%List<OrganizationDTO> organizationDTOList = (List<OrganizationDTO>) request.getAttribute("organizationList");%>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <div class="card-body">
            <table class="table table-hover my-0 dataTable">
                <thead>
                <tr>
                    <th style="width:5%;">ID</th>
                    <th style="width:30%;">Tashkilot nomi</th>
                    <th style="width:15%;">Tashkilot tel raqami</th>
                    <th style="width:18%;">Tashkilotga qarzdorlik</th>
                    <th style="width:18%;">Tashkilotga to'lov</th>
                    <th style="width:14%;">Amallar</th>
                </tr>
                </thead>
                <tbody>
                <% int count=1;%>
                <% for (OrganizationDTO organizationDTO : organizationDTOList) {%>
                <tr>
                    <td><%=count++%></td>
                    <td><%=organizationDTO.getName()%></td>
                    <td><%=organizationDTO.getPhoneNumber()%></td>
                    <td><%=organizationDTO.getOrganizationCalculate().getTotalDebtSumma()%></td>
                    <td><%=organizationDTO.getOrganizationCalculate().getTotalPaymentSumma()%></td>
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