//


function changePrice(event){
    event.preventDefault();

    var amount= parseFloat(document.getElementById("amount").value);
    var price= parseFloat(document.getElementById("price").innerText);
    console.log(amount);
    console.log(price);


    var newPrice= amount * price;
    var roundedPrice = newPrice.toFixed(2);

    document.getElementById("totalPrice").innerHTML= roundedPrice;

    console.log(newPrice);

}
