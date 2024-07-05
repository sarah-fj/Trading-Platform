// scripts.js

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('view-details').addEventListener('click', function() {
        document.getElementById('home-page').style.display = 'none';
        document.getElementById('portfolio-page').style.display = 'block';
    });

    document.getElementById('return-button').addEventListener('click', function() {
        document.getElementById('portfolio-page').style.display = 'none';
        document.getElementById('home-page').style.display = 'block';
    });
});