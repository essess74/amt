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
    }
}]);