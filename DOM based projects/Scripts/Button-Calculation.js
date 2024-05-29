function subscribe() {
    const buttonElement = document.querySelector('button');
    if (buttonElement.innerHTML === 'Subscribe') {
        buttonElement.innerHTML = 'Subscribed';
        buttonElement.classList.add('is-subscribed');
    } else {
        buttonElement.innerHTML = 'Subscribe';
        buttonElement.classList.remove('is-subscribed');
    }
}

function calcualateTotal() {
    const inputElement = document.querySelector('.js-cost-input');
    let cost = Number(inputElement.value);
    if (cost < 40) {
        cost = cost + 10;
    }

    document.querySelector('.js-total-cost').innerHTML = `$${cost}`;
}

function handleKeyDown(event) {
    if (event.key === 'Enter') {
        calcualateTotal();
    }
}

function handleAutoUpdateText() {
    const inputElement = document.querySelector('.js-text-autoupdate');
    document.querySelector('.js-updated-text').innerHTML = inputElement.value;
}