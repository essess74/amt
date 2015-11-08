app.service('ArticlesService', ['$resource', function ($resource) {
    this.getAllArticles = function () {
        return $resource('articles', {}, {
            query: {method: 'GET', params: {}, isArray: true}
        }).query();
    };
    this.getArticle = function (articleId) {
        articleId = articleId || 0;
        return $resource('articles/' + articleId, {}, {
            query: {method: 'GET', params: {}, isArray: false}
        }).query();
    };
    this.getArticlesWithKeywords = function (keyWords, page) {
        page = page || 0;
        return $resource('articles/search', {}, {
            query: {
                method: 'GET', params: {
                    'keyWords': keyWords,
                    'page': page
                }, isArray: false
            }
        }).query();
    };
    this.getArticlesWithCategory = function (category, page) {
        page = page || 0;
        return $resource('articles/search/cat', {}, {
            query: {
                method: 'GET', params: {
                    'category': category,
                    'page': page
                }, isArray: false
            }
        }).query();
    };
}]);