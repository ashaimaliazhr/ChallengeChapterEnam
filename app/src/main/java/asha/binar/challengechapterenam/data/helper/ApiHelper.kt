package asha.binar.challengechapterenam.data.helper

import asha.binar.challengechapterenam.data.network.ApiService
import asha.binar.challengechapterenam.model.users.PostUserResponse
import javax.inject.Inject
import javax.inject.Named

class ApiHelper  @Inject constructor(
    @Named("Movie")
    private val apiServiceMovie: ApiService,
    @Named("User")
    private val apiServiceUser: ApiService
){
    suspend fun getPopularMovies(apiKey: String) = apiServiceMovie.getPopularMovie(apiKey)
    suspend fun getNowPlayingMovies(apiKey: String) = apiServiceMovie.getNowPlayingMovie(apiKey)
    suspend fun getDetailMovie(id: Int, apiKey: String) = apiServiceMovie.getDetailMovie(id, apiKey)
    suspend fun getCreditMovie(id: Int, apiKey: String) = apiServiceMovie.getCreditMovie(id, apiKey)
    suspend fun getSimilarMovie(id: Int, apiKey: String) =
        apiServiceMovie.getSimilarMovie(id, apiKey)

    suspend fun getUser(email:String) = apiServiceUser.getUser(email)
    suspend fun addUsers(user: PostUserResponse) = apiServiceUser.addUsers(user)
    suspend fun updateUser(user: PostUserResponse, id: String) = apiServiceUser.updateUser(user, id)
}