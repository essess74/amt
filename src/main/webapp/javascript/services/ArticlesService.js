app.service('ArticlesService', ['$resource', function ($resource) {
    this.getAllArticles = function () {
        return $resource('articles', {}, {
            query: {method: 'GET', params: {}, isArray: true}
        }).query();
    };
}]);