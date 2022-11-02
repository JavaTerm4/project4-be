<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="w3l-breadcrumb">
    <div class="breadcrum-bg py-sm-5 py-4">
        <div class="container py-lg-3">

            <h2>Contact</h2>
            <p>
                <a href="${pageContext.request.contextPath }/home">Home</a> &nbsp; /
                &nbsp; Contact
            </p>

        </div>
    </div>
</section>
    <section class="w3l-contact-1 py-5">
    <div class="contacts-9 py-lg-5 py-sm-4">
        <div class="container">
            <div class="d-grid contact-view">
                <div class="cont-details">
                    <p>Get in touch</p>
                    <h3 class="title-big">Contact and Access</h3>
                </div>
                <div class="map-content-9">
                    <p>Officially opened in December 2019, Homie Hotel, MGallery Collection is located 
                    in the centre of Ho Chi Minh's most vibrant district, just away from Notre Dame Cathedral, Opera House,
                     Central Post Office. history and other key tourist attractions a few kilometers. The hotel is just 20 
                     minutes drive from Tan Son Nhat international Airport.</p>
                </div>
            </div>
            <div class="map-iframe my-5">
               <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d31352.84697489185!2d106.65596577019265!3d10.803202757406456!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752ed245c18b99%3A0x83d529c21d62670a!2zNTkwIMSQLiBDw6FjaCBN4bqhbmcgVGjDoW5nIDgsIFBoxrDhu51uZyAxMSwgUXXhuq1uIDMsIFRow6BuaCBwaOG7kSBI4buTIENow60gTWluaCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1647790711973!5m2!1svi!2s" width="100%" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
            </div>
            <div class="d-grid contact-view">
                <div class="cont-details">
                    <div class="cont-top">
                        <div class="cont-left text-center">
                            <span class="fa fa-phone text-primary"></span>
                        </div>
                        <div class="cont-right">
                            <h6>Call Us</h6>
                            <p><a href="tel:+44 99 555 42">+84 123 456 789</a></p>
                        </div>
                    </div>
                    <div class="cont-top margin-up">
                        <div class="cont-left text-center">
                            <span class="fa fa-envelope-o text-primary"></span>
                        </div>
                        <div class="cont-right">
                            <h6>Email Us</h6>
                            <p><a href="mailto:example@mail.com" class="mail">hotel@fpt.edu.vn</a></p>
                        </div>
                    </div>	
                    <div class="cont-top margin-up">
                        <div class="cont-left text-center">
                            <span class="fa fa-map-marker text-primary"></span>
                        </div>
                        <div class="cont-right">
                            <h6>Address</h6>
                            <p>590 Cach Mang Thang 8, Ward 11, District 3, Ho Chi Minh City.
									</p>
                        </div>
                    </div>
                </div>
                <div class="map-content-9 mt-lg-0 mt-4">
                    <form  method="post" action="/send">
                        <div class="twice-two">
                            <input type="text" class="form-control" name="name" id="name" placeholder="Your name"
                                required>
                            <input type="email" class="form-control" name="to" id="to" placeholder="Email"
                                required>
                        </div>
                        <div class="twice">
                            <input type="text" class="form-control" name="subject" id="subject"
                                placeholder="Topic" required>
                        </div>
                        <textarea name="content" class="form-control" id="content" placeholder="Message"
                            required></textarea>
                        <button type="submit" class="btn btn-contact">Send Message</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>