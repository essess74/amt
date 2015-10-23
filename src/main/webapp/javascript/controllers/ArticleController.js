app.controller('ArticleCtrl', ['$scope', 'ArticlesService', '$routeParams', '$sce','$location', '$anchorScroll', function ($scope, ArticlesService, $routeParams, $sce,$location, $anchorScroll) {
    $scope.articleId = $routeParams.articleId;
    $scope.trustSrc = function (url) {
        return $sce.trustAsResourceUrl(url);
    }
    $scope.article = ArticlesService.getArticle($scope.articleId);
    $location.hash('content');

    // call $anchorScroll()
    $anchorScroll();
}]);
