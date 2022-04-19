function calculate(){
	var index = document.cartForm.productID.selectedIndex;
	var price = document.cartForm.productID.options[index].getAttribute("price");
	var quantity = document.cartForm.quantity.value;
	document.getElementsByName('price')[0].innerText = quantity * price;
}