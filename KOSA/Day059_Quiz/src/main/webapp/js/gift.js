function submitForm(action) {
    let form = document.getElementById('giftForm');
    form.action = action;
    form.submit();
}