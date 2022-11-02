<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="w3l-breadcrumb">
    <div class="breadcrum-bg py-sm-5 py-4">
        <div class="container py-lg-3">

            <h2>Blog Posts</h2>
            <p><a href="${pageContext.request.contextPath }/home">Home</a> &nbsp; / &nbsp; Blog</p>

        </div>
    </div>
</section>
<section class="w3l-blog py-5">
    <div class="grid-view py-lg-5 py-sm-4">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="row">
                        <div class="col-lg-6 col-md-6">
                            <div class="grids5-info">
                                <a href="blog-single.html" class="d-block zoom"><img src="images/blog1.jpg"
                                        alt="" class="img-fluid news-image" /></a>
                                <div class="blog-info">
                                    <h4><a href="blog-single">How to make best holiday with your family</a></h4>
                                    <p class="date">March 10, 2022</p>
                                    <p class="blog-text">Top 10 Tips for the Perfect Family Holiday
										Planning a family holiday can be daunting, whether you’re travelling 
										with an irritable new-born or an irritable pre-teen, you have to ensure that 
										you get the right balance between family fun and relaxation. To help anyone planning 
										a family holiday this summer, we’ve put together some top tips to help you achieve 
										the perfect trip.</p>
                                    <a href="blog-single" class="btn btn-news mt-4" style="color: orange;">Read More</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 mt-md-0 mt-4">
                            <div class="grids5-info">
                                <a href="blog-single.html" class="d-block zoom"><img src="images/blog2.jpg"
                                        alt="" class="img-fluid news-image" /></a>
                                <div class="blog-info">
                                    <h4><a href="blog-single">Natural relaxation - Hotel SPA & Wellness</a></h4>
                                    <p class="date">March 11, 2022</p>
                                    <p class="blog-text">Welcome to a place where you can escape everyday life 
                                    and retreat into a sanctuary filled with healing treatments, soothing sounds and caressing aromas. 
                                    A unique environment providing you a wellness experience like none other.</p>
                                    <a href="blog-single" class="btn btn-news mt-4" style="color: orange;">Read More</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 mt-4">
                            <div class="grids5-info">
                                <a href="blog-single.html" class="d-block zoom"><img src="images/blog3.jpg"
                                        alt="" class="img-fluid news-image" /></a>
                                <div class="blog-info">
                                    <h4><a href="blog-single">Have a “Name Our New Drink” contest</a></h4>
                                    <p class="date">March 10, 2022</p>
                                    <p class="blog-text">Post a picture of the new drink that is being served by your bar staff, 
                                    then offer your guests an opportunity to name the new drink for a limited period of time.  
                                    Offer a small prize to the winner of the contest, and name the drink the winning name for a select period of time.</p>
                                    <a href="blog-single" class="btn btn-news mt-4" style="color: orange;">Read More</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 mt-4">
                            <div class="grids5-info">
                                <a href="blog-single" class="d-block zoom"><img src="images/blog4.jpg"
                                        alt="" class="img-fluid news-image" /></a>
                                <div class="blog-info">
                                    <h4><a href="blog-single">8 Unexpected Cinco de Mayo Recipes</a></h4>
                                    <p class="date">March 11, 2022</p>
                                    <p class="blog-text">We asked Omni chefs to share their favorite Cinco de Mayo recipes. 
                                    If you’re hosting your own fiesta or just looking to spice up dinner </p>
                                    <a href="blog-single" class="btn btn-news mt-4" style="color: orange;">Read More</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 mt-lg-0 mt-4">
                    <div class="best-rooms bg-transparent">
                        <div class="grids5-info">
                            <div class="blog-info-bg-primary text-center mb-4">
                                <h4><a href="https://www.facebook.com/Homie-Hotel-HCM-108866298425783">Follow our <b>Resort Luxury Hotels</b></a></h4>
                            </div>
                        </div>
                        <div class="grids5-info">
                            <div class="blog-info blog-info-bg-theme-light text-center mb-4">
                                <div class="blog-icon mb-4">
                                    <a href="blog-single"><span class="fa fa-link"></span></a>
                                </div>
                                <h4><a href="blog-single">How to make best holiday with your family</a></h4>
                            </div>
                        </div>
                        <div class="maghny-gd-1">
                            <div class="maghny-grid">
                                <figure class="effect-lily border-radius">
                                    <img class="img-fluid" src="images/bottom.jpg">
                                    <figcaption class="w3set-hny">
                                        <div>
                                            <h4>Family Rooms <span> Hotels</span></h4>
                                            <p><a href="blog-single" style="color: orange;">Read More</a> </p>
                                        </div>
                                    </figcaption>
                                </figure>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
              <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center mt-sm-5 mt-4 mb-0">
                    <li class="page-item disabled">
                        <a class="page-link page-prev" href="#previous" tabindex="-1">Previous</a>
                    </li>
                    <li class="page-item"><a class="page-link page-number" href="#1">1</a></li>
                    <li class="page-item active"><a class="page-link page-number" href="#2">2</a></li>
                    <li class="page-item"><a class="page-link page-number" href="#3">3</a></li>
                    <li class="page-item"><a class="page-link page-next" href="#next">→</a></li>
                </ul>
            </nav>
        </div>
    </div>
</section>