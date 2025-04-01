document.addEventListener("DOMContentLoaded", function() {
    fetch('/api/news')
        .then(response => response.json())
        .then(data => {
            let newsContainer = document.getElementById('news-container');
            newsContainer.innerHTML = '';
            data.forEach(article => {
                let div = document.createElement('div');
                div.classList.add('card');
                div.innerHTML = `<h2>${article.title}</h2><p>${article.content}</p>`;
                newsContainer.appendChild(div);
            });
        });
});

async function fetchNews() {
    try {
        const response = await fetch('/api/news');
        const newsData = await response.json();
        const container = document.getElementById('news-container');
        container.innerHTML = '';

        newsData.forEach(news => {
            const newsElement = document.createElement('div');
            newsElement.className = 'news-card';
            newsElement.innerHTML = `
                <h2>${news.title}</h2>
                <p>${news.description}</p>
                <a href="${news.url}" target="_blank">Read more</a>
            `;
            container.appendChild(newsElement);
        });
    } catch (error) {
        console.error('Error fetching news:', error);
    }
}
