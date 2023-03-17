<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>SIAKAD</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <asset:stylesheet href="css/styles.css"></asset:stylesheet>
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.8.2/angular.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/3.3.7/ui-bootstrap-tpls.min.js"></script>

</head>
<body class="sb-nav-fixed">
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <!-- Navbar Brand-->
    <a class="navbar-brand ps-3" href="${g.createLink(uri: '/dashboard')}">SIAKAD</a>
    <!-- Sidebar Toggle-->
    <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
    <!-- Navbar Search-->
    <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
        <div class="input-group">
            <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
            <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
        </div>
    </form>
    <!-- Navbar-->
    <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
%{--                <li><a class="dropdown-item" href="#!">Settings</a></li>--}%
%{--                <li><a class="dropdown-item" href="#!">Activity Log</a></li>--}%
%{--                <li><hr class="dropdown-divider" /></li>--}%
                <li><a class="dropdown-item" href="${g.createLink(uri: '/logout') }">Logout</a></li>
            </ul>
        </li>
    </ul>
</nav>
<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading"></div>
                    <a class="nav-link ${request.getRequestURI() == '/dashboard' ? 'active' : ''} " href="${g.createLink(uri: '/dashboard')}">
                        <div class="sb-nav-link-icon"><i class="fas fa-dashboard"></i></div>
                        Dashboard
                    </a>
                    <a class="nav-link ${request.getRequestURI() == '/dashboard/create-student' ? 'active' : '' || request.getRequestURI() == '/dashboard/student' ? 'active' : '' || request.getRequestURI().startsWith("/dashboard/update-student")  ? 'active' : '' || request.getRequestURI().startsWith("/dashboard/save-student")  ? 'active' : ''}  " href="${g.createLink(uri: '/dashboard/student')}">
                        <div class="sb-nav-link-icon"><i class="fas fa-user"></i></div>
                        Student
                    </a>
                    <a class="nav-link ${request.getRequestURI() == '/dashboard/study-plan' ? 'active' : '' || request.getRequestURI() == '/dashboard/add-course' ? 'active' : ''} " href="${g.createLink(uri: '/dashboard/study-plan')}">
                        <div class="sb-nav-link-icon"><i class="fas fa-file-alt"></i></div>
                        KRS
                    </a>
                    <a class="nav-link ${request.getRequestURI() == '/dashboard/study-plan-result' ? 'active' : ''} " href="${g.createLink(uri: '/dashboard/study-plan-result')}">
                        <div class="sb-nav-link-icon"><i class="fas fa-book"></i></div>
                        Kartu Hasil Studi
                    </a>
                    <a class="nav-link ${request.getRequestURI() == '/dashboard' ? 'active' : ''} " href="${g.createLink(uri: '/dashboard')}">
                        <div class="sb-nav-link-icon"><i class="fas fa-file-invoice-dollar"></i></div>
                        Pembayaran UKT
                    </a>
                    <a class="nav-link ${request.getRequestURI() == '/dashboard' ? 'active' : ''} " href="${g.createLink(uri: '/dashboard')}">
                        <div class="sb-nav-link-icon"><i class="fas fa-file-alt"></i></div>
                        Transkrip
                    </a>
%{--                    <div class="sb-sidenav-menu-heading">Interface</div>--}%
%{--                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">--}%
%{--                        <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>--}%
%{--                        Layouts--}%
%{--                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>--}%
%{--                    </a>--}%
%{--                    <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">--}%
%{--                        <nav class="sb-sidenav-menu-nested nav">--}%
%{--                            <a class="nav-link" href="layout-static.html">Static Navigation</a>--}%
%{--                            <a class="nav-link" href="layout-sidenav-light.html">Light Sidenav</a>--}%
%{--                        </nav>--}%
%{--                    </div>--}%
%{--                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">--}%
%{--                        <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>--}%
%{--                        Pages--}%
%{--                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>--}%
%{--                    </a>--}%
%{--                    <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">--}%
%{--                        <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">--}%
%{--                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">--}%
%{--                                Authentication--}%
%{--                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>--}%
%{--                            </a>--}%
%{--                            <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">--}%
%{--                                <nav class="sb-sidenav-menu-nested nav">--}%
%{--                                    <a class="nav-link" href="login.html">Login</a>--}%
%{--                                    <a class="nav-link" href="register.html">Register</a>--}%
%{--                                    <a class="nav-link" href="password.html">Forgot Password</a>--}%
%{--                                </nav>--}%
%{--                            </div>--}%
%{--                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">--}%
%{--                                Error--}%
%{--                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>--}%
%{--                            </a>--}%
%{--                            <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">--}%
%{--                                <nav class="sb-sidenav-menu-nested nav">--}%
%{--                                    <a class="nav-link" href="401.html">401 Page</a>--}%
%{--                                    <a class="nav-link" href="404.html">404 Page</a>--}%
%{--                                    <a class="nav-link" href="500.html">500 Page</a>--}%
%{--                                </nav>--}%
%{--                            </div>--}%
%{--                        </nav>--}%
%{--                    </div>--}%
%{--                    <div class="sb-sidenav-menu-heading">Addons</div>--}%
%{--                    <a class="nav-link" href="charts.html">--}%
%{--                        <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>--}%
%{--                        Charts--}%
%{--                    </a>--}%
%{--                    <a class="nav-link" href="tables.html">--}%
%{--                        <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>--}%
%{--                        Tables--}%
%{--                    </a>--}%
%{--                </div>--}%
            </div>
        </nav>
    </div>
    <div id="layoutSidenav_content">