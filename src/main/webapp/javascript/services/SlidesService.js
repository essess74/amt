app.service('SlidesService', ['$resource', function ($resource) {
    this.getAllSlides = function () {
        return $resource('slide', {}, {
            query: {method: 'GET', params: {}, isArray: true}
        }).query();
    };
}]);
