app.controller('ArticleCtrl', ['$scope', 'ArticlesService', '$routeParams', '$sce', function ($scope, ArticlesService, $routeParams, $sce) {
    $scope.articleId = $routeParams.articleId;
    $scope.trustSrc = function (url) {
        return $sce.trustAsResourceUrl(url);
    }
    $scope.article = ArticlesService.getArticle($scope.articleId);
}]);
