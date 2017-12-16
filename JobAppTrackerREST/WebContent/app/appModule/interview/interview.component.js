angular.module('appModule')
	.component('interview', {
		templateUrl: 'app/appModule/interview/interview.component.html',
		controller: function(interviewService, $scope, $location){
			var vm = this;
			vm.interviews = [];
			vm.loading = 0;
			vm.showCreateInterviewForm = false;
			
			interviewService.index().then(function(interview){
				vm.interviews = interview.data;
				console.log(vm.interviews)
			});
			
/**************************** view all responses *****************************/
//			$scope.$on('viewInterviews', function(){
//				console.log('click recieved')
//				vm.showUpdateInterviewForm = true;
//			});
			
/**************************** return true if a interview contains an offer made during subsequent interview *****************************/
//			used to apply bg-success class to any response with a job offer
			vm.offerCheck = function(interview){
				for (var i = 0; i < vm.interviews.length; i++) {
					if(interview.interviews.length > 0){
						if(interview.interviews[i].offerMade){
							return true;
						}
					}
				}
			}			

/**************************** add a interview to an application *****************************/
			$scope.$on('showCreateInterviewForm', function(e, args){
				console.log('broadcast received')
				console.log(args)
				vm.appToAddInterview = args;
				vm.showCreateInterviewForm = true;
			});
			
/**************************** add a interview to an application *****************************/
			vm.newInterviewSubmit = function(appId, resObj){
				interviewService.create(appId, resObj).then(function(interview){
					console.log('interview created');
					console.log(interview.data);
					vm.interviews.push(interview.data);
					vm.showCreateInterviewForm = false;
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