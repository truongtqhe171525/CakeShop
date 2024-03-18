const loadOrder = (data) => {
    let xml = ""
    if(data == null || data.length == 0) xml = emptyCard();
    else {
        data.forEach(order => {
            xml += orderCard(order);
        })
    }
    document.getElementsByClassName('list-order')[0].innerHTML = xml;
}

const orderCard = (data) => {
    return `
        <li class="order-card">
            <a class="order-image" href="/cakeDetail?id=${data.idCake}">
                <img src="${data.url}"/>
            </a>
            <div class="order-content">
                <a href="/cakeDetail?id=${data.idCake}" class="order-name"> ${data.cakeName} </a>
                <div class="order-title-group"> Kích thước: <span> ${data.size} </span> </div>
                <div class="order-title-group"> Số lượng: <span> ${data.quantity} </span></div>
                <div class="order-title-group"> Địa chỉ: <span> ${data.address} </span> </div>
                <div class="order-title-group"> Ngày giao: <span> ${new Date(data.date).toLocaleString()} </span> </div>
                <div class="order-title-group"> Lưu ý: <span class="order-notice"> ${data.notice} </span> </div>
                <div class="order-title-group"> Tổng: <span> ${data.total} </span> </div>
            <div class="cake-price"></div>
        </li>
    `
}

const emptyCard = () => {
    return `
        <div class="empty-order">
            <img src="https://cdni.iconscout.com/illustration/premium/thumb/empty-cart-7359557-6024626.png" alt="empty-cart"/>
            <div>
                <h1> You don't have any order </h1>
                <a href="/shop"> Go to shop </a>
            </div>
        </div>
    `
}

const checkLogin = (user) =>{
    if(user == null) Warning("You need to login to view your order", "window.location.href='/login'" , "Login now");
}