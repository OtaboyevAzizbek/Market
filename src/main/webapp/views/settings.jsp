<%@ include file="header.jsp" %>
<style>
    .stat {
        height: 70px; /* Set the height */
        width: 70px; /* Set the width */
    }

    .stat svg {
        height: 30px;
        width: 30px;
    }

    .card-title {
        font-size: 24px; /* Set the font size for the title */
        margin-bottom: 0; /* Remove margin at the bottom */
    }

    .text-muted {
        font-size: 16px; /* Set the font size for the muted text */
    }
</style>

<div class="row">
    <div class="col-lg-4 col-md-6 mb-3">
        <a href="<%=request.getContextPath()%>/market/view_organizations" class="link-light">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col-auto">
                            <div class="stat text-primary">
                                <i class="fa-solid fa-building" style="font-size: 50px;"></i>
                            </div>
                        </div>
                        <div class="col mt-auto">
                            <h5 class="card-title" style="margin-bottom: 20px;">Tashkilotlar</h5>
                            <span class="text-muted">Tashkilotlar soni: <%=request.getAttribute("organizationNum")%> ta</span>
                        </div>
                    </div>
                </div>
            </div>
        </a>
    </div>
    <div class="col-lg-4 col-md-6 mb-3">
        <a href="<%=request.getContextPath()%>/market/view_categories" class="link-light">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col-auto">
                            <div class="stat text-primary">
                                <i class="fa-solid fa-layer-group" style="font-size: 50px;"></i>
                            </div>
                        </div>
                        <div class="col mt-auto">
                            <h5 class="card-title" style="margin-bottom: 20px;">Kategoriyalar</h5>
                            <span class="text-muted">Kategoriyalar soni: <%=request.getAttribute("categoryNum")%> ta</span>
                        </div>
                    </div>
                </div>
            </div>
        </a>
    </div>
    <div class="col-lg-4 col-md-6 mb-3">
        <a href="<%=request.getContextPath()%>/market/view_unit_types" class="link-light">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col-auto">
                            <div class="stat text-primary">
                                <i class="fa-solid fa-scale-unbalanced" style="font-size: 50px;"></i>
                            </div>
                        </div>
                        <div class="col mt-auto">
                            <h5 class="card-title" style="margin-bottom: 20px;">O'lchov birligi</h5>
                            <span class="text-muted">O'lchov birliklari soni: <%=request.getAttribute("unitTypeNum")%> ta</span>
                        </div>
                    </div>
                </div>
            </div>
        </a>
    </div>
    <div class="col-lg-4 col-md-6 mb-3">
        <a href="<%=request.getContextPath()%>/market/view_products" class="link-light">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col-auto">
                            <div class="stat text-primary">
                                <i class="fa-solid fa-cart-shopping" style="font-size: 50px;"></i>
                            </div>
                        </div>
                        <div class="col mt-auto">
                            <h5 class="card-title" style="margin-bottom: 20px;">Mahsulotlar</h5>
                            <span class="text-muted">Mahsulotlar soni: <%=request.getAttribute("productNum")%> ta</span>
                        </div>
                    </div>
                </div>
            </div>
        </a>
    </div>
    <div class="col-lg-4 col-md-6 mb-3">
        <a href="<%=request.getContextPath()%>/market/view_invoice_documents" class="link-light">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col-auto">
                            <div class="stat text-primary">
                                <i class="fa-solid fa-file-invoice" style="font-size: 50px;"></i>
                            </div>
                        </div>
                        <div class="col mt-auto">
                            <h5 class="card-title" style="margin-bottom: 20px;">Yuk xatlari</h5>
                            <span class="text-muted">Yuk xatlari soni: <%=request.getAttribute("invoiceDocNum")%> ta</span>
                        </div>
                    </div>
                </div>
            </div>
        </a>
    </div>
    <div class="col-lg-4 col-md-6 mb-3">
        <a href="<%=request.getContextPath()%>/market/view_invoice_document_items" class="link-light">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col-auto">
                            <div class="stat text-primary">
                                <i class="fa-solid fa-warehouse" style="font-size: 50px;"></i>
                            </div>
                        </div>
                        <div class="col mt-auto">
                            <h5 class="card-title" style="margin-bottom: 20px;">Kirim qilish</h5>
                            <span class="text-muted">Kirim qilishlar soni: <%=request.getAttribute("incomeNum")%> ta</span>
                        </div>
                    </div>
                </div>
            </div>
        </a>
    </div>
</div>
<%@ include file="footer.jsp" %>
