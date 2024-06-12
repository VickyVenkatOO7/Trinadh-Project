export function formatCurrency(price) {
    return (Math.round(price) / 100).toFixed(2);
}

export default formatCurrency;