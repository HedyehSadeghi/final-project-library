//


function changePrice(event){
    event.preventDefault();

    var amount= parseFloat(document.getElementById("amount").value);
    var price= parseFloat(document.getElementById("price").innerText);
    console.log(amount);
    console.log(price);


    var newPrice= amount * price;

    document.getElementById("totalPrice").innerHTML= newPrice;

    console.log(newPrice);

}