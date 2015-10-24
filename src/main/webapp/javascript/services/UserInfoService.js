app.factory('UserInfoService', ['$resource', function ($resource) {
    return $resource('userInfo/:email');
}]);