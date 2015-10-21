app.filter('add', function () {
    return function (data, toAdd) {
        var sum = data | 0;
        sum = sum + (toAdd | 0);
        return sum;
    };
});