# android_said
This Android Kotlin Application shows you an example of MVVM and Coordinator using the android_framework without the module and some nice Shared Element Transitions!


##Coordinator Pattern
This is no fancy implementation of the Coordinator Pattern, in the UI for each view you'll see a View(Fragment and Activity) and a Coordinator for that View, sometimes a ViewModel that could be shared among some other Views.

```
\ui
	\main
		- MainActivity
		- MainCoordinator
		- MainViewModel
	\home
		- HomeCoordinator
		- HomeFragment
```

##Navigator
This is an Static Class that is in charge of calling the appropriate Activity and a helper methods to go to a Fragment(re-usability)... 

```
\navigation
	- Navigator
```

##Dagger
Although this project uses Dagger 2 for dependency injection, this is mainly for Data related instances, so for example the Coordinators are created per each view. This simplifies the Component since only the Application (for init) and ViewModels are Injected to. 