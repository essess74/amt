app.service('ArticlesService', ['$resource', function ($resource) {
    this.getAllArticles = function () {
        return $resource('articles', {}, {
            query: {method: 'GET', params: {sort: 'submissionDate,DESC'}, isArray: false}
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
        return $resource('articles/' + article.id, {}).delete();
    };
    this.getAllCategories = function () {
        return $resource('categories', {}, {
            query: {method: 'GET', params: {}, isArray: true}
        }).query();
    };
    this.getKeyWordsForArticle = function (articleId) {
        return $resource('keywords', {}, {
            query: {method: 'GET', params: {articleId: articleId}, isArray: true}
        }).query();
    };
    this.saveKeyWordsForArticle = function (keywords, articleId) {
        return $resource('keywords', {}, {
            query: {method: 'POST', params: {keywords: keywords, articleId: articleId}, isArray: false}
        }).query();
    }
}]);