const removeExistAnimation = () => {
    let CardAnimation = document.getElementsByClassName('card-animation');
    for (let i = 0; i < CardAnimation.length; i++) {
        CardAnimation[i].style.animation = 'none';
    }
}
const loadCake = (data) => {
    removeExistAnimation()
    let xml = "";
    data.forEach(cake => {
        xml += cakeCard(cake);
    });
    document.querySelector('.list-cake').innerHTML += xml;
}

const cakeCard = (data) => {
    return `
            <li class="card-animation cake-card">
                    <a href="/cakeDetail?id=${data.id}">
                        <img class="cake-image" src="${data.cakeImages[0].url}" alt="cake" loading="lazy"/>
                    </a>
                    <div class="card-content"> 
                        <a class="cake-name" href="/cakeDetail?id=${data.id}"> ${data.name} </a>
                        ${cakeSizes(data)}
                        <div class="cake-old-price" id="cake-old-price-${data.id}"> ${data.cakeSizes[0].oldPrice == 0 ? "" : formatMoney(data.cakeSizes[0].oldPrice)} </div>
                        <div class="cake-price" id="cake-price-${data.id}"> ${formatMoney(data.cakeSizes[0].price)} </div>
                        <a class="more-infor" href="/cakeDetail?id=${data.id}"> Xem chi tiết </a>
                    </div>
               
            </li>
        `
}

const cakeSizes = (data) => {
    let x = "<ul class='list-cake-size'> ";
    for (let i = 0; i < data.cakeSizes.length; i++) {
        let size = data.cakeSizes[i]
        if (i === 0) x += "<li style='background-color: var(--size-target-color)'"
        else x += "<li style='background-color: var(--size-untarget-color)'"
        x += " class='size-group-" + data.id + "' onclick='changePrice(" + data.id + "," + size.oldPrice + "," + size.price + "," + i + ")'>" + size.size + "</li>"
    }
    return x + "</ul>"
}
const changePrice = (id, oldPrice, price, index) => {
    if (oldPrice == 0) oldPrice = "";
    document.getElementById(`cake-old-price-${id}`).innerHTML = formatMoney(oldPrice);
    document.getElementById(`cake-price-${id}`).innerHTML = formatMoney(price);
    changeTarget(id, index)
}

const changeTarget = (id, index) => {
    let sizeGroup = document.getElementsByClassName(`size-group-${id}`);

    for (let i = 0; i < sizeGroup.length; i++) {
        if (i === index) sizeGroup[i].style.backgroundColor = "var(--size-target-color)";
        else sizeGroup[i].style.backgroundColor = "var(--size-untarget-color)";
    }
}

const formatMoney = (money) => {
    return money.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".") + "đ";
}