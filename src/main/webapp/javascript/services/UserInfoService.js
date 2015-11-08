app.factory('UserInfoService', ['$resource', function ($resource) {
    return $resource('category/');
}]);