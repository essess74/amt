app.controller('IndexCtrl', ['$scope','CategoryService', 'ArticlesService', 'SlidesService', '$sce', '$timeout', function ($scope,CategoryService, ArticlesService, SlidesService, $sce, $timeout) {
    $scope.slides = SlidesService.getAllSlides();
    $scope.categories = CategoryService.getAllCategories();
    $scope.articles = ArticlesService.getAllArticles();
    $scope.trustSrc = function (url) {
        return $sce.trustAsResourceUrl(url);
    }
}]);