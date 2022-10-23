package asha.binar.challengechapterenam.data.network

import asha.binar.challengechapterenam.model.credit.GetCreditResponse
import asha.binar.challengechapterenam.model.detailmovie.GetDetailMovieResponse
import asha.binar.challengechapterenam.model.nowplaying.GetNowPlayingResponse
import asha.binar.challengechapterenam.model.popularmovie.GetPopularMovieResponse
import asha.binar.challengechapterenam.model.users.GetUserResponseItem
import asha.binar.challengechapterenam.model.users.PostUserResponse
import retrofit2.http.*

interface ApiService {
    //=====================Movie========================
    @GET("/3/movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") api_key: String
    ): GetPopularMovieResponse

    @GET("/3/movie/{movie_id}")
    suspend fun getDetailMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") api_key: String
    ): GetDetailMovieResponse

    @GET("/3/movie/{movie_id}/credits")
    suspend fun getCreditMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") api_key: String
    ): GetCreditResponse


    @GET("/3/movie/now_playing")
    suspend fun getNowPlayingMovie(
        @Query("api_key") api_key: String
    ): GetNowPlayingResponse

    @GET("/3/movie/{movie_id}/similar")
    suspend fun getSimilarMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") api_key: String
    ): GetPopularMovieResponse

    //=====================User========================

    @GET("/users")
    suspend fun getUser(
        @Query("email") email: String
    ) : List<GetUserResponseItem>

    @POST("/users")
    suspend fun addUsers(
        @Body user : PostUserResponse
    ): GetUserResponseItem

    @PUT("/users/{id}")
    suspend fun updateUser(
        @Body user : PostUserResponse, @Path("id") id:String
    ) : GetUserResponseItem
}