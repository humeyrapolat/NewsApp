# NewsApp

This is my first kotlin application.In this application I used retrofit to get data from ınternet.And also I used MVVM architecture.In the first page you can see the list of the news. If you click one of them you can go to next page.In this page you can see new details like the title,desciption,categories and the author.

# Technologies

Mvvm Architecture                                                                                                                                                                   
Retrofit                                                                                                                                                                           
Room                                                                                                                                                                               
Extensions -> KTX, Glide,                                                                                                                                                           
Navigation                                                                                                                                                                         
RxJava 2                                                                                                                                                                            Live Data & Data Binding 

# How to build on your enviroment
Add your API key in Constant file.
get api key --> https://currentsapi.services/en

const val API_KEY = "your_api_key"

 fun getNews(
        @Query("apiKey") apiKey: String = "your_api_key"
    ): Single<APIResponse>

# Images
![1](https://user-images.githubusercontent.com/71139790/131098590-2f95f3a2-46cb-419d-95d0-c854d7823dcd.png)
![2](https://user-images.githubusercontent.com/71139790/131098598-aa4704c5-dbd4-4850-a86e-c3d39badab55.png)
![3](https://user-images.githubusercontent.com/71139790/131098600-e70d68c3-1bb8-4ef9-9405-e6ccc57cc6cd.png)

