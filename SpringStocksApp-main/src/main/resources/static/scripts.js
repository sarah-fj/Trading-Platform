document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('view-details').addEventListener('click', function() {
        document.getElementById('home-page').style.display = 'none';
        document.getElementById('portfolio-page').style.display = 'block';
        loadPortfolio();
    });

    document.getElementById('return-button').addEventListener('click', function() {
        document.getElementById('portfolio-page').style.display = 'none';
        document.getElementById('home-page').style.display = 'block';
    });

    function loadPortfolio() {
        fetch('http://localhost:8080/stocks')
            .then(response => response.json())
            .then(data => {
                const portfolioList = document.getElementById('portfolio-list');
                portfolioList.innerHTML = '';
                data.forEach(stock => {
                    const stockDiv = document.createElement('div');
                    stockDiv.classList.add('portfolio-item');
                    stockDiv.innerHTML = `
                        <div class="portfolio-left">
                            <div class="circle"></div>
                            <div class="stock-info">
                                <p class="stock-name">${stock.stockName}</p>
                                <p class="stock-shares">${stock.quantity} Shares</p>
                            </div>
                        </div>
                        <div class="portfolio-middle">
                            <img src="https://static.vecteezy.com/system/resources/thumbnails/022/659/642/small_2x/3d-growth-stock-diagram-financial-graph-isolated-on-transparent-background-business-candlestick-chart-investment-market-trade-exchange-analysis-and-economy-finance-report-png.png" alt="Graph" class="stock-graph">
                        </div>
                        <div class="portfolio-right">
                            <p class="stock-value">$${stock.stockPrice.toFixed(2)}</p>
                        </div>
                    `;
                    portfolioList.appendChild(stockDiv);
                });
            })
            .catch(error => console.error('Error:', error));
    }

    document.getElementById('createStockForm').addEventListener('submit', function (event) {
        event.preventDefault();
        const stock = {
            stockId: document.getElementById('stockId').value,
            stockName: document.getElementById('stockName').value,
            stockPrice: parseFloat(document.getElementById('stockPrice').value),
            purchasePrice: parseFloat(document.getElementById('purchasePrice').value),
            quantity: parseInt(document.getElementById('quantity').value)
        };
        fetch('http://localhost:8080/stock', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(stock)
        })
        .then(response => response.json())
        .then(data => console.log('Stock created:', data))
        .catch(error => console.error('Error:', error));
    });

    document.getElementById('getStockForm').addEventListener('submit', function (event) {
        event.preventDefault();
        const stockId = document.getElementById('getStockId').value;
        fetch(`http://localhost:8080/stock/${stockId}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Network response was not ok: ${response.statusText}`);
                }
                return response.json();
            })
            .then(data => {
                console.log('Stock retrieved:', data);
                if (data) {
                    const fetchedStockData = document.getElementById('fetched-stock-data');
                    fetchedStockData.innerHTML = `
                        <p><strong>Stock ID:</strong> ${data.stockId}</p>
                        <p><strong>Stock Name:</strong> ${data.stockName}</p>
                        <p><strong>Stock Price:</strong> $${data.stockPrice}</p>
                        <p><strong>Purchase Price:</strong> $${data.purchasePrice}</p>
                        <p><strong>Quantity:</strong> ${data.quantity}</p>
                        <p><strong>Gain/Loss:</strong> $${data.gainLoss}</p>
                    `;
                } else {
                    alert('Stock not found');
                }
            })
            .catch(error => console.error('Error:', error));
    });

    document.getElementById('increaseStockForm').addEventListener('submit', function (event) {
        event.preventDefault();
        const stockId = document.getElementById('increaseStockId').value;
        const amount = parseFloat(document.getElementById('increaseAmount').value);
        fetch(`http://localhost:8080/stock/${stockId}/increase`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ amount: amount })
        })
        .then(response => {
            if (!response.ok) {
                throw new Error(`Network response was not ok: ${response.statusText}`);
            }
            return response.json();
        })
        .then(data => console.log('Stock price increased:', data))
        .catch(error => console.error('Error:', error));
    });

    document.getElementById('getAllStocksButton').addEventListener('click', function () {
        fetch('http://localhost:8080/stocks')
            .then(response => response.json())
            .then(data => {
                const allStocksDiv = document.getElementById('allStocks');
                allStocksDiv.innerHTML = '';
                data.forEach(stock => {
                    const stockDiv = document.createElement('div');
                    stockDiv.innerHTML = `<p>Stock ID: ${stock.stockId}, Stock Name: ${stock.stockName}, Stock Price: ${stock.stockPrice}</p>`;
                    allStocksDiv.appendChild(stockDiv);
                });
            })
            .catch(error => console.error('Error:', error));
    });
});
