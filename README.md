# NYTimesBooK
NYTimesBooK is an Android sample app which shows list of NewYorkTimes books.

Branches 
---------------
- hilt
- dagger

Getting Started
---------------
NYTimesBooK uses New York Times API to load books on the library screen. To use the API, you will need to obtain a free developer API key. First create an account and then go to [myapps](https://developer.nytimes.com/my-apps) on your profile and add new app. See the York Times API [Documentation](https://developer.nytimes.com/docs/books-product/1/overview) for instructions.

Once you have the key, add this line to the `local.properties` file:

```
BOOK_API = your New York Times API key
```
The app is unusable without an API key.

Screenshots
-----------
![List of books](screenshots/Screenshot_20210317_212040.png "A list of books")

Built With
-----------
 * [Lifecycles][1]
 * [LiveData][2] 
 * [Navigation][3] 
 * [Room][4]
 * [ViewModel][5]
 * [Hilt][6]
 * [Kotlin Coroutines][7]


[1]: https://developer.android.com/topic/libraries/architecture/lifecycle
[2]: https://developer.android.com/topic/libraries/architecture/livedata
[3]: https://developer.android.com/topic/libraries/architecture/navigation/
[4]: https://developer.android.com/topic/libraries/architecture/room
[5]: https://developer.android.com/topic/libraries/architecture/viewmodel
[6]: https://developer.android.com/training/dependency-injection/hilt-android
[7]: https://kotlinlang.org/docs/reference/coroutines-overview.html


