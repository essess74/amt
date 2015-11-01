app.service('ArticlesService', ['$resource', function ($resource) {
    this.getAllArticles = function () {
        return $resource('articles', {}, {
            query: {method: 'GET', params: {}, isArray: false}
        }).query();
    };
    this.getArticle = function (articleId) {
        articleId = articleId || 0;
        return $resource('articles/' + articleId, {}, {
            query: {method: 'GET', params: {}, isArray: false}
        }).query();
    };
    this.saveArticle = function (article) {
        return $resource('articles/' + article.id, {}, {
            'update': {method: 'PUT'}
        }).update(article);
    };
    this.addArticle = function (article) {
        return $resource('articles', {}).save(article);
    };
    this.deleteArticle = function (article) {
        return $resource('articles/'+article.id, {}).delete();
    };
}]);