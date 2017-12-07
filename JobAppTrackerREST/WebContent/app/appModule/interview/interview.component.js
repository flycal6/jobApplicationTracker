angular.module('appModule')
	.component('interview', {
		templateUrl: 'app/appModule/interview/interview.component.html',
		controller: function(interviewService) {
			var vm = this;
			vm.interviews = [];
			
			var reload = function(){
				interviewService.index().then(function(res){
					console.log('interview response');
					vm.interviews = res.data;
					console.log(res.data)
				})
				.catch(function(err){
					console.log(err);
				});
			};
			reload();
			
			vm.viewInterviewCreationForm = function(res, app){
				interviewService.storeResAndApp(res, app).then(function(response){
					console.log(response);
				})
			};
			
		},
		controllerAs: 'vm'
	});