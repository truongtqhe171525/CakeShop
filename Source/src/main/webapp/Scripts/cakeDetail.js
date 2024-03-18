let indexSize = 0;
let cakeData = null;
let user = null;

let cakePriceEle = document.getElementsByClassName('cake-price')[0];
let cakeOldPriceEle = document.getElementsByClassName('cake-old-price')[0];
let cakeSizeEle = document.getElementsByClassName('list-cake-size')[0];
let quantityEle = document.getElementsByName('quantity')[0];

quantityEle.addEventListener("change", (event) => {
    if (Number(event.target.value) < 1) event.target.value = 1;
    else quantity = Number(event.target.value)
    changePrice();
})

const handleQuantity = (x) => {
    if (x === 1) {
        quantityEle.value = Number(quantityEle.value) + 1;
        changePrice();
    } else {
        if (Number(quantityEle.value) > 1) {
            quantityEle.value = Number(quantityEle.value) - 1;
            changePrice();
        }
    }
}

const checkUser = (userInfor) => {
    console.log(userInfor)
    user = JSON.parse(userInfor);
}

const loadDetail = (data) => {
    cakeData = data;
    document.getElementsByClassName('cake-image')[0].src = data.cakeImages[0].url;
    document.getElementsByClassName('cake-name')[0].innerHTML = data.name;
    document.getElementsByClassName('cake-description')[0].innerHTML = data.description;
    cakePriceEle.innerHTML = formatMoney(data.cakeSizes[0].price);
    cakeSizeEle.innerHTML = cakeSizes(data);
    if (Number(data.cakeSizes[0].oldPrice) != 0) cakeOldPriceEle.innerHTML = formatMoney(data.cakeSizes[0].oldPrice);
    else cakeOldPriceEle.innerHTML = "";
}

const cakeSizes = (data) => {
    let x = "";
    for (let i = 0; i < data.cakeSizes.length; i++) {
        if (i === 0) x += "<li style='background-color: var(--size-target-color)'"
        else x += "<li style='background-color: var(--size-untarget-color)'"
        x += " class='size-group' onclick='changeSize(" + i + ")'>" + data.cakeSizes[i].size + "</li>"
    }
    return x
}
const loadQuantity = (quantity) =>{
    if(quantity!=null){
        quantityEle.value = quantity;
        changePrice();
    }
}

const loadSize = (size) =>{
    if(size != null && size != ""){
        for (let i = 0; i < cakeData.cakeSizes.length; i++) {
            if(cakeData.cakeSizes[i].size===size){
                changeSize(i);
                break;
            }
        }
    }
}

const changeSize = (index) => {
    indexSize = index;
    changePrice();
    changeTarget(index)
}

const changePrice = () => {
    cakePriceEle.innerHTML = formatMoney((Number(cakeData.cakeSizes[indexSize].price) * Number(quantityEle.value)).toString());
    if (Number(cakeData.cakeSizes[indexSize].oldPrice) != 0) cakeOldPriceEle.innerHTML = formatMoney((Number(cakeData.cakeSizes[indexSize].oldPrice) * Number(quantityEle.value)).toString());
}

const changeTarget = (index) => {
    let sizeGroup = document.getElementsByClassName(`size-group`);

    for (let i = 0; i < sizeGroup.length; i++) {
        if (i === index) sizeGroup[i].style.backgroundColor = "var(--size-target-color)";
        else sizeGroup[i].style.backgroundColor = "var(--size-untarget-color)";
    }
}

const formatMoney = (money) => {
    return money.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".") + "đ";
}

const orderCake = () => {
    if (user == null) {
        Warning("You need to login to order cake", "window.location.href='/login'" , "Login now");
        return;
    }
    showOrderForm();
    document.getElementsByName('idCake')[0].value = cakeData.id;
    document.getElementsByName('sizeCake')[0].value = cakeData.cakeSizes[indexSize].size;
    document.getElementsByName('quantityCake')[0].value = Number(quantityEle.value);
    document.getElementsByName('idClient')[0].value = user.id;
    document.getElementsByName('total')[0].value = Number(cakeData.cakeSizes[indexSize].price) * Number(quantityEle.value);
}
const showOrderForm = ()=>{
    document.getElementsByClassName('order-form-container')[0].style.display = 'flex';
}
const checkFail = (fail) =>{
    if(fail!=null && fail!="") orderCake()
}

const checkSaveOrder = (rs) => {
    if(rs == "success") Success("Your order is success", "window.location.href='/cart'", "See your order");
}