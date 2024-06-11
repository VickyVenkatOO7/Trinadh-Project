export function formatCurrency(price) {
    return (Math.round(price)).toFixed(2);
}

export default formatCurrency;