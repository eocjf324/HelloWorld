<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="container-fluid bg-white sticky-top">
        <div class="container">
            <nav class="navbar navbar-expand-lg bg-white navbar-light py-2 py-lg-0">
                <a href="home.do" class="navbar-brand">
                    <img class="img-fluid" src="TeaHouse/img/logo.png" alt="Logo">
                </a>
                <button type="button" class="navbar-toggler ms-auto me-0" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <div class="navbar-nav ms-auto">
                        <a href="home.do" class="nav-item nav-link active">Home</a>
                        <a href="about.do" class="nav-item nav-link">About</a>
                        <a href="product.do" class="nav-item nav-link">Products</a>
                        <a href="store.do" class="nav-item nav-link">Store</a>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">회사소개</a>
                            <div class="dropdown-menu bg-light rounded-0 m-0">
                                <a href="feature.do" class="dropdown-item">Features</a>
                                <a href="blog.html" class="dropdown-item">Blog Article</a>
                                <a href="testimonial.html" class="dropdown-item">Testimonial</a>
                                <a href="admin.do" class="dropdown-item">관리자</a>
                               
                            </div>
                        </div>
                        <a href="contact.do" class="nav-item nav-link">Contact</a>
                    </div>
                    <div class="border-start ps-4 d-none d-lg-block">
                        <button type="button" class="btn btn-sm p-0"><i class="fa fa-search"></i></button>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</body>
</html>