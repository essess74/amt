app.controller('SearchCtrl', [
    '$scope', 'ArticlesService', 'CategoryService', '$routeParams', '$sce', '$location', '$anchorScroll', function ($scope, ArticlesService, CategoryService, $routeParams, $sce, $location, $anchorScroll) {
        $scope.keyWords = $routeParams.keyWords;
        $scope.category = $routeParams.category;
        $scope.categories = CategoryService.getAllCategories();
        $scope.trustSrc = function (url) {
            return $sce.trustAsResourceUrl(url);
        };
        $scope.fetchPage = function (page) {
            $scope.articles = $scope.keyWords ? ArticlesService.getArticlesWithKeywords($scope.keyWords, page) : ArticlesService.getArticlesWithCategory($scope.category, page);
            $location.hash('content');
            $anchorScroll();
        };
        $scope.fetchPage(0);
        $scope.range = function (n) {
            var toReturn = [];
            for (var i = 1; i <= n; i++) {
                toReturn.push(i);
            }
            return toReturn;
        };
    }]);
