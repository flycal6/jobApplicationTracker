angular.module('appModule', [ 'ngRoute', 'authModule' ]).config(
		function($routeProvider) {
			$routeProvider
			.when('/', {
				template : '<home></home>'
			})
			.when('/navigation', {
				template : '<navigation></navigation>'
			})
			.otherwise({
				template : '<not-found></not-found>'
			})
		})
