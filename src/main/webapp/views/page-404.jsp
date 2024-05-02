<!DOCTYPE html>
<html>
<head>
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" id="bootstrap-style" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/css/app.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/icons.min.css" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/css/app.min.css" id="app-style" rel="stylesheet" type="text/css">
    <title>404 Error Page | Market</title>
</head>

<body>

<div class="account-pages my-5 pt-5">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="text-center mb-5">
<%--                    <i class="bx bx-buoy bx-spin text-primary display-3"></i>--%>
                    <h1 class="display-2 font-weight-medium">404</h1>
                    <h4 class="text-uppercase">Sorry, page not found</h4>
                    <div class="mt-5 text-center">
                        <a class="btn btn-primary waves-effect waves-light" href="<%=request.getContextPath()%>/market/main">Back to Dashboard</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-8 col-xl-6">
                <div>
                    <img src="<%=request.getContextPath()%>/images/error-img.png" alt="" class="img-fluid">
                </div>
            </div>
        </div>
    </div>
</div>>
<script src="<%=request.getContextPath()%>/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/js/app.js"></script>
<script src="<%=request.getContextPath()%>/js/all.min.js"></script>
</body>
</html>
