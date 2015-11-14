app.controller('ArticleCtrl', ['$scope', 'ArticlesService', '$sce', function ($scope, ArticlesService, $sce) {
    $scope.articles = ArticlesService.getAllArticles();
    $scope.trustSrc = function (url) {
        return $sce.trustAsResourceUrl(url);
    };
}]);
app.controller('EditArticleCtrl', ['$scope', '$mdDialog', 'ArticlesService', '$sce', '$routeParams', '$location', function ($scope, $mdDialog, ArticlesService, $sce, $routeParams, $location) {
    $scope.articleId = $routeParams.articleId;
    $scope.article = ArticlesService.getArticle($scope.articleId);
    $scope.categories = ArticlesService.getAllCategories();
    $scope.keywords = ArticlesService.getKeyWordsForArticle($scope.articleId);
    $scope.isImage = function () {
        return $scope.article.type == 'IMG';
    }
    $scope.isOther = function () {
        return $scope.article.type == 'OTH';
    }
    $scope.saveArticle = function (form) {
        if (form.$valid) {
            ArticlesService.saveArticle($scope.article);
            $location.path("/articles");
        }
    };
    $scope.deleteArticle = function () {
        ArticlesService.deleteArticle($scope.article);
        $location.path("/articles");
    };
    $scope.trustSrc = function (url) {
        return $sce.trustAsResourceUrl(url);
    };
    $scope.someHandlerMethod = function (a, b, c) {
        $scope.article.imageId = b;
    };
    $scope.tinymceOptions = {
        onChange: function (e) {
            // put logic here for keypress and cut/paste changes
        },
        inline: false,
        plugins: 'autolink link image lists charmap image preview',
        skin: 'lightgray',
        theme: 'modern'
    };
    $scope.showKeyWords = function (ev) {
        $mdDialog.show({
                controller: DialogController,
                templateUrl: 'pages/keywordsdialog.tmpl.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose: true,
                locals: {
                    articleId: $scope.articleId,
                    keywords : $scope.keywords
                }
            })
            .then(function (answer) {
                $scope.status = 'You said the information was "' + answer + '".';
            }, function () {
                $scope.status = 'You cancelled the dialog.';
            });
    };
}]);
app.controller('AddArticleCtrl', ['$scope', 'ArticlesService', '$sce', '$routeParams', '$location', function ($scope, ArticlesService, $sce, $routeParams, $location) {
    $scope.article = {};//ArticlesService.getArticle($scope.articleId);
    $scope.isImage = function () {
        return $scope.article.type == 'IMG';
    }
    $scope.isOther = function () {
        return $scope.article.type == 'OTH';
    }
    $scope.addArticle = function (form) {
        if (form.$valid) {
            ArticlesService.addArticle($scope.article);
            $location.path("/articles");
        }
    }
    $scope.trustSrc = function (url) {
        return $sce.trustAsResourceUrl(url);
    };
    $scope.someHandlerMethod = function (a, b, c) {
        $scope.article.imageId = b;
    };
    $scope.categories = ArticlesService.getAllCategories();
    $scope.tinymceOptions = {
        onChange: function (e) {
            // put logic here for keypress and cut/paste changes
        },
        inline: false,
        plugins: 'autolink link image lists charmap image preview',
        skin: 'lightgray',
        theme: 'modern'
    };
}]);
function DialogController($scope, $mdDialog, articleId, keywords, ArticlesService) {
    $scope.keywords = keywords;
    $scope.hide = function () {
        $mdDialog.hide();
    };
    $scope.cancel = function () {
        $mdDialog.cancel();
    };
    $scope.save = function () {
        ArticlesService.saveKeyWordsForArticle($scope.keywords,articleId);
        $mdDialog.cancel();
    };
}