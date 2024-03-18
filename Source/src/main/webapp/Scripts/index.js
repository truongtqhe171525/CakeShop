let indexImg = 0;
let sliceshowImg = ["//bakeryn-store-demo.myshopify.com/cdn/shop/files/slideshowV1-bg1.jpg?v=1642004254", "//bakeryn-store-demo.myshopify.com/cdn/shop/files/slideshowV1-bg2.jpg?v=1642004254"];

const changeSliceShow = () => {
    if (indexImg === 0) indexImg = 1;
    else indexImg = 0;
    document.getElementsByClassName("slideshow-image")[0].innerHTML = `
        <img id="slideshow-image" src="${sliceshowImg[indexImg]}" alt="">
    `

}