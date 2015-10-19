var app = angular.module('AmtApp', ['ngResource', 'ngSanitize', 'ngRoute']);

/*app.config(function ($translateProvider, $routeProvider) {
 $translateProvider.useStaticFilesLoader({
 prefix: 'languages/',
 suffix: '.json'
 });
 $translateProvider.preferredLanguage('frFR');

 $routeProvider.when('/search', {
 templateUrl: 'search-back.html'
 });
 });*/

app.directive('cIndex', function () {
    return {
        restrict: 'E',
        templateUrl: 'component/index.html'
    };
});
/* Category service */
app.service('ArticlesService', ['$resource', function ($resource) {
    this.getAllArticles = function () {
        return $resource('articles', {}, {
            query: {method: 'GET', params: {}, isArray: true}
        }).query();
    };
}]);

app.controller('ArticlesCtrl', ['$scope', 'ArticlesService','$sce', function ($scope, ArticlesService,$sce) {
    $scope.articles = ArticlesService.getAllArticles();
    $scope.trustSrc = function( url ){
        return $sce.trustAsResourceUrl(url);
    }
}]);
