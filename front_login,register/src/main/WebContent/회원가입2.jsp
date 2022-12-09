<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
 <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>CustomMovie</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">





<!-- -------------------------------------------------------------------------------------------------------- -->

  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>회원가입 화면</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="newM/img/favicon.png" rel="icon">
  <link href="newM/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="newM/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="newM/vendor/aos/aos.css" rel="stylesheet">
  <link href="newM/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="newM/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="newM/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="newM/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="newM/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="newM/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Restaurantly - v3.1.0
  * Template URL: https://bootstrapmade.com/restaurantly-restaurant-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <!-- ======= Top Bar ======= -->



  <!-- ======= Header ======= -->




    <!-- ======= Book A Table Section ======= -->
    <section id="book-a-table" class="book-a-table">
      <div class="container" data-aos="fade-up">

        <div class="section-title">
          <h2>회원가입</h2>
          <a href="home.jsp"><p>Join Membership</p></a>
        </div>

        <form action="forms/book-a-table.php" method="post" role="form" class="php-email-form" data-aos="fade-up" data-aos-delay="100">
          <div class="row" style="float: left; width: 60%; height: 80%;">
            <div class="form-group mt-3">
            <div class="col-2 text-center" style="float:left;"><p>아이디</p></div>
              <input type="text" class="col-6" name="name" id="name" placeholder="Your Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
              <div class="validate"></div>
            </div>
            <div class="form-group mt-3">
              <div class="col-2 text-center" style="float:left;">비밀번호</div> <input type="text" class="col-6" name="password" id="password" placeholder="Your Password" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
              <div class="validate"></div>
            </div>
            <div class="form-group mt-3">
               <div class="col-2 text-center" style="float:left;">비밀번호 확인</div><input type="text" class="col-6" name="passwordCheck" id="passwordCheck" placeholder="Your Password" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
              <div class="validate"></div>
            </div>
            <div class="form-group mt-3">
               <div class="col-2 text-center" style="float:left;">e-mail</div><input type="email" class="col-6" name="email" id="email" placeholder="Your Email" data-rule="email" data-msg="Please enter a valid email">
              <div class="validate"></div>
            </div>
            <div class="form-group mt-3">
               <div class="col-2 text-center" style="float:left;">생년월일</div><input type="text" class="col-6" name="birthday" id="birthday" placeholder="Your Birthday" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
              <div class="validate"></div>
            </div>
            <div class="form-group mt-3 mt-3 mt-md-0">
               <div class="col-2 text-center" style="float:left;">닉네임</div><input type="text" class="col-6" name="nickname" id="nickname" placeholder="Your NickName" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
              <div class="validate"></div>
            </div>
            <!--  div class="col-lg-4 col-md-6 form-group mt-3">
              <input type="number" class="form-control" name="people" id="people" placeholder="# of people" data-rule="minlen:1" data-msg="Please enter at least 1 chars">
              <div class="validate"></div>
            </div>-->
          </div>
          <div class="row" style="float: left; width: 40%; height: 80%; border-left:1px solid #d9ba85;">
	          <div class="form-group mt-3">
	            <h3>MBTI</h3>
	            <p>E<input type="range">I</p>
	            <p>S<input type="range">N</p>
	            <p>T<input type="range">F</p>
	            <p>J<input type="range">P</p>
	            <br><hr>
	            <div class="validate"></div>
	          </div>
          </div>
          <div class="mt-3">
          <div class="text-center"><p><button type="submit">가입 신청</button></p></div>
            <div class="loading">Loading</div>
            <div class="error-message"></div>
            <div class="sent-message">Your booking request was sent. We will call back or send an Email to confirm your reservation. Thank you!</div>
          </div>
        </form>

      </div>
    </section><!-- End Book A Table Section -->

  

  <div id="preloader"></div>
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>