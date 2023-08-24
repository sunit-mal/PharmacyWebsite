var totel = 0;

function calculatePrice(index, price) {
	var quantity = document.getElementById("quantity" + index).value;
	var totalPrice = price * quantity;
	document.getElementById("price" + index).value = totalPrice;
	totel += totalPrice;
	document.getElementById("total").value = totel;
}