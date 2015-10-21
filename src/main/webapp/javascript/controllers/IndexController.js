app.controller('IndexCtrl', ['$scope', 'ArticlesService', 'SlidesService', '$sce', '$timeout', function ($scope, ArticlesService, SlidesService, $sce, $timeout) {
    $scope.slides = SlidesService.getAllSlides();
    $scope.articles = ArticlesService.getAllArticles();
    $scope.trustSrc = function (url) {
        return $sce.trustAsResourceUrl(url);
    }
}]);