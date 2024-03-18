<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <link rel="stylesheet" href="../Styles/header.css"/>
    <link rel="stylesheet" href="../Styles/footerSt.css"/>
    <link rel="stylesheet" href="../Styles/reset.css"/>
    <link rel="stylesheet" href="../Styles/home.css"/>

    <title>Cake Shop</title>
</head>

<body>
    <header class="header">
        <h1 class="header-icon"> Cake </h1>
        <nav class="header-navbar">
            <ul>
                <li class="header-target"><a href="/"> Home </a></li>
                <li><a href="/aboutUs"> About Us </a></li>
                <li><a href="/shop"> Shop </a></li>
                <li><a href="/contact"> Contact </a></li>
            </ul>
        </nav>
        <div class="header-action">
            <a href="/cart" class="header-cart">
                <svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 576 512" height="1em"
                     width="1em" xmlns="http://www.w3.org/2000/svg">
                    <path d="M253.3 35.1c6.1-11.8 1.5-26.3-10.2-32.4s-26.3-1.5-32.4 10.2L117.6 192H32c-17.7 0-32 14.3-32 32s14.3 32 32 32L83.9 463.5C91 492 116.6 512 146 512H430c29.4 0 55-20 62.1-48.5L544 256c17.7 0 32-14.3 32-32s-14.3-32-32-32H458.4L365.3 12.9C359.2 1.2 344.7-3.4 332.9 2.7s-16.3 20.6-10.2 32.4L404.3 192H171.7L253.3 35.1zM192 304v96c0 8.8-7.2 16-16 16s-16-7.2-16-16V304c0-8.8 7.2-16 16-16s16 7.2 16 16zm96-16c8.8 0 16 7.2 16 16v96c0 8.8-7.2 16-16 16s-16-7.2-16-16V304c0-8.8 7.2-16 16-16zm128 16v96c0 8.8-7.2 16-16 16s-16-7.2-16-16V304c0-8.8 7.2-16 16-16s16 7.2 16 16z"></path>
                </svg>
            </a>

            <div class="header-btn header-user">
                <button id="user-infor"></button>
                <button id="btn-logout" onclick="window.location.href='/logout'"> <svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 24 24" height="1em" width="1em" xmlns="http://www.w3.org/2000/svg"><path d="M16 13v-2H7V8l-5 4 5 4v-3z"></path><path d="M20 3h-9c-1.103 0-2 .897-2 2v4h2V5h9v14h-9v-4H9v4c0 1.103.897 2 2 2h9c1.103 0 2-.897 2-2V5c0-1.103-.897-2-2-2z"></path></svg> Log out</button>
            </div>
            <div class="header-btn header-login">
                <button id="btn-login" onclick="window.location.href='/login'"> Login</button>
                <button id="btn-signin" onclick="window.location.href='/signin'"> Sign In</button>
            </div>

        </div>
    </header>

    <main>

        <div class="slideshow">
            <div class="slideshow-image">
                <img id="slideshow-image"
                     src="//bakeryn-store-demo.myshopify.com/cdn/shop/files/slideshowV1-bg1.jpg?v=1642004254" alt="">
            </div>
            <div class="slideshow-content">
                <h2> SPECIAL OFFER </h2>
                <h1> Sweet Cakes </h1>
                <button><a href="/shop"> Shop now </a></button>
            </div>
            <button class="btn-slideshow-left" onclick="changeSliceShow()">
                <svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 512 512" height="1em"
                     width="1em" xmlns="http://www.w3.org/2000/svg">
                    <path d="M217.9 256L345 129c9.4-9.4 9.4-24.6 0-33.9-9.4-9.4-24.6-9.3-34 0L167 239c-9.1 9.1-9.3 23.7-.7 33.1L310.9 417c4.7 4.7 10.9 7 17 7s12.3-2.3 17-7c9.4-9.4 9.4-24.6 0-33.9L217.9 256z"></path>
                </svg>
            </button>
            <button class="btn-slideshow-right" onclick="changeSliceShow()">
                <svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 512 512" height="1em"
                     width="1em" xmlns="http://www.w3.org/2000/svg">
                    <path d="M294.1 256L167 129c-9.4-9.4-9.4-24.6 0-33.9s24.6-9.3 34 0L345 239c9.1 9.1 9.3 23.7.7 33.1L201.1 417c-4.7 4.7-10.9 7-17 7s-12.3-2.3-17-7c-9.4-9.4-9.4-24.6 0-33.9l127-127.1z"></path>
                </svg>
            </button>
        </div>

        <div class="introduction">
            <div class="introduction-top">
                <h3> Delicieux </h3>
                <p>WELCOME TO THE STORE</p>
                <img decoding="async"
                     src="https://warethemes.com/wordpress/bready/wp-content/themes/bready/assets/images/icons/floral.png"
                     alt="Delicieux">
            </div>

            <ul class="introduction-center">
                <li>
                    <img decoding="async"
                         src="https://warethemes.com/wordpress/bready/wp-content/uploads/2018/09/award-1.png"
                         alt="BAKERY OF THE YEAR">
                    <h4>
                        BAKERY OF THE YEAR
                        <span>2011 -2012</span>
                    </h4>
                    <p>Tart bear claw cake tiramisu chocolate bar gummies dragée lemon drops brownie. Jujubes chocolate cake
                        sesame snaps</p>
                </li>

                <li>
                    <img decoding="async"
                         src="https://warethemes.com/wordpress/bready/wp-content/uploads/2018/09/award-2.png"
                         alt="CUPCAKES SHOP OF THE YEAR">
                    <h4>
                        CUPCAKES SHOP OF THE YEAR
                        <span>2012 - 2015</span>
                    </h4>
                    <p>Tart bear claw cake tiramisu chocolate bar gummies dragée lemon drops brownie. Jujubes chocolate cake
                        sesame snaps</p>
                </li>

                <li>
                    <img decoding="async"
                         src="https://warethemes.com/wordpress/bready/wp-content/uploads/2018/09/award-3.png"
                         alt="BAKERY OF THE MONTH">
                    <h4>
                        BAKERY OF THE MONTH
                        <span>2017 - 2018</span>
                    </h4>
                    <p>Tart bear claw cake tiramisu chocolate bar gummies dragée lemon drops brownie. Jujubes chocolate cake
                        sesame snaps</p>
                </li>
            </ul>

            <div class="introduction-bottom">
                <img decoding="async" src="https://warethemes.com/wordpress/bready/wp-content/uploads/2018/10/baker-png.png"
                     alt="Bready">
                <p>“It seems that every country that can get its hands on butter has its opinion of what butter cream
                    frosting should be. Some are made with eggs and butter.”</p>
            </div>

        </div>

        <div class="home-contact">
            <div>
                <img src='https://warethemes.com/wordpress/bready/wp-content/uploads/2018/09/1-1.jpg'/>
            </div>
            <div>
                <h3>OFFICE AT VIETNAM</h3>
                <h3>189/32, ABC, VIET NAM</h3>
                <p>+8400-000-0000</p>
            </div>
        
            <div>
                <img src='https://warethemes.com/wordpress/bready/wp-content/uploads/2018/09/2-1.jpg'/>
            </div>

            <div>
                <p> Every day we make </p>
                <h3> Freshly baker Bread </h3>
                <p> Bakery. See more. Do more</p>
            </div>

            <div>
                <h3>Time to Open</h3>
                <p>Monday - Friday:<br>
                08:00 am - 08:30 pm<br>
                Saturday - Sunday:<br>
                10:00 am - 16:30 pm</p>
            </div>

            <div>
                <img src='https://warethemes.com/wordpress/bready/wp-content/uploads/2018/09/3-1.jpg'/>
            </div>
            <div>
                <h3>Love Bready?</h3>
                <p>Leverage agile frameworks to provide a</p>
                <a href="/shop">Join with us</a>
            </div>

            <div>
                <img src='https://warethemes.com/wordpress/bready/wp-content/uploads/2018/09/4.jpg'/>
            </div>
        </div>

    </main>


    <footer class="footer">              
        <ul>
            <h1 class="footer-icon"> Cake </h1>
            <p class="footer-title">Sophisticated simplicity for the independent mind.</p>
            <ul class="list-icon">
                <li>
                    <a href="" class="social-item"><svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 320 512" height="1em" width="1em" xmlns="http://www.w3.org/2000/svg"><path d="M279.14 288l14.22-92.66h-88.91v-60.13c0-25.35 12.42-50.06 52.24-50.06h40.42V6.26S260.43 0 225.36 0c-73.22 0-121.08 44.38-121.08 124.72v70.62H22.89V288h81.39v224h100.17V288z"></path></svg></a>
                </li>
                
                <li>
                    <a href="" class="social-item"><svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 512 512" height="1em" width="1em" xmlns="http://www.w3.org/2000/svg"><path d="M459.37 151.716c.325 4.548.325 9.097.325 13.645 0 138.72-105.583 298.558-298.558 298.558-59.452 0-114.68-17.219-161.137-47.106 8.447.974 16.568 1.299 25.34 1.299 49.055 0 94.213-16.568 130.274-44.832-46.132-.975-84.792-31.188-98.112-72.772 6.498.974 12.995 1.624 19.818 1.624 9.421 0 18.843-1.3 27.614-3.573-48.081-9.747-84.143-51.98-84.143-102.985v-1.299c13.969 7.797 30.214 12.67 47.431 13.319-28.264-18.843-46.781-51.005-46.781-87.391 0-19.492 5.197-37.36 14.294-52.954 51.655 63.675 129.3 105.258 216.365 109.807-1.624-7.797-2.599-15.918-2.599-24.04 0-57.828 46.782-104.934 104.934-104.934 30.213 0 57.502 12.67 76.67 33.137 23.715-4.548 46.456-13.32 66.599-25.34-7.798 24.366-24.366 44.833-46.132 57.827 21.117-2.273 41.584-8.122 60.426-16.243-14.292 20.791-32.161 39.308-52.628 54.253z"></path></svg></a>
                </li>
                
                <li>
                    <a href="" class="social-item"><svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 448 512" height="1em" width="1em" xmlns="http://www.w3.org/2000/svg"><path d="M224.1 141c-63.6 0-114.9 51.3-114.9 114.9s51.3 114.9 114.9 114.9S339 319.5 339 255.9 287.7 141 224.1 141zm0 189.6c-41.1 0-74.7-33.5-74.7-74.7s33.5-74.7 74.7-74.7 74.7 33.5 74.7 74.7-33.6 74.7-74.7 74.7zm146.4-194.3c0 14.9-12 26.8-26.8 26.8-14.9 0-26.8-12-26.8-26.8s12-26.8 26.8-26.8 26.8 12 26.8 26.8zm76.1 27.2c-1.7-35.9-9.9-67.7-36.2-93.9-26.2-26.2-58-34.4-93.9-36.2-37-2.1-147.9-2.1-184.9 0-35.8 1.7-67.6 9.9-93.9 36.1s-34.4 58-36.2 93.9c-2.1 37-2.1 147.9 0 184.9 1.7 35.9 9.9 67.7 36.2 93.9s58 34.4 93.9 36.2c37 2.1 147.9 2.1 184.9 0 35.9-1.7 67.7-9.9 93.9-36.2 26.2-26.2 34.4-58 36.2-93.9 2.1-37 2.1-147.8 0-184.8zM398.8 388c-7.8 19.6-22.9 34.7-42.6 42.6-29.5 11.7-99.5 9-132.1 9s-102.7 2.6-132.1-9c-19.6-7.8-34.7-22.9-42.6-42.6-11.7-29.5-9-99.5-9-132.1s-2.6-102.7 9-132.1c7.8-19.6 22.9-34.7 42.6-42.6 29.5-11.7 99.5-9 132.1-9s102.7-2.6 132.1 9c19.6 7.8 34.7 22.9 42.6 42.6 11.7 29.5 9 99.5 9 132.1s2.7 102.7-9 132.1z"></path></svg></a>
                </li>
                
                <li>
                    <a href="" class="social-item"><svg stroke="currentColor" fill="currentColor" stroke-width="0" version="1.2" baseProfile="tiny" viewBox="0 0 24 24" height="1em" width="1em" xmlns="http://www.w3.org/2000/svg"><path d="M8.865 5c.751 0 1.44.202 2.069.609.324-.08.711-.121 1.157-.121 1.846 0 3.418.67 4.717 2.008 1.299 1.339 1.948 2.962 1.948 4.87 0 .466-.051.953-.152 1.461.264.589.396 1.187.396 1.794 0 1.097-.38 2.036-1.142 2.815-.761.781-1.668 1.173-2.725 1.173-.629 0-1.237-.162-1.825-.488-.527.081-.933.122-1.217.122-1.847 0-3.425-.67-4.733-2.009s-1.963-2.962-1.963-4.868c0-.447.051-.902.152-1.37-.364-.609-.547-1.288-.547-2.039 0-1.096.376-2.029 1.126-2.799.75-.772 1.664-1.158 2.739-1.158m3.135 10.53c-.406 0-.729-.061-.975-.183-.263-.142-.445-.284-.547-.425-.243-.447-.376-.681-.396-.7-.081-.243-.202-.447-.364-.609-.203-.14-.406-.213-.61-.213-.284 0-.517.091-.7.274-.183.182-.274.396-.274.639 0 .386.144.801.428 1.248.263.405.629.741 1.096 1.003.648.346 1.45.519 2.404.519.79 0 1.49-.122 2.1-.365.609-.284 1.055-.639 1.339-1.065.304-.467.456-.975.456-1.522 0-.445-.08-.852-.242-1.217-.163-.304-.416-.578-.762-.82-.365-.225-.75-.407-1.156-.548-.689-.204-1.178-.336-1.461-.396-.143-.021-.32-.055-.533-.107l-.41-.106c-.243-.08-.416-.152-.518-.212-.163-.081-.294-.193-.396-.336-.103-.1-.152-.233-.152-.396 0-.243.142-.455.426-.639.265-.203.649-.305 1.156-.305.508 0 .884.092 1.127.273.263.225.456.478.577.762.163.264.295.446.396.547.162.123.355.184.578.184.264 0 .498-.102.699-.306.184-.181.275-.404.275-.669 0-.202-.072-.467-.214-.791-.162-.243-.376-.486-.639-.729-.284-.224-.659-.417-1.127-.579-.485-.143-1.004-.213-1.552-.213-.73 0-1.38.11-1.948.335-.566.2-1.003.505-1.307.911-.305.406-.457.872-.457 1.4 0 .527.143.984.426 1.37.346.405.73.688 1.156.851.488.224 1.076.407 1.766.548.121.021.27.056.441.106l.457.123.319.075c.284.103.517.243.699.427.183.141.274.354.274.639 0 .346-.162.629-.486.853-.364.243-.821.364-1.369.364m-3.135-12.53c-1.609 0-3.053.61-4.174 1.765-1.105 1.134-1.691 2.585-1.691 4.192 0 .832.156 1.619.466 2.348-.047.357-.07.713-.07 1.062 0 2.438.853 4.547 2.532 6.267 1.693 1.732 3.768 2.61 6.164 2.61.254 0 .547-.02.896-.06.69.283 1.409.426 2.146.426 1.588 0 3.025-.614 4.157-1.777 1.117-1.143 1.709-2.6 1.709-4.211 0-.677-.111-1.349-.332-2.004.059-.427.089-.846.089-1.251 0-2.437-.846-4.544-2.513-6.263-1.685-1.735-3.755-2.615-6.152-2.615-.279 0-.546.013-.801.038-.756-.35-1.568-.527-2.426-.527z"></path></svg></a>
                </li>
            </ul>
        </ul>
        
        <ul class="catefory-list">
            <h2> Help & Information </h2>
            <li><a href="/aboutUs" title="About Us">About Us</a></li>
            
            <li><a href="/" title="Privacy Policy">Privacy Policy</a></li>
            
            <li><a href="/" title="Terms &amp; Conditions">Terms &amp; Conditions</a></li>
            
            <li><a href="/" title="Products Return">Products Return</a></li>
            
            <li><a href="/" title="Wholesale Policy">Wholesale Policy</a></li>
        
        </ul>        
        
        <ul class="catefory-list">
            <h2> Quick Shop </h2>
            <li><a href="/" title="Pagination">Pagination</a></li>
            
            <li><a href="/" title="Terms &amp; Conditions">Terms &amp; Conditions</a></li>
            
            <li><a href="/contact" title="Contact">Contact</a></li>
            
            <li><a href="/" title="Accessories">Accessories</a></li>
            
            <li><a href="/" title="Term of use">Term of use</a></li>
            
        </ul>        
    
    
        <ul class="catefory-list">
            <h2> Categories </h2>
            <li><a href="/" title="Croissant">Croissant</a></li>
            
            <li><a href="/" title="Donuts">Donuts</a></li>
            
            <li><a href="/" title="Dough">Dough</a></li>
            
            <li><a href="/" title="Flour">Flour</a></li>
            
            <li><a href="/" title="Pies Sweet">Pies Sweet</a></li>
        
        </ul>        
    </footer>

    <script src="../Scripts/index.js"></script>
    <script src="../Scripts/loadUser.js"></script>
    <script>
        loadUserSc(${userInfor})
    </script>

</body>
</html>