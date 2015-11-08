app.service('CategoryService', ['$resource', function ($resource) {
    this.getAllCategories = function () {
        return $resource('category', {}, {
            query: {method: 'GET', params: {}, isArray: true}
        }).query();
    };
}]);