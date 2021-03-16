# NYTimesBooK
NYTimesBooK is an Android sample app which shows list of NewYorkTimes books.

Branches 
---------------
-hilt
-dagger

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

Built With
-----------
* [Lifecycles][12] - Create a UI that automatically responds to lifecycle events.
  * [LiveData][13] - Build data objects that notify views when the underlying database changes.
  * [Navigation][14] - Handle everything needed for in-app navigation.
  * [Room][16] - Access your app's SQLite database with in-app objects and compile-time checks.
  * [ViewModel][17] - Store UI-related data that isn't destroyed on app rotations. Easily schedule
     asynchronous tasks for optimal execution.


