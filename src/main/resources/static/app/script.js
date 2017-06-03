var app = angular.module('checkoutapp', []);

app.controller('MainCtrl', function($scope, $timeout, $http) {
    $scope.rows = [{}];
    $scope.nrows = [];
    $scope.addRow = function() {
        $scope.rows.push({

        });

    };
    $scope.getProductDetails = function(row) {
        angular.forEach($scope.product, function(p) {
            if (p.code == row.code) {
                row.price = p.price;              
                row.tax = p.tax;              

            }
        })
    }
    $scope.total_amount = function() {
        var total = 0;
        $scope.rows.forEach(function(row) {
            total += row.amount;
        });
        return total;
    }

    $scope.total_tax = function() {
        var total = 0;
        $scope.rows.forEach(function(row) {
            total += row.tax;
        });
        return total;
    }
    
    $http({
    	  method: 'GET',
    	  url: '/checkout/repo'
    	}).then(function successCallback(response) {
    		console.log(response.data);
    		$scope.product = response.data;
    	    // this callback will be called asynchronously
    	    // when the response is available
    	  }, function errorCallback(response) {
    	    // called asynchronously if an error occurs
    	    // or server returns response with an error status.
    	  });

});