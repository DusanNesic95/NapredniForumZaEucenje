app.controller('loginController', ['$scope', '$localStorage', '$http', 'funkcije',
 function($scope, $localStorage, $http, funkcije) {
	$scope.korisnik = {
		korisnickoIme : '',
		lozinka : ''
	}

	$scope.login = function() {
		if ($scope.korisnik.korisnickoIme != '' && $scope.korisnik.lozinka != '' && 
			$scope.korisnik.korisnickoIme != null && $scope.korisnik.lozinka != null) {
			
			var input = JSON.stringify($scope.korisnik);
			funkcije.prijava(input)
			.success(function(response) {
				if (response == '') {
					document.getElementById('wrongData').style.display = 'block';
				} else {
					var input = JSON.stringify(response);
					funkcije.ucitajrolukorisnika(input)
					.success(function(response) {
						if (response == null) {
							alert('Nemate dodeljenu rolu!');
						} else {
							document.getElementById('wrongData').style.display = 'none';
							document.getElementById('correctData').style.display = 'block';

							if (response.nazivRole == 'ADMINISTRATOR') {
								$localStorage.rola = 'ADMINISTRATOR';
								$localStorage.korisnik = response;
								$scope.navigateTo('homepageAdmin.html#/homeadmin');
							} else if (response.nazivRole == 'PROFESOR') {
								$localStorage.rola = 'PROFESOR';
								$localStorage.korisnik = response;
								$scope.navigateTo('homepageProfesor.html#/homeprofesor');
							} else if (response.nazivRole == 'STUDENT') {
								$localStorage.rola = 'STUDENT';
								$localStorage.korisnik = response;
								$scope.navigateTo('homepageStudent.html#/home');
							} else {
								alert('Nemate dodeljenu rolu!');
							}
						}
					})
					.error(function(error) {
						$scope.prikaziGresku(error);
					});
				}
			})
			.error(function(error) {
				$scope.prikaziGresku(error);
			});
		} else {
			alert("Input data is incorrect!");
		}
	};

	$scope.prikaziGresku = function(input) {
		alert("Došlo je do greške: " + input);
	}

	$scope.navigateTo = function(address) {
		setTimeout(function() {
			window.location = 'views/' + address;
		}, 500);
	}
}]);
