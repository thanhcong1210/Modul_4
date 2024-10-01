function updateTotalPrice() {
    let totalPrice = 0;
    document.querySelectorAll('.card').forEach(function(card) {
        let price = parseFloat(card.querySelector('.card-price').textContent);
        let quantity = parseInt(card.querySelector('.quantityDisplay').value);
        totalPrice += price * quantity;
    });
    document.getElementById('totalPriceDisplay').textContent = totalPrice.toFixed(2);
    document.getElementById('totalPriceDisplayPay').textContent = totalPrice.toFixed(2);
}

document.querySelectorAll('.decrease-btn').forEach(function(button) {
    button.addEventListener('click', function() {
        let input = button.parentElement.querySelector('.quantityDisplay');
        let currentQuantity = parseInt(input.value);
        if (currentQuantity > 1) {
            currentQuantity--;
            input.value = currentQuantity;
            updateTotalPrice();
        }
    });
});

document.querySelectorAll('.increase-btn').forEach(function(button) {
    button.addEventListener('click', function() {
        let input = button.parentElement.querySelector('.quantityDisplay');
        let currentQuantity = parseInt(input.value);
        currentQuantity++;
        input.value = currentQuantity;
        updateTotalPrice();
    });
});
updateTotalPrice();